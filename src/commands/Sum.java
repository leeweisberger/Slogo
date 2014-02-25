package commands;

import java.util.List;

import slogo_team02.TurtleState;
import model.Model;

public class Sum extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return((double) getInput1().doCommand(state)+(double) getInput2().doCommand(state));
	}



}
