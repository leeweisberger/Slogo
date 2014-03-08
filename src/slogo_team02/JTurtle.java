package slogo_team02;

import java.awt.geom.Point2D;
import org.jbox2d.common.Vec2;
import jgame.JGColor;
import jgame.JGObject;

public class JTurtle extends JGObject {
	private static final int COLLISION_ID  = 0; 
	private Point2D coordinate;
	private boolean isPenUp;
	private JGColor color;
	private Vec2 velocity;
	private Point2D origin = new Point2D(SIZE.)
	
	private static final String IMAGE_NAME = "turtle.jpg"; 	

	public JTurtle(double x, double y) {
		super("turtle", false, x, y, COLLISION_ID, IMAGE_NAME);
	}

	public void move(int myX, int myY, double myAngle, boolean myPenDown, boolean myShowing) {
		rotate(myAngle);
		setPos(myX,myY);	
	}
	
	public boolean getIsPen(){
	    return isPenUp;
	}
	
	public JGColor getColor(){
	    return color;
	}
	
	public void setColor(){
	    
	}
	
	public void rotate(double angle){
		xdir = (int) Math.abs((1*Math.cos(angle)));  //check what values these give 
		ydir = (int) Math.abs((1*Math.sin(angle)));
	}

	

}