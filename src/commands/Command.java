package commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.PopUpException;
import exceptions.ParameterNotEnoughException;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import turtles.Turtle;
import javafx.scene.image.Image;

public abstract class Command {
	protected List<Double> parameters;
	protected double returnValue;
	protected double expectedNumParameters = 0;
	protected Command dependent;
	protected int numCommandAsParam;
	protected Turtle target;
	//the background index
	protected Map<Integer, Color> backgroundColor;
	//the pen color index
	protected Map<Integer, Color> penColor;
	//the pen size
	protected Map<Integer, Double> penSize;
	//the shape (image) of the turtle
	protected Map<Integer, Image> shape;
	//the index of RGB
	protected Map<Integer, List<Integer>> RGBMap;
	

	
	public Command() {
		parameters = new ArrayList<Double>();
		returnValue = 0;
		backgroundColor = new HashMap<>();
		//the default background color
		backgroundColor.put(0, Color.WHITE);
		penColor = new HashMap<>();
		//the default pen color
		penColor.put(0, Color.BLACK);
		penSize = new HashMap<>();
		//the default pen size or thickness
		penSize.put(0, 1.0);
		
		shape = new HashMap<>();
		Image image = new Image("images/slogo1.jpg");
		//default image
		shape.put(0, image);
		
		RGBMap = new HashMap<>();
		List<Integer> initRGB = new ArrayList<>();
		initRGB.addAll(Arrays.asList(0, 0 , 0));
		RGBMap.put(0, initRGB);
		
	}
	
	public List<Double> getParameters() {
		return parameters;
	}
	
	public void setTurtle(Turtle turtle) {
		// TODO Auto-generated method stub
		target = turtle;
		
	}
	
	public boolean needsVariable() {
		return false;
	}
	
	public double getNumParameters() {
		return expectedNumParameters;
		
	}
	
	public boolean needsParameter() {
		return !(parameters.size() + numCommandAsParam == expectedNumParameters);
	}
	
	public boolean needsCommand() {
		return needsParameter();
	}
	
	public void addCommand(Command toAdd) {
		toAdd.setDependent(this);
	}
	
	public double getReturnValue() {
		return returnValue;
	}
	
	public void addParameter(Double param) {
		this.parameters.add(param);
	}
	
	protected void sendReturnToDependent() {
		if (dependent != null) {
			dependent.numCommandAsParam--;
			dependent.addParameter(returnValue);
			
			System.out.println("Dependent, " + dependent.getClass().getSimpleName() + ", now has " + dependent.parameters.size() + " " + numCommandAsParam + " because of " + this.getClass().getSimpleName());
		}
		
	}
	
	public void setDependent(Command dependent) {
		this.dependent = dependent;
		dependent.numCommandAsParam++;
		//System.out.println("Dependent is set " + dependent.getClass().getName());
		//System.out.println(dependent.numCommandAsParam + " is numComAsParam");
		//System.out.println("dependent now has: " + (dependent.numCommandAsParam+dependent.parameters.size()));
	}
	
	public void setReturnValue() throws ParameterNotEnoughException {
		if (parameters.size() == expectedNumParameters) {
				returnValue = (parameters.get(parameters.size()-1));				
				sendReturnToDependent();
		} else {
			ParameterNotEnoughException p =  new ParameterNotEnoughException();
			PopUpException pop = new PopUpException(p.getMessage());
			pop.showMessage();
		}
		
	}
	
	public abstract double executeCommand();
}