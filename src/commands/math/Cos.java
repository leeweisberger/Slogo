package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class Cos.
 */
public class Cos extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Double doCommand(TurtleState state) {
		return(Math.cos(Math.toRadians((Double) getInput1().doCommand(state))));

	}
}
