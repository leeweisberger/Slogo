package commands;

import model.Model;
import model.TurtleState;

public class AskWith extends CommandList{



	@Override
	public Object doCommand(TurtleState turtleState) {
		Command condition = getInputs().get(0);
		for(TurtleState turtle: Model.myStates.values()){
			if((Double)condition.doCommand(turtle)==1){
				for(int i=0; i<getNumFalseInputs();i++){
					getFalseInputs().get(i).doCommand(turtle);
				}
			}
		}
		return null;
	}

}
