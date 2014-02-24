package commands;

import model.Model;
import slogo_team02.State;


/*
 * Abstract super class for all turtle movements
 */
public abstract class Movement extends CommandOneInput{
	//get pixels from the tree
	
	//calculate the new position that is to be moved to
	public State doCommand(Model model){
		double pixels =  ((Constant)getInputs()[0]).getValue();
		double currentAngle = model.getAngle();
		double currentX=model.getX();
		double currentY=model.getY();
		double newX = currentX+move(pixels)*Math.sin(currentAngle);
		double newY = currentY+move(pixels)*Math.cos(currentAngle);
		return new State(newX,newY,currentAngle);
	}
	public  abstract double move(double pixels);
		
}
