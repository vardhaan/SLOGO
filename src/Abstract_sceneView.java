import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class Abstract_sceneView {
	private Scene myScene;
	private double hueShift;
	private double saturationShift;
	private double lightnessShift;
	private double height;
	private double width;
	

public  void setValue(){
	saturationShift=1;
	lightnessShift=1;
	hueShift=0;
}


	public void updateView (double width ,double height){
		Paint Scene = myScene.getFill().valueOf();
		myScene.getRoot(). 
		myScene.setFill(myScene);
		myScene.setFill((myScene.getFill().
				//getFill()).deriveColor(hueShift,saturationShift,lightnessShift,1));

	}
	protected void setView(Scene view){

	}

	public void setHueShift(double amount) {
		hueShift = amount;
	}
	public void setSaturationShift(double amount) {
		saturationShift = amount;
	}
	public void setLightnessShift(double amount) {
		lightnessShift = amount;
	}

	protected Scene getView() {
		return myScene;
	}
}
