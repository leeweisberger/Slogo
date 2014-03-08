package commands;

import commands.basic.CommandZeroInputs;

import model.TurtleState;

/**
 * The Class PenDown.
 */
public class PenDown extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState turtleState) {
		turtleState.setPen(true);
		return 1;
	}

	

}
