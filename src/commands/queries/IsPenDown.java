package commands.queries;

import commands.basic.CommandZeroInputs;
import model.TurtleState;

/**
 * The Class PenDownP.
 */
public class IsPenDown extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {
		if (state.getPenDown())
			return 1.0;
		return 0.0;
	}
}
