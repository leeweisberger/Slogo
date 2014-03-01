package commands;

import model.TurtleState;

public class Difference extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return((Double) getInput1().doCommand(state)-(Double) getInput2().doCommand(state));

	}
}
