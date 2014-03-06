package slogo_team02;

import view.*;
import model.*;
import jgame.JGColor;
import jgame.platform.JGEngine;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.View;

public class ViewController {
    private static final String TITLE = "SLogo";
    public static final Dimension SIZE = new Dimension(1000, 800);
    private Model myModel;
    private Map<Integer, List<TurtleState>> myHistoryMap;
    private List<Integer> myActiveTurtles;
    private TurtleGraphicsWindow turtleGraphicsWindow;
    private boolean permission;


    public void initializeView(Model model){
        myModel = model;
        myHistoryMap = myModel.getMyHistoryMap();
        myActiveTurtles = myModel.getActiveTurtles();

        Display display = new Display(myModel, null); 
        JFrame frame = new JFrame(TITLE); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add our user interface components to Frame and show it
        frame.getContentPane().add(display);        
        frame.setSize(SIZE);
        frame.setVisible(true);                
<<<<<<< HEAD
=======
        turtleGraphicsWindow = display.getTab1().getTurtleGraphicsWindow();

>>>>>>> 58340039648404c740b754d2802e25ef0fc0b09d
        /*test draw and update path*/
//        drawPath();
    }

    void drawPath(){
        /*Run when the run button or is pressed;*/
        
    }
    
    public void drawTurtle(){
        
    }

    private void changeColor(JGColor color){
        turtleGraphicsWindow.setColor(color);
    }

    private void changeDrawSpeed(Double fps, Double maxframeskip){
        turtleGraphicsWindow.changeDrawSpeed(fps, maxframeskip);
    }    

    private void activeTurtle(boolean showBounding){
        //        public void dbgShowBoundingBox(boolean enabled)
    }
}
