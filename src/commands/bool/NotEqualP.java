package commands.bool;

import commands.basic.CommandTwoInputs;
import model.TurtleState;

public class NotEqualP extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		if((Double) getInput1().doCommand(state)!=(Double) getInput2().doCommand(state))
			return 1.0;
		return 0.0;

	}
}
