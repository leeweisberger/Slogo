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

import view.menu.FileMenu;
import view.menu.FormatMenu;
import jgame.JGColor;



public class MenuBar implements ActionListener {
	private JMenuBar menuBar;
	private FileMenu myFileMenu; 
	private FormatMenu myFormatMenu; 
	private JMenu file, format, help, penColors, turtleImages;
	private JMenuItem open, save,  newTab, savePreferences,loadPreferences, redPen,
	chooseTurtleImage, showHelpPage;
	private JFileChooser fileChooser;
	private HelpPage helpPage; 
	private File importedFile; 
	private File savedFile; 

	private CommandInput commandInput; 

	MenuBar(CommandInput commandInput){
		
		myFileMenu = new FileMenu(commandInput, importedFile, savedFile); 
		myFormatMenu = new FormatMenu(); 
		
		//Create the menu bar.
		menuBar = new JMenuBar();
		format = new JMenu("Format");
		help = new JMenu("Help");
		penColors = new JMenu("Choose a Pen Color"); 
		turtleImages = new JMenu("Choose a Turtle Image");
		
		helpPage = new HelpPage(); 
		this.commandInput = commandInput; 
		savedFile = new File("saved commands.txt");
		
		addMenus();
		createAndAddMenuItems(); 
	}

	public void createAndAddMenuItems(){
	

		redPen = new JMenuItem("Red",
				KeyEvent.VK_T);
		redPen.addActionListener(this); 


		chooseTurtleImage = new JMenuItem("Choose Turtle Image",
				KeyEvent.VK_T);
		chooseTurtleImage.addActionListener(this); 

		showHelpPage = new JMenuItem("Show Help Page"); 
		showHelpPage.setActionCommand("showHelpPage");
		showHelpPage.addActionListener(this);

		penColors.add(redPen);
		
		

		help.add(showHelpPage);
	}

	public void addMenus(){
		menuBar.add(myFileMenu.getFileMenu());
		menuBar.add(myFormatMenu.getFormatMenu());
		menuBar.add(help);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		int temp; 
		Component temp1 = null; 
	
		
		if(e.getSource() == newTab){
			
		}
		if(e.getSource() == redPen){

		}
		if(e.getSource() == chooseTurtleImage){

		}
		if("showHelpPage".equals(e.getActionCommand())){
			helpPage.createAndShowHelpPage();
		}
	
		
		if(e.getSource()== redPen){
			
		}
	}
	
	
}