import java.io.File;

import gui.GUIBuilder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import turtles.TurtleViewer;

public class main extends Application {
	public static final double SCENE_WIDTH = 1400;
	public static final double SCENE_HEIGHT = 800;
	public static final String STAGE_TITLE = "SLOGO Team 1";
	public static final String LOGO = "Logo.gif";
	
	@Override
	public void start(Stage s) throws Exception {
		showGUI(s);
	}
	
	public void showGUI(Stage s){
		s.setTitle(STAGE_TITLE);
		s.setScene(setupSplash(s));
		s.show();
	}
	private void run(Stage s){
		GUIBuilder builder = new GUIBuilder();
		GridPane myRoot = builder.buildGridPane();
		builder.buildGUI(myRoot);
		
		Scene scene = new Scene(myRoot, SCENE_WIDTH, SCENE_HEIGHT);
		
		File cssFile = new File("src/resources/format.css");
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));
		
		s.setTitle(STAGE_TITLE);
        s.setScene(scene);
        s.show();
	}
	
	private Scene setupSplash (Stage s) {
		VBox root = new VBox();

		Button playButton = new Button("Play");
		playButton.setOnAction(e -> run(s));

		Image image = new Image(getClass().getClassLoader().getResourceAsStream(LOGO));
		ImageView logo = new ImageView(image);
		
		root.getChildren().add(logo);
		root.getChildren().add(playButton);
		
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

		return scene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
