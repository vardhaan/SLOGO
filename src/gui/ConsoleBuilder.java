package gui;

import java.util.ArrayList;
import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ConsoleBuilder {
	private TextArea console;
	private TextArea previousCommands;
	private String[] buts = {"Execute", "Clear"};
    
	public ConsoleBuilder(){
		console = new TextArea();
		previousCommands = new TextArea();
		previousCommands.setEditable(false);
	}
	
	public void buildConsole(GridPane myRoot){
		GridPane.setConstraints(console, 0, 2);
		GridPane.setConstraints(previousCommands, 0, 1);
		myRoot.getChildren().addAll(console, previousCommands);
		createButtons(myRoot, 2);
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
	
	public void addPreviousCommand(String previous){
		previousCommands.appendText("\n" + previous);
	}
	
}
