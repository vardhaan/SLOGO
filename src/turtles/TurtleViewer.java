import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import turtles.Turtle;
import turtles.TurtleHandler;

public class TurtleViewer extends Observable implements Observer, Iterable<Turtle>{


	private List<Turtle> turtles=new ArrayList<Turtle>();

	public void getTurtle(Turtle turtlename){
		turtles.add(turtlename);
	
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
