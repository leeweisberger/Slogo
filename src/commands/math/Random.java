package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class Random.
 */
public class Random extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Double doCommand(TurtleState state) {
		return(Math.random()*(Double) getInput1().doCommand(state));

	}
}
