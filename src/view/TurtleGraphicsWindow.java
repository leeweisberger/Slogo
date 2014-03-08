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
import jgame.JGTimer;
import jgame.platform.JGEngine;
import model.Model;
import model.TurtleState;


public class TurtleGraphicsWindow extends JGEngine{    

    private static final Dimension SIZE = new Dimension(755, 505);
    TurtleState myCurrentState = TurtleState.getInstant();
    private boolean test = true;
    private JGColor penColor;  
	private double DYNAMIC_WIDTH = SIZE.getWidth();
    private double DYNAMIC_HEIGHT = SIZE.getHeight();
    private double CENTER_WIDTH = DYNAMIC_WIDTH/2;
    private double CENTER_HEIGHT = DYNAMIC_HEIGHT/2;
    private Map<Integer, List<TurtleState>> myHistoryMap;
    private List<Integer> myActiveTurtles;
    private boolean permission = true;
    private boolean isClicked = false;

    public TurtleGraphicsWindow(){
        super();
        initEngineComponent(SIZE.width, SIZE.height);
        penColor = new JGColor(10, 10, 10); 
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
//        System.out.println("show the PF size width " + pfWidth() + " Height " + pfHeight());
//        System.out.println("show the Display " + displayWidth() + " Height " + displayHeight());
        /*define which game state to switch into */
    }

    @Override
    public void doFrame() {
    }

    public void simpleDraw () {
//        drawImage("myTurtle", DYNAMIC_WIDTH/2, DYNAMIC_HEIGHT/2);
        drawLine(0.0, 0.0, DYNAMIC_WIDTH, DYNAMIC_HEIGHT, 2.0, JGColor.blue);
//        showActiveTurtle();
        drawLine(CENTER_WIDTH, CENTER_HEIGHT, CENTER_WIDTH, CENTER_HEIGHT+10, 2.0, JGColor.red);
    }

    void showActiveTurtle(){
        drawRect(200.0, 200.0, 30.0, 20.0, false, false, 2.0, JGColor.red);
    }

    void runBottonAction(Map<Integer, List<TurtleState>> myHistoryMap, List<Integer> myActiveTurtles, boolean permission){
        isClicked = true;
        this.myHistoryMap = myHistoryMap;  
//        System.out.println("showing historyMap in TGW" + myHistoryMap.size());
        this.myActiveTurtles = myActiveTurtles;
        this.permission = permission;
//        System.out.println("myHistory map received in run action is of size " + myHistoryMap.size());
//                System.out.println("runBottonAction called");
    }

    @Override
    public void paintFrame(){
//        simpleDraw();
        if ((!isClicked) || myHistoryMap.isEmpty()){    
            resetTPosition();
        }
        else{
            updateView();
        }
    }

    void updateView(){
        permission = true;
        for (Map.Entry<Integer, List<TurtleState>> singleTEntrySet: myHistoryMap.entrySet()){
            List<TurtleState> singleTStateList = singleTEntrySet.getValue();
            //            if (myActiveTurtles.contains(singleTStateList.getKey())){ 
            //                drawUpdate(singleTStateList.getValue());
            //            } 
            //            System.out.println("drawPath called");
            //            System.out.println("singleTStateList value is " + singleTStateList.getValue());
            drawPath(singleTStateList);
        }
    }
    
    void drawPath(List<TurtleState> singleTStateList){   
        TurtleState myFinalState = singleTStateList.get(singleTStateList.size() - 1);
        drawImage("myTurtle", (CENTER_WIDTH+myFinalState.getX()), (CENTER_HEIGHT-myFinalState.getY()));
        
        for (int i=0; i<singleTStateList.size()-1; i++){
            //                dbgShowBoundingBox(permission);
            TurtleState myPrevState = singleTStateList.get(i);
            TurtleState myNextState= singleTStateList.get(i+1);
//            doRotation(myPrevState.getAngle(), myNextState.getAngle());
            drawLine(CENTER_WIDTH + myPrevState.getX(), CENTER_HEIGHT - myPrevState.getY(), 
                     CENTER_WIDTH + myNextState.getX(), CENTER_HEIGHT - myNextState.getY(), 2.0, penColor);
        }
    }
    
    public void clearDrawing(Map<Integer, List<TurtleState>> myHistoryMap, List<Integer> myActiveTurtles){
        updateView();
        resetTPosition();
    }
    
    void doRotation(double preAngle, double nextAngle){
        defineImageRotated("myTurtle", null, 0, "turtle.png", nextAngle); 
    }

    public void changeDrawSpeed (Double fps, Double maxframeskip) {
        // TODO Auto-generated method stub
        setFrameRate(fps, maxframeskip);
    }
    
    void resetTPosition () {
        drawImage("myTurtle", CENTER_WIDTH, CENTER_HEIGHT);
    }

//    public void changeState (int prevWinIndex, int nextWinIndex, Model currentModel) {
//        System.out.println("change gameState called");
//        addGameState("window" + prevWinIndex);
//        clearGameState();
//        Model.clearState();
//        Model.setState(0, 0, 0, 0);
//        setGameState("window" + nextWinIndex);
//        // TODO Auto-generated method stub   
//    }

    
    
    
    

    /* Continue Writing
     * Window2 Screen*/

    /** Called when the Title state is entered. */
    public void startWindow2() {
            // we need to remove all game objects when we go from in-game to the
            // title screen
            removeObjects(null,0);
    }

    public void paintFrameWindow2() {
            drawString("We are in the StartGame state.",pfWidth()/2,90,0);
            drawString("Title state. Press space to go to InGame",pfWidth()/2,90,0);
    }

    public JGColor getPenColor() {
		return penColor;
	}

	public void setPenColor(JGColor penColor) {
		this.penColor = penColor;
	}
	
    public void doFrameWindow2() {
            if (getKey(' ')) {
                    // ensure the key has to be pressed again to register
                    clearKey(' ');
                    // Set both StartGame and InGame states simultaneously.
                    // When setting a state, the state becomes active only at the
                    // beginning of the next frame.
                    setGameState("StartGame");
                    addGameState("InGame");
                    // set a timer to remove the StartGame state after a few seconds,
                    // so only the InGame state remains.
                    new JGTimer(
                            70, // number of frames to tick until alarm
                            true, // true means one-shot, false means run again
                                  // after triggering alarm
                            "StartGame" // remove timer as soon as the StartGame state
                                        // is left by some other circumstance.
                                        // In particular, if the game ends before
                                        // the timer runs out, we don't want the timer to
                                        // erroneously trigger its alarm at the next
                                        // StartGame.
                    ) {
                            // the alarm method is called when the timer ticks to zero
                            public void alarm() {
                                    removeGameState("StartGame");
                            }
                    };
            }
    }


    /** The StartGame state is just for displaying a start message. */
}
