package commands;

import model.TurtleState;
import commands.basic.CommandZeroInputs;

public class PenColor extends CommandZeroInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		return turtleState.getColor();
	}

	

}
