package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parse.Node;
import parse.Parser;
import commands.basic.Command;
import commands.multiple.MultipleTurtleCommand;


/**
 * The Class Model.
 */
public class Model {
	private Map<Integer, TurtleState> myStatesMap = new HashMap<Integer, TurtleState>();
	private List<Integer> myActiveTurtles = new ArrayList<Integer>();
	public static Map<String, Command> customCommandList = new HashMap<String, Command>();
	private Map<Integer, List<TurtleState>> myHistoryMap = new HashMap<Integer, List<TurtleState>>();

	public Map<Integer, List<TurtleState>> getMyHistoryMap() {
		return myHistoryMap;
	}


	/**
	 * Creates a new TurtleState.
	 *
	 * @param xpos the xpos
	 * @param ypos the ypos
	 * @param angle the angle
	 * @param turtleID the turtle id
	 */
	public void setState(double xpos, double ypos, double angle, int turtleID) {
		TurtleState CurrentState = new TurtleState(xpos, ypos, angle, true,
				true, turtleID,0);
		myStatesMap.put(turtleID, CurrentState);
		myActiveTurtles.add(turtleID);
	}

	
	/**
	 * Do commands.
	 *
	 * @param input the raw userinput
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

	/**
	 * Parses the input to a node list.
	 *
	 * @param input the input
	 * @return the list of nodes
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
