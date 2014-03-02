package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parse.Node;
import parse.Parser;
import view.TurtleGraphicsWindow;

import commands.Command;

public class Model { 
	private TurtleState myCurrentState;
	public static Map<String,Command> customCommandList = new HashMap<String,Command>();

	public void setState(double xpos, double ypos, double angle){
		myCurrentState = new TurtleState(xpos,ypos,angle);
	}

	public void doCommands(String input){
		for(Node node: parseToNodeList(input)){
			Command command = node.getCommand();
			command.setInputsFromNode(node);
			command.doCommand(myCurrentState);
			myCurrentState.updateStateHistory();
//			viewUpdateState()
		}
	}
	
	public List<Node> parseToNodeList(String input){
		Parser parser = new Parser(input, "English");
		return parser.parseToNodeList();
	}

	public void viewUpdateState(TurtleState myCurrentState){  // need to find place to call this??
	        this.myCurrentState = myCurrentState;
	        TurtleGraphicsWindow tg = new TurtleGraphicsWindow();
	        tg.drawUpdate(myCurrentState);
	        
	}
	
	
	
}
