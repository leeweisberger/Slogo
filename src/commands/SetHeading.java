package commands;

import model.Model;
import model.TurtleState;

public class SetHeading extends CommandOneInput {

	@Override
	public Double doCommand(TurtleState state) {
		double degrees = Math.toRadians((double) getInput1().doCommand(state));
		double degreeChange = degreesMoved(state.getAngle(),degrees);
		state.setAngle(degrees);
		return degreeChange;
	}
	public double degreesMoved(double oldDegrees, double newDegrees){
		return newDegrees-oldDegrees;
	}

	

}
