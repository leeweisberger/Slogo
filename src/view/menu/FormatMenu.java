package view.menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class FormatMenu implements ActionListener {
	private List<JMenuItem> menuItems; // to be used or reflection 
	private JMenuItem changePenColor, chooseTurtleImage; 
	private JMenu format; 
	

	
	public FormatMenu(){
		initialiseMenuItems(); 
		addMenuItemsToMenu(); 
		addActionListenerToMenuItems(); 
		
	}
	
	public void initialiseMenuItems(){
		format = new JMenu("Format"); 
		changePenColor = new JMenuItem("Change Pen Color"); 
		chooseTurtleImage = new JMenuItem("Choose Turtle Image"); 
	}
	
	public void addMenuItemsToMenu(){
		format.add(changePenColor);
		format.add(chooseTurtleImage);
	}
	
	public void addActionListenerToMenuItems(){
		changePenColor.addActionListener(this);
		changePenColor.addActionListener(this);
		chooseTurtleImage.addActionListener(this);
		chooseTurtleImage.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
	}
	
	public JMenu getFormatMenu() {
		return format;
	}
	
	private class PenColorsSubmenu{
		private JMenu penColors; 
		private JMenu turtleImages; 
		
	}
}
