package gui;

import java.util.ArrayList;
import java.util.Collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ConsoleBuilder {
	private TextArea console;
	private SplitPane previousCommands;
	private String[] buts = {"Execute", "Clear"};
	private ObservableList<Button> pcommands;
	private ListView<Button> plist;
    
	public ConsoleBuilder(){
		console = new TextArea();
		console.setPrefColumnCount(80);
		console.setPrefRowCount(5);
		console.setMinHeight(150);
		pcommands = FXCollections.observableArrayList();
		plist = new ListView<Button>();
		plist.setItems(pcommands);
		plist.setOrientation(Orientation.VERTICAL);
		plist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		previousCommands = new SplitPane();
		previousCommands.setOrientation(Orientation.VERTICAL);
		
		//previousCommands.set
		SplitPane.setResizableWithParent(previousCommands, Boolean.FALSE);
		
	}
	
	public void buildConsole(GridPane myRoot){
		GridPane.setConstraints(console, 0, 3);
		GridPane.setConstraints(plist, 1, 2);
		GridPane.setColumnSpan(plist, 2);
		ScrollPane previousScroll = new ScrollPane();
		previousScroll.setContent(previousCommands);
		previousScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		GridPane.setConstraints(previousScroll, 1, 2);
		GridPane.setColumnSpan(previousScroll, 2);
		myRoot.getChildren().addAll(console, plist);
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
		Button pcommandButton = new Button(previousText);
		//pcommandButton.setOnAction(executePreviousCommand);
		pcommands.add(pcommandButton);
		
	}
	
}
