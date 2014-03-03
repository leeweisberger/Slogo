package commands;

import java.util.List;
import java.util.Map;

import model.Model;
import model.TurtleState;

public abstract class MultipleTurtleCommand extends CommandList {

	public abstract void commandTurtles(List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap);

	public TurtleState getTurtle(int turtleID, List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap) {

		if (!statesMap.keySet().contains(turtleID)) {
			TurtleState currentState = new TurtleState(0, 0, 0, true, true, turtleID);
			statesMap.put(turtleID, currentState);
			return currentState;
		}

		return statesMap.get(turtleID);
	}

}
