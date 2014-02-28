package commands;

import model.TurtleState;

public class GreaterP extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		if((Double) getInput1().doCommand(state)>(Double) getInput2().doCommand(state))
			return 1.0;
		return 0.0;

	}
}
