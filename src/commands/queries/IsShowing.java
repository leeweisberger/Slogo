package commands.queries;

import commands.basic.CommandZeroInputs;
import model.TurtleState;

/**
 * The Class ShowingP.
 */
public class IsShowing extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {
		if (state.getShowing())
			return 1.0;
		return 0.0;
	}
}
