package commands;

import model.TurtleState;

public class Minus extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		return(-(Double) getInput1().doCommand(state));

	}
}
