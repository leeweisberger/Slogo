package slogo_team02;

import jgame.JGColor;
import jgame.JGObject;

public class JTurtle extends JGObject {
    private double myX;
    private double myY;
    private String FileName;
    private double xspeed = 0.0;
    private double yspeed = 0.0;
    private int xdir = 0;
    private int ydir = 0;
    
    public JTurtle(String name, double x, double y){
        myX = x;
        myY = y;
        FileName = name;
        super(name, 
              boolean unique_id, 
              x, 
              y, 
              int collisionid, 
              java.lang.String gfxname, 
              int expiry, 
              xspeed, 
              yspeed, 
              int xdir, 
              int ydir);   
    }
    
    //      defineImage("myTurtle", null, 0, "view/turtle.png", name, debugflags, debugflags, debugflags, debugflags);
    //      defineImage("myTurtle", null, 0, null, null, , debugflags, debugflags, debugflags);

    drawImage("myTurtle", DYNAMIC_WIDTH/2, DYNAMIC_HEIGHT/2);
    //        setImage();
    drawLine(0.0, 0.0, DYNAMIC_WIDTH, DYNAMIC_HEIGHT, 2.0, JGColor.blue);
    //        defineImage(null, null, 0, "turtle", null);
    //        JGRectangle bBox = getImageBBox("myTurtle");
    //        drawRect((double) bBox.x,(double) bBox.y,(double) Math.max(bBox.width, bBox.height),(double) Math.max(bBox.width, bBox.height), false, false, 0.8, JGColor.red);
    showActiveTurtle();
    
    
    public void move(){
        
    }
    
    public void move(double dX, double dY){
        
    }

}
