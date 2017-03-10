package gui;

import java.awt.Desktop;
import java.net.URI;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Effect;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import turtles.TurtleViewer;

public class MenuBuilder {
	private MenuBar menu;
	public  String RESOURCES_LOCATION = "resources/gui";
	private  ResourceBundle myResources = ResourceBundle.getBundle(RESOURCES_LOCATION);
	private GridPane myroot;
	private TurtleViewer tv;
	//resources

	public MenuBuilder(TurtleViewer tvIn) {
		tv = tvIn;
		Menu settings=initSettingsMenu();
		Menu reset=initResetMenu();
		Menu help= intHelpMenu();
		menu=new MenuBar(settings, reset, help);
	}
	public void buildMenu(GridPane myRoot) {
		// TODO Auto-generated method stub
		GridPane.setConstraints(menu, 0, 0);
		myRoot.getChildren().add(menu);
	}
	public void updateMenu(GridPane myRoot){
		myRoot.getChildren().remove(menu);
		//myRoot.getChildren().addAll(menu);

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
			Desktop.getDesktop().browse(new URI("http://www.cs.duke.edu/courses/spring17/compsci308/assign/03_slogo/commands.php"));
			Desktop.getDesktop().browse(new URI("http://www.cs.duke.edu/courses/spring17/compsci308/assign/03_slogo/commands2_J2W.php"));
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
	}

	private Menu initResetMenu() {
		MenuItem resetSimulation = new MenuItem(myResources.getString("ResetLabel"));
		resetSimulation.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN));
		resetSimulation.setOnAction(e-> reset());
		return new Menu(myResources.getString("ResetLabel"), null, resetSimulation);
	}

	private Menu initSettingsMenu() {
		/*MenuItem colorShiftPen = new MenuItem("Adjust_PenColor");
		colorShiftPen.setOnAction(e -> colorShiftPen());
		MenuItem BackgroundColor= new MenuItem("Background_Color");
		BackgroundColor.setOnAction(e-> BackgroundColor());*/
		Menu turtleImageSelect = new Menu("TurtleImage");
		addOptions(turtleImageSelect);
		return new Menu("Settings", null, turtleImageSelect);
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
	
	/*
	private void BackgroundColor() {
		Dialog dbox = new Dialog();
		dbox.setTitle(myResources.getString("AdjustLabel"));
		dbox.setHeaderText(myResources.getString("ContentLabel"));
		dbox.getDialogPane().getButtonTypes().add(new ButtonType(myResources.getString("OkayButton"), ButtonBar.ButtonData.CANCEL_CLOSE));
		GridPane content = new GridPane();
		content.getColumnConstraints().add(new ColumnConstraints(90));
		ColumnConstraints slidersColumn = new ColumnConstraints();
		slidersColumn.setHgrow(Priority.ALWAYS);
		content.getColumnConstraints().add(slidersColumn);
		Slider hSlider = new Slider(0, 360, 0);
		content.add(new Label("Hue"), 0, 0);
		content.add(hSlider, 1, 0);
		Slider sSlider = new Slider(0, 1, 1);
		content.add(new Label("Saturation"), 0, 1);
		content.add(sSlider, 1, 1);
		Slider lSlider = new Slider(0, 2, 1);
		content.add(new Label("Lightness"), 0, 2);
		content.add(lSlider, 1, 2);
		dbox.getDialogPane().setContent(content);
		dbox.showAndWait();
	}

	private void colorShiftPen() {
		Dialog dbox = new Dialog();
		dbox.setTitle(myResources.getString("AdjustLabel"));
		dbox.setHeaderText(myResources.getString("ContentLabel"));
		dbox.getDialogPane().getButtonTypes().add(new ButtonType(myResources.getString("OkayButton"), ButtonBar.ButtonData.CANCEL_CLOSE));
		GridPane content = new GridPane();
		content.getColumnConstraints().add(new ColumnConstraints(90));
		ColumnConstraints slidersColumn = new ColumnConstraints();
		slidersColumn.setHgrow(Priority.ALWAYS);
		content.getColumnConstraints().add(slidersColumn);
		Slider hSlider = new Slider(0, 360, 0);
		content.add(new Label("Hue"), 0, 0);
		content.add(hSlider, 1, 0);
		Slider sSlider = new Slider(0, 1, 1);
		content.add(new Label("Saturation"), 0, 1);
		content.add(sSlider, 1, 1);
		Slider lSlider = new Slider(0, 2, 1);
		content.add(new Label("Lightness"), 0, 2);
		content.add(lSlider, 1, 2);
		dbox.getDialogPane().setContent(content);
		dbox.showAndWait();
	}*/
}



