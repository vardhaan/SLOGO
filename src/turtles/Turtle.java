package turtles;

import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

public class Turtle extends Observable implements Cloneable{

	private double xPos;
	private double yPos;
	private double heading;
	private boolean showing;
	private double xChange;
	private double yChange;
	private double headingChange;
	private double commandCounter;
	private double updateSpeed;
	private double turtleSpeed;
	private boolean penDown;
	private int myImageIndex;
	private int myPenColorIndex;
	private int myID;
	
	
	public static final double DEFAULT_TURTLE_SPEED = 100; //pixels or degrees per second
	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 90;
	public static final double size=700;
	public Turtle(int id) {
		setX(DEFAULT_X_POS);
		setY(DEFAULT_Y_POS);
		setHeading(DEFAULT_ANGLE);
		showing = true;
		penDown=true;
		myImageIndex=0;
		myPenColorIndex=0;
		turtleSpeed=DEFAULT_TURTLE_SPEED;
		myID=id;
	
	}
	
	public void setX(double newX) {
		double gridXDisplacement = getGridWidth()/2.0;
		this.xPos = newX + gridXDisplacement;
		if(Math.abs(xPos)>=getGridWidth()){
			
		}
	}
	
	public void setY(double newY) {
		double gridYDisplacement = getGridHeight()/2.0;
		this.yPos = newY + gridYDisplacement;
	}
	
	public double getX() {
		return this.xPos - (getGridWidth()/2.0);
	}
	
	public double getY() {
		return this.yPos - (getGridHeight()/2.0);
	}
	
	public double getHeading() {
		return this.heading;
	}
	
	private double getGridHeight() {
		//TODO: IMPLEMENT, GET FROM FRONTEND
		return size;
	}
	
	private double getGridWidth() {
		//TODO: IMPLEMENT, GET FROM FRONTEND
		return size;
	}
	
	public void setHeading(double newHeading) {
		this.heading = newHeading;
	}
	
	public boolean showTurtle(){
		//notifyChange();
		return showing;
	}
	
	public void setShow(boolean b){
		showing = b;
		
	}
	
	//here the method is for the PENDOWN command
	public void setPenDown(boolean b){
		penDown = b ;
	}
	
	public boolean  isPenDown(){
		return penDown;
	}
	public boolean getPen(){
		return penDown;
	}
	
	public void setOverallXChange(double overallXChange) {
		double incrementalXChange = getIncrementalChange(overallXChange);
		xChange = incrementalXChange;
		
	}
	
	public void setOverallYChange(double overallYChange) {
		double incrementalXChange = getIncrementalChange(overallYChange);
		yChange = incrementalXChange;
		
	}
	
	public void setOverallHeadingChange(double overallHeadingChange) {
		double incrementalHeadingChange = getIncrementalChange(overallHeadingChange);
		headingChange = incrementalHeadingChange;
	}
	
	private double getIncrementalChange(double overallChange) {
		double timeToComplete = overallChange/turtleSpeed;
		double numUpdateIncrements = timeToComplete*updateSpeed;
		commandCounter = numUpdateIncrements;
		double incrementalChange = overallChange/numUpdateIncrements;
		return incrementalChange;
	}
	
	public List<Double> getAllChange() {
		List<Double> changes = new ArrayList<Double>();
		changes.add(getXChange());
		changes.add(getYChange());
		changes.add(getHeadingChange());
		
		return changes;
	}
	public int setImageIndex(int index){
		myImageIndex=index;			
		return myImageIndex;
	}
	
	public int getImageIndex(){
		return myImageIndex;
	}
	public int getID(){
		return myID;
	}
	public int setPenColorIndex(int index){
		myPenColorIndex=index;
		return myPenColorIndex;
	}
	public int getPenColorIndex(){
		return myPenColorIndex;
	}
	private Double getXChange() {
		if (commandCounter>1) {
			//if the xChange is greater than 
			return xChange ;
		}
		if (commandCounter>0) {
			return xChange*commandCounter;
		} else {
			return 0.0;
		}
	}
	
	private double getWidth(){
		//TODO: get the size of the grid
		return 0;
	}
	
	private Double getYChange() {
		if (commandCounter>1) {
			return yChange;
		}
		if (commandCounter>0) {
			return yChange*commandCounter;
		} else {
			return 0.0;
		}
	}
	
	private Double getHeadingChange() {
		if (commandCounter>1) {
			return headingChange;
		}
		if (commandCounter>0) {
			return headingChange*commandCounter;
		} else {
			return 0.0;
		}
	}
		
}