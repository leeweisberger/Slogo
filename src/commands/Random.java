package commands;

import model.TurtleState;

public class Random extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		return(Math.random()*(Double) getInput1().doCommand(state));

	}
}
