import java.io.File;

import gui.GUIBuilder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class main extends Application {
	public static final double SCENE_WIDTH = 1400;
	public static final double SCENE_HEIGHT = 800;
	public static final String STAGE_TITLE = "SLOGO Team 1";
	
	@Override
	public void start(Stage s) throws Exception {
		showGUI(s);
	}
	
	public void showGUI(Stage s){
		
		GUIBuilder builder = new GUIBuilder();
		GridPane myRoot = builder.buildGridPane();
		builder.buildGUI(myRoot);
		//MenuBar myMenu=builder.buildMenu();
		Scene scene = new Scene(myRoot, SCENE_WIDTH, SCENE_HEIGHT);
		
		File cssFile = new File("src/resources/format.css");
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));
		
		s.setTitle(STAGE_TITLE);
        s.setScene(scene);
        s.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
