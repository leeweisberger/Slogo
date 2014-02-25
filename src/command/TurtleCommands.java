package command;

import slogo_team02.TurtleState;

public class TurtleCommands {
	
	private TurtleState myTurtle;
	
	public TurtleCommands(TurtleState turtleState){
		myTurtle = turtleState;
	}
	
	public double forward(double pixels){
		double angle = Math.toRadians(myTurtle.getAngle());
		myTurtle.setX(myTurtle.getX() + Math.cos(angle) * pixels);
		myTurtle.setY(myTurtle.getY() + Math.sin(angle) * pixels);
		return pixels;
	}
	
	public double back(double pixels){
		return forward(-pixels);
	}
	
	public double left(double degrees){
		myTurtle.setAngle(myTurtle.getAngle() + degrees);
		return degrees;
	}
	
	public double right(double degrees){
		return left(-degrees);
	}
	
	public double setheading(double degrees){
		double moved = degrees - myTurtle.getAngle();
		myTurtle.setAngle(degrees);
		return moved;
	}

	public double setxy(double x, double y){
		double movedX = x - myTurtle.getX();
		double movedY = y - myTurtle.getY();
		double moved = Math.sqrt(movedX * movedX + movedY * movedY);
		myTurtle.setX(x);
		myTurtle.setY(y);
		return moved;
	}
	
	public double pendown(){
		myTurtle.penDown();
		return 1;
	}
	
	public double penup(){
		myTurtle.penUp();
		return 0;
	}
	
	public double showturtle(){
		myTurtle.show();
		return 1;
	}
	
	public double hideturtle(){
		myTurtle.show();
		return 0;
	}
	
	public double home(){
		return setxy(0,0);
	}
	
	public double clearscreen(){
		//this might require certain actions in the view 
		return home();
	}
}