package turtles;

import java.util.HashMap;

public class TurtleHandler {

	private HashMap<String, Turtle> turtles;
	
	
	public Turtle getTurtle(String turtleName) {
		try {
			return turtles.get(turtleName);
		} catch( Exception e) { //TODO: CREATE CUSTOM EXCEPTION
			//TODO: ERROR BOX
		}
		return null;
	}
	
}