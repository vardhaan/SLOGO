package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SplashScreen {


private Scene setupSplash (Stage s) {
    Group root = new Group();
    Scene myScene = new Scene(root, WIDTH, HEIGHT);
    Image image = new Image(getClass().getClassLoader().getResourceAsStream(SPLASH_SCREEN));
    
    ImageView splashScreen = new ImageView(image);
    splashScreen.setX(0);
    splashScreen.setY(0);
    
    Rectangle playButton = new Rectangle(520, 390, 245, 100);
    playButton.setFill(Color.TRANSPARENT);
    
    root.getChildren().add(splashScreen);
    root.getChildren().add(playButton);
    
    myScene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY(),playButton, s));
    return myScene;
}
}