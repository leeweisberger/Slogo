package model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TurtleState.
 */
public class TurtleState {

	/** The my x. */
	private double myX;
	
	/** The my y. */
	private double myY;
	
	/** The my angle. */
	private double myAngle;
	
	/** The my pen down. */
	private boolean myPenDown;
	
	/** The my showing. */
	private boolean myShowing;
	
	/** The my id. */
	private int myID;
	
	/** The my state history. */
	private List<TurtleState> myStateHistory = new ArrayList<TurtleState>();


	/** The _instance state. */
	private static TurtleState _instanceState;
	
	/** The my current state. */
	private static TurtleState myCurrentState;
	
	/** The isnew. */
	private boolean isnew = true;

	/**
	 * Instantiates a new turtle state.
	 *
	 * @param x the x
	 * @param y the y
	 * @param angle the angle
	 * @param penDown the pen down
	 * @param showing the showing
	 * @param turtleID the turtle id
	 */
	public TurtleState(double x, double y, double angle,boolean penDown,boolean showing, int turtleID) {
		setState(x, y, angle, penDown, showing, turtleID);
	}

	/**
	 * Gets the instant.
	 *
	 * @return the instant
	 */
	public static  TurtleState getInstant() {
		return myCurrentState;
	}

	/**
	 * Sets the state.
	 *
	 * @param x the x position
	 * @param y the y position
	 * @param angle the angle
	 * @param penDown the pen down
	 * @param showing the showing
	 * @param turtleID the turtle id
	 */
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

	/**
	 * Gets the state history.
	 *
	 * @return the state history
	 */
	public List<TurtleState> getStateHistory() {
		
		return myStateHistory;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(double x) {
		setState(x, myY, myAngle, myPenDown, myShowing, myID);
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(double y) {
		setState(myX, y, myAngle, myPenDown, myShowing, myID);
	}

	/**
	 * Sets the angle.
	 *
	 * @param angle the new angle
	 */
	public void setAngle(double angle) {
		setState(myX, myY, angle, myPenDown, myShowing, myID);
	}

	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setPosition(double x, double y) {
		setState(x, y, myAngle, myPenDown, myShowing, myID);
	}

	/**
	 * Sets the pen.
	 *
	 * @param isDown the new pen
	 */
	public void setPen(boolean isDown) {
		setState(myX, myY, myAngle, isDown, myShowing, myID);
	}

	/**
	 * Sets the show.
	 *
	 * @param isShown the new show
	 */
	public void setShow(boolean isShown) {
		setState(myX, myY, myAngle, myPenDown, isShown, myID);
	}

	/**
	 * Update state history if the state is not new.
	 */
	public void updateStateHistory() {
		isnew = true;
		myStateHistory.add(new TurtleState(myX,myY,myAngle,myPenDown,myShowing,myID));
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
		return myX;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY() {
		return myY;
	}

	/**
	 * Gets the angle.
	 *
	 * @return the angle
	 */
	public double getAngle() {
		return myAngle;
	}

	/**
	 * Gets the pen down.
	 *
	 * @return the pen down
	 */
	public boolean getPenDown() {
		return myPenDown;
	}

	/**
	 * Gets the showing.
	 *
	 * @return the showing
	 */
	public boolean getShowing() {
		return myShowing;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
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