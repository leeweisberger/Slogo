package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import model.Model;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;

import javax.swing.text.BadLocationException;
import javax.swing.GroupLayout.*;

import jgame.JGColor;
import jgame.JGObject;
import jgame.JGPoint;
import jgame.JGRectangle;
import view.*;

import model.TurtleState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import slogo_team02.ViewController;
import view.Display;

public class DisplayTab extends JPanel implements ActionListener{
    private static final Dimension SIZE = new Dimension(800, 600);
    private static final String DRAW_BOX_TITLE = "Draw";
    private static final String HISTORY_BOX_TITLE = "History";
    private static final String COMMAND_BOX_TITLE = "Command";
    private static Model myModel;
    private static ResourceBundle myResources;
    private JTextArea output;
    private JScrollPane scrollPane;
    private MenuBar menuBar;
    private CommandInput commandInput; 
    private Container pane;
    private JButton run, stop, clear, history;
    private JRadioButton faster, slower; 
    private String historyLabel;
    private JTextPane turtleStatus = new JTextPane(); 
    private TurtleGraphicsWindow turtleGraphicsWindow;
    private Dimension GRAPHIC_WINDOW_SIZE;
    private Map<Integer, List<TurtleState>> myHistoryMap;
    private List<Integer> myActiveTurtles;

    public DisplayTab (Model model, String language){
        myModel = model;
        setLayout(new BorderLayout());		
        commandInput = new CommandInput();
        menuBar = new MenuBar(commandInput); 
        run = new JButton("run");
        stop = new JButton("stop");
        clear = new JButton("clear");
        historyLabel = new String("History"); 
        history = new JButton(historyLabel);
        faster = new JRadioButton("faster"); 
        slower = new JRadioButton("slower"); 
        
        pane = new Container();	

        addActionListenerToComponents(); 
        addComponentsToLayout(); 
        
//        myHistoryMap = myModel.getMyHistoryMap();
////        System.out.println("checking if myHistoryMap is received in DisplayTab " + myHistoryMap.get(0));
//        myActiveTurtles = myModel.getActiveTurtles();


    }

    /**
     * 
     */
    private void addComponentsToLayout(){
        add(menuBar.getMenuBar(), BorderLayout.NORTH);
        add(commandInput.getCommandInput(), BorderLayout.SOUTH);
        add(layoutButtons(pane),  BorderLayout.EAST);
        add(history,  BorderLayout.WEST);
    }
    private Container layoutButtons(Container pane){
        pane.setLayout(new GridBagLayout()); 
        pane.add(turtleStatus, setComponentConstraints(0,0));
        pane.add(run, setComponentConstraints(0,1));
        pane.add(faster, setComponentConstraints(1,1));
        pane.add(slower, setComponentConstraints(1,2));
        pane.add(stop, setComponentConstraints(0,3));
        pane.add(clear, setComponentConstraints(0,4));

        return pane; 
    }

    private void addActionListenerToComponents(){
        run.setActionCommand("run");
        run.addActionListener(this);
        stop.setActionCommand("stop");
        stop.addActionListener(this);
        clear.setActionCommand("clear");
        clear.addActionListener(this);
        history.setActionCommand("history");
        history.addActionListener(this);
    }

    private GridBagConstraints setComponentConstraints(int x, int y){
        GridBagConstraints c = new GridBagConstraints();
        c.weightx= 0.5;
        c.gridx = x; 
        c.gridy = y; 
        return c; 
    }

    public void setHistoryButtonText(String lastCommand){
        historyLabel = lastCommand; 
        history.setText(historyLabel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if("run".equals( e.getActionCommand() )){	
            System.out.println("Run Bottum called");
            setHistoryButtonText(commandInput.getValue());
            myModel.doCommands(commandInput.getValue());
            myHistoryMap = myModel.getMyHistoryMap();
//            System.out.println("show commandinput.getvalue " + commandInput.getValue().toString());
            turtleGraphicsWindow.runBottonAction(myHistoryMap, myActiveTurtles, true);  
            
        }
        if("stop".equals(e.getActionCommand())){
            
        }
        if("clear".equals(e.getActionCommand())){
            turtleGraphicsWindow.dbgShowGameState(true);
            myModel.clearState();
            myModel.setState(0, 0, 0, 0);
//            turtleGraphicsWindow.clearGameState();
            
//            myHistoryMap.clear();
//            myActiveTurtles.clear();
//            
            /* ASK frontend guy to take care:
             * manually add a turtleState at the origin*/
//            turtleGraphicsWindow.clearDrawing(myHistoryMap, myActiveTurtles);
            
            /* Ask backEnd guys to take care
             * We need to get access to the History in the Model
             */
        }
        if("history".equals(e.getActionCommand())){
            myModel.parseToNodeList(historyLabel);
        }
        if("faster".equals(e.getActionCommand())){

        }
        if("slower".equals(e.getActionCommand())){

        }


    }

    public TurtleGraphicsWindow getTurtleGraphicsWindow () {
        return turtleGraphicsWindow;
        // TODO Auto-generated method stub
    }

    public void setTurtleGraphicsWindow(TurtleGraphicsWindow turtleGraphicsWindow) {
        this.turtleGraphicsWindow = turtleGraphicsWindow;
        add(turtleGraphicsWindow, BorderLayout.CENTER);
    }


    public void loadState(){

    }


    public void saveState(){

    }


}
