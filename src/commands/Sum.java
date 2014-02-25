package commands;

import java.util.List;

import model.Model;

public class Sum extends CommandTwoInputs{

	@Override
	public Double doCommand(Model model) {
		List<Command> inputs = getInputs();
		double sum = 0;
		for(int i=0;i<myNumInputs;i++){
			Command command = inputs.get(i);
			sum+=(double) command.doCommand(model);
		}
		return sum;
	}



}
