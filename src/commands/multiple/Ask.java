package commands.multiple;

import java.util.List;
import java.util.Map;

import model.Model;
import model.TurtleState;

/**
 * The Class Ask.
 */
public class Ask extends MultipleTurtleCommand {

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState turtleState) {
		double result = -1;
		for (int i = 0; i < this.getNumFalseInputs(); i++) {
			result = getFalseInputs().get(i).doCommand(turtleState);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see commands.multiple.MultipleTurtleCommand#commandTurtles(java.util.List, java.util.Map)
	 */
	@Override
	public void commandTurtles(List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap) {
		for (int i = 0; i < getNumInputs(); i++) {
			int turtleID = (int) getInputs().get(i).doCommand(null);
			doCommand(getTurtle(turtleID, activeTurtles, statesMap));
		}

	}

}
