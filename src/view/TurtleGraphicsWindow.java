package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

import jgame.JGColor;
import jgame.platform.JGEngine;
import model.*;

public class TurtleGraphicsWindow extends JGEngine{    
    /**
     * 
     */
//    private static final long serialVersionUID = 1L;
//    JFrame turtleGraphicsWindow ;
    TurtleState myCurrentState;
    List<TurtleState> myStateHistory = new ArrayList<TurtleState>();
    private boolean test = true;
    public TurtleGraphicsWindow(){
//        TurtleState.getStateInstant(x, y, angle);
//        turtleGraphicsWindow = new JFrame();
        
        int height = 480;
        double aspect = 16.0 / 9.0;
        initEngineComponent((int) (height * aspect), height);      
    }

    @Override
    public void initCanvas () {
        // TODO Auto-generated method stub
        setCanvasSettings(1, // width of the canvas in tiles
                          1, // height of the canvas in tiles
                          displayWidth(), // width of one tile
                          displayHeight(), // height of one tile
                          null,// foreground colour -> use default colour white
                          null,// background colour -> use default colour black
                          null); // standard font -> use default font
        setScalingPreferences(1,1,0,0,0,0);
    }

    @Override
    public void initGame () {
        defineMedia("viewer.tbl");
        drawImage("myTurtle", 0.0, 0.0);
        // TODO Auto-generated method stub
        setFrameRate(6, 2);
    }
    
    @Override
    public void doFrame() {
        // TODO Auto-generated method stub
    	 drawLine(200.0, 200.0, 200.0, 250.0, 5.0, JGColor.blue);
    	//this.setBackground(Color.white);
      // if(test) simpeDraw();
    	setColor(JGColor.red);
    	drawRect(200, 200, 10, 10, true, true);
    	repaint();
    	
    }
    public void paint(Graphics g){
    	g.setColor(Color.white);
    	g.drawOval(100, 100, 20, 20);
    }
    private void simpeDraw () {
        // TODO Auto-generated method stub
        drawLine(200.0, 200.0, 200.0, 250.0, 5.0, JGColor.blue);
        test = false;
    }

    public void drawUpdate(TurtleState myCurrentState){
        myCurrentState = TurtleState.getInstant();
        myStateHistory = myCurrentState.getStateHistory();
        System.out.println("the myStateHistory at this moment is " + myStateHistory);
        for (int i=0; i<myStateHistory.size()-1; i++){
            TurtleState myPrevState = myStateHistory.get(i);
            TurtleState myNextState= myStateHistory.get(i+1);
            // make a media file, and setImage at prev location
            drawLine(myPrevState.getX(), myPrevState.getY(), myNextState.getX(), myNextState.getY(), 5.0, JGColor.blue);
            // after the line is drawn, setImage at next location
        }
        /*for rotation: 
         * defineImageRotated(java.lang.String imgname, java.lang.String tilename, int collisionid, java.lang.String srcimg, double angle) 
          Define new image by rotating an already loaded image.*/
    }
    
//    public void main(String[] args){
            /*for test purpose*/
//    }

}
