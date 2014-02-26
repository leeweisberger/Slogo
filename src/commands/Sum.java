package commands;

import java.util.List;

import slogo_team02.TurtleState;
import model.Model;

public class Sum extends CommandTwoInputs{

	@Override
	public Double doCommand(TurtleState state) {
		return((Double) getInput1().doCommand(state)+(Double) getInput2().doCommand(state));
	}



}
