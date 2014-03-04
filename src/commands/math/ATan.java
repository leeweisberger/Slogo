package commands.math;

import commands.basic.CommandOneInput;
import model.TurtleState;

public class ATan extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		return(Math.toDegrees(Math.atan((Double) getInput1().doCommand(state))));

	}
}
