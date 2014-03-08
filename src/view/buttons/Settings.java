package view.buttons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import jgame.JGColor;

import org.xml.sax.SAXException;

import view.TurtleGraphicsWindow;
import view.menu.ParseAndWriteXML;

public class Settings {
	private ParseAndWriteXML myParseAndWriteXML; 
	private Map<String, String> settings; 
	private static Settings _instance; 
	private Map<String, JGColor> stringToJGColorMap; 

	public Map<String, JGColor> getStringToJGColorMap() {
		return stringToJGColorMap;
	}

	public Settings(){
		myParseAndWriteXML = new ParseAndWriteXML(); 
		settings = new HashMap<String, String>(); 
		setDefaultSettings();
		initialiseStringToJGColorMap(); 	
	}
	
	public Map<String, JGColor> initialiseStringToJGColorMap(){
		stringToJGColorMap = new HashMap<String, JGColor>(); 
		stringToJGColorMap.put("blue", new JGColor(0,0,255)); 
		stringToJGColorMap.put("red", new JGColor(255,0,0)); 
		stringToJGColorMap.put("green", new JGColor(0,128,0)); 
		return stringToJGColorMap;
	}

	public static Settings getInstance(){
		if(_instance == null){
			_instance = new Settings(); 
			return _instance; 
		}
		return _instance;
	}
	
	public void updateSettings(){ 
		TurtleGraphicsWindow.setPenColor(stringToJGColorMap.get("penColor")); 
		TurtleGraphicsWindow.setTurtleImage(settings.get("turtleImage")); 
	}
	
	public void loadSettings(File settingsFile){
		try {
			settings = myParseAndWriteXML.parseXML(settingsFile);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateSettings(); 
		
	
	}
	
	public void saveSettings(){
		try {
			myParseAndWriteXML.writeOutXMLFile(settings);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setDefaultSettings(){
		settings.put("penColor", "yellow");
		settings.put("backgroundColor", "black");
		settings.put("turtleImage", "myCircle");
		settings.put("commandFile", "commands.txt");
	}
	
	
}
