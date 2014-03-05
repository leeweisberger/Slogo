package commands.basic;

/**
 * The Class CommandTwoInputs.
 */
public abstract class CommandTwoInputs extends Command {

	/**
	 * Instantiates a new command two inputs.
	 */
	public CommandTwoInputs() {
		super.setNumInputs(2);
	}
	
	/**
	 * Gets the input1.
	 *
	 * @return the input1
	 */
	public Command getInput1(){
		return getInputs().get(0);
	}
	
	/**
	 * Gets the input2.
	 *
	 * @return the input2
	 */
	public Command getInput2(){
		return getInputs().get(1);
	}


}
