package commands;

import model.Model;
import model.TurtleState;

public class To extends CommandList {

	@Override
	public Object doCommand(TurtleState turtleState) {
		CustomCommand customCommand = (CustomCommand) getInputs().get(0);
		Model.customCommandList.put(customCommand.getName(), customCommand);
		return 1;
	}


}
