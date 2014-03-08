package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Point2D;
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

    

	public static final Dimension SIZE = new Dimension(755, 505);

    public static final double DYNAMIC_WIDTH = SIZE.getWidth();
    public static final double DYNAMIC_HEIGHT = SIZE.getHeight();
    public static final double CENTER_WIDTH = DYNAMIC_WIDTH/2;
    public static final double CENTER_HEIGHT = DYNAMIC_HEIGHT/2;

    private boolean isPenUp;
    private JGColor color;

    TurtleState myCurrentState = TurtleState.getInstant();
    private boolean test = true;
    private Map<Integer, List<TurtleState>> myHistoryMap;
    private List<Integer> myActiveTurtles;
    private boolean permission = true;
    private boolean isClicked = false;
    
    private static JGColor penColor; 
    private static String turtleImage;
    private static TurtleGraphicsWindow _instance; 
    

    public TurtleGraphicsWindow(){
        super();
        initEngineComponent(SIZE.width, SIZE.height);
        //        initEngineComponent((int) DYNAMIC_WIDTH, (int) DYNAMIC_HEIGHT);
        penColor = new JGColor(0,0,0); 
        turtleImage = "myTurtle";
    }

    public static TurtleGraphicsWindow getInstance(){
    	if(_instance==null){
    		_instance = new TurtleGraphicsWindow(); 
    		return _instance; 
    	}
		return _instance; 
    }
    
    public static void setPenColor(JGColor newPenColor){
    	if(_instance==null){
    		_instance = new TurtleGraphicsWindow(); 
    		_instance.penColor = newPenColor; 
    	}
    	_instance.penColor = newPenColor; 
    }
 
    public static void setTurtleImage(String newTurtleImage){
    	if(_instance==null){
    		_instance = new TurtleGraphicsWindow(); 
    		_instance.turtleImage = newTurtleImage; 
    	}
    	_instance.turtleImage = newTurtleImage; 
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
        setFrameRate(10, 0);
        /*define which game state to switch into */
        setBGColor(JGColor.grey);
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
        System.out.println("showing historyMap in TGW" + myHistoryMap.size());
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
            if (myActiveTurtles.contains(singleTEntrySet.getKey())){
                List<TurtleState> singleTStateList = singleTEntrySet.getValue();
                drawPath(singleTStateList);
            }
            //                        if (myActiveTurtles.contains(singleTStateList.getKey())){ 
            //                            drawUpdate(singleTStateList.getValue());
            //                        } 
            //            System.out.println("drawPath called");
            //            System.out.println("singleTStateList value is " + singleTStateList.getValue());
        }
    }

    void drawPath(List<TurtleState> singleTStateList){   
        TurtleState myFinalState = singleTStateList.get(singleTStateList.size() - 1);
        drawImage(turtleImage, (CENTER_WIDTH+myFinalState.getX()), (CENTER_HEIGHT-myFinalState.getY()));

        for (int i=0; i<singleTStateList.size()-1; i++){
            TurtleState myPrevState = singleTStateList.get(i);
            TurtleState myNextState= singleTStateList.get(i+1);
            drawLine(CENTER_WIDTH + myPrevState.getX(), CENTER_HEIGHT - myPrevState.getY(), 
                     CENTER_WIDTH + myNextState.getX(), CENTER_HEIGHT - myNextState.getY(), 2.0, penColor);
        }
    }

    public void clearDrawing(Map<Integer, List<TurtleState>> myHistoryMap, List<Integer> myActiveTurtles){
        updateView();
        resetTPosition();
    }

    void doRotation(double preAngle, double nextAngle){
        defineImageRotated(turtleImage, null, 0, turtleImage, nextAngle); 
    }

    public void changeDrawSpeed (Double fps, Double maxframeskip) {
        // TODO Auto-generated method stub
        setFrameRate(fps, maxframeskip);
    }

    void resetTPosition () {
        drawImage(turtleImage, CENTER_WIDTH, CENTER_HEIGHT);
    }



    /** Called when the Title state is entered. */
    public void startWindow2() {
        removeObjects(null,0);
    }

    public void paintFrameWindow2() {
        drawString("We are in the StartGame state.",pfWidth()/2,90,0);
        drawString("Title state. Press space to go to InGame",pfWidth()/2,90,0);
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
}
