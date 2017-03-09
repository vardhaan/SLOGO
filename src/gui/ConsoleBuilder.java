package gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import commands.Parser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ConsoleBuilder {
	private TabPane myTab;
	private TextArea console;
	private ObservableList<Button> pcommands;
	private ObservableList<TextArea> turtleList;
	private ListView<Button> plist;
	private ListView<TextArea> turtleVariables;
	private ResourceBundle myResources;
	private Parser myParser;
	private TextArea variables;

	public ConsoleBuilder(ResourceBundle myResourcesIn, Parser parserIn){
		myResources = myResourcesIn;
		myParser = parserIn;

		console = new TextArea();
		console.setPrefColumnCount(50);
		console.setPrefRowCount(5);
		console.setMinHeight(150);

		pcommands = FXCollections.observableArrayList();
		plist = new ListView<Button>();
		plist.setItems(pcommands);
		plist.setOrientation(Orientation.VERTICAL);
		plist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		myTab = new TabPane();
		myTab.setMinWidth(300);
		myTab.setMaxWidth(300);
		
		Tab pcTab = new Tab();
		pcTab.setText("Previous Commands");
		pcTab.setContent(plist);
		myTab.getTabs().add(pcTab);
		
		variables = new TextArea();
		variables.setEditable(false);
		variables.setMaxWidth(280);
		String name = "Turtle1";
		double xloc = 0;
		double yloc = 0;
		double angle = 0;
		variables.setText(String.format(name + "\nX: %f \nY: %f \nAngle: %f", xloc, yloc, angle));
		
		turtleList = FXCollections.observableArrayList();
		turtleVariables = new ListView<TextArea>();
		turtleVariables.setItems(turtleList);
		turtleVariables.setOrientation(Orientation.VERTICAL);
		turtleVariables.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		turtleList.add(variables);
		
		Tab turtleTab = new Tab();
		turtleTab.setText("Turtles");
		turtleTab.setContent(turtleVariables);
		myTab.getTabs().add(turtleTab);

	}

	public void buildConsole(GridPane myRoot){
		GridPane.setConstraints(console, 0, 3);
		GridPane.setConstraints(myTab, 1, 1);
		GridPane.setRowSpan(myTab, 2);
		GridPane.setColumnSpan(myTab, 3);
		myRoot.getChildren().addAll(console, myTab);
		createButtons(myRoot, 3);
	}

	private void createButtons(GridPane myRoot, int row) {
		String[] buttonLabels = { "ExecuteButtonLabel", "ClearButtonLabel", "UndoButtonLabel"};
		EventHandler<ActionEvent> execute = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				addPreviousCommand(console.getText());
				try {
					myParser.parse(console.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				console.clear();

			}
		};
		EventHandler<ActionEvent> clear = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				console.clear();
			}
		};
		EventHandler<ActionEvent> undo = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//myParser.
			}
		};
		ArrayList<EventHandler<ActionEvent>> events = new ArrayList<EventHandler<ActionEvent>>();
		events.add(execute);
		events.add(clear);
		events.add(undo);
		Collection<ButtonBuilder> buttons = new ArrayList<ButtonBuilder>();
		for (int i = 0; i < buttonLabels.length; i++) {
			ButtonBuilder newButton = new ButtonBuilder(myResources.getString(buttonLabels[i]), row, i + 1, events.get(i));
			buttons.add(newButton);
		}
		ButtonBuilder.addButtonsTo(buttons, myRoot);
	}

	public void addPreviousCommand(String previousText){
		Button pcommandButton = new Button(previousText);
		pcommandButton.setOnAction(e -> {
			try {
				myParser.parse(previousText);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pcommands.add(pcommandButton);

	}

}
