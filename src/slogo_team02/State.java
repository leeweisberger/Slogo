package slogo_team02;

public class State {
	private double myX;
	private double myY;
	private double myAngle;
	public State(double x, double y, double angle) {
		myX=x;
		myY=y;
		myAngle=angle;
	}
	
	public void setX(double x){
		myX=x;
	}
	
	public void setY(double y){
		myY=y;
	}
	public double getX(){
		return myX;
	}
	public double getY(){
		return myY;
	}
	public double getAngle() {
		return myAngle;
	}
	public void setAngle(double angle) {
		myAngle = angle;
	}

}
