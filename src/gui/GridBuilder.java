package gui;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Shape;

public class GridBuilder {

	private GridPane myGrid;
	private int rowBounds = 20;
	private int colBounds = 20;
	
	public GridBuilder(){
		myGrid = new GridPane();
		myGrid.setPrefHeight(700);
		myGrid.setPrefWidth(1200);
		myGrid.setGridLinesVisible(false);
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
