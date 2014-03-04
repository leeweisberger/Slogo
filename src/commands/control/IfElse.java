package commands.control;

import commands.basic.CommandList;
import model.TurtleState;

public class IfElse extends CommandList{

	@Override
	public Object doCommand(TurtleState turtleState) {
		double condition = (Double) getInputs().get(0).doCommand(turtleState);
		if(condition!=0){
			for(int i=1; i<getNumInputs(); i++){
				getInputs().get(i).doCommand(turtleState);
			}
			return null;
		}

		for(int i=0; i<getNumFalseInputs(); i++){
			getFalseInputs().get(i).doCommand(turtleState);
		}
		return null;
	}



}
