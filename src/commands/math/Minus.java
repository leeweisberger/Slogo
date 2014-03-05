package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class Minus.
 */
public class Minus extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Double doCommand(TurtleState state) {
		return(-(Double) getInput1().doCommand(state));

	}
}
