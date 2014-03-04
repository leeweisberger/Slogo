package commands.bool;

import commands.basic.CommandOneInput;
import model.TurtleState;

public class Not extends CommandOneInput{

	@Override
	public Double doCommand(TurtleState state) {
		if((Double) getInput1().doCommand(state)==0)
			return 1.0;
		return 0.0;

	}
}
