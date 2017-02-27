package gui;

import java.util.ArrayList;
import java.util.Collection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ConsoleBuilder {
	private TextArea console;
	private SplitPane previousCommands;
	private String[] buts = {"Execute", "Clear"};
    
	public ConsoleBuilder(){
		console = new TextArea();
		console.setPrefColumnCount(80);
		console.setPrefRowCount(5);
		console.setMinHeight(150);
		previousCommands = new SplitPane();
		previousCommands.setOrientation(Orientation.VERTICAL);
		SplitPane.setResizableWithParent(previousCommands, Boolean.FALSE);
		
	}
	
	public void buildConsole(GridPane myRoot){
		GridPane.setConstraints(console, 0, 3);
		GridPane.setConstraints(previousCommands, 1, 2);
		GridPane.setColumnSpan(previousCommands, 2);
		ScrollPane previousScroll = new ScrollPane();
		previousScroll.setContent(previousCommands);
		previousScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		GridPane.setConstraints(previousScroll, 1, 2);
		GridPane.setColumnSpan(previousScroll, 2);
		//previousScroll.setFitToHeight(true);
		myRoot.getChildren().addAll(console, previousCommands, previousScroll);
		createButtons(myRoot, 3);
	}
	
	private void createButtons(GridPane myRoot, int row) {
		String[] buttonLabels = { "ExecuteButtonLabel", "ClearButtonLabel"};
		EventHandler<ActionEvent> execute = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				addPreviousCommand(console.getText());
				console.clear();
			}
		};
		EventHandler<ActionEvent> clear = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				console.clear();
			}
		};
		ArrayList<EventHandler<ActionEvent>> events = new ArrayList<EventHandler<ActionEvent>>();
		events.add(execute);
		events.add(clear);
		Collection<ButtonBuilder> buttons = new ArrayList<ButtonBuilder>();
		for (int i = 0; i < buttonLabels.length; i++) {
			//ButtonBuilder newButton = new ButtonBuilder(myResources.getString(buttonLabels[i]), row, i, events.get(i));
			ButtonBuilder newButton = new ButtonBuilder(buts[i], row, i + 1, events.get(i));
			buttons.add(newButton);
		}
		ButtonBuilder.addButtonsTo(buttons, myRoot);
	}
	
	public void addPreviousCommand(String previousText){
		StackPane previousPane = new StackPane();
		Button pcommandButton = new Button(previousText);
		//pcommandButton.setOnAction(executePreviousCommand);
		previousPane.getChildren().add(pcommandButton);
		previousCommands.getItems().add(previousPane);
	}
	
}
