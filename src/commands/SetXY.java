package commands;

import model.Model;
import model.TurtleState;

public class SetXY extends CommandTwoInputs {

	@Override
	public Double doCommand(TurtleState state) {

		double newX=(Double) getInput1().doCommand(state);
		double newY=(Double) getInput2().doCommand(state);
		double distanceMoved = calculateDistance(state.getX(),newX,state.getY(),newY);
		state.setPosition(newX, newY);
		return distanceMoved;

	}
	public double calculateDistance(double x1, double x2, double y1, double y2){
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
}
