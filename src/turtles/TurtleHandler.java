package turtles;

import java.util.HashMap;

public class TurtleHandler {

	private static HashMap<String, Turtle> turtles;
	
	public static final String DEFAULT_TURTLE = "0";
	
	public static Turtle getTurtle(String turtleName) {
		try {
			return turtles.get(turtleName);
		} catch( Exception e) { //TODO: CREATE CUSTOM EXCEPTION
			//TODO: ERROR BOX
		}
		return null;
	}
	
}