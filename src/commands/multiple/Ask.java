package commands.multiple;

import java.util.List;
import java.util.Map;

import model.Model;
import model.TurtleState;

public class Ask extends MultipleTurtleCommand {

	@Override
	public Object doCommand(TurtleState turtleState) {
		for (int i = 0; i < this.getNumFalseInputs(); i++) {
			getFalseInputs().get(i).doCommand(turtleState);
		}

		return null;
	}

	@Override
	public void commandTurtles(List<Integer> activeTurtles,
			Map<Integer, TurtleState> statesMap) {
		for (int i = 0; i < getNumInputs(); i++) {
			int turtleID = (int) ((double) getInputs().get(i).doCommand(null));
			doCommand(getTurtle(turtleID, activeTurtles, statesMap));
		}

	}

}
