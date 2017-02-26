package gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import gui.MenuBuilder;

public class GUIBuilder {

    protected final List<String> history = new ArrayList<>();
    protected int historyPointer = 0;
    //public String RESOURCES_LOCATION;
    

    private Consumer<String> onMessageReceivedHandler;
    
	public GUIBuilder(){
		
	}
	
	public void buildGUI(GridPane myRoot){
		ConsoleBuilder b = new ConsoleBuilder();
		b.buildConsole(myRoot);
		
		MenuBuilder m=new MenuBuilder();
		m.buildMenu(myRoot);
		
		VariableBoxBuilder v = new VariableBoxBuilder();
		v.buildVariableBox(myRoot);
	}
	
	public GridPane buildGridPane(){
		GridPane myRoot = new GridPane();
		myRoot.setPadding(new Insets(10,10,10,10));
		myRoot.setHgap(2);
		myRoot.setVgap(2);
		return myRoot;
	}
	public MenuBar buildMenu(){
	MenuBar myMenu=new MenuBar();
	return myMenu;	
	}
	
	public void buildVariableBox(BorderPane myRoot){
		
	}
	
	public void buildCommandBox(BorderPane myRoot){
		
	}

	public void buildGUI(MenuBar myMenu) {
		// TODO Auto-generated method stub
		
	}

}
