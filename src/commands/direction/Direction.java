package commands.direction;

import commands.basic.CommandOneInput;
import model.Model;
import model.TurtleState;

/**
 * The Class Direction.
 */
public abstract class Direction extends CommandOneInput{
	
	public Double doCommand(TurtleState state){
		double degrees = Math.toRadians((Double) getInput1().doCommand(state));
		state.setAngle(state.getAngle()+changeDirection(degrees));
		return changeDirection(degrees);
	}
	
	/**
	 * Change direction.
	 *
	 * @param degrees the degrees
	 * @return the number of degrees moved
	 */
	public  abstract double changeDirection(Double degrees);

}
