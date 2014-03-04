package commands.control;

import java.util.List;

import commands.basic.Command;
import commands.basic.Constant;
import model.TurtleState;

public class DoTimes extends Repeat{


	@Override
	protected double getNumTimes(TurtleState state){
		Constant c = (Constant) getInputs().get(1);
		return c.doCommand(state);
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
