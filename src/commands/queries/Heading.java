package commands.queries;

import commands.basic.CommandZeroInputs;
import model.TurtleState;

public class Heading extends CommandZeroInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return state.getAngle();

	}
}
