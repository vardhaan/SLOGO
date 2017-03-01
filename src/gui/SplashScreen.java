package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplashScreen {

	public static final String SPLASH_SCREEN = "Logo.gif";

	private Scene setupSplash (Stage s) {
		VBox root = new VBox();

		Button playButton = new Button();
		//playButton.setOnAction();

		root.getChildren().add(playButton);

		Image image = new Image(getClass().getClassLoader().getResourceAsStream(SPLASH_SCREEN));
		ImageView logo = new ImageView(image);
		
		root.getChildren().addAll(logo, playButton);

		Scene myScene = new Scene(root);

		return myScene;
	}
}