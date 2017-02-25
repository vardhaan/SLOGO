package gui;

import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class VariableBoxBuilder {
	private TextArea variables;
	
	public VariableBoxBuilder(){
		variables = new TextArea();
		variables.setEditable(false);
		double xloc = 10;
		double yloc = 11;
		double angle = 12.1;
		variables.setText(String.format("X: %f \n Y: %f \n Angle: %f", xloc, yloc, angle));
	}
	
	public void buildVariableBox(GridPane myRoot){
		GridPane.setConstraints(variables, 3, 1);
		GridPane.setColumnSpan(variables, 3);
		myRoot.getChildren().addAll(variables);
	}
	
	public void updateVariables(double x, double y, double angle){
		variables.setText(String.format("X: %f \nY: %f \nAngle: %f", x, y, angle));
	}
	
	

}
