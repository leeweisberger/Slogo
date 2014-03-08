package commands.movement;

import commands.basic.CommandOneInput;
import model.Model;
import model.TurtleState;



/**
 * The Class Movement.
 */
public abstract class Movement extends CommandOneInput{
	
	
	public double doCommand(TurtleState state){

		double pixels = (Double) getInput1().doCommand(state);
		state.setPosition(state.getX()+move(pixels)*Math.cos(Math.toRadians(state.getAngle())), 
				state.getY()+move(pixels)*Math.sin(Math.toRadians(state.getAngle())));
		return move(pixels);
	}
	
	/**
	 * Move.
	 *
	 * @param pixels the number of pixels to be moved
	 * @return the distance moved
	 */
	public  abstract double move(double pixels);		
}
