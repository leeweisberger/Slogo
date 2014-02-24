package commands;

import model.Model;
import slogo_team02.State;

public class SetHeading extends CommandOneInput {

	@Override
	public State doCommand(Model model) {
		double degrees = Math.toRadians(((Constant) getInputs()[0]).getValue());
		double degreeChange = degreesMoved(model.getAngle(),degrees);
		double newAngle = degrees;
		return new State(model.getX(),model.getY(),newAngle);
	}
	public double degreesMoved(double oldDegrees, double newDegrees){
		return newDegrees-oldDegrees;
	}

	

}
