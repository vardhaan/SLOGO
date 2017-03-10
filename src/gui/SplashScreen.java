package gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplashScreen {

	public static final String SPLASH_SCREEN = "Logo.gif";
	public static final String RESOURCE_LOCATION =  "resources/gui";
	private ResourceBundle myResources;
	ArrayList<EventHandler<ActionEvent>> events;
	private double width;
	private double height;

	public SplashScreen(ArrayList<EventHandler<ActionEvent>> eventsIn, double widthIn, double heightIn){
		events = eventsIn;
		width = widthIn;
		height = heightIn;
	}

	public Scene setupSplash(Stage s) {

		VBox root = new VBox(10);

		Image image = new Image(getClass().getClassLoader().getResourceAsStream(SPLASH_SCREEN));
		ImageView logo = new ImageView(image);

		root.getChildren().add(logo);

		myResources = ResourceBundle.getBundle("resources/gui");
		createButtons(root);

		root.setAlignment(Pos.CENTER);

		Scene myScene = new Scene(root, width, height);

		return myScene;
	}

	private void createButtons(VBox myRoot) {
		String[] buttonLabels = { "ChineseLabel", "EnglishLabel", "FrenchLabel", "GermanLabel", "ItalianLabel",
				"PortugueseLabel", "RussianLabel", "SpanishLabel"};
		Collection<ButtonBuilder> buttons = new ArrayList<ButtonBuilder>();
		for (int i = 0; i < buttonLabels.length; i++) {
			ButtonBuilder newButton = new ButtonBuilder(myResources.getString(buttonLabels[i]), events.get(i));
			buttons.add(newButton);
		}
		ButtonBuilder.addButtonsTo(buttons, myRoot);
	}
}