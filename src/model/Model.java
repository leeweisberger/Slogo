package model;

import java.util.List;

import parse.Node;
import parse.Parser;

import commands.Command;
import commands.CommandList;

public class Model { 
	private TurtleState myCurrentState;

	public void setState(double xpos, double ypos, double angle){
		myCurrentState = new TurtleState(xpos,ypos,angle);
	}

	public void doCommands(String input){
		for(Node node: parseToNodeList(input)){
			Command command = node.getCommand();
			command = setCommandInputs(node, command);
			command.doCommand(myCurrentState);

		}

	}
	public List<Node> parseToNodeList(String input){
		Parser parser = new Parser(input, "English");
		List<Node> nodeList= parser.parseToNodeList();
		return nodeList;
	}

	public Command setCommandInputs(Node node, Command command){
		for(int i=0; i<command.getNumInputs(); i++){
			for(Node child:node.getChildrenList()){
				command.addInput(child.getCommand());
				setCommandInputs(child, child.getCommand());
			}
		}
		if(command instanceof CommandList){
			for(int i=0; i< ((CommandList) command).getNumFalseInputs(); i++){
				for(Node child:node.getFalseChildrenList()){
				
					((CommandList) command).addFalseInput(child.getCommand());
					setCommandInputs(child, child.getCommand());
				}
			}
		}
		return command;
	}
}
