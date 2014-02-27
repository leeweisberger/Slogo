package commands;

import model.Model;
import model.TurtleState;

public abstract class Direction extends CommandOneInput{
	
	public Double doCommand(TurtleState state){
		double degrees = Math.toRadians((Double) getInput1().doCommand(state));
		state.setAngle(state.getAngle()+changeDirection(degrees));
		return changeDirection(degrees);
	}
	public  abstract double changeDirection(Double degrees);

}
