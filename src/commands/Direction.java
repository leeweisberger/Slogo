package commands;

import model.Model;
import slogo_team02.TurtleState;

public abstract class Direction extends CommandOneInput{
	
	public Double doCommand(Model model){
		double degrees = Math.toRadians((double) getInputs().get(0).doCommand(model));
		double currentAngle = model.getAngle();
		double newAngle = currentAngle+changeDirection(degrees);
		model.setState(new TurtleState(model.getX(),model.getY(),newAngle));
		return changeDirection(degrees);
	}
	public  abstract double changeDirection(double degrees);

}
