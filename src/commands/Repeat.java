package commands;

import java.util.List;

import model.Model;
import parse.Node;
import slogo_team02.State;

public class Repeat extends CommandList{



	public State doCommand(Model model) {
		double numTimes = (((Constant) getConstantInput()).getValue());
		List<Command> commandList = getCommandList();
		State state=null;
		for(Command command:commandList){
			
			for(int i=0; i<numTimes; i++){
				command.doCommand(model);
			}
			
			
		}
		return state;
	}

	@Override
	public Command[] getInputs() {
		// TODO Auto-generated method stub
		return null;
	}



}
