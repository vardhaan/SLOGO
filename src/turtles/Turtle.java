package turtles;

import java.util.Observable;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Turtle extends Observable implements Cloneable{

	private double xPos;
	private double yPos;
	private double previousxPos;
	private double previousyPos;

	private double heading;
	private double previousHeading;
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
	private ImageView turtleView;
	private ArrayList<Line> myLines = new ArrayList<Line>();
	private Pane myRoot;
	private Animation myAnimation;

	public static final double DEFAULT_TURTLE_SPEED = 100; //pixels or degrees per second
	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 90;
	private static final double FULL_CIRCLE = 360;
	private double width=1050;
	private double height=625;
	public Turtle(int id, Pane myRootIn) {
		myRoot = myRootIn;
		this.xPos =0;
		this.yPos = 0;
		this.previousxPos = 0;
		this.previousyPos = 0;
		this.heading = 0;
		showing = true;
		penDown=true;
		myImageIndex=0;
		myPenColorIndex=0;
		turtleSpeed=DEFAULT_TURTLE_SPEED;
		myID=id;

	}

	public void setTurtleView(ImageView tv) {
		turtleView = tv;
	}

	public void setX(double newX) {
		previousxPos=xPos;	
		xPos = move(previousxPos,newX,width);
		if(xPos!=previousxPos){
			myAnimation = moveAnimation();
			myAnimation.play();
		}
		updatePen();

	}

	private double move(double previous, double current, double parameter) {
		if(current>=parameter){
			current=current % parameter;
			return current;
		}
		else if(current<0){
			current=parameter-Math.abs(current % parameter);
			return current;
		}
		return current;
	}

	public void setY(double newY) {
		previousyPos = yPos;
		yPos = move(previousyPos,newY,getGridHeight());
		
		if(yPos!=previousyPos){
			myAnimation = moveAnimation();
			myAnimation.play();
		}

	}

	private void updatePen(){
		if (penDown){
			Line current = new Line(previousxPos, previousyPos + 25, xPos, yPos + 25);
			myLines.add(current);
			myRoot.getChildren().add(current);
		}
	}

	private Animation moveAnimation(){
		Path path = new Path();
		path.getElements().addAll(new MoveTo(previousxPos + 25, previousyPos + 25), new LineTo(xPos+25, yPos+25));
		PathTransition pt = new PathTransition(Duration.seconds(2), path, turtleView);
		return new SequentialTransition(turtleView, pt);
	}
	private Animation rotateAnimation(){
		RotateTransition rt = new RotateTransition(Duration.seconds(1));
		rt.setToAngle(heading);
		return new SequentialTransition(turtleView, rt);
	}
	private Animation makeAnimation () {
		//System.out.println("Animation called");
		double xTrans=xPos+25;
		double yTrans=yPos+25;
		//if(previousxPos!=xPos && previousyPos!=yPos){
		boolean rotate = false; 
		RotateTransition rt = new RotateTransition(Duration.seconds(2));
		if(heading!=previousHeading){
			rt.setToAngle(heading);
			rotate = true;
		}
		System.out.println("The angle is:" + rt.getByAngle());

		Path path = new Path();
		path.getElements().addAll(new MoveTo(previousxPos + 25, previousyPos + 25), new LineTo(xTrans, yTrans));
		//path.getElements().addAll(new MoveTo(xPos, yPos), new HLineTo(xTrans), new VLineTo(yTrans));
		//System.out.println(xPos);
		//System.out.println(yPos);
		PathTransition pt = new PathTransition(Duration.seconds(2), path, turtleView);
		if(rotate){
			return new SequentialTransition(turtleView, rt, pt);
		}else{
			return new SequentialTransition(turtleView, pt);
		}
	}


	public void clearLines(){
		for(Line current: myLines){
			myRoot.getChildren().remove(current);
		}
		System.out.println("clearsLine");
		myLines.clear();
	}

	public double getX() {
		return this.xPos;
	}

	public double getY() {
		return this.yPos;
	}

	public double getPreviousX() {
		return this.previousxPos;
	}

	public double getPreviousY() {
		return this.previousyPos;
	}


	public double getHeading() {
		return this.heading;
	}

	private double getGridHeight() {
		//TODO: IMPLEMENT, GET FROM FRONTEND
		return height;
	}

	private double getGridWidth() {
		//TODO: IMPLEMENT, GET FROM FRONTEND
		return width;
	}

	public void setHeading(double newHeading) {
		previousHeading = heading;
		heading = newHeading;
		
			myAnimation = rotateAnimation();
			myAnimation.play();
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