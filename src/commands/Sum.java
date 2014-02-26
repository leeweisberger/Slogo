package commands;

import model.TurtleState;

public class Sum extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return((double) getInput1().doCommand(state) + (double) getInput2().doCommand(state));
	}
}
