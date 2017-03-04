import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.shape.Line;

public class PenLineBUndle implements Iterable<Line>{
	private ArrayList<Line> Linelist= new ArrayList<Line>();
	private double initXpos;
	private double initYpos;
	private double FinalXpos;
	private double FinalYpos;
	public void clearinglines(){
		Linelist.clear();
	}
	public Iterator<Line> iterator(){
		return Linelist.iterator();
	}
	public void addLine(Line NumberOfLine){
		Linelist.add(NumberOfLine);
	}

}
