package model;

import java.util.List;

import parse.Node;
import parse.Parser;
import slogo_team02.State;

import commands.Command;
import commands.CommandList;

public class Model { 
	private State myCurrentState;
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
	public void doCommands(List<Node> nodeList){
		for(Node node:nodeList){
			
			Command curCommand=node.getCommand();
			
			if(node.getLeftChild()!=null)
				curCommand.setInput1((Command)node.getLeftChild().getCommand());
			if(curCommand instanceof CommandList)
				((CommandList) curCommand).setCommandList(node.getRightChild());
			else if(node.getRightChild()!=null)
				curCommand.setInput2((Command)node.getRightChild().getCommand());		
			myCurrentState=curCommand.doCommand(this);		
			System.out.println("x: " + myCurrentState.getX() + " y: " + myCurrentState.getY() + " angle: " + myCurrentState.getAngle());
		}
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
