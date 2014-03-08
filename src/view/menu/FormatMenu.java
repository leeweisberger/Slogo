package view.menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import jgame.JGColor;
import view.TurtleGraphicsWindow;
import view.buttons.Settings;

public class FormatMenu implements ActionListener {
	private List<JMenuItem> penColor; // to be used or reflection 
	private List<JMenuItem> turtleImage; // to be used or reflection 
	private List<JMenu> menus; 
	private JMenuItem red, blue, green, turtle, box, circle; 
	private JMenu format, changePenColor, chooseTurtleImage; 
	private Settings mySettings; 
	private Map<String, JGColor> stringToJGColorMap; 
	private String turtleImageURL, boxImageURL, shoeImageURL; 


	public FormatMenu(){
		mySettings = Settings.getInstance(); 
		stringToJGColorMap = mySettings.getStringToJGColorMap(); 
		
		initialiseMenuItems(); 
		addMenusToMenu(menus, format);
		addMenuItemsToMenu(penColor, changePenColor); 
		addMenuItemsToMenu(turtleImage, chooseTurtleImage); 
		addActionListenerToMenuItems(penColor);
		addActionListenerToMenuItems(turtleImage);	
	}
	
	public void initialiseTurtleImageURLs(){
		turtleImageURL =  "turtle.png";
		boxImageURL = "";
		shoeImageURL = "";
		
	}

	public JMenu addMenuItemsToMenu(List<JMenuItem> menuItems, JMenu menu){
		for(JMenuItem menuItem: menuItems){
			menu.add(menuItem); 
		}
		return menu; 
	}

	public JMenu addMenusToMenu(List<JMenu> menus, JMenu menu){
		for(JMenu m: menus ){
			menu.add(m);
		}
		return menu; 
	}

	public void initialiseMenuItems(){
		menus = new ArrayList<JMenu>(); 

		format = new JMenu("Format");

		changePenColor = new JMenu("Choose pen color");
		menus.add(changePenColor);
		chooseTurtleImage = new JMenu("Choose turtle image");
		menus.add(chooseTurtleImage);

		penColor = new ArrayList<JMenuItem>(); 
		turtleImage = new ArrayList<JMenuItem>(); 

		red = new JMenuItem("red");
		penColor.add(red);
		blue = new JMenuItem("blue");
		penColor.add(blue);
		green = new JMenuItem("green"); 
		penColor.add(green);

		turtle = new JMenuItem("turtle");
		turtleImage.add(turtle);
		box = new JMenuItem("box");
		turtleImage.add(box);
		circle = new JMenuItem("shoe"); 
		turtleImage.add(circle);
	}



	public List<JMenuItem> addActionListenerToMenuItems( List<JMenuItem> menuItems){
		for(JMenuItem menuItem: menuItems){
			menuItem.addActionListener(this);
		}	
		return menuItems; 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == red){	
			TurtleGraphicsWindow.setPenColor(stringToJGColorMap.get("red")); 
		}
		if(e.getSource() == green){
			TurtleGraphicsWindow.setPenColor(stringToJGColorMap.get("green")); 
		}
		if(e.getSource() == blue){
			TurtleGraphicsWindow.setPenColor(stringToJGColorMap.get("blue")); 
		}
		if(e.getSource() == turtle){
			TurtleGraphicsWindow.setTurtleImage("myTurtle");
		}
		if(e.getSource() == box){
			TurtleGraphicsWindow.setTurtleImage("myBox");
		}
		if(e.getSource() == circle){
			TurtleGraphicsWindow.setTurtleImage("myCircle");
		}

	}

	public JMenu getFormatMenu() {
		return format;
	}

}
