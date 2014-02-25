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
			for(int i=0; i<command.myNumInputs; i++){
				for(Node child:node.getChildrenList()){
					command.setInput(child.getCommand());
					setCommandInputs(child, child.getCommand());
				}
			}
		}
		return command;

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
