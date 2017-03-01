package turtles;

import Turtle;
public class LinePositioning {
private int MyColorRGB;
//Pair of XY coordinategit 
	public LinePositioning(){
		
		StartXY=start.clone();
	}
	public int getColor(){
		return MyColorRGB;
	}
	public double getAngle(){
		return Pair.getAngleBetween(StartXY,EndXY);
	}
	
}
