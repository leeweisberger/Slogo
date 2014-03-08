package commands;

import model.TurtleState;
import commands.basic.CommandOneInput;

public class SetPenColor extends CommandOneInput{

	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setColor((double) getInput1().doCommand(turtleState));
		return getInput1().doCommand(turtleState);
	}

	

}
