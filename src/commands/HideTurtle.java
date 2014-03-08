package commands;

import commands.basic.CommandZeroInputs;

import model.TurtleState;

/**
 * The Class HideTurtle.
 */
public class HideTurtle extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setShow(false);
		return 0;
	}

	

}
