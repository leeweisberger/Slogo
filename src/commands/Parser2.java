package commands;

import java.util.ResourceBundle;


public class Parser2 {
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	ResourceBundle myResources;
	String myInput;

	public Parser2(String input, String language) {
		myInput=input;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		
	}
	public void parse(String str){
		String[] array = myInput.split(" ");
		for(String s:array){
			Command c = getCommandType(str);
			for(int i=0; i<c.getNumInputs(); i++){
				
			}
		}


	}
	public void getChildren(){
		
	}
	
	private boolean isNumeric(String str){  
		try{ Double.parseDouble(str);  } 
		catch(NumberFormatException nfe){return false;}  
		return true;  
	}
	private Command getCommandType(String str){
		if(isNumeric(str))
			return new Constant(Double.parseDouble(str));
		//All commands must be in the commands package
		try {	
			str = myResources.getString(str.toLowerCase());
			
			return (Command) Class.forName("commands."+token.data).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
