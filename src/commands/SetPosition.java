package commands;

import commands.basic.CommandTwoInputs;

import model.Model;
import model.TurtleState;

/**
 * The Class SetXY.
 */
public class SetPosition extends CommandTwoInputs {

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState state) {

		double newX=(Double) getInput1().doCommand(state);
		double newY=(Double) getInput2().doCommand(state);
		double distanceMoved = calculateDistance(state.getX(),newX,state.getY(),newY);
		state.setPosition(newX, newY);
		return distanceMoved;

	}
	
	/**
	 * Calculate distance.
	 *
	 * @param x1 the x1
	 * @param x2 the x2
	 * @param y1 the y1
	 * @param y2 the y2
	 * @return the distance
	 */
	public double calculateDistance(double x1, double x2, double y1, double y2){
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
}
