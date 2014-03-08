package commands.queries;

import commands.basic.CommandZeroInputs;
import model.TurtleState;

/**
 * The Class YCor.
 */
public class YCor extends CommandZeroInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {
		return state.getY();

	}
}
