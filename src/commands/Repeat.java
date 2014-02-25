package commands;

import java.util.List;

import model.Model;
import parse.Node;
import slogo_team02.TurtleState;

public class Repeat extends CommandList{



	public Object doCommand(Model model) {
		List<Command> inputs = getInputs();
		Command numTimesCommand = inputs.get(0);
		double numTimes = (double) numTimesCommand.doCommand(model);
		for(int i=1; i<this.myNumInputs; i++){
			for(int j=0; j<numTimes; j++){
				Command command = inputs.get(i);
				command.doCommand(model);
			}
		}
		return null;
	}
}
