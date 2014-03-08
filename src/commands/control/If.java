package commands.control;

import commands.basic.CommandList;
import model.TurtleState;

/**
 * The Class If.
 */
public class If extends CommandList{

	@Override
	public double doCommand(TurtleState turtleState) {
		double condition = (Double) getInputs().get(0).doCommand(turtleState);
		double result = -1;
		if(condition!=0){
			for(int i=1; i<getNumInputs(); i++){
				result = getInputs().get(i).doCommand(turtleState);
			}
		}
		return result;
	}
}
