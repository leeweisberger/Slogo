package commands.basic;

import model.TurtleState;

/**
 * The Class Variable.
 */
public class Variable extends Constant{
	
	/**
	 * Instantiates a new variable.
	 *
	 * @param value the value
	 */
	public Variable(double value) {
		super(value);
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(double value){
		myValue = value;
	}

	

}
