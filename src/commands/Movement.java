package commands;

import model.Model;
import slogo_team02.TurtleState;


/*
 * Abstract super class for all turtle movements
 */
public abstract class Movement extends CommandOneInput{
	//get pixels from the tree
	
	//calculate the new position that is to be moved to
	public Double doCommand(TurtleState state){
		double pixels = (Double) getInput1().doCommand(state);
		state.setX(state.getX()+move(pixels)*Math.sin(state.getAngle()));
		state.setY(state.getY()+move(pixels)*Math.cos(state.getAngle()));
		//model.setState(newX,newY,model.getAngle());
		return move(pixels);
	}
	public  abstract double move(double pixels);
		
}
