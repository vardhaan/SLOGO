package gui;

import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

public class MenuBuilder {
	private MenuBar menu;
	//public static final String RESOURCES_LOCATION = "resources";
	//public static final ResourceBundle myResources = ResourceBundle.getBundle(RESOURCES_LOCATION);
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
		myRoot.getChildren().addAll(menu);
	}

	private Menu intHelpMenu() {
		MenuItem viewHelp = new MenuItem("View_Readme");
		viewHelp.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		viewHelp.setOnAction(e -> openReadme());
		MenuItem viewJavadoc = new MenuItem("View_Documentation");
		viewJavadoc.setAccelerator(new KeyCodeCombination(KeyCode.J, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		viewJavadoc.setOnAction(e -> openJavadoc());
		MenuItem about = new MenuItem("About");
		about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
		about.setOnAction(e -> about());
		return new Menu("Help", null, viewHelp, viewJavadoc, about);
	}// TODO Auto-generated method stub
	private void about() {
		Alert about= new Alert(Alert.AlertType.INFORMATION);
		about.setHeaderText("Slogo");
		about.setTitle("About");
		about.setContentText("AboutContent");
		about.showAndWait();
	}

	private Object openJavadoc() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object openReadme() {
		// TODO Auto-generated method stub
		return null;
	}


	private Menu initResetMenu() {
		MenuItem resetSimulation = new MenuItem("reset");
		resetSimulation.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN));
		return new Menu("Reset", null, resetSimulation);
	}

	private Menu initSettingsMenu() {
		MenuItem colorShiftPen = new MenuItem("Adjust_PenColor");
        colorShiftPen.setOnAction(e -> colorShiftPen());
        MenuItem BackgroundColor= new MenuItem("Background_Color");
        BackgroundColor.setOnAction(e-> BackgroundColor());
        MenuItem Language = new MenuItem("Language");
        Language.setOnAction(e-> Language());
		return new Menu("Settings", null, Language,BackgroundColor,colorShiftPen );
        
        
	}

	private Object Language() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object BackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object colorShiftPen() {
		// TODO Auto-generated method stub
		return null;
	}



}
