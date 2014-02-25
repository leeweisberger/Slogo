package commands;

import java.util.List;

import model.Model;
import parse.Node;
import slogo_team02.State;

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
//		Command numTimesCommand = (((Command) getConstantInput()));
//		double numTimes = (double) numTimesCommand.doCommand(model);
//		List<Command> commandList = getCommandList();
//		State state=null;
//		for(Command command:commandList){
//			
//			for(int i=0; i<numTimes; i++){
//				command.doCommand(model);
//			}
//			
//			
//		}
//		return state;
		return null;
	}
}
