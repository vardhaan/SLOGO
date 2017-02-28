package gui;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class InputDataGetter extends ResourceBundle {
	//private  String RESOURCES_LOCATION;
	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object handleGetObject(String arg0) {
		// TODO Auto-generated method stub
		return "resources/languages/English" ;
	}

}
