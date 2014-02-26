package commands;

import model.Model;
import slogo_team02.TurtleState;

public class SetXY extends CommandTwoInputs {

	@Override
	public Double doCommand(TurtleState state) {
		double newX=(Double) getInput1().doCommand(state);
		double newY=(Double) getInput2().doCommand(state);
		double distance = calculateDistance(state.getX(),newX,state.getY(),newY);
		state.setX(newX);
		state.setY(newY);
		return distance;
	}
	public double calculateDistance(double x1, double x2, double y1, double y2){
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
}
