package commands;


public abstract class CommandOneInput extends Command {

	public CommandOneInput() {
		
		super.myNumInputs=1;
	}
	public Command[] getInputs(){
		return new Command[] {myInput1};
	}
	

}
