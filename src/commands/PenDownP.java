package commands;

import model.TurtleState;

public class PenDownP extends CommandZeroInputs{

	@Override
	public Double doCommand(TurtleState state) {
		if (state.getPenDown())
			return 1.0;
		return 0.0;
	}
}
