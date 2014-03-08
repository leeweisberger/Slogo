package view.menu;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node; 

public class ParseAndWriteXML {
	DocumentBuilderFactory docFactory; 
	DocumentBuilder docBuilder; 
	Document doc; 
	TransformerFactory transformerFactory ;
	Transformer transformer ;
	DOMSource source;
	StreamResult result;
	File file; 
	public File getFile() {
		return file;
	}

	Map<String, String> settings; 
	
	 
	public void setSettings(Map<String, String> settings) {
		this.settings = settings;
	}


	public Map<String, String> getSettings() {
		return settings;
	}


	public  ParseAndWriteXML(){
		docFactory = DocumentBuilderFactory.newInstance();
		
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doc = docBuilder.newDocument();
		transformerFactory = TransformerFactory.newInstance();
		
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		source = new DOMSource(doc);
		result = new StreamResult(new File("settings.xml"));
		
		settings = new HashMap<String, String>(); 
		settings.put("penColor", "yellow");
		settings.put("backgroundColor", "black");
		settings.put("turtleImage", "turtle1.jpg");
		settings.put("commandFile", "commands.txt");
		
		file = new File("settings.xml"); 
	}

	
	public void writeOutXMLFile(Map<String, String> settings) throws ParserConfigurationException{
			Element rootElement = doc.createElement("settings");
			doc.appendChild(rootElement);

			// staff elements
			Element penColor = doc.createElement("penColor");
			penColor.appendChild(doc.createTextNode(settings.get("penColor")));
			rootElement.appendChild(penColor);

			Element backgroundColor = doc.createElement("backgroundColor");
			backgroundColor.appendChild(doc.createTextNode(settings.get("backgroundColor")));
			rootElement.appendChild(backgroundColor);

			Element turtleImage = doc.createElement("turtleImage");
			turtleImage.appendChild(doc.createTextNode(settings.get("turtleImage")));
			rootElement.appendChild(turtleImage);

			Element commandFile = doc.createElement("commandFile");
			commandFile.appendChild(doc.createTextNode(settings.get("commandFile")));
			rootElement.appendChild(commandFile);

			try {
				transformer.transform(source, result);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			System.out.println("Settings file saved!");

	
	}

	public Map<String, String> parseXML(File settingsFile) throws ParserConfigurationException, SAXException, IOException{
		
        doc = docBuilder.parse (settingsFile);
        doc.getDocumentElement().normalize();
        
        // normalize text representation
        doc.getDocumentElement ().normalize ();

        NodeList listOfSettings = doc.getElementsByTagName("settings");

        for(int s=0; s<listOfSettings.getLength() ; s++){

            Node firstSettingNode = listOfSettings.item(s);
            if(firstSettingNode.getNodeType() == Node.ELEMENT_NODE){


                Element onlySettingNode = (Element)firstSettingNode;

                //-------
                NodeList penColorList = onlySettingNode.getElementsByTagName("penColor");
                Element penColorElement = (Element)penColorList.item(0);

                NodeList textFNList = penColorElement.getChildNodes();
                settings.put("penColor", textFNList.item(0).getNodeValue());
         

                //-------
                NodeList lastNameList = onlySettingNode.getElementsByTagName("backgroundColor");
                Element lastNameElement = (Element)lastNameList.item(0);

                NodeList textLNList = lastNameElement.getChildNodes();
                settings.put("backgroundColor", textLNList.item(0).getNodeValue());

                //----
                NodeList ageList = onlySettingNode.getElementsByTagName("turtleImage");
                Element ageElement = (Element)ageList.item(0);

                NodeList textAgeList = ageElement.getChildNodes();
                settings.put("turtleImage", textAgeList.item(0).getNodeValue());

                
                NodeList commandFile = onlySettingNode.getElementsByTagName("commandFile");
                Element commandElement = (Element)commandFile.item(0);

                NodeList textCommandElement = commandElement.getChildNodes();
                settings.put("commandFile", textCommandElement.item(0).getNodeValue());

                //------
                
            }
        }
        System.out.println(settings.get("penColor"));
        System.out.println(settings.get("backgroundColor"));
        System.out.println(settings.get("turtleImage"));
        System.out.println(settings.get("commandFile"));


        return settings;
	}

	
 	
	public static void main(String argv[]) {
		ParseAndWriteXML parserAndWriter = new ParseAndWriteXML(); 
		
		try {
			parserAndWriter.writeOutXMLFile(parserAndWriter.getSettings());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			parserAndWriter.parseXML(parserAndWriter.getFile());
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
}