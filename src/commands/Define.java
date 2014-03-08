package commands;

import model.Model;
import model.TurtleState;
import commands.basic.CommandList;

public class Define extends CommandList{


	@Override
	public double doCommand(TurtleState turtleState) {
		CustomCommand customCommand = (CustomCommand) getInputs().get(0);
		Model.customCommandList.put(customCommand.getName(), customCommand);
		customCommand.saveCommand(customCommand.getInputs(), customCommand.getFalseInputs());
		return 1;
	}

}
