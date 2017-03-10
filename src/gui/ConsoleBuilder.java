package gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import commands.Parser;
import exceptions.EmptyParserException;
import exceptions.ErrorParsing;
import exceptions.MyException;
import exceptions.NoTurtleException;
import exceptions.PopUpException;
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
import turtles.Turtle;
import turtles.TurtleViewer;

public class ConsoleBuilder {
	private TabPane myTab;
	private TextArea console;
	private ObservableList<Button> pcommands;
	private ObservableList<TextArea> turtleList;
	private ListView<Button> plist;
	private ListView<TextArea> turtleVariables;
	private ResourceBundle myResources;
	private Parser myParser;
	private TurtleViewer tv;
	private int currentID = 0;

	public ConsoleBuilder(ResourceBundle myResourcesIn, Parser parserIn, TurtleViewer tvIn){
		tv = tvIn;
		myResources = myResourcesIn;
		myParser = parserIn;

		console = new TextArea();
		console.setPrefColumnCount(50);
		console.setPrefRowCount(5);
		console.setMinHeight(150);
		console.setMaxHeight(150);

		pcommands = FXCollections.observableArrayList();
		plist = new ListView<Button>();
		plist.setItems(pcommands);
		plist.setOrientation(Orientation.VERTICAL);
		plist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		myTab = new TabPane();
		myTab.setMinWidth(300);
		myTab.setMaxWidth(300);

		Tab pcTab = new Tab();
		pcTab.setText("Prev Cmnds");
		pcTab.setContent(plist);
		myTab.getTabs().add(pcTab);

		TextArea variables = createNewTurtleTextArea("Turtle" + currentID, 0, 0, 0, true);
		currentID++;

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
		GridPane.setRowSpan(console, 2);
		GridPane.setConstraints(myTab, 1, 1);
		GridPane.setRowSpan(myTab, 2);
		GridPane.setColumnSpan(myTab, 2);
		myRoot.getChildren().addAll(console, myTab);
		createButtons(myRoot, 3);
	}

	private void createButtons(GridPane myRoot, int row) {
		String[] buttonLabels = { "ExecuteButtonLabel", "ClearButtonLabel", "UndoButtonLabel", "AddTurtleLabel"};
		EventHandler<ActionEvent> execute = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				addPreviousCommand(console.getText());
				try {
					myParser.parse(console.getText());
				} catch (Exception e1) {
					// TODO replace printStackTrace
					MyException p =  new EmptyParserException();
					PopUpException pop = new PopUpException(p.getMessage());
					pop.showMessage();
				}
				try {
					updateVariables();
				} catch (Exception e2) {
					// TODO replace printStackTrace
					MyException p =  new NoTurtleException();
					PopUpException pop = new PopUpException(p.getMessage());
					pop.showMessage();
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
				try {
					tv.getTurtle(currentID).setprev();
					tv.getTurtle(currentID).clearprevlines();
				} catch (Exception e1) {
					MyException p =  new NoTurtleException();
					PopUpException pop = new PopUpException(p.getMessage());
					pop.showMessage();
				}
				console.clear();
				//myParser.
			}
		};
		EventHandler<ActionEvent> addTurtle = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				TextArea turtleVars = createNewTurtleTextArea("Turtle" + currentID, 0, 0, 0, true);
				turtleList.add(turtleVars);
				tv.addTurtle();
			}
		};
		ArrayList<EventHandler<ActionEvent>> events = new ArrayList<EventHandler<ActionEvent>>();
		events.add(execute);
		events.add(clear);
		events.add(undo);
		events.add(addTurtle);
		Collection<ButtonBuilder> buttons = new ArrayList<ButtonBuilder>();
		ButtonBuilder newButton = new ButtonBuilder(myResources.getString(buttonLabels[0]), row, 1, events.get(0));
		buttons.add(newButton);
		newButton = new ButtonBuilder(myResources.getString(buttonLabels[1]), row, 2, events.get(1));
		buttons.add(newButton);
		newButton = new ButtonBuilder(myResources.getString(buttonLabels[2]), row+1, 1, events.get(2));
		buttons.add(newButton);
		newButton = new ButtonBuilder(myResources.getString(buttonLabels[3]), row+1, 2, events.get(3));
		buttons.add(newButton);
		ButtonBuilder.addButtonsTo(buttons, myRoot);
	}

	private void addPreviousCommand(String previousText){
		Button pcommandButton = new Button(previousText);
		pcommandButton.setOnAction(e -> {
			try {
				myParser.parse(previousText);
			} catch (Exception e1) {
				MyException p =  new ErrorParsing();
				PopUpException pop = new PopUpException(p.getMessage());
				pop.showMessage();
			}
		});
		pcommands.add(pcommandButton);
	}

	private void updateVariables() throws Exception{
		for(Turtle temp: tv.getTurtleList()){
			String name = "Turtle" + temp.getID();
			double xloc = temp.getX();
			double yloc = temp.getY();
			double angle = temp.getHeading() % 360;
			boolean active = temp.getActivity();
			turtleList.get(temp.getID()).setText(String.format("%s\nX: %f \nY: %f \nAngle: %f\nActive: %B",name, xloc, yloc, angle, active));
		}
	}
	
	private TextArea createNewTurtleTextArea(String name, double xloc, double yloc, double angle, boolean active){
		TextArea variables = new TextArea();
		variables.setEditable(false);
		variables.setMaxWidth(280);
		variables.setMaxHeight(120);
		variables.setText(String.format(name + "\nX: %f \nY: %f \nAngle: %f\nActive: %B", xloc, yloc, angle, active));
		return variables;
	}

}
