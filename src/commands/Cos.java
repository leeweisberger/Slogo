package commands;

import model.TurtleState;

public class Cos extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		return(Math.cos(Math.toRadians((Double) getInput1().doCommand(state))));

	}
}
