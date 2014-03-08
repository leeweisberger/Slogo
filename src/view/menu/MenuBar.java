package view.menu;

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

import view.CommandInput;
import view.HelpPage;
import view.buttons.Settings;

import jgame.JGColor;



public class MenuBar implements ActionListener {
	private JMenuBar menuBar;
	private FileMenu myFileMenu; 
	private FormatMenu myFormatMenu; 
	private JMenu file, format, help, penColors, turtleImages;
	private JMenuItem showHelpPage;
	private HelpPage helpPage; 
	private File importedFile, savedFile;  
	private CommandInput commandInput; 

	public MenuBar(CommandInput commandInput){		
		myFileMenu = new FileMenu(commandInput, importedFile, savedFile); 
		myFormatMenu = new FormatMenu(); 

		//Create the menu bar.
		menuBar = new JMenuBar();

		helpPage = new HelpPage(); 
		this.commandInput = commandInput; 
		savedFile = new File("saved commands.txt");

		addMenus();
	
	}

	public void createAndAddMenuItems(){


	
	}

	public void addMenus(){
		menuBar.add(myFileMenu.getFileMenu());
		menuBar.add(myFormatMenu.getFormatMenu());
		menuBar.add(helpPage.getHelp());
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}



	@Override
	public void actionPerformed(ActionEvent e) {	
	
	}
}