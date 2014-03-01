package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import jgame.platform.JGEngine;
import model.*;

public class TurtleGraphicsWindow extends JGEngine{    
    /**
     * 
     */
//    private static final long serialVersionUID = 1L;
    JFrame turtleGraphicsWindow ;
    TurtleState myCurrentState;
    List<TurtleState> myStateHistory = new ArrayList<TurtleState>();
    
    public TurtleGraphicsWindow(){
//        TurtleState.getStateInstant(x, y, angle);
//        turtleGraphicsWindow = new JFrame();
        
        int height = 480;
        double aspect = 16.0 / 9.0;
        initEngineComponent((int) (height * aspect), height);      
     
    }
    
    public void drawUpdate(TurtleState myCurrentState){
        myCurrentState = TurtleState.getInstant();
        myStateHistory = myCurrentState.getStateHistory();
        for (TurtleState state: myStateHistory){
            
        }
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
        // TODO Auto-generated method stub
        
    }

    
    public void main(String[] args){
        
    }

}
