package model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TurtleState.
 */
public class TurtleState {

	private double myX=0;
	private double myY=0;
	private double myAngle=0;
	private boolean myPenDown=true;
	private boolean myShowing=true;
	private int myID;
	private List<TurtleState> myStateHistory = new ArrayList<TurtleState>();
	//private static TurtleState _instanceState;
	private static TurtleState myCurrentState;
	private double myColor=0;
	
	/**
	 * Instantiates a new turtle state.
	 *
	 * @param x the x ps
	 * @param y the y pos
	 * @param angle the angle
	 * @param penDown the pen down
	 * @param showing the showing
	 * @param turtleID the turtle id
	 */
	public TurtleState(double x, double y, double angle,boolean penDown,boolean showing, int turtleID, double color) {
		initializeState(x, y, angle, penDown, showing, turtleID, color);
	}

	/**
	 * Gets the instant.
	 *
	 * @return the instant
	 */

	public static TurtleState getInstant(){
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
		initializeState(x, y, angle, penDown, showing, turtleID, myColor);
		updateStateHistory();
	}

	public void initializeState(double x, double y, double angle,boolean penDown,boolean showing, int turtleID, double color){
		myX = x;
		myY = y;
		myAngle = angle;
		myPenDown = penDown;
		myShowing = showing;
		myID = turtleID;
		myColor=color;
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
	 * Sets the color.
	 *
	 * @param d the new color
	 */
	public void setColor(double d){
		myColor=d;
		setState(myX, myY, myAngle, myPenDown, myShowing, myID);
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public double getColor(){
		return myColor;
	}

	/**
	 * Update state history.
	 */
	public void updateStateHistory() {
		
		myStateHistory.add(new TurtleState(myX,myY,myAngle,myPenDown,myShowing,myID,myColor));
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

}
