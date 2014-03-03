package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parse.Node;
import parse.Parser;
import view.TurtleGraphicsWindow;
import commands.Command;
import commands.Tell;

public class Model { 
	public static Map<Integer,TurtleState> myStates = new HashMap<Integer,TurtleState>();
	public static List<Integer> activeTurtles = new ArrayList<Integer>();
	public static Map<String,Command> customCommandList = new HashMap<String,Command>();

	public static void setState(double xpos, double ypos, double angle, int whichTurtle){
		TurtleState CurrentState = new TurtleState(xpos,ypos,angle);
		myStates.put(whichTurtle,CurrentState);
		activeTurtles.add(whichTurtle);
	}

	public void doCommands(String input){
		for(Node node: parseToNodeList(input)){
			Command command = node.getCommand();
			command.setInputsFromNode(node);
			for(int turtle:activeTurtles){
				command.doCommand(myStates.get(turtle));
				myStates.get(turtle).updateStateHistory();
				if(command instanceof Tell)break;
				
			}
			
//			viewUpdateState()
		}
	}
	
	public List<Node> parseToNodeList(String input){
		Parser parser = new Parser(input, "English");
		return parser.parseToNodeList();
	}

	//need to change this to accommodate multiple turtles
//	public void viewUpdateState(TurtleState CurrentState){  // need to find place to call this??
//	        this.myCurrentState = myCurrentState;
//	        TurtleGraphicsWindow tg = new TurtleGraphicsWindow();
//	        tg.drawUpdate(myCurrentState);
//	        
//	}
	
	
	
}
