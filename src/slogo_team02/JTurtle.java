package slogo_team02;

import jgame.JGObject;



public class JTurtle extends JGObject {
	private static final int COLLISION_ID  = 0; 
	private static final String IMAGE_NAME = "turtle.jpg"; 	

	public JTurtle(double x, double y) {
		super("turtle", false, x, y, COLLISION_ID, IMAGE_NAME);
	}

	public void move(int myX, int myY, double myAngle, boolean myPenDown, boolean myShowing) {
		rotate(myAngle);
		setPos(myX,myY);	
	}
	
	public void rotate(double angle){
		xdir = (int) Math.abs((1*Math.cos(angle)));  //check what values these give 
		ydir = (int) Math.abs((1*Math.sin(angle)));
	}

	

}