package turtles;
import 
public class LinePositioning {
private int MyColorRGB;
//Pair of XY coordinategit 
	public LinePositioning(Location start,Location end){
		StartXY=start.clone();
	}
	public int getColor(){
		return MyColorRGB;
	}
	public double getAngle(){
		return Pair.getAngleBetween(StartXY,EndXY);
	}
	
}
