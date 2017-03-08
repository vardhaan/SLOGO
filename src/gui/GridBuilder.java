package gui;


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

	private GridPane myGrid;
	private int rowBounds = 20;
	private int colBounds = 20;
	
	public GridBuilder(){
		myGrid = new GridPane();
		myGrid.setPrefHeight(500);
		myGrid.setPrefWidth(1050);
		myGrid.setGridLinesVisible(false);
		
	}
	
	//the color is the one in the backgroundcolor.properties
	//TODO: Zhiyong ,need to set background color
	public void setBackgroundColor(String index){
		Background b = new Background(new BackgroundFill((Paint)(Color.web(index)), null, null));
		myGrid.setBackground(b);
		myGrid.setOpacity(OPACITY);
		
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
