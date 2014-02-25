package slogo_team02;

import commands.Command;

import model.Model;
import parse.Node;

public class Controller {
/*
 * The Controller class serves as a bridge between the View and the Model
 */
	private void initModel(String input){
		Model model = new Model();		
		model.setState(30, 50, 0);	
		for(Node node: model.parse(input)){
			Command command = node.getCommand();
			command = model.setCommandInputs(node, command);
			model.doCommand(command);
		}
		
	}
	
	//main method to test
	public static void main(String[] args) {
		Controller c = new Controller();
		c.initModel("Repeat 4 [ Forward Sum 2 4 ]");
	}
	

}
