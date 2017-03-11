package turtles;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import turtles.Turtle;

public class TurtleViewer{

	private ArrayList<Turtle> turtles = new ArrayList<Turtle>();
	private ArrayList<Turtle> activeTurtles = new ArrayList<Turtle>();
	public static final double DEFAULT_SIZE = 700;
	private String currentImage = "images/slogo1.jpg";
	private String inactiveImage = "images/slogo1in.jpg";
	private Pane myRoot;

	public static final double DEFAULT_X_POS = 500;
	public static final double DEFAULT_Y_POS = 215;
	public static final double DEFAULT_ANGLE = 0;

	public TurtleViewer(Pane myRootIn){
		myRoot = myRootIn;
		Turtle baseTurtle = new Turtle(0, myRoot);
		Image image2 = new Image(currentImage);
		ImageView myTurtleImage = new ImageView(image2);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myTurtleImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				baseTurtle.setActivity(!baseTurtle.getActivity());
				if(!baseTurtle.getActivity()){
					activeTurtles.remove(baseTurtle);
					myTurtleImage.setImage(new Image(inactiveImage));
				}
				else{
					activeTurtles.add(baseTurtle);
					myTurtleImage.setImage(new Image(currentImage));
				}
			}
		});
		myRoot.getChildren().add(myTurtleImage);
		baseTurtle.setTurtleImage(myTurtleImage);
		baseTurtle.setX(DEFAULT_X_POS);
		baseTurtle.setY(DEFAULT_Y_POS);
		baseTurtle.setHeading(DEFAULT_ANGLE);
		turtles.add(baseTurtle);
		activeTurtles.add(baseTurtle);
	}

	//TODO: Zhiyong, get the all the turtles as a HashMap
	//and then test whether it is active
	public ArrayList<Turtle> getTurtleList(){
		return turtles;
	}
	
	public ArrayList<Turtle> getActiveList(){
		return activeTurtles;
	}

	public void buildTurtle(Pane myRoot){
		Image image2 = new Image(currentImage);
		ImageView myTurtleImage=new ImageView(image2);
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

	public void addTurtle(int ID){
		Turtle temp = new Turtle(ID, myRoot);
		Image tempImage = new Image(currentImage);
		ImageView myTurtleImage=new ImageView(tempImage);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myTurtleImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				temp.setActivity(!temp.getActivity());
				if(!temp.getActivity()){
					activeTurtles.remove(temp);
					myTurtleImage.setImage(new Image(inactiveImage));
				}
				else{
					activeTurtles.add(temp);
					myTurtleImage.setImage(new Image(currentImage));
				}
			}
		});
		myRoot.getChildren().add(myTurtleImage);
		temp.setTurtleImage(myTurtleImage);
		turtles.add(temp);
		activeTurtles.add(temp);
	}
	
	public Turtle getTurtle(int ID) throws Exception {
		for (Turtle t : turtles) {
			if (t.getID() == ID) {
				return t;
			}
		}
		throw new Exception("ID not found");
	}
	
	public boolean containsTurtle(int ID) {
		for (Turtle t : turtles) {
			if (t.getID() == ID) {
				return true;
			}
		}
		return false;
	}

	public void setImage(String imageIn){
		currentImage = imageIn;
		String[] splitTemp = imageIn.split(".");
		inactiveImage = splitTemp[0] + "in" + splitTemp[1];
		for(Turtle t: turtles){
			if(t.getActivity()){
				t.setImage(new Image(currentImage));
			}
		}
	}
	
	public String getImage(){
		return currentImage;
	}
	
	public String getInactiveImage(){
		return inactiveImage;
	}
	
	public Pane getTurtlePane(){
		return myRoot;
	}

}