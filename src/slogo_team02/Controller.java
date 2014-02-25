package slogo_team02;

import commands.Command;

import model.Model;
import parse.Node;

public class Controller {
	/*
	 * The Controller class serves as a bridge between the View and the Model
	 */
	private void doModel(String input){
		Model model = initializeModel();	
		doModelCommands(input, model);	
	}

	private Model initializeModel() {
		Model model = new Model();		
		model.setState(0, 0, 0);
		return model;
	}

	private void doModelCommands(String input, Model model) {
		for(Node node: model.parseToNodeList(input)){
			Command command = node.getCommand();
			command = model.setCommandInputs(node, command);
			model.doCommand(command);
		}
	}

	//main method to test
	public static void main(String[] args) {
		Controller c = new Controller();
		c.doModel("Left 90 Repeat 5 [ Forward Sum 5 Sum 6 6 ]");
	}


}
