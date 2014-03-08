package commands.queries;

import commands.basic.CommandZeroInputs;
import model.TurtleState;

/**
 * The Class Heading.
 */
public class Heading extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {
		return state.getAngle();

	}
}
