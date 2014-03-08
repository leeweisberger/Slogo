package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class ATan.
 */
public class ATan extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Double doCommand(TurtleState state) {
		return(Math.toDegrees(Math.atan((Double) getInput1().doCommand(state))));

	}
}
