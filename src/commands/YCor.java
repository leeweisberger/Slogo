package commands;

import model.TurtleState;

public class YCor extends CommandZeroInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return state.getY();

	}
}
