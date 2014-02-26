package commands;

import model.TurtleState;

public class ShowTurtle extends CommandZeroInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		turtleState.setShow(true);
		return 1;
	}
	
	

}
