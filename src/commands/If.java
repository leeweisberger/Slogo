package commands;

import java.util.List;

import model.TurtleState;

public class If extends CommandList{

	@Override
	public Object doCommand(TurtleState turtleState) {
		double condition = (double) getInputs().get(0).doCommand(turtleState);
		if(condition!=0){
			for(int i=1; i<getNumInputs(); i++){
				getInputs().get(i).doCommand(turtleState);
			}
		}
		return null;
	}
}
