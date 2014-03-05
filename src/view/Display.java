package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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


public class Display extends JPanel implements ActionListener{
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
	private String historyLabel;
	private JTextPane turtleStatus = new JTextPane(); 
	private TurtleGraphicsWindow turtleGraphicsWindow;
	
	public Display (Model model, String language){
		myModel = model;
		setLayout(new BorderLayout());		
		commandInput = new CommandInput();
		menuBar = new MenuBar(commandInput); 
		turtleGraphicsWindow = new TurtleGraphicsWindow(); 
		run = new JButton("run");
		stop = new JButton("stop");
		clear = new JButton("clear");
		historyLabel = new String("History"); 
		history = new JButton(historyLabel);

		pane = new Container();	

		addActionListenerToComponents(); 
		addComponentsToLayout(); 
	}

	private void addComponentsToLayout(){
		add(menuBar.getMenuBar(), BorderLayout.NORTH);
		add(commandInput.getCommandInput(), BorderLayout.SOUTH);
		add(layoutButtons(pane),  BorderLayout.EAST);
		add(history,  BorderLayout.WEST);
		add(turtleGraphicsWindow, BorderLayout.CENTER);
		System.out.println("turtleGraphicsWindow added");
	}
	private Container layoutButtons(Container pane){
		pane.setLayout(new GridBagLayout()); 
		pane.add(turtleStatus, setComponentConstraints(0,0));
		pane.add(run, setComponentConstraints(0,1));
		pane.add(stop, setComponentConstraints(0,2));
		pane.add(clear, setComponentConstraints(0,3));

		return pane; 
	}

	private void addActionListenerToComponents(){
		run.setActionCommand("run");
		run.addActionListener(this);
		
		stop.addActionListener(this);
		clear.addActionListener(this);
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
		historyLabel += " "+lastCommand; 
		history.setText(historyLabel);
		System.out.println("historyLabel: "+historyLabel); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("run".equals( e.getActionCommand() )){	
			setHistoryButtonText(commandInput.getValue()); 
			myModel.parseToNodeList(commandInput.getValue());
		}
		if("stop".equals(e.getActionCommand())){

		}
		if("clear".equals(e.getActionCommand())){

		}
		if("history".equals(e.getActionCommand())){
			myModel.parseToNodeList(historyLabel);
		}

	}

}
