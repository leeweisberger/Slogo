package commands;

import model.TurtleState;

public class PenUp extends CommandZeroInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setPen(true);
		return 0;
	}

	

}
