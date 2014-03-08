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
	private boolean myError=false;
	
	public Model(){
	    this.setFirstTurtleState(0, 0, 0, 0);
	}
	
	public Map<Integer, TurtleState> getMyStatesMap(){
	    return myStatesMap;
	}

	public Map<Integer, List<TurtleState>> getMyHistoryMap() {
//	    System.out.println("getMyHistoryMap in Model called ");
	    return myHistoryMap;

	}

	public List<Integer> getActiveTurtles(){
		return myActiveTurtles;
	}

	public void clearState(){

	    /*here we can either initialize new model, or clean up whatever we have in model*/
	    myActiveTurtles.clear();
	    myHistoryMap.clear();
	    myStatesMap.clear();
	    this.setFirstTurtleState(0, 0, 0, 0);
	}

	/**
	 * Creates a new TurtleState.
	 *
	 * @param xpos the xpos
	 * @param ypos the ypos
	 * @param angle the angle
	 * @param turtleID the turtle id
	 */
	public void setFirstTurtleState(double xpos, double ypos, double angle, int turtleID) {
		TurtleState currentState = new TurtleState(xpos, ypos, angle, true,
				true, turtleID,0);
		currentState.updateStateHistory();
		myStatesMap.put(turtleID, currentState);
		myActiveTurtles.add(turtleID);
	}


	/**
	 * Do commands.
	 *
	 * @param input the raw userinput
	 */
	public void doCommands(String input) {

//	    System.out.println("doCommands in Model passed "+ input);
	    if(parseToNodeList(input)==null){
	        System.out.println("myError in doCommands shows up");
	    	myError=true;
	    	return;
	    }
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
		//System.out.println("myStatesMap size in doCommands: "+ myStatesMap.size());

		for (TurtleState turtle : myStatesMap.values()) {
			System.out.println("myHistoryMap in Model updated");
			myHistoryMap.put(turtle.getID(), turtle.getStateHistory());
			System.out.println("MyHistory map size: "+ myHistoryMap.get(0).size());
		//	System.out.println("id" + turtle.getID());
		//	System.out.println("MyHistory map size: "+ myHistoryMap.size());

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
		//System.out.println("parseToNodeList: "+parser.parseToNodeList().size());
		return parser.parseToNodeList();
	}

	/**
	 * Checks if is error.
	 *
	 * @return true, if is error
	 */
	public boolean isError(){
		return myError;
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
