package turtles;

public class Turtle {

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
	
	
	public static final double DEFAULT_TURTLE_SPEED = 100; //pixels or degrees per second
	public static final double DEFAULT_X_POS = 0;
	public static final double DEFAULT_Y_POS = 0;
	public static final double DEFAULT_ANGLE = 90;
	
	public Turtle() {
		setX(DEFAULT_X_POS);
		setY(DEFAULT_Y_POS);
		setHeading(DEFAULT_ANGLE);
	}
	
	public void setX(double newX) {
		double gridXDisplacement = getGridWidth()/2.0;
		this.xPos = newX + gridXDisplacement;
	}
	
	public void setY(double newY) {
		double gridYDisplacement = getGridHeight()/2.0;
		this.yPos = newY + gridYDisplacement;
	}
	
	public double getX() {
		return this.xPos - (getGridWidth()/2.0);
	}
	
	public double getY() {
		return this.yPos - (getGridHeight()/2.0);
	}
	
	private double getGridHeight() {
		//TODO: IMPLEMENT, GET FROM FRONTEND
		return 0.0;
	}
	
	private double getGridWidth() {
		//TODO: IMPLEMENT, GET FROM FRONTEND
		return 0.0;
	}

	public void setHeading(double newHeading) {
		this.heading = newHeading;
	}
	
	
}
