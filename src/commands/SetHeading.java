package commands;

import model.Model;
import slogo_team02.TurtleState;

public class SetHeading extends CommandOneInput {

	@Override
	public Double doCommand(Model model) {
		double degrees = Math.toRadians((double) getInputs().get(0).doCommand(model));
		double degreeChange = degreesMoved(model.getAngle(),degrees);
		double newAngle = degrees;
		model.setState(new TurtleState(model.getX(),model.getY(),newAngle));
		return degreeChange;
	}
	public double degreesMoved(double oldDegrees, double newDegrees){
		return newDegrees-oldDegrees;
	}

	

}
