package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parse.Node;
import parse.Parser;

import commands.Command;
import commands.MultipleTurtleCommand;

/*
 * Backend of Slogo. Parses user input and calls each of the parsed commands
 */
public class Model {
	private Map<Integer, TurtleState> myStatesMap = new HashMap<Integer, TurtleState>();
	private List<Integer> myActiveTurtles = new ArrayList<Integer>();
	public static Map<String, Command> customCommandList = new HashMap<String, Command>();
	private Map<Integer, List<TurtleState>> myHistoryMap = new HashMap<Integer, List<TurtleState>>();

	public Map<Integer, List<TurtleState>> getMyHistoryMap() {
		return myHistoryMap;
	}

	public void setState(double xpos, double ypos, double angle, int turtleID) {
		TurtleState CurrentState = new TurtleState(xpos, ypos, angle, true,
				true, turtleID);
		myStatesMap.put(turtleID, CurrentState);
		myActiveTurtles.add(turtleID);
	}

	/*
	 * Parses and calls each of the commands. Stores the resulting state
	 * histories in myHistoryMap
	 * 
	 * @param raw user input
	 */
	public void doCommands(String input) {
		for (Node node : parseToNodeList(input)) {
			Command command = node.getCommand();
			command.setInputsFromNode(node);
			if (command instanceof MultipleTurtleCommand) {
				((MultipleTurtleCommand) command).commandTurtles(
						myActiveTurtles, myStatesMap);

			} else {
				for (int turtle : myActiveTurtles) {
					command.doCommand(myStatesMap.get(turtle));

				}
			}

			// viewUpdateState()
		}
		for (TurtleState turtle : myStatesMap.values()) {
			myHistoryMap.put(turtle.getID(), turtle.getStateHistory());
		}

	}

	/*
	 * Creates a parser which parses raw string input into a list of nodes.
	 * 
	 * @param Raw String input
	 * 
	 * @return List<Node> where each token is a member
	 */
	public List<Node> parseToNodeList(String input) {
		Parser parser = new Parser(input, "English");
		return parser.parseToNodeList();
	}

	public void viewUpdateState(TurtleState myCurrentState) { // need to find
																// place to call
																// this??
	// this.myCurrentState = myCurrentState;
	// TurtleGraphicsWindow tg = new TurtleGraphicsWindow();
	// tg.drawUpdate(myCurrentState);

	}

	// need to change this to accommodate multiple turtles
	// public void viewUpdateState(TurtleState CurrentState){ // need to find
	// place to call this??
	// this.myCurrentState = myCurrentState;
	// TurtleGraphicsWindow tg = new TurtleGraphicsWindow();
	// tg.drawUpdate(myCurrentState);
	//
	// }

}
