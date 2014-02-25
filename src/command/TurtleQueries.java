package command;

import slogo_team02.TurtleState;

public class TurtleQueries {

	private TurtleState myTurtle;
	
	public TurtleQueries(TurtleState turtleState){
		myTurtle = turtleState;
	}
	
	public double xcor(){
		return myTurtle.getX();
	}
	
	public double ycor(){
		return myTurtle.getY();
	}
	
	public double heading(){
		return myTurtle.getAngle();
	}
	
	public int pendownp(){
		if (myTurtle.isPenDown()) return 1;
		return 0;
	}
	
	public int showingp(){
		if (myTurtle.isShowing()) return 1;
		return 0;
	}
}