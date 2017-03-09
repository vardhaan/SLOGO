package turtles;

import java.util.Observable;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;
import lines.Lines;

import java.util.ArrayList;
import java.util.List;

public class Turtle extends Observable implements Cloneable{
	


	private double xPos;
	private double yPos;
	private double previousxPos;
	private double previousyPos;
	private double prevprevxPos;
	private double prevprevyPos;
	private double heading;
	private double previousHeading;
	private double prevprevHeading;
	private boolean showing;
	private boolean penDown;
	private int myImageIndex;
	private int myPenColorIndex;
	private int myID;
	private ImageView turtleImage;
	private ArrayList<Lines> myLines = new ArrayList<Lines>();
	private Pane myRoot;
	private Animation myAnimation;

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
		myID=id;
		myPenColorIndex = 0;

	}

	public void setTurtleImage(ImageView imageIn) {
		turtleImage = imageIn;
	}

	public void setX(double newX) {
		prevprevxPos = previousxPos;
		previousxPos=xPos;	
		xPos = move(previousxPos,newX,width);
		if(xPos!=previousxPos){
			myAnimation = moveAnimation();
			myAnimation.play();
		}
		updatePen(myPenColorIndex);

	}

	public void setY(double newY) {
		prevprevyPos=previousyPos;
		previousyPos = yPos;
		yPos = move(previousyPos,newY,height);

		if(yPos!=previousyPos){
			myAnimation = moveAnimation();
			myAnimation.play();
		}
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

	private void updatePen(int index){
		if (penDown){
			Lines current = new Lines(previousxPos, previousyPos + 25, xPos, yPos + 25);
			current.setColorIndex(index);
			System.out.println("Color is here");
			myLines.add(current);
			myRoot.getChildren().add(current.getLine());
		}
	}

	private Animation moveAnimation(){
		Path path = new Path();
		path.getElements().addAll(new MoveTo(previousxPos + 25, previousyPos + 25), new LineTo(xPos+25, yPos+25));
		PathTransition pt = new PathTransition(Duration.seconds(2), path, turtleImage);
		return new SequentialTransition(turtleImage, pt);
	}
	
	private Animation rotateAnimation(){
		RotateTransition rt = new RotateTransition(Duration.seconds(1));
		rt.setToAngle(heading);
		return new SequentialTransition(turtleImage, rt);
	}

	public void clearLines(){
		for(Lines current: myLines){
			myRoot.getChildren().remove(current.getLine());
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

	public void setHeading(double newHeading) {
		prevprevHeading=previousHeading;
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

	public void setPenDown(boolean b){
		penDown = b ;
	}

	public boolean getPen(){
		return penDown;
	}
	
	public void setprev(){
		/*Pos=previousxPos;
		yPos=previousyPos;
		heading=	previousHeading;
		*/
		setX(previousxPos);
		setY(previousyPos);
		setHeading(previousHeading);
		clearprevlines();
	}
	public void clearprevlines(){
		myLines.remove(myLines.size()-1);
		myLines.remove(myLines.size()-1);
	}
	
	public void setImage(Image imageIn){
		turtleImage.setImage(imageIn);
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

}