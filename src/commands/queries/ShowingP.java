package commands.queries;

import commands.basic.CommandZeroInputs;
import model.TurtleState;

public class ShowingP extends CommandZeroInputs{

	@Override
	public Double doCommand(TurtleState state) {
		if (state.getShowing())
			return 1.0;
		return 0.0;
	}
}
