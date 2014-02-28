package commands;

import java.util.List;

import model.Model;
import model.TurtleState;
import parse.Node;

public class Repeat extends CommandList{
	public Object doCommand(TurtleState state) {

		List<Command> inputs = getInputs(); 
		double numTimes = (Double) inputs.get(0).doCommand(state);

		for(int i=1; i<getNumInputs(); i++){
			for(int j=0; j<numTimes; j++){
				inputs.get(i).doCommand(state);
			}
		}
		return null;
	}
}
