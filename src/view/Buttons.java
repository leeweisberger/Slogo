package view;

import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Buttons {
	/*ImageIcon stop = createImageIcon();
	ImageIcon run = createImageIcon();
	ImageIcon undo = createImageIcon();
	ImageIcon clear = createImageIcon();*/

	private JButton stop, run, undo, clear; 

	Buttons(){
		stop = new JButton("Stop"); 
		run = new JButton("Run"); 
		undo = new JButton("Undo"); 
		clear = new JButton("Clear"); 
	}

	public void setToolTipText(){
		run.setToolTipText("Click this button to run the turtle");
		stop.setToolTipText("Click this button to stop the turtle");
		undo.setToolTipText("Click this button to undo the turtle's last movement");
		clear.setToolTipText("Click this button to clear the turtle graphics screen");
	}

	public JButton getStop() {
		return stop;
	}

	public JButton getRun() {
		return run;
	}

	public JButton getUndo() {
		return undo;
	}

	public JButton getClear() {
		return clear;
	}
}
