package commands;

import model.Model;
import model.TurtleState;


/*
 * Abstract super class for all turtle movements
 */
public abstract class Movement extends CommandOneInput{
	public Double doCommand(TurtleState state){

		double pixels = (Double) getInput1().doCommand(state);
		state.setPosition(state.getX()+move(pixels)*Math.sin(state.getAngle()), state.getY()+move(pixels)*Math.cos(state.getAngle()));
		return move(pixels);
	}
	public  abstract double move(double pixels);		
}
