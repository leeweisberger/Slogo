package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JInternalFrame;



public class MenuBar implements ActionListener {
	private JMenuBar menuBar;
	private JMenu file, format, help;
	private JMenuItem open, save, changeColor, chooseTurtleImage;
	private JFileChooser fileChooser;
	private HelpPage helpPage; 
	private File importedFile; 
	private File savedFile; 

	private CommandInput commandInput; 

	MenuBar(CommandInput commandInput){
		//Create the menu bar.
		menuBar = new JMenuBar();
		file = new JMenu("File");
		format = new JMenu("Format");
		help = new JMenu("Help");
		fileChooser = new JFileChooser(); 
		helpPage = new HelpPage(); 
		this.commandInput = commandInput; 
		savedFile = new File("saved commands.txt");
		
		addMenus();
		createAndAddMenuItems(); 
	}

	public void createAndAddMenuItems(){
		open = new JMenuItem("Open File",
				KeyEvent.VK_T);
		open.addActionListener(this); 

		save = new JMenuItem("Save File",
				KeyEvent.VK_T);
		save.addActionListener(this); 

		changeColor = new JMenuItem("Change Pen Color",
				KeyEvent.VK_T);
		changeColor.addActionListener(this); 


		chooseTurtleImage = new JMenuItem("Choose Turtle Image",
				KeyEvent.VK_T);
		chooseTurtleImage.addActionListener(this); 

		help.addActionListener(this);


		file.add(open);
		file.add(save);
		format.add(changeColor);
		format.add(chooseTurtleImage); 
	}

	public void addMenus(){
		menuBar.add(file);
		menuBar.add(format);
		menuBar.add(help);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		int temp; 
		Component temp1 = null; 
		if(e.getSource() == open){
			temp = fileChooser.showOpenDialog(temp1);

			if (temp == JFileChooser.APPROVE_OPTION) {
				importedFile = fileChooser.getSelectedFile();
				commandInput.insertCommandsFromFile(importedFile); 
			}
		}
		if(e.getSource() == save){
			temp = fileChooser.showSaveDialog(temp1);
			
			if(temp == JFileChooser.APPROVE_OPTION) {
				savedFile = commandInput.saveCommandsToFile(savedFile);
			}

		}
		if(e.getSource() == changeColor){

		}
		if(e.getSource() == chooseTurtleImage){

		}
		if(e.getSource() == help){
			helpPage.createAndShowHelpPage();

		}
	
	}
}