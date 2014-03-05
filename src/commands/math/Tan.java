package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class Tan.
 */
public class Tan extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Double doCommand(TurtleState state) {
		return(Math.tan(Math.toRadians((Double) getInput1().doCommand(state))));

	}
}
