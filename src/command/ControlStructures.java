package command;

import java.util.List;


public class ControlStructures {
	
	private Program myProgram;
	
	public ControlStructures(Program program){
		myProgram = program;
	}
	
	public double REPEAT(double expr, List<String> commands){
		double value = -1;
		while (expr > 0){
			//have to update the variable :repcount
			value = myProgram.execute(commands);
			expr--;
		}
		return value;
	}
	
	public double IF(double expr, List<String> commands){
		double value = -1;
		if (expr != 0)
			value = myProgram.execute(commands);
		return value;
	}
	
	public double IFELSE(double expr, List<String> trueCommands, List<String> falseCommands){
		double value = -1;
		if (expr != 0)
			value = myProgram.execute(trueCommands);
		else
			value = myProgram.execute(falseCommands);
		return value;
	}
}