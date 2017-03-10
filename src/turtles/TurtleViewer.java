package turtles;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
//import javafx.scene.paint.Color;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import turtles.Turtle;

public class TurtleViewer{

	private Turtle myTurtle;
	private ArrayList<Turtle> turtles=new ArrayList<Turtle>();
	private int currentID = 0;
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
	private String currentImage = "images/slogo1.jpg";
	private Line line;

	private Pane myRoot;

	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 0;
	private ImageView myTurtleImage;

	public TurtleViewer(Pane myRootIn){
		myRoot = myRootIn;
		myTurtle=new Turtle(currentID, myRoot);
		currentID++;
		turtles.add(myTurtle);
		Image image2 = new Image(currentImage);
		myTurtleImage=new ImageView(image2);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myRoot.getChildren().add(myTurtleImage);
		myTurtle.setTurtleImage(myTurtleImage);
	}

	//TODO: Zhiyong, get the all the turtles as a HashMap
	//and then test whether it is active
	public ArrayList<Turtle> getTurtleList(){
		return turtles;
	}

	public void buildTurtle(Pane myRoot){
		Image image2 = new Image(currentImage);
		myTurtleImage=new ImageView(image2);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myRoot.getChildren().add(myTurtleImage);
	}

	public void clear(){
		for(Turtle t: turtles){
			t.setX(DEFAULT_X_POS);
			t.setY(DEFAULT_Y_POS);
			t.setHeading(DEFAULT_ANGLE);
			t.clearLines();
		}
	}

	public void addTurtle(){
		turtles.add(new Turtle(currentID, myRoot));
		currentID++;
		Image tempImage = new Image(currentImage);
		myTurtleImage=new ImageView(tempImage);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myRoot.getChildren().add(myTurtleImage);
		myTurtle.setTurtleImage(myTurtleImage);
	}
	
	public Turtle getTurtle(int ID) throws Exception{
		if (turtles.size() > ID){
			return turtles.get(ID);
		}
		else {
			throw new Exception("ID not found");
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
/*	public void setX(ImageView turtleImage, int myID) throws Exception {
		turtleImage.setX(getTurtle(myID).getX());
		updatePen();
	}
	public void setY(ImageView turtleImage, int myID) throws Exception {
		turtleImage.setY(getTurtle(myID).getY());
		updatePen();
	} */
	
	public void setImage(String imageIn){
		currentImage = imageIn;
		for(Turtle t: turtles){
			if(t.getActivity())
				t.setImage(new Image(currentImage));
		}
	}

	private void updatePen(){
		if (myTurtle.getPen()){
			Line current = new Line(myTurtle.getPreviousX(), myTurtle.getPreviousY(), myTurtle.getX(), myTurtle.getY());
			myLines.add(current);
			myRoot.getChildren().add(current);
		}
	}

}