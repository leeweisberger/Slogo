package commands;

import model.Model;
import parse.Node;
import slogo_team02.State;

public class Repeat extends CommandList{


	
	public State doCommand(Model model) {
		double numTimes = ((Constant)getInputs()[0]).getValue();
		Command command = getInputs()[1];
		//I don't want to have to hard code in the constant
	
		State state=null;
		while(numTimes!=0){
			state = command.doCommand(model);
			model.setState(state);
			numTimes--;
		}
		return state;
	}



}
