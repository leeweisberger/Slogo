package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;

import javax.swing.text.BadLocationException;
import javax.swing.GroupLayout.*;

import com.sun.jndi.toolkit.url.Uri;

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
import java.awt.Desktop; 

import slogo_team02.ViewController;
import sun.awt.X11.ListHelper;
import view.Display;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DisplayTab extends JPanel implements ActionListener{	
    private static final Dimension SIZE = new Dimension(800, 600);
    private static final String DRAW_BOX_TITLE = "Draw";
    private static final String HISTORY_BOX_TITLE = "History";
    private static final String COMMAND_BOX_TITLE = "Command";
    private static Model myModel;
    private MenuBar menuBar;
    private CommandInput commandInput; 
    private Container pane;
    private CommandHistoryList historyList;
    private JList list;
    private DefaultListModel listModel;
    private JButton run, clear, history;
    private String historyLabel;
    private TurtleGraphicsWindow turtleGraphicsWindow;
    private Map<Integer, List<TurtleState>> myHistoryMap;
    private List<Integer> myActiveTurtles;


    public DisplayTab (Model model, String language){
        myModel = model;
        setLayout(new BorderLayout());		
        commandInput = new CommandInput();
        menuBar = new MenuBar(commandInput); 
        run = new JButton("run");
        clear = new JButton("clear");

        listModel = new DefaultListModel();
        list = new JList(listModel);
        historyList = new CommandHistoryList(list, listModel);

        pane = new Container();	

        addActionListenerToComponents(); 
        addComponentsToLayout();

        historyLabel = new String("History"); 
        history = new JButton(historyLabel);
    }

    /**
     * 
     */
    private void addComponentsToLayout(){
        add(menuBar.getMenuBar(), BorderLayout.NORTH);
        add(commandInput.getCommandInput(), BorderLayout.SOUTH);
        add(layOutAllButtons(pane),  BorderLayout.EAST);
        add(historyList.getScrollPane(),  BorderLayout.WEST);
    }

    private Container layOutAllButtons(Container pane){
        pane.setLayout(new GridBagLayout()); 
        pane.add(run, setComponentConstraints(0,1));
        pane.add(clear, setComponentConstraints(0,2));

        return pane; 
    }

    private void addActionListenerToComponents(){
        run.setActionCommand("run");
        run.addActionListener(this);
        clear.setActionCommand("clear");
        clear.addActionListener(this);

        history.setActionCommand("history");
        history.addActionListener(this);

        list.addMouseListener(historyList.initializeMouseListener());

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
            updateBackEndandDraw(commandInput.getValue());
            historyList.getListModel().addElement(commandInput.getValue());
        }

        if("clear".equals(e.getActionCommand())){
            myModel.clearState();

        }

        if("history".equals(e.getActionCommand())){
            myModel.doCommands(historyLabel);
            turtleGraphicsWindow.runBottonAction(myHistoryMap, myActiveTurtles, true);  

        }



        //        public void actionPerformed(ActionEvent e) {
        //            
        //            
        //            int index = list.getSelectedIndex(); //get selected index
        //            if (index == -1) { //no selection, so insert at beginning
        //                index = 0;
        //            } else {           //add after the selected item
        //                index++;
        //	        //            }
        //	        int index = list.getSelectedIndex();
        //	        //Select the new item and make it visible.
        //	        list.setSelectedIndex(index);
        //	        list.ensureIndexIsVisible(index);
        //		/*some potential command to add in:*/
        //		String clickCommand = (String) historyList.getList().getSelectedValue();


    }

    void updateBackEndandDraw (String typedCommand) {
        myHistoryMap = myModel.getMyHistoryMap();
        //        System.out.println("checking if myHistoryMap is received in DisplayTab " + myHistoryMap.get(0));
        myActiveTurtles = myModel.getActiveTurtles();
        setHistoryButtonText(typedCommand);
        myModel.doCommands(typedCommand);
        turtleGraphicsWindow.runBottonAction(myHistoryMap, myActiveTurtles, true);
    }


    public TurtleGraphicsWindow getTurtleGraphicsWindow () {
        return turtleGraphicsWindow;
        // TODO Auto-generated method stub
    }

    public void setTurtleGraphicsWindow(TurtleGraphicsWindow turtleGraphicsWindow) {
        this.turtleGraphicsWindow = turtleGraphicsWindow;
        add(turtleGraphicsWindow, BorderLayout.CENTER);
    }



}
