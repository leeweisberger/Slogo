package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class DisplayTab extends JPanel implements ActionListener{
	private static final Dimension SIZE = new Dimension(800, 600);
	private static final String DRAW_BOX_TITLE = "Draw";
	private static final String HISTORY_BOX_TITLE = "History";
	private static final String COMMAND_BOX_TITLE = "Command";
	private static Model model;
	private MenuBar menuBar;
	private CommandInput commandInput; 
	private Container pane;
	private JButton run, clear, history;
	private String historyLabel;
	private JTextPane turtleStatus = new JTextPane(); 
	private TurtleGraphicsWindow turtleGraphicsWindow;
	private Map<Integer, List<TurtleState>> myHistoryMap;
	private List<Integer> myActiveTurtles;

	public DisplayTab (Model model, String language){
		this.model = model;			
		
		initialiseComponents();
		setLayout(new BorderLayout());
			
		addActionListenerToComponents(); 
		addComponentsToLayout(); 
	}

	private void initialiseComponents(){
		commandInput = new CommandInput();
		menuBar = new MenuBar(commandInput); 
		run = new JButton("run");
		clear = new JButton("clear");
		historyLabel = new String("History"); 
		history = new JButton(historyLabel);
<<<<<<< HEAD
		pane = new Container();
=======
		faster = new JRadioButton("faster"); 
		slower = new JRadioButton("slower"); 

		pane = new Container();	

		addActionListenerToComponents(); 
		addComponentsToLayout(); 
		
	        myHistoryMap = myModel.getMyHistoryMap();
	        System.out.println("checking if myHistoryMap is received in DisplayTab" + myHistoryMap.get(0));
	        myActiveTurtles = myModel.getActiveTurtles();
>>>>>>> 58340039648404c740b754d2802e25ef0fc0b09d
	}
	
	private void addComponentsToLayout(){
		add(menuBar.getMenuBar(), BorderLayout.NORTH);
		add(commandInput.getCommandInput(), BorderLayout.SOUTH);
		add(layOutButtonsInPane(pane),  BorderLayout.EAST);
		add(history,  BorderLayout.WEST);
	}
	
	private Container layOutButtonsInPane(Container pane){
		pane.setLayout(new GridBagLayout()); 
		pane.add(turtleStatus, setComponentConstraints(0,0));
		pane.add(run, setComponentConstraints(0,1));
		pane.add(clear, setComponentConstraints(0,4));

		return pane; 
	}

	private void addActionListenerToComponents(){
		run.setActionCommand("run");
		run.addActionListener(this);
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
<<<<<<< HEAD
			setHistoryButtonText(commandInput.getValue()); 
			model.doCommands(commandInput.getValue());
=======
			setHistoryButtonText(commandInput.getValue());
			myModel.parseToNodeList(commandInput.getValue());
			turtleGraphicsWindow.runBottonAction(myHistoryMap, myActiveTurtles, true);
			System.out.println(myHistoryMap.get(0));
		}
		if("stop".equals(e.getActionCommand())){

>>>>>>> 58340039648404c740b754d2802e25ef0fc0b09d
		}
	
		if("clear".equals(e.getActionCommand())){

		}
		if("history".equals(e.getActionCommand())){
			model.parseToNodeList(historyLabel);
		}
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
