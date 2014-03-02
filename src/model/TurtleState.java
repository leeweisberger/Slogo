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
    private List<TurtleState> myStateHistory = new ArrayList<TurtleState>();
    
    private static TurtleState _instanceState;
    private static TurtleState myCurrentState;

    public TurtleState(double x, double y, double angle) {
        setState(x,y,angle,true,true);
        //		checkInstance of whether 
    }

    public static TurtleState getInstant(){
        return myCurrentState;
    }

    public void setState(double x, double y, double angle, boolean penDown, boolean showing){
        myX=x;
        myY=y;
        myAngle=angle;
        myPenDown=penDown;
        myShowing=showing;
        //Whenever setState is called, we know that the state has changed and we will add the state to our history
        myStateHistory.add(this);
        System.out.println("x: " + myX + " y: " + myY + " angle: " + myAngle + " penDown: " + myPenDown + " showing: " + myShowing);

    }
    public List<TurtleState> getStateHistory(){
        return myStateHistory;
    }

    public void setX(double x) {
        setState(x, myY, myAngle,myPenDown,myShowing);
    }

    public void setY(double y) {
        setState(myX, y, myAngle,myPenDown,myShowing);
    }

    public void setAngle(double angle) {
        setState(myX, myY, angle,myPenDown,myShowing);
    }

    public void setPosition(double x, double y){
        setState(x,y,myAngle,myPenDown,myShowing);
    }
    public void setPen(boolean isDown) {
        setState(myX, myY, myAngle,isDown,myShowing);	}

    public void setShow(boolean isShown) {
        setState(myX, myY, myAngle,myPenDown,isShown);
    }
    
    public void updateStateHistory(){
    	myStateHistory.add(this);
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

    public static TurtleState getStateInstant(double x, double y, double angle){
        if (_instanceState == null){
            _instanceState = new TurtleState(x, y, angle);
            return _instanceState;
        }
        return _instanceState;
    }
  

}