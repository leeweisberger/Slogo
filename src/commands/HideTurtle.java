package commands;

import model.TurtleState;

public class HideTurtle extends CommandZeroInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setShow(false);
		return 0;
	}

	

}
