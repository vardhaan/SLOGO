package turtles;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
//import javafx.scene.paint.Color;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import turtles.Turtle;
import turtles.TurtleHandler;

public class TurtleViewer extends Observable implements Observer{

	private Turtle myTurtle;
	private HashMap<Integer,Turtle> turtles=new HashMap<Integer,Turtle>();
	private ArrayList<Line> myLines = new ArrayList<Line>();
	private double xPos;
	private double yPos;
	private double heading;
	private boolean penDown;
	private boolean showing;
	private double xChange;
	private double yChange;
	private double headingChange;
	private double commandCounter;
	private double updateSpeed;
	private double turtleSpeed;
	private Dimension panelSize;
	public static final double DEFAULT_SIZE = 700;
	public static final String TURTLE_IMAGE="images/slogo1.jpg";
	private Line line;
	
	private Pane myRoot;
	//private Workspace myWorkspace;
	public static String turtleimage1="slogo1.jpg";

	public static final double DEFAULT_TURTLE_SPEED = 100; //pixels or degrees per second
	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 0;
	private ImageView myTurtleImage;

	public TurtleViewer(int myID, Pane myRootIn){
		myRoot = myRootIn;
		myTurtle=new Turtle(myID, myRoot);
		turtles.put(myID, myTurtle);
		Image image2 = new Image(TURTLE_IMAGE);
		myTurtleImage=new ImageView(image2);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myRoot.getChildren().add(myTurtleImage);
		myTurtle.setTurtleView(myTurtleImage);
	}

	public void buildTurtle(Pane myRoot){
		Image image2 = new Image("images/slogo1.jpg");
		myTurtleImage=new ImageView(image2);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myRoot.getChildren().add(myTurtleImage);
	}
	
	public void clear(){
		myTurtle.setX(DEFAULT_X_POS);
		myTurtle.setY(DEFAULT_Y_POS);
		myTurtle.setHeading(DEFAULT_ANGLE);
		myTurtle.clearLines();
	}

	public void addTurtle(int ID){
		turtles.put(ID,new Turtle(ID, myRoot));

	}
	public Turtle getTurtle(int ID) throws Exception{
		if (turtles.containsKey(ID)){
			return turtles.get(ID);
		}
		else {
			throw new Exception("ID not found" );
		}
	}
	
	public void PaintingView (Turtle turtle, String ImagePath, GridPane myRoot){
		Line lines=line;

		/*
		if (turtle.getPen()){
			lines.setFill(javafx.scene.paint.Color.AQUA);

		}
		 */
	}
	public void setX(ImageView turtleImage, int myID) throws Exception {
		turtleImage.setX(getTurtle(myID).getX());
		updatePen();
	}
	public void setY(ImageView turtleImage, int myID) throws Exception {
		turtleImage.setY(getTurtle(myID).getY());
		updatePen();
	}
	
	private void updatePen(){
		System.out.println("Update pen is called");
		if (myTurtle.getPen()){
			Line current = new Line(myTurtle.getPreviousX(), myTurtle.getPreviousY(), myTurtle.getX(), myTurtle.getY());
			myLines.add(current);
			myRoot.getChildren().add(current);
		}
	}
	

	@Override
	public void update(Observable turtle, Object arg1) {
		setChanged();
		notifyObservers();
	}
	public void addObserver(Observer o){
		setChanged();
		notifyObservers();
		super.addObserver(o);
	}

}
