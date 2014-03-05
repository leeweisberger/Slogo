package commands.multiple;

import java.util.List;
import java.util.Map;

import commands.basic.Command;
import model.Model;
import model.TurtleState;

/**
 * The Class AskWith.
 */
public class AskWith extends MultipleTurtleCommand {

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Object doCommand(TurtleState turtleState) {

		for (int i = 0; i < getNumFalseInputs(); i++) {
			getFalseInputs().get(i).doCommand(turtleState);
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see commands.multiple.MultipleTurtleCommand#commandTurtles(java.util.List, java.util.Map)
	 */
	@Override
	public void commandTurtles(List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap) {
		Command condition = getInputs().get(0);
		for (TurtleState turtle : statesMap.values()) {
			if ((Double) condition.doCommand(turtle) == 1)
				doCommand(turtle);
		}
	}
}
