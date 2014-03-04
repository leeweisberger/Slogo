package commands.bool;

import commands.basic.CommandTwoInputs;
import model.TurtleState;

/**
 * The Class Or.
 */
public class Or extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		if((Double) getInput1().doCommand(state)!=0 || (Double) getInput2().doCommand(state)!=0)
			return 1.0;
		return 0.0;

	}
}
