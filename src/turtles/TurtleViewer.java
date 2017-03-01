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
import javafx.scene.shape.Line;
import turtles.Turtle;
import turtles.TurtleHandler;

public class TurtleViewer extends Observable implements Observer, Iterable<Turtle>{

	private Turtle myTurtle;
	private List<Turtle> turtles=new ArrayList<Turtle>();
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
	public static final String TURTLE_IMAGE="";
	private Line line;
	//private Workspace myWorkspace;
	public static String turtleimage1="slogo1.jpg";

	public static final double DEFAULT_TURTLE_SPEED = 100; //pixels or degrees per second
	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 90;
	private ImageView myTurtleImage;

	public TurtleViewer(int myID){
		myTurtle=new Turtle(myID);
	}

	public void buildTurtle(GridPane myRoot){
		Image image2 = new Image("images/slogo1.jpg");
		myTurtleImage=new ImageView(image2);
		myTurtleImage.setX(myTurtle.getX());
		myTurtleImage.setY(myTurtle.getY());
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myRoot.getChildren().add(myTurtleImage);
	}


	public void getTurtle(Turtle turtlename){
		turtles.add(turtlename);

	}
	public void PaintingView (Turtle turtle, String ImagePath, GridPane myRoot){
		Line lines=line;


		
		/*
		if (turtle.getPen()){
			lines.setFill(javafx.scene.paint.Color.AQUA);

		}
		 */
	}

	public Iterator<Turtle> iterator() {
		return turtles.iterator();
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
