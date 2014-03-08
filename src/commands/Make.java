package commands;

import commands.basic.Command;
import commands.basic.CommandTwoInputs;
import commands.basic.Variable;

import model.TurtleState;

/**
 * The Class Make.
 */
public class Make extends CommandTwoInputs{

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Object doCommand(TurtleState turtleState) {
		Variable variable = (Variable) getInput1();
		Command command = getInput2();
		variable.setValue((double) command.doCommand(turtleState));
		return null;
	}
}
