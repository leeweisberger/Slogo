package slogo_team02;

import java.awt.geom.Point2D;
import org.jbox2d.common.Vec2;
import view.TurtleGraphicsWindow;
import jgame.JGColor;
import jgame.JGObject;

public class JTurtle extends JGObject {
    private static final int COLLISION_ID  = 0; 
    private Point2D coordinate;
    private Point2D origin;
    private double xLocation;
    private double yLocation;
    private Vec2 velocity;
    private int shapeId;
    private String IMAGE_NAME;
    //    private static final String IMAGE_NAME = "turtle";

    public JTurtle(double x, double y, String imageName) {
        super(imageName, true, x, y, COLLISION_ID, "myTurtle");
        IMAGE_NAME = imageName;
        setxLocation(x);
        setyLocation(y);
        this.setPos(x, y);
    }
    
    private double getxLocation(){
        return xLocation;
    }

    private void setxLocation (double x) {
        this.xLocation = xLocation;
    }

    public double getyLocation() {
        return yLocation;
    }

    public void setyLocation(double yLocation) {
        this.yLocation = yLocation;
    }

    public void showActiveTurtle(){
        
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

