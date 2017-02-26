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
		previousCommands = new SplitPane();
		previousCommands.setOrientation(Orientation.VERTICAL);
		
	}
	
	public void buildConsole(GridPane myRoot){
		GridPane.setConstraints(console, 0, 2);
		GridPane.setConstraints(previousCommands, 0, 1);
		
		ScrollBar scrollVertical = new ScrollBar();
		GridPane.setConstraints(scrollVertical, 0, 1);
		scrollVertical.setMin(0);
		scrollVertical.setMax(100);
		scrollVertical.setOrientation(Orientation.VERTICAL);
		scrollVertical.setTranslateX(-8);
		scrollVertical.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				previousCommands.setTranslateY(-new_val.doubleValue() - 7);
			}
		});
		
		myRoot.getChildren().addAll(console, previousCommands, scrollVertical);
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
	
	public void addPreviousCommand(String previousText){
		StackPane previousPane = new StackPane();
		Button pcommandButton = new Button(previousText);
		//pcommandButton.setOnAction(executePreviousCommand);
		previousPane.getChildren().add(pcommandButton);
		previousCommands.getItems().add(previousPane);
	}
	
}
