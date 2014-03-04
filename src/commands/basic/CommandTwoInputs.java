package commands.basic;

public abstract class CommandTwoInputs extends Command {

	public CommandTwoInputs() {
		super.setNumInputs(2);
	}
	public Command getInput1(){
		return getInputs().get(0);
	}
	public Command getInput2(){
		return getInputs().get(1);
	}


}
