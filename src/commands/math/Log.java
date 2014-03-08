package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class Log.
 */
public class Log extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Double doCommand(TurtleState state) {
		return(Math.log((Double) getInput1().doCommand(state)));

	}
}
