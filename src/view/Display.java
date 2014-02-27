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


public class Display extends JPanel implements DocumentListener{
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
	private Buttons buttons; 

	public Display (Model model, String language){
		myModel = model;
		//    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		setLayout(new BorderLayout());
		//        add(makeCommandHistoryBox(), BorderLayout.EAST);
		//        add(makeTurtleStatusBox(), BorderLayout.SOUTH);
		//        add(makeDrawTurtleWindow(), BorderLayout.CENTER);
		menuBar = new MenuBar(); 
		commandInput = new CommandInput(); 
		buttons = new Buttons(); 

		add(menuBar.getMenuBar(), BorderLayout.NORTH);
		add(commandInput.getCommandInput(), BorderLayout.SOUTH);
		add(buttons.getRun());
		add(buttons.getStop(), BorderLayout.CENTER);
		add(buttons.getClear(), BorderLayout.CENTER);
		add(buttons.getUndo(), BorderLayout.CENTER);
	}

	private Component makeCommandHistoryBox () {
		// TODO Auto-generated method stub
		return null;
	}

	private Component makeTurtleStatusBox () {
		// TODO Auto-generated method stub
		return null;
	}

	private Component makeDrawTurtleWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	//    TODO: figure out how to set the drawing plate





}
