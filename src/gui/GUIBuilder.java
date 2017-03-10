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
		Pane turtleRoot = new Pane();
		TurtleViewer tv = new TurtleViewer(0, turtleRoot);
		myRoot.getChildren().add(turtleRoot);
		GridPane.setConstraints(turtleRoot, 0, 1);
		
		Parser myParser = new Parser(tv);
		myParser.changeLanguage(myLanguage);
		
		ConsoleBuilder b = new ConsoleBuilder(myResources, myParser, tv);
		b.buildConsole(myRoot);

		MenuBuilder m=new MenuBuilder(tv);
		m.buildMenu(myRoot);
		
		GridBuilder g = new GridBuilder("0");
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
