package commands;

import model.Model;
import slogo_team02.State;

public abstract class Direction extends CommandOneInput{
	
	public Double doCommand(Model model){
		double degrees = Math.toRadians(((Constant) getInputs()[0]).getValue());
		double currentAngle = model.getAngle();
		double newAngle = currentAngle+changeDirection(degrees);
		model.setState(new State(model.getX(),model.getY(),newAngle));
		return changeDirection(degrees);
	}
	public  abstract double changeDirection(double degrees);

}
