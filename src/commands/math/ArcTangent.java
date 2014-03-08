package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

/**
 * The Class ATan.
 */
public class ArcTangent extends CommandOneInput{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {
		return(Math.toDegrees(Math.atan((Double) getInput1().doCommand(state))));

	}
}
