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
		stringToJGColorMap.put("yellow", new JGColor(255,255,0)); 	
		return stringToJGColorMap;
	}

	public static Settings getInstance(){
		if(_instance == null){
			_instance = new Settings(); 
			return _instance; 
		}
		return _instance;
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
		
		
		updateBackgroundColor(); 
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
		settings.put("turtleImage", "turtle1.jpg");
		settings.put("commandFile", "commands.txt");
	}
	
	public String getPenColor(){
		return settings.get("penColor"); 
	}
	public void updateBackgroundColor(){
<<<<<<< HEAD

=======
		 
>>>>>>> branch 'master' of https://github.com/duke-compsci308-spring2014/slogo_team02
	}
	public String TurtleImageName(){
		return settings.get("turtleImage"); 
	}
	public String getCommandFile(){
		return settings.get("commandFile"); 
	}
	public String putPenColor(String penColor){
		return settings.put("penColor",penColor); 
	}
	public String putBackgroundColor(String backgroundColor){
		return settings.put("backgroundColor", backgroundColor); 
	}
	public String putTurtleImageName(String turtleImageName){
		return settings.put("turtleImage", turtleImageName); 
	}
	public String putCommandFile(String commandFileName){
		return settings.put("commandFile",commandFileName ); 
	}
}
