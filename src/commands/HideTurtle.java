package commands;

import commands.basic.CommandZeroInputs;

import model.TurtleState;

public class HideTurtle extends CommandZeroInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setShow(false);
		return 0;
	}

	

}
