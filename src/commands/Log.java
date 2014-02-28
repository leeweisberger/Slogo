package commands;

import model.TurtleState;

public class Log extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		return(Math.log((Double) getInput1().doCommand(state)));

	}
}
