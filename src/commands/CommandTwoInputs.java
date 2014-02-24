package commands;

public abstract class CommandTwoInputs extends Command {

	public CommandTwoInputs() {
		super.myNumInputs=2;
	}
	public Command[] getInputs(){
		return new Command[] {myInput1,myInput2};
	}

}
