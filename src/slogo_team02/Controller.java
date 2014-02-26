package slogo_team02;

import java.util.ResourceBundle;

import commands.Command;
import model.Model;
import parse.Node;

public class Controller {
	/*
	 * The Controller class serves as a bridge between the View and the Model
	 */
	private void doModel(String input){
		Model model = new Model();		
		model.setState(0, 0, 0);
		model.doCommands(input);	
	}
	
	//main method to test
	public static void main(String[] args) {
		Controller c = new Controller();
		c.doModel("ifelse 0 [ fd 5 ] [ back 20 ]");
	}


}
