package exceptions;
/**
 * @author Zhiyong
 *
 */
 

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PopUpException{
	public static final double SIZE =300;
	
	private Scene scene;
	private String message;
	
	public PopUpException(String exception){
       message = exception;
	}
	
	public Scene getScene(){
		return scene;
	}
	public void showMessage(){
		Pane root = new Pane();
		// create a place to see the shapes
		scene = new Scene(root, SIZE, SIZE);
		
		Text splash = new Text();
		//show the exception to the user
		splash = new Text(10,50,message);
		splash.setFont(Font.font(25));
		splash.setFill(Color.DARKVIOLET);
		root.getChildren().addAll(splash);
		Stage s = new Stage();
		s.setScene(scene);
		s.setTitle("Errors");
		s.show();
	}
}