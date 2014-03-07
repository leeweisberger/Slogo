package commands.multiple;

import java.util.List;
import java.util.Map;

import commands.basic.CommandList;
import model.Model;
import model.TurtleState;

/**
 * The Class MultipleTurtleCommand.
 */
public abstract class MultipleTurtleCommand extends CommandList {

	/**
	 * Command turtles.
	 *
	 * @param activeTurtles the active turtles
	 * @param statesMap the map of all of the turtleStates
	 */
	public abstract void commandTurtles(List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap);

	/**
	 * Gets the turtle and adds one if it doesn't exist.
	 *
	 * @param turtleID the turtle id
	 * @param activeTurtles the active turtles
	 * @param statesMap the states map
	 * @return the turtle
	 */
	public TurtleState getTurtle(int turtleID, List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap) {

		if (!statesMap.keySet().contains(turtleID)) {
			TurtleState currentState = new TurtleState(0, 0, 0, true, true, turtleID,0);
			statesMap.put(turtleID, currentState);
			currentState.updateStateHistory();
			return currentState;
		}

		return statesMap.get(turtleID);
	}

}
