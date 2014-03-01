package commands;

import model.TurtleState;

public class Pow extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return(Math.pow((Double) getInput1().doCommand(state),(Double) getInput2().doCommand(state)));

	}
}
