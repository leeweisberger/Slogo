package commands;

import commands.basic.CommandZeroInputs;

import model.TurtleState;

public class PenDown extends CommandZeroInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setPen(true);
		return 1;
	}

	

}
