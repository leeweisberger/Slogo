package slogo_team02;

public class TurtleState {
	private double myX;
	private double myY;
	private double myAngle;
	private boolean penDown;
	private boolean showing;
	
	public TurtleState(double x, double y, double angle) {
		myX=x;
		myY=y;
		myAngle=angle;
		penDown=true;
		showing=true;
	}
	
	public void setX(double x) {
		myX=x;
	}
	
	public void setY(double y) {
		myY=y;
	}
	
	public void setAngle(double angle) {
		myAngle = angle;
	}
	
	public void penDown() {
		penDown = true;
	}
	
	public void penUp() {
		penDown = false;
	}
	
	public void show() {
		showing = true;
	}
	
	public void hide() {
		showing = false;
	}
	
	public double getX() {
		return myX;
	}
	
	public double getY() {
		return myY;
	}
	
	public double getAngle() {
		return myAngle;
	}
	
	public boolean isPenDown() {
		return penDown;
	}
	
	public boolean isShowing() {
		return showing;
	}
}