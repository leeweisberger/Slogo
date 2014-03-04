package commands.basic;


public abstract class CommandOneInput extends Command {

	public CommandOneInput() {
		super.setNumInputs(1);
	}
	
	public Command getInput1(){
		return getInputs().get(0);
	}
}
