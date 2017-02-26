package gui;

import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * creates a graphical button with the parameters given in the constructor
 * 
 * @author Jack Bloomfeld
 */
public class ButtonBuilder{
	private Button myButton;

	public ButtonBuilder(String label, int row, int col, EventHandler<ActionEvent> buttonPress) {
		myButton = new Button();
		GridPane.setConstraints(myButton, col, row);
		myButton.setText(label);
		myButton.setOnAction(buttonPress);
	}

	/**
	 * Adds button collection to a Gridpane
	 */
	public static void addButtonsTo(Collection<ButtonBuilder> buttons, GridPane gridPane) {
		for (ButtonBuilder button : buttons) {
			gridPane.getChildren().add(button.getButton());
		}
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public Button getButton() {
		return myButton;
	}
}