package commands.multiple;

import java.util.List;
import java.util.Map;

import model.Model;
import model.TurtleState;

/**
 * The Class Tell.
 */
public class Tell extends MultipleTurtleCommand {
	
	/** The my active turtles. */
	private List<Integer> myActiveTurtles;

	/* (non-Javadoc)
	 * @see commands.multiple.MultipleTurtleCommand#commandTurtles(java.util.List, java.util.Map)
	 */
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

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Object doCommand(TurtleState turtleState) {
		myActiveTurtles.add(turtleState.getID());
		return null;
	}

}