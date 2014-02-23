package commands;

import slogo_team02.State;
import model.Model;


public class Constant extends Command{
	private double myValue;
	
	public Constant(double value) {
		myValue=value;
	}
	public double getValue(){
		return myValue;
	}
	@Override
	public State doCommand(Model model) {
		// TODO Auto-generated method stub
		return null;
	}







}
