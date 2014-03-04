package commands;

import commands.basic.CommandZeroInputs;

import model.TurtleState;

public class PenUp extends CommandZeroInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setPen(false);
		return 0;
	}

	

}
