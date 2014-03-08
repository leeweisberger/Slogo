package view.buttons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import view.menu.ParseAndWriteXML;

public class Settings {
	private ParseAndWriteXML myParseAndWriteXML; 
	private Map<String, String> settings; 
	

	Settings(){
		myParseAndWriteXML = new ParseAndWriteXML(); 
		settings = new HashMap<String, String>(); 
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
	}
	
	public void saveSettings(){
		try {
			myParseAndWriteXML.writeOutXMLFile(settings);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPenColor(){
		return settings.get("penColor"); 
	}
	public String backgroundColor(){
		return settings.get("backgroundColor"); 
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
