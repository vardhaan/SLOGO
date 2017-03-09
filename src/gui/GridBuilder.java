package gui;


import java.util.ResourceBundle;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class GridBuilder {
	
	//the default opacity of the background
	public static final double OPACITY = 0.5;
	public static final String RESOURCE_BUNDLE = "index/backgroundcolor";

	private GridPane myGrid;
	private int rowBounds = 20;
	private int colBounds = 20;
	
	public GridBuilder(){
		myGrid = new GridPane();
		myGrid.setPrefHeight(500);
		myGrid.setPrefWidth(1050);
		myGrid.setGridLinesVisible(false);
		
	}
	//TODO: add by Zhiyong
	public GridBuilder(String index){
		this();
		ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
		Background b = new Background(new BackgroundFill((Paint)(Color.web(resources.getString(index))), null, null));
		myGrid.setBackground(b);
		myGrid.setOpacity(OPACITY);
		System.out.println("The op is " + myGrid.getOpacity());
		
	}
	
	//the color is the one in the backgroundcolor.properties
	//TODO: Zhiyong ,need to set background color
	public void setBackgroundColor(String index){
		ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
		Background b = new Background(new BackgroundFill((Paint)(Color.web(resources.getString(index))), null, null));
		myGrid.setBackground(b);
		myGrid.setOpacity(OPACITY);
	
	}
	
	public GridPane getGrid(){
		return myGrid;
	}

	public void buildGrid(GridPane myRoot) {
		for (int i = 0; i < rowBounds; i++) {
			RowConstraints rowConstraint = new RowConstraints();
			rowConstraint.setPercentHeight(100);
			myGrid.getRowConstraints().add(rowConstraint);
		}
		for (int i = 0; i < colBounds; i++) {
			ColumnConstraints colConstraint = new ColumnConstraints();
			colConstraint.setPercentWidth(100);
			myGrid.getColumnConstraints().add(colConstraint);
		}
		GridPane.setHalignment(myGrid, HPos.CENTER);
		GridPane.setValignment(myGrid, VPos.CENTER);
		GridPane.setConstraints(myGrid, 0, 1);
		GridPane.setRowSpan(myGrid, 2);
		myRoot.getChildren().add(myGrid);
	}

}
