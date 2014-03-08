package commands;

import model.TurtleState;
import commands.basic.CommandZeroInputs;

public class GetPenColor extends CommandZeroInputs{

	@Override
	public double doCommand(TurtleState turtleState) {
		return turtleState.getColor();
	}

	

}
