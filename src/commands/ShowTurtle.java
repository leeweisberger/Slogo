package commands;

import commands.basic.CommandZeroInputs;

import model.TurtleState;

/**
 * The Class ShowTurtle.
 */
public class ShowTurtle extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState turtleState) {
		turtleState.setShow(true);
		return 1;
	}
	
	

}
