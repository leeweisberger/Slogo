package commands;

import model.TurtleState;

public class XCor extends CommandZeroInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return state.getX();

	}
}
