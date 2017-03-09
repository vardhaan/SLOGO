package gui;

import java.util.ResourceBundle;

import commands.Parser;
import javafx.geometry.Insets;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import gui.MenuBuilder;
import turtles.TurtleViewer;

public class GUIBuilder {

	public static final String RESOURCE_LOCATION =  "resources/gui";
	private ResourceBundle myResources = ResourceBundle.getBundle(RESOURCE_LOCATION);
	private String myLanguage;
	
	public GUIBuilder(String languageIn){
		myLanguage = languageIn;
	}

	public void buildGUI(GridPane myRoot){
		Pane myRoot2 = new Pane();
		TurtleViewer tv = new TurtleViewer(0, myRoot2);
		myRoot.getChildren().add(myRoot2);
		GridPane.setConstraints(myRoot2, 0, 1);
		
		Parser myParser = new Parser(tv);
		myParser.changeLanguage(myLanguage);
		
		ConsoleBuilder b = new ConsoleBuilder(myResources, myParser, tv);
		b.buildConsole(myRoot);

		MenuBuilder m=new MenuBuilder(tv);
		m.buildMenu(myRoot);
		
		GridBuilder g = new GridBuilder();
		g.buildGrid(myRoot);
	}
	
	
	public MenuBar buildMenu(){
		MenuBar myMenu=new MenuBar();
		return myMenu;	
	}

	public void buildGUI(MenuBar myMenu) {
		// TODO Auto-generated method stub

	}

}
