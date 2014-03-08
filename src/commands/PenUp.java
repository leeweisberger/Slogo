package commands;

import commands.basic.CommandZeroInputs;

import model.TurtleState;

/**
 * The Class PenUp.
 */
public class PenUp extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState turtleState) {
		turtleState.setPen(false);
		return 0;
	}

	

}
