package commands.control;

import java.util.List;

import commands.basic.Command;
import model.TurtleState;

public class For extends Repeat{

	@Override
	protected double getNumTimes(TurtleState state){
		Double start = (Double) getInputs().get(1).doCommand(state);
		Double end = (Double) getInputs().get(2).doCommand(state);
		Double increment = (Double) getInputs().get(3).doCommand(state);
		return (end-start)/increment;
		
	}
	@Override
	protected List<Command> getCommands(){
		return getFalseInputs();
	}
	@Override
	protected double getNumCommands(){
		return getNumFalseInputs();
	}

}
