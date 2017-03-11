package turtles;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import turtles.Turtle;

public class TurtleViewer{

	private ArrayList<Turtle> turtles=new ArrayList<Turtle>();
	private int currentID = 0;
	public static final double DEFAULT_SIZE = 700;
	private String currentImage = "images/slogo1.jpg";
	private String inactiveImage = "images/slogo1in.jpg";
	private Pane myRoot;

	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 0;

	public TurtleViewer(Pane myRootIn){
		myRoot = myRootIn;
		Turtle baseTurtle =new Turtle(currentID, myRoot);
		currentID++;
		Image image2 = new Image(currentImage);
		ImageView myTurtleImage=new ImageView(image2);
		myTurtleImage.setFitWidth(50);
		myTurtleImage.setFitHeight(50);
		myTurtleImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("clicked");
				turtles.get(0).setActivity(false);
				turtles.get(0).setImage(new Image(inactiveImage));
				event.consume();
			}
		});
		myRoot.getChildren().add(myTurtleImage);
		baseTurtle.setTurtleImage(myTurtleImage);
		turtles.add(baseTurtle);
	}

	//TODO: Zhiyong, get the all the turtles as a HashMap
	//and then test whether it is active
	public ArrayList<Turtle> getTurtleList(){
		return turtles;
	}
	
	public ArrayList<Turtle> getActiveList(){
		ArrayList<Turtle> activeList = new ArrayList<Turtle>();
		activeList = turtles;
		for(Turtle t: turtles){
			if(t.getActivity()){
				activeList.add(t);
			}
		}
		return activeList;
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
		myTurtleImage.setOnMouseClicked(event -> {
			System.out.println("clicked");
		});
		myRoot.getChildren().add(myTurtleImage);
		temp.setTurtleImage(myTurtleImage);
		turtles.add(temp);
	}

	public Turtle getTurtle(int ID) throws Exception{
		if (turtles.size() > ID){
			return turtles.get(ID);
		}
		else {
			throw new Exception("ID not found");
		}
	}

	public void setImage(String imageIn){
		currentImage = imageIn;
		for(Turtle t: turtles){
			if(t.getActivity()){
				t.setImage(new Image(currentImage));
			}
		}
	}

}