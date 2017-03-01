package gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import gui.MenuBuilder;
import turtles.TurtleViewer;

public class GUIBuilder {

	public static final String RESOURCE_LOCATION =  "resources/gui";
	ResourceBundle myResources;
	
	public GUIBuilder(){

		myResources = ResourceBundle.getBundle(RESOURCE_LOCATION);
		
	}

	public void buildGUI(GridPane myRoot){
		ConsoleBuilder b = new ConsoleBuilder(myResources);
		b.buildConsole(myRoot);

		MenuBuilder2 m=new MenuBuilder2();
		m.buildMenu(myRoot);

		VariableBoxBuilder v = new VariableBoxBuilder(myResources);
		v.buildVariableBox(myRoot);
		
		GridBuilder g = new GridBuilder();
		g.buildGrid(myRoot);
		TurtleViewer one=new TurtleViewer(0);
		one.buildTurtle(myRoot);
		
	}

	public GridPane buildGridPane(){
		GridPane myRoot = new GridPane();
		myRoot.setPadding(new Insets(10,10,10,10));
		myRoot.setHgap(20);
		myRoot.setVgap(5);
		return myRoot;
	}
	public MenuBar buildMenu(){
		MenuBar myMenu=new MenuBar();
		return myMenu;	
	}

	public void buildGUI(MenuBar myMenu) {
		// TODO Auto-generated method stub

	}

}
