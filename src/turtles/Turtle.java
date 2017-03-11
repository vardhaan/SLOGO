package turtles;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import lines.Lines;

import java.util.ArrayList;
import java.util.List;

public class Turtle{

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
	private List<Lines> myLines; 
	private Pane myRoot;
	private Animation myAnimation;

	private double width=1000;
	private double height=430;

	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 0;
	//private static final double FULL_CIRCLE = 360;
	private int myPenSize;
	private ImageView turtleImage;
	private boolean isActive;
	/**
	 * This method instantiates the turtle and gives its original characteristics
	 * @param id
	 * @param Pane 
	 */
	public Turtle(int id, Pane myRootIn) {
		myRoot = myRootIn;
		xPos = DEFAULT_X_POS;
		yPos = DEFAULT_Y_POS;
		previousxPos = DEFAULT_X_POS;
		previousyPos = DEFAULT_Y_POS;
		heading = DEFAULT_ANGLE;
		myLines= new ArrayList<Lines>();
		showing = true;
		penDown=true;
		myImageIndex=0;
		myPenColorIndex=0;
		myID=id;
		myPenColorIndex = 0;
		myPenSize = 4;
		isActive = true;
	}
	/**
	 * This method sees if the turtle is active or not
	 */
	public boolean getActivity(){
		return isActive;
	}

	public void setActivity(boolean b){
		isActive = b;
	}

	public void setTurtleImage(ImageView imageIn) {
		turtleImage = imageIn;
	}
	/**
	 * This method sets the new x position of the turtle depending on where it is and if its active or not
	 * @param X coordinate
	 */
	public void setX(double newX) {
		if(isActive){
			prevprevxPos = previousxPos;
			previousxPos=xPos;	
			xPos = checkBounds(previousxPos,newX,width);
			if(xPos!=previousxPos){
				myAnimation = moveAnimation();
				myAnimation.play();
			}
			updatePen(myPenColorIndex, myPenSize);
		}

	}
	/**
	 * This method sets the new y position of the turtle depending on where it is and if its active or not
	 * @param Ycoordinate
	 */
	public void setY(double newY) {
		if(isActive){
			prevprevyPos=previousyPos;
			previousyPos = yPos;
			yPos = checkBounds(previousyPos,newY,height);
			if(yPos!=previousyPos){
				myAnimation = moveAnimation();
				myAnimation.play();
			}
		}
	}

	private double checkBounds(double previous, double current, double parameter) {
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

	private void updatePen(int colorIndex, int penSize){
		if (penDown){
			Lines current = new Lines(previousxPos, previousyPos + 25, xPos, yPos + 25);
			current.setColorIndex(colorIndex);
			current.setThickness(penSize);
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
		if(isActive){
			prevprevHeading=previousHeading;
			previousHeading = heading;
			heading = newHeading;

			myAnimation = rotateAnimation();
			myAnimation.play();
		}
	}

	public boolean showTurtle(){
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
		myRoot.getChildren().remove(myRoot.getChildren().size()-1);
		myLines.remove(myLines.size()-1);
		//myLines.remove(myLines.size()-1);
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

	public int setPenSize(int pixel){
		myPenSize = pixel;
		return myPenSize;
	}
}