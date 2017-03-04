package gui;

import java.util.ResourceBundle;

import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class VariableBoxBuilder {
	private TextArea variables;
	
	public VariableBoxBuilder(ResourceBundle myResources){
		variables = new TextArea();
		variables.setEditable(false);
		variables.setPrefColumnCount(10);
		variables.setPrefRowCount(5);
		variables.setMinHeight(100);
		variables.setMaxHeight(100);
		double xloc = 10;
		double yloc = 11;
		double angle = 12.1;
		variables.setText(String.format("X: %f \nY: %f \nAngle: %f", xloc, yloc, angle));
	}
	
	public void buildVariableBox(GridPane myRoot){
		GridPane.setConstraints(variables, 1, 1);
		GridPane.setColumnSpan(variables, 2);
		myRoot.getChildren().addAll(variables);
	}
	
	public void updateVariables(double x, double y, double angle){
		variables.setText(String.format("X: %f \nY: %f \nAngle: %f", x, y, angle));
	}
	
	

}
