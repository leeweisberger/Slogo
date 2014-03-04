package commands;

import commands.basic.Command;
import commands.basic.CommandTwoInputs;
import commands.basic.Variable;

import model.TurtleState;

public class Make extends CommandTwoInputs{

	@Override
	public Object doCommand(TurtleState turtleState) {
		Variable variable = (Variable) getInput1();
		Command command = getInput2();
		variable.setValue((double) command.doCommand(turtleState));
		return null;
	}
}
