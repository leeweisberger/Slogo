package commands;

import model.TurtleState;

/**
 * The Class Home.
 */
public class Home extends SetPosition {

	/* (non-Javadoc)
	 * @see commands.SetXY#doCommand(model.TurtleState)
	 */
	@Override
	public double doCommand(TurtleState turtleState) {
		double distanceMoved = calculateDistance(turtleState.getX(),0,turtleState.getY(),0);
		turtleState.setX(0);
		turtleState.setY(0);
		return distanceMoved;
	}
}
