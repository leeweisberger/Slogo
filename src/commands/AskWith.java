package commands;

import java.util.List;
import java.util.Map;

import model.Model;
import model.TurtleState;

public class AskWith extends MultipleTurtleCommand {

	@Override
	public Object doCommand(TurtleState turtleState) {

		for (int i = 0; i < getNumFalseInputs(); i++) {
			getFalseInputs().get(i).doCommand(turtleState);
		}

		return null;
	}

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
