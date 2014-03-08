package view.menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import view.CommandInput;

public class FileMenu implements ActionListener {
	private List<JMenuItem> menuItems = new ArrayList<JMenuItem>(); // to be used or reflection 
	private JMenuItem open, save, loadPreferences, savePreferences, newTab; 
	private JFileChooser fileChooser; 
	private JMenu file;
	

	private CommandInput myCommandIn; 
	private File importedCommandsFile, savedCommandsFile; 
	
	public FileMenu(CommandInput commandInput, File importedFile, File savedFile){
		this.myCommandIn = commandInput; 
		initialiseMenuItems(); 
		addMenuItemsToMenu(menuItems, file); 
		addActionListenerToMenuItems(menuItems); 
		
		fileChooser = new JFileChooser(); 
		this.importedCommandsFile = importedFile; 
		this.savedCommandsFile = savedFile; 
	}
	
	public List<JMenuItem> initialiseMenuItems(){
		file = new JMenu("File");
		menuItems.add(file);
		open = new JMenuItem("Load Commands"); 
		menuItems.add(open);
		save = new JMenuItem("Save Commands"); 
		menuItems.add(save);
		loadPreferences = new JMenuItem("Load Preferences"); 
		menuItems.add(loadPreferences);
		savePreferences = new JMenuItem("Save Preferences");
		menuItems.add(savePreferences);
		newTab = new JMenuItem("New Tab");	
		menuItems.add(newTab);
		
		return menuItems; 
	}
	
	public JMenu addMenuItemsToMenu(List<JMenuItem> menuItems, JMenu file){
		for(JMenuItem menuItem: menuItems){
			file.add(menuItem);
		}
		return file;  
	}
	
	public List<JMenuItem> addActionListenerToMenuItems(List<JMenuItem> menuItems){
		for(JMenuItem menuItem: menuItems){
			menuItem.addActionListener(this);
		}
		return menuItems; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int temp; 
		Component temp1 = null; 

		if(e.getSource() == open){
			temp = fileChooser.showOpenDialog(temp1);

			if (temp == JFileChooser.APPROVE_OPTION) {
				importedCommandsFile = fileChooser.getSelectedFile();
				myCommandIn.insertCommandsFromFile(importedCommandsFile); 
			}
		}
		if(e.getSource() == save){
			temp = fileChooser.showSaveDialog(temp1);
			
			if(temp == JFileChooser.APPROVE_OPTION) {
				savedCommandsFile = myCommandIn.saveCommandsToFile(savedCommandsFile);
			}	
		}
		if(e.getSource() == loadPreferences){
			temp = fileChooser.showSaveDialog(temp1);
			
			if(temp == JFileChooser.APPROVE_OPTION) {
				
			}	
		}
		
		if(e.getSource() == savePreferences){
			temp = fileChooser.showSaveDialog(temp1);
			
			if(temp == JFileChooser.APPROVE_OPTION) {
				
			}	
		}				
	}
	
	public JMenu getFileMenu() {
		return file;
	}
	

}
