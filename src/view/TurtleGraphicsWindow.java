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
import jgame.JGRectangle;
import jgame.platform.JGEngine;
import model.Model;
import model.TurtleState;


public class TurtleGraphicsWindow extends JGEngine{    

    private static final Dimension SIZE = new Dimension(900, 600);
    TurtleState myCurrentState = TurtleState.getInstant();
    //    private Map<Integer, List<TurtleState>> myHistoryMap = new HashMap<Integer, List<TurtleState>>();
    private boolean test = true;  
    private double DYNAMIC_WIDTH = 740.0;
    private double DYNAMIC_HEIGHT = 517.0;
    private double CENTER_WIDTH = DYNAMIC_WIDTH/2;
    private double CENTER_HEIGHT = DYNAMIC_HEIGHT/2;
    private Map<Integer, List<TurtleState>> myHistoryMap;
    private List<Integer> myActiveTurtles;
    private boolean permission = true;
    private boolean isClicked = false;

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
        setFrameRate(4, 0);
    }

    @Override
    public void doFrame() {
        //        simpleDraw();
    }

    public void simpleDraw () {
        //      defineImage("myTurtle", null, 0, "view/turtle.png", name, debugflags, debugflags, debugflags, debugflags);
        //      defineImage("myTurtle", null, 0, null, null, , debugflags, debugflags, debugflags);

        drawImage("myTurtle", DYNAMIC_WIDTH/2, DYNAMIC_HEIGHT/2);
        //        setImage();
        drawLine(0.0, 0.0, DYNAMIC_WIDTH, DYNAMIC_HEIGHT, 2.0, JGColor.blue);
        //        defineImage(null, null, 0, "turtle", null);
        //        JGRectangle bBox = getImageBBox("myTurtle");
        //        drawRect((double) bBox.x,(double) bBox.y,(double) Math.max(bBox.width, bBox.height),(double) Math.max(bBox.width, bBox.height), false, false, 0.8, JGColor.red);
        showActiveTurtle();
    }

    void showActiveTurtle(){
        drawRect(200.0, 200.0, 30.0, 20.0, false, false, 2.0, JGColor.red);
    }

    void runBottonAction(Map<Integer, List<TurtleState>> myHistoryMap, List<Integer> myActiveTurtles, boolean permission){
        isClicked = true;
        this.myHistoryMap = myHistoryMap;  
        this.myActiveTurtles = myActiveTurtles;
        this.permission = permission;
//        System.out.println(myHistoryMap.get(0));
//        System.out.println("runBottonAction called");
        //        paintFrame();
    }

    /*for rotation: 
     * defineImageRotated(java.lang.String imgname, java.lang.String tilename, int collisionid, java.lang.String srcimg, double angle) 
              Define new image by rotating an already loaded image.*/

    @Override
    public void paintFrame(){
        if (isClicked){
//            simpleDraw();
            //            System.out.println("drawPath correctly called");
            drawPath();
        }
        //            System.out.println(getImageBBox("myTurtle").toString());
        //        System.out.println("displaywidth is " + DISPLAY_WIDTH + "displayHeight is " + DISPLAY_HEIGHT);
    }

    void drawPath(){
        //        System.out.println("drawPath is called");
        permission = true;
        for (Map.Entry<Integer, List<TurtleState>> singleTStateList: myHistoryMap.entrySet()){
            //            if (myActiveTurtles.contains(singleTStateList.getKey())){ 
            //                drawUpdate(singleTStateList.getValue());
            //            } 
//            System.out.println("drawPath called");
//            System.out.println("singleTStateList value is " + singleTStateList.getValue());
            drawUpdate(singleTStateList.getValue());
        }
    }

    void drawUpdate(List<TurtleState> singleTStateList){   
        TurtleState myFinalState = singleTStateList.get(singleTStateList.size() - 1);
        drawImage("myTurtle", (CENTER_WIDTH+myFinalState.getX()), (CENTER_HEIGHT-myFinalState.getY()));
//        isClicked = false;
        
        
        /*
        //        System.out.println("the myStateHistory at this moment is " + singleTStateList);
        for (int i=0; i<singleTStateList.size()-1; i++){
            //                dbgShowBoundingBox(permission);
            TurtleState myPrevState = singleTStateList.get(i);
            TurtleState myNextState= singleTStateList.get(i+1);
            drawImage("myTurtle", myPrevState.getX(), myPrevState.getY());
            System.out.println("drawImage called");
            
//            drawLine(myPrevState.getX(), myPrevState.getY(), myNextState.getX(), myNextState.getY(), 5.0, JGColor.blue);
//            drawImage("myTurtle", myNextState.getX(), myNextState.getY());
            isClicked = false;
            }*/
        }
    

    public void changeDrawSpeed (Double fps, Double maxframeskip) {
        // TODO Auto-generated method stub
        setFrameRate(fps, maxframeskip);
    }

}
