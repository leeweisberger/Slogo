package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuBar {
	private JMenuBar menuBar;
	private JMenu file, format, help;
	private JMenuItem open, save, changeColor, chooseTurtleImage;

	MenuBar(){
		//Create the menu bar.
		menuBar = new JMenuBar();
		file = new JMenu("File");
		format = new JMenu("Format");
		help = new JMenu("Help");

		addMenus();
		createAndAddMenuItems(); 
	}

	public void createAndAddMenuItems(){
		open = new JMenuItem("Open File",
				KeyEvent.VK_T);

		save = new JMenuItem("Save File",
				KeyEvent.VK_T);

		changeColor = new JMenuItem("Change Pen Color",
				KeyEvent.VK_T);

		chooseTurtleImage = new JMenuItem("Choose Turtle Image",
				KeyEvent.VK_T);
		
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



}
