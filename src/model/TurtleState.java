package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//import view.TurtleGraphics;
import java.util.Set;

import commands.Command;

public class TurtleState {
	private double myX;
	private double myY;
	private double myAngle;
	private boolean myPenDown;
	private boolean myShowing;
	private int myID;
	private List<TurtleState> myStateHistory = new ArrayList<TurtleState>();
	private static TurtleState _instanceState;
	private static TurtleState myCurrentState;
	private boolean isnew = true;

	public TurtleState(double x, double y, double angle,boolean penDown,boolean showing, int turtleID) {
		setState(x, y, angle, penDown, showing, turtleID);
	}

	public  TurtleState getInstant() {
		return myCurrentState;
	}

	public void setState(double x, double y, double angle, boolean penDown,
			boolean showing, int turtleID) {
		myX = x;
		myY = y;
		myAngle = angle;
		myPenDown = penDown;
		myShowing = showing;
		myID = turtleID;
		if(!isnew)updateStateHistory();
		for(TurtleState st : myStateHistory){
			System.out.println("History: " + st.getID() + " x: " + st.getX() + " y: " + st.getY() + " angle: " + st.getAngle());
		}
		
//		System.out.println("x: " + myX + " y: " + myY + " angle: " + myAngle
//				+ " penDown: " + myPenDown + " showing: " + myShowing);
		isnew = false;
	}

	public List<TurtleState> getStateHistory() {
		
		return myStateHistory;
	}

	public void setX(double x) {
		setState(x, myY, myAngle, myPenDown, myShowing, myID);
	}

	public void setY(double y) {
		setState(myX, y, myAngle, myPenDown, myShowing, myID);
	}

	public void setAngle(double angle) {
		setState(myX, myY, angle, myPenDown, myShowing, myID);
	}

	public void setPosition(double x, double y) {
		setState(x, y, myAngle, myPenDown, myShowing, myID);
	}

	public void setPen(boolean isDown) {
		setState(myX, myY, myAngle, isDown, myShowing, myID);
	}

	public void setShow(boolean isShown) {
		setState(myX, myY, myAngle, myPenDown, isShown, myID);
	}

	public void updateStateHistory() {
		isnew = true;
		myStateHistory.add(new TurtleState(myX,myY,myAngle,myPenDown,myShowing,myID));
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

	public boolean getPenDown() {
		return myPenDown;
	}

	public boolean getShowing() {
		return myShowing;
	}

	public int getID() {
		return myID;
	}

	// public static TurtleState getStateInstant(double x, double y, double
	// angle){
	// if (_instanceState == null){
	// _instanceState = new TurtleState(x, y, angle);
	// return _instanceState;
	// }
	// return _instanceState;
	// }

}