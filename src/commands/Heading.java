package commands;

import model.TurtleState;

public class Heading extends CommandZeroInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return state.getAngle();

	}
}
