package commands;

import commands.basic.Command;
import commands.basic.CommandTwoInputs;
import commands.basic.Variable;

import model.TurtleState;

/**
 * The Class Make.
 */
public class MakeVariable extends CommandTwoInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState turtleState) {
		Variable variable = (Variable) getInput1();
		Command command = getInput2();
		double result = (Double) command.doCommand(turtleState);
		variable.setValue(result);
		return result;
	}
}
