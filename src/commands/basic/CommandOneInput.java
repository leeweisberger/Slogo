package commands.basic;


/**
 * The Class CommandOneInput.
 */
public abstract class CommandOneInput extends Command {

	/**
	 * Instantiates a new command one input.
	 */
	public CommandOneInput() {
		super.setNumInputs(1);
	}
	
	/**
	 * Gets the input1.
	 *
	 * @return the input1
	 */
	public Command getInput1(){
		return getInputs().get(0);
	}
}
