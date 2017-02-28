import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import turtles.Turtle;
import turtles.TurtleHandler;

public class TurtleViewer extends Observable implements Observer, Iterable<Turtle>{


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
	private BufferedImage display;
	//private Workspace myWorkspace;
	
	
	public static final double DEFAULT_TURTLE_SPEED = 100; //pixels or degrees per second
	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 90;
	
	public TurtleViewer(Dimension size,){
		panelSize=size;
		display=new BufferedImage(panelSize.width,panelsize.height,Bu)
	}
	public void getTurtle(Turtle turtlename){
		turtles.add(turtlename);
	
}
	public void TurtleImage(String ImagePath){
		try{
			BufferedImage TurtleImage=ImageIO.read(new File("src/images/"+ImagePath));
		}
		catch(IOException e){
			Graphics2D graph=(Graphics2D) display.getGraphics();
			graph.setColor(Color.GREEN);
			graph.fillRect(0, 0, display.getHeight(), display.getWidth());
			graph.dispose();
		}
		
		
	}
	public void PaintingView (Turtle turtle){
		Graphics2D g= (Graphics2D) display.getGraphics();
		
		//for(Line line: turtle.getGraph)
	if(turtle.getShow()){
		BuffereImage Turtle-ImageIO.read(arg0)
	}
	}
	/*
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
*/
}
