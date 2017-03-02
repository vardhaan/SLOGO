package gui;

import java.awt.Desktop;
import java.net.URI;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MenuBuilder {
	private MenuBar menu;
	public  String RESOURCES_LOCATION = "resources/gui";
	private  ResourceBundle myResources = ResourceBundle.getBundle(RESOURCES_LOCATION);
	private GridPane myroot;
	//resources

	public MenuBuilder() {
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
		MenuItem viewJavadoc = new MenuItem(myResources.getString("DocumentationLabel"));
		viewJavadoc.setAccelerator(new KeyCodeCombination(KeyCode.J, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		viewJavadoc.setOnAction(e -> openJavadoc());
		MenuItem about = new MenuItem(myResources.getString("AboutLabel"));
		about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		about.setOnAction(e -> about());
		return new Menu(myResources.getString("HelpLabel"), null, viewHelp, viewJavadoc, about);
	}
	// TODO Auto-generated method stub
	private void about() {
		Alert about= new Alert(Alert.AlertType.INFORMATION);
		about.setHeaderText("Slogo");
		about.setTitle("About");
		about.setContentText("AboutContent");
		about.showAndWait();
	}

	private void openJavadoc() {
		try {
            Desktop.getDesktop().browse(new URI("file://" + System.getProperty("user.dir").replace('\\','/') + "/doc/index.html"));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "ErrorDocumentation").show();
        }
	}

	private void openReadme() {
		 try {
             Desktop.getDesktop().browse(new URI("http://coursework.cs.duke.edu/CompSci308_2017Spring/slogo_team01"));
         } catch (Exception e) {
             new Alert(Alert.AlertType.ERROR, "ErrorReadme").show();
         }
	}
	private void reset(){
		
	}

	private Menu initResetMenu() {
		MenuItem resetSimulation = new MenuItem("reset");
		resetSimulation.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN));
		resetSimulation.setOnAction(e-> reset());
		return new Menu("Reset", null, resetSimulation);
	}

	private Menu initSettingsMenu() {
		MenuItem colorShiftPen = new MenuItem("Adjust_PenColor");
		colorShiftPen.setOnAction(e -> colorShiftPen());
		MenuItem BackgroundColor= new MenuItem("Background_Color");
		BackgroundColor.setOnAction(e-> BackgroundColor());
		MenuItem TurtleImage= new MenuItem("Change_Image");
		TurtleImage.setOnAction(e-> TurtleImageChange());
		return new Menu("Settings", null,BackgroundColor,colorShiftPen, TurtleImage );


	}
	
	private Object TurtleImageChange() {
		// TODO Auto-generated method stub
		return null;
	}
		
	private void BackgroundColor() {
		Dialog dbox = new Dialog();
		dbox.setTitle("Adjust_Color");
		dbox.setHeaderText("Adjust_Color_Content");
		dbox.getDialogPane().getButtonTypes().add(new ButtonType("Okay", ButtonBar.ButtonData.CANCEL_CLOSE));
		GridPane content = new GridPane();
		content.getColumnConstraints().add(new ColumnConstraints(90));
		ColumnConstraints slidersColumn = new ColumnConstraints();
		slidersColumn.setHgrow(Priority.ALWAYS);
		content.getColumnConstraints().add(slidersColumn);
		Slider hSlider = new Slider(0, 360, 0);
		//hSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setHueShift(hSlider.getValue())));
		content.add(new Label("Hue"), 0, 0);
		content.add(hSlider, 1, 0);
		Slider sSlider = new Slider(0, 1, 1);
		//sSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setSaturationShift(sSlider.getValue())));
		content.add(new Label("Saturation"), 0, 1);
		content.add(sSlider, 1, 1);
		Slider lSlider = new Slider(0, 2, 1);
		//lSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setLightnessShift(lSlider.getValue())));
		content.add(new Label("Lightness"), 0, 2);
		content.add(lSlider, 1, 2);
		dbox.getDialogPane().setContent(content);
		dbox.showAndWait();
	}

	private void colorShiftPen() {
		Dialog dbox = new Dialog();
		dbox.setTitle("Adjust_Color");
		dbox.setHeaderText("Adjust_Color_Content");
		dbox.getDialogPane().getButtonTypes().add(new ButtonType("Okay", ButtonBar.ButtonData.CANCEL_CLOSE));
		GridPane content = new GridPane();
		content.getColumnConstraints().add(new ColumnConstraints(90));
		ColumnConstraints slidersColumn = new ColumnConstraints();
		slidersColumn.setHgrow(Priority.ALWAYS);
		content.getColumnConstraints().add(slidersColumn);
		Slider hSlider = new Slider(0, 360, 0);
		//hSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setHueShift(hSlider.getValue())));
		content.add(new Label("Hue"), 0, 0);
		content.add(hSlider, 1, 0);
		Slider sSlider = new Slider(0, 1, 1);
		//sSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setSaturationShift(sSlider.getValue())));
		content.add(new Label("Saturation"), 0, 1);
		content.add(sSlider, 1, 1);
		Slider lSlider = new Slider(0, 2, 1);
		//lSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setLightnessShift(lSlider.getValue())));
		content.add(new Label("Lightness"), 0, 2);
		content.add(lSlider, 1, 2);
		dbox.getDialogPane().setContent(content);
		dbox.showAndWait();
	}
}




