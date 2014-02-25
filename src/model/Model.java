package model;

import java.util.ArrayList;
import java.util.List;

import parse.Node;
import parse.Parser;
import slogo_team02.State;

import commands.Command;
import commands.CommandList;
import commands.CommandTwoInputs;
import commands.CommandZeroInputs;

public class Model { 
	private State myCurrentState;
	private List<Command> myCommandList = new ArrayList<Command>();
	//set where turtle is initally. Eventually will be in the middle of the screen
	public void setState(double xpos, double ypos, double angle){
		myCurrentState = new State(xpos,ypos,angle);
		System.out.println("x: " + myCurrentState.getX() + " y: " + myCurrentState.getY() + " angle: " + myCurrentState.getAngle());
	}
	public void setState(State state){
		myCurrentState=state;
	}
	public List<Node> parse(String input){
		Parser parser = new Parser(input);
		List<Node> nodeList= parser.doParse();
		return nodeList;
	}
	public void doCommand(Command command){

			command.doCommand(this);
			System.out.println("x: " + myCurrentState.getX() + " y: " + myCurrentState.getY() + " angle: " + myCurrentState.getAngle());
			
		

			
	}

	public Command setCommandInputs(Node node, Command command){
		if(command instanceof CommandZeroInputs)
			return null;
		else {
			command.setInput1((Command)node.getLeftChild().getCommand());
			setCommandInputs(node.getLeftChild(),(Command)node.getLeftChild().getCommand());
		}
		return command;
//		Command command = node.getCommand();
//		if(node instanceof CommandZeroInputs)
//			return;
//		else {
//			node.setInput1((Command)node.getLeftChild().getCommand());
//			nodeToCommand(node.getLeftChild());
//		}
//		if(node instanceof CommandTwoInputs){
//			node.setInput2((Command)node.getRightChild().getCommand());
//		}
//		return node;

	}
	public double getX(){
		return myCurrentState.getX();
	}
	public double getY(){
		return myCurrentState.getY();
	}
	public double getAngle(){
		return myCurrentState.getAngle();
	}


}
