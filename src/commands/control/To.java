package commands.control;

import commands.CustomCommand;
import commands.basic.CommandList;
import model.Model;
import model.TurtleState;

public class To extends CommandList {

	@Override
	public Object doCommand(TurtleState turtleState) {
		CustomCommand customCommand = (CustomCommand) getInputs().get(0);
		Model.customCommandList.put(customCommand.getName(), customCommand);
		customCommand.saveCommand(customCommand.getInputs(), customCommand.getFalseInputs());
		return 1;
	}


}
