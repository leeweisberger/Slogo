package commands;

import model.Model;
import slogo_team02.State;

public abstract class Direction extends CommandOneInput{
	
	public State doCommand(Model model){
		double degrees = Math.toRadians(((Constant) getInputs()[0]).getValue());
		double currentAngle = model.getAngle();
		double newAngle = currentAngle+changeDirection(degrees);
		return new State(model.getX(),model.getY(),newAngle);
	}
	public  abstract double changeDirection(double degrees);

}
