package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuBar implements ActionListener {
	private JMenuBar menuBar;
	private JMenu file, format, help;
	private JMenuItem open, save, changeColor, chooseTurtleImage;
    private JFileChooser fileChooser;


	MenuBar(){
		//Create the menu bar.
		menuBar = new JMenuBar();
		file = new JMenu("File");
		format = new JMenu("Format");
		help = new JMenu("Help");
		fileChooser = new JFileChooser(); 

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

		}
		if(e.getSource() == save){
			temp = fileChooser.showSaveDialog(temp1);

		}
		if(e.getSource() == changeColor){

		}
		if(e.getSource() == chooseTurtleImage){

		}
	}



}
