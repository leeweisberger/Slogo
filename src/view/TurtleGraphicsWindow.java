package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

import jgame.JGColor;
import jgame.platform.JGEngine;
import model.Model;
import model.TurtleState;


public class TurtleGraphicsWindow extends JGEngine{    

    private static final Dimension SIZE = new Dimension(900, 600);
    TurtleState myCurrentState = TurtleState.getInstant();
    private Map<Integer, List<TurtleState>> myHistoryMap = new HashMap<Integer, List<TurtleState>>();
    private boolean test = true;  

    public TurtleGraphicsWindow(){
        super();
        double width = 835.0;
        double height = 567.0;
        initEngineComponent((int) width, (int) height);      
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
        setFrameRate(6, 2);
    }

    @Override
    public void doFrame() {
    }

    void simpleDraw () {
        drawLine(0.0, 0.0, 900.0, 600.0, 2.0, JGColor.blue);
       // System.out.println("simpleDraw called");
    }
//
//    public void drawUpdate(TurtleState myCurrentState){
//        for (int i = 0; i< )
//        myCurrentState = myStateHistory = myCurrentState.getStateHistory();
////        System.out.println("the myStateHistory at this moment is " + myStateHistory);
//        for (int i=0; i<myStateHistory.size()-1; i++){
//            TurtleState myPrevState = myStateHistory.get(i);
//            TurtleState myNextState= myStateHistory.get(i+1);
//            // make a media file, and setImage at prev location
//            drawLine(myPrevState.getX(), myPrevState.getY(), myNextState.getX(), myNextState.getY(), 5.0, JGColor.blue);
//            // after the line is drawn, setImage at next location
//        }
//        /*for rotation: 
//         * defineImageRotated(java.lang.String imgname, java.lang.String tilename, int collisionid, java.lang.String srcimg, double angle) 
//              Define new image by rotating an already loaded image.*/
//    }

    @Override
    public void paintFrame(){
        //        System.out.println("do Frame called");
        //      System.out.println("myCurrentState is " + myCurrentState);
        //              drawUpdate(myCurrentState);
        simpleDraw();
        drawImage("myTurtle", 450.0, 300.0);
        int DISPLAY_WIDTH = displayWidth();
        int DISPLAY_HEIGHT = displayHeight();
        //System.out.println("displaywidth is " + DISPLAY_WIDTH + "displayHeight is " + DISPLAY_HEIGHT);
    }

    public void changeDrawSpeed (Double fps, Double maxframeskip) {
        // TODO Auto-generated method stub
        setFrameRate(fps, maxframeskip);
    }

}
