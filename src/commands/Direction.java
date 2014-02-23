package commands;

import model.Model;
import slogo_team02.State;

public abstract class Direction extends CommandOneInput{
	
	public State doCommand(Model model){
		double degrees = Math.toRadians(getInputs()[0].getValue());
		double currentAngle = model.getAngle();
		double currentX=model.getX();
		double currentY=model.getY();
		double newAngle = currentAngle+changeDirection(degrees);
		return new State(currentX,currentY,newAngle);
	}
	public  abstract double changeDirection(double degrees);

}
