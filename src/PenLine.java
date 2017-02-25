import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.shape.Line;

public class PenLine implements Iterable<Line>{
	private ArrayList<Line> Linelist= new ArrayList<Line>();
	
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
