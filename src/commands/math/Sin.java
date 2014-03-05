package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class Sin.
 */
public class Sin extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Double doCommand(TurtleState state) {
		return(Math.sin(Math.toRadians((Double) getInput1().doCommand(state))));

	}
}
