package commands;

import model.TurtleState;

public class Sin extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		return(Math.sin(Math.toRadians((Double) getInput1().doCommand(state))));

	}
}
