package gui;

import java.awt.Desktop;
import java.net.URI;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import turtles.TurtleViewer;

public class MenuBuilder {
	private MenuBar menu;
	public  String RESOURCES_LOCATION = "resources/gui";
	private  ResourceBundle myResources = ResourceBundle.getBundle(RESOURCES_LOCATION);
	private TurtleViewer tv;
	private Pane turtlePane;

	public MenuBuilder(TurtleViewer tvIn, Pane paneIn) {
		turtlePane = paneIn;
		tv = tvIn;
		Menu settings=initSettingsMenu();
		Menu reset=initResetMenu();
		Menu help= intHelpMenu();
		menu=new MenuBar(settings, reset, help);
	}
	public void buildMenu(Pane myRoot) {
		GridPane.setConstraints(menu, 0, 0);
		myRoot.getChildren().add(menu);
	}
	public void updateMenu(GridPane myRoot){
		myRoot.getChildren().remove(menu);
	}

	private Menu intHelpMenu() {
		MenuItem viewHelp = new MenuItem(myResources.getString("ReadmeLabel"));
		viewHelp.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		viewHelp.setOnAction(e -> openReadme());
		MenuItem viewJavadoc = new MenuItem(myResources.getString("HelpLabel"));
		viewJavadoc.setAccelerator(new KeyCodeCombination(KeyCode.J, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		viewJavadoc.setOnAction(e -> openHelp());
		MenuItem about = new MenuItem(myResources.getString("AboutLabel"));
		about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		about.setOnAction(e -> about());
		return new Menu(myResources.getString("HelpLabel"), null, viewHelp, viewJavadoc, about);
	}
	// TODO Auto-generated method stub
	private void about() {
		Alert about= new Alert(Alert.AlertType.INFORMATION);
		about.setHeaderText(myResources.getString("AboutHeader"));
		about.setTitle(myResources.getString("AboutTitle"));
		about.setContentText(myResources.getString("AboutContent"));
		about.showAndWait();
	}

	private void openHelp() {
		try {
			Desktop.getDesktop().browse(new URI(myResources.getString("HelpURL1")));
			Desktop.getDesktop().browse(new URI(myResources.getString("HelpURL2")));
		} catch (Exception e) {
			new Alert(Alert.AlertType.ERROR, myResources.getString("JavadocError")).show();
		}
	}

	private void openReadme() {
		try {
			Desktop.getDesktop().browse(new URI(myResources.getString("ReadmeURL")));
		} catch (Exception e) {
			new Alert(Alert.AlertType.ERROR, myResources.getString("ReadmeError")).show();
		}
	}
	private void reset(){
		tv.clear();
		tv.setCleared(true);
	}

	private Menu initResetMenu() {
		MenuItem resetSimulation = new MenuItem(myResources.getString("ResetLabel"));
		resetSimulation.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN));
		resetSimulation.setOnAction(e-> reset());
		return new Menu(myResources.getString("ResetLabel"), null, resetSimulation);
	}

	private Menu initSettingsMenu() {
		Menu turtleImageSelect = new Menu(myResources.getString("TurtleImageLabel"));
		addOptions(turtleImageSelect);
		MenuItem backgroundColor = new MenuItem(myResources.getString("BackgroundLabel"));
		backgroundColor.setOnAction(e -> pickColor());
		return new Menu("Settings", null, turtleImageSelect, backgroundColor);
	}

	private void addOptions(Menu menuIn){
		MenuItem turtle1 = new MenuItem(myResources.getString("image1name"));
		turtle1.setOnAction(e -> turtleImageChange(myResources.getString("image1")));
		MenuItem turtle2 = new MenuItem(myResources.getString("image2name"));
		turtle2.setOnAction(e -> turtleImageChange(myResources.getString("image2")));
		MenuItem turtle3 = new MenuItem(myResources.getString("image3name"));
		turtle3.setOnAction(e -> turtleImageChange(myResources.getString("image3")));
		MenuItem turtle4 = new MenuItem(myResources.getString("image4name"));
		turtle4.setOnAction(e -> turtleImageChange(myResources.getString("image4")));
		menuIn.getItems().addAll(turtle1, turtle2, turtle3, turtle4);
	}

	private void turtleImageChange(String image) {
		tv.setImage(image);
	}
	
	private void pickColor(){
		Stage stage = new Stage();
		ColorPicker colorPicker = new ColorPicker();
        Circle circle = new Circle(50);
        circle.setFill(colorPicker.getValue());
        colorPicker.setOnAction(e -> circle.setFill(colorPicker.getValue()));
        Button okayButton = new Button(myResources.getString("OkayButton"));
        okayButton.setOnAction(e -> {
        	turtlePane.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        	stage.close();
        });
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(20);
        root.getChildren().addAll(circle, colorPicker, okayButton);
        Scene scene = new Scene(root, 400, 200);
        stage.setTitle(myResources.getString("ColorWindow"));
        stage.setScene(scene);
        stage.show();
    }
}



