package slogo_team02;

import model.Model;

public class Controller {
/*
 * The Controller class serves as a bridge between the View and the Model
 */
	private void initModel(String input){
		Model model = new Model();		
		model.setState(30, 50, 0);		
		model.doCommands(model.parse(input));
	}
	
	//main method to test
	public static void main(String[] args) {
		Controller c = new Controller();
		c.initModel("Forward 50 Back 45 Repeat 5 [ Forward 10 ]");
	}
	

}
