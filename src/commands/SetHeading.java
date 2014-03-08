package commands;

import commands.basic.CommandOneInput;

import model.Model;
import model.TurtleState;

/**
 * The Class SetHeading.
 */
public class SetHeading extends CommandOneInput {

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {
		double degrees = Math.toRadians((Double) getInput1().doCommand(state));
		double degreeChange = degreesMoved(state.getAngle(),degrees);
		state.setAngle(degrees);
		return degreeChange;
	}
	
	/**
	 * Degrees moved.
	 *
	 * @param oldDegrees the old degrees
	 * @param newDegrees the new degrees
	 * @return the number of degrees moved
	 */
	public double degreesMoved(double oldDegrees, double newDegrees){
		return newDegrees-oldDegrees;
	}

	

}
