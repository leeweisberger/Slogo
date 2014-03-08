package commands;

import model.TurtleState;
import commands.basic.CommandOneInput;

public class SetPenColor extends CommandOneInput{

	@Override
	public double doCommand(TurtleState turtleState) {
		turtleState.setColor((Double) getInput1().doCommand(turtleState));
		return getInput1().doCommand(turtleState);
	}

	

}
