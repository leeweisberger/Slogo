package commands;

import model.Model;
import slogo_team02.TurtleState;


/*
 * Abstract super class for all turtle movements
 */
public abstract class Movement extends CommandOneInput{
	//get pixels from the tree
	
	//calculate the new position that is to be moved to
	public Double doCommand(Model model){
		Command commandPixels =  getInputs().get(0);
		double pixels = (double) commandPixels.doCommand(model);
		double currentAngle = model.getAngle();
		double currentX=model.getX();
		double currentY=model.getY();
		double newX = currentX+move(pixels)*Math.sin(currentAngle);
		double newY = currentY+move(pixels)*Math.cos(currentAngle);
		model.setState(new TurtleState(newX,newY,currentAngle));
		return move(pixels);
	}
	public  abstract double move(double pixels);
		
}
