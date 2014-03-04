package commands.basic;

import model.Model;
import model.TurtleState;


public class Constant extends CommandZeroInputs{
	protected double myValue;
	
	public Constant(double value) {
		myValue = value;
	}
	@Override
	public Double doCommand(TurtleState turtleState) {
		return getMyValue();
	}
	public double getMyValue() {
		return myValue;
	}








}
