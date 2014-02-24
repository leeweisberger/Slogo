package commands;

public abstract class CommandZeroInputs extends Command{

	public CommandZeroInputs() {
		super.myNumInputs=0;
	}

	public Constant[] getInputs(){
		return new Constant[] {};
	}

}