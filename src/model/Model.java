package model;

import java.util.List;

import parse.Node;
import parse.Parser;
import slogo_team02.State;
import commands.Command;

public class Model { 
	
	//set where turtle is initally. Eventually will be in the middle of the screen
	public void setState(){
		State state = new State(0,0,0);
	}
	public void parse(String input){
		Parser parser = new Parser(input);
		List<Node> nodeList= parser.doParse();
		traverseTree(nodeList);
	}
	private void traverseTree(List<Node> nodeList){
		for(Node node:nodeList){
			Command curCommand=node.getCommand();
			
		}
	}
	

}
