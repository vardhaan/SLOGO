import java.awt.geom.Point2D;

public class Lines {
	private double initXpos;
	private double initYpos;
	private double FinalXpos;
	private double FinalYpos;
	private int myColorIndex;
	private int myThickness;
	private int myAngle;

	public double getLength(){
		return Point2D.distance(initXpos,initYpos,FinalXpos,FinalYpos);
	}
	public double getAngle(){
		return myAngle;
	}
	public int getColor() {
		return myColorIndex;
	}

	public int getThickness() {
		return myThickness;
	}

	public void setColorIndex(int colorIndex) {
		myColorIndex = colorIndex;
	}

	/**
	 * Sets the thickness of the line
	 */
	public void setThickness(int thickness) {
		myThickness = thickness;
	}
}
