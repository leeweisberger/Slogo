package commands;

import java.util.List;

import model.Model;
import model.TurtleState;
import parse.Node;

public class Repeat extends CommandList{
	public Object doCommand(TurtleState state) {
		List<Command> inputs = getCommands(); 
		double numTimes = getNumTimes(state);
		for(int j=0; j<numTimes; j++){
			for(int i=0; i<getNumCommands(); i++){
				inputs.get(i).doCommand(state);
			}
		}
		return null;
	}
	
	protected double getNumTimes(TurtleState state){
		return (Double) getInputs().get(0).doCommand(state);
	}
	
	protected List<Command> getCommands(){
		return getInputs().subList(1, getInputs().size()-1);
	}
	
	protected double getNumCommands(){
		return getNumInputs();
	}
}
