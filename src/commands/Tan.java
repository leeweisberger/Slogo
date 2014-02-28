package commands;

import model.TurtleState;

public class Tan extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		return(Math.tan(Math.toRadians((Double) getInput1().doCommand(state))));

	}
}
