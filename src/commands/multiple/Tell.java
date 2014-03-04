package commands.multiple;

import java.util.List;
import java.util.Map;

import model.Model;
import model.TurtleState;

public class Tell extends MultipleTurtleCommand {
	private List<Integer> myActiveTurtles;

	@Override
	public void commandTurtles(List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap) {
		activeTurtles.clear();
		myActiveTurtles = activeTurtles;
		for (int i = 0; i < getNumInputs(); i++) {
			int turtleID = (int) ((double) getInputs().get(i).doCommand(null));
			doCommand(getTurtle(turtleID, activeTurtles, statesMap));
		}
	}

	@Override
	public Object doCommand(TurtleState turtleState) {
		myActiveTurtles.add(turtleState.getID());
		return null;
	}

}