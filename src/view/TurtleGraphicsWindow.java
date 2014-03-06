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
    private double DYNAMIC_WIDTH = 835.0;
    private double DYNAMIC_HEIGHT = 567.0;
    

    public TurtleGraphicsWindow(){
        super();
        initEngineComponent((int) DYNAMIC_WIDTH, (int) DYNAMIC_HEIGHT);      
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

    public void simpleDraw () {
        drawLine(0.0, 0.0, 900.0, 600.0, 2.0, JGColor.blue);
    }

    public void drawUpdate(List<TurtleState> singleTStateList, boolean permission){
        if (permission){
            //        System.out.println("the myStateHistory at this moment is " + singleTStateList);
            for (int i=0; i<singleTStateList.size()-1; i++){
                TurtleState myPrevState = singleTStateList.get(i);
                TurtleState myNextState= singleTStateList.get(i+1);
                drawImage("myTurtle", myPrevState.getX(), myPrevState.getY());
                drawLine(myPrevState.getX(), myPrevState.getY(), myNextState.getX(), myNextState.getY(), 5.0, JGColor.blue);
                drawImage("myTurtle", myNextState.getX(), myNextState.getY());
            }
        }
            /*for rotation: 
             * defineImageRotated(java.lang.String imgname, java.lang.String tilename, int collisionid, java.lang.String srcimg, double angle) 
              Define new image by rotating an already loaded image.*/
        }

        @Override
        public void paintFrame(){
            simpleDraw();
            drawImage("myTurtle", DYNAMIC_WIDTH/2, DYNAMIC_HEIGHT/2);
            int DISPLAY_WIDTH = displayWidth();
            int DISPLAY_HEIGHT = displayHeight();
            //        System.out.println("displaywidth is " + DISPLAY_WIDTH + "displayHeight is " + DISPLAY_HEIGHT);
        }

        public void changeDrawSpeed (Double fps, Double maxframeskip) {
            // TODO Auto-generated method stub
            setFrameRate(fps, maxframeskip);
        }

    }
