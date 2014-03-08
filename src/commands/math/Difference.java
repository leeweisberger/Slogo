package commands.math;

import commands.basic.CommandTwoInputs;
import model.TurtleState;

/**
 * The Class Difference.
 */
public class Difference extends CommandTwoInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {
		return((Double) getInput1().doCommand(state)-(Double) getInput2().doCommand(state));

	}
}
