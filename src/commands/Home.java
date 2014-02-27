package commands;

import model.TurtleState;

public class Home extends SetXY {

	@Override
	public Double doCommand(TurtleState turtleState) {
		double distanceMoved = calculateDistance(turtleState.getX(),0,turtleState.getY(),0);
		turtleState.setX(0);
		turtleState.setY(0);
		return distanceMoved;
	}
}
