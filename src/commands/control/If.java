package commands.control;

import java.util.List;

import commands.basic.CommandList;
import model.TurtleState;

/**
 * The Class If.
 */
public class If extends CommandList{

	@Override
	public Object doCommand(TurtleState turtleState) {
		double condition = (Double) getInputs().get(0).doCommand(turtleState);
		if(condition!=0){
			for(int i=1; i<getNumInputs(); i++){
				getInputs().get(i).doCommand(turtleState);
			}
		}
		return null;
	}
}
