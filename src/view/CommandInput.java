package view;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommandInput {

	JTextArea commandIn;
	JScrollPane commandInScrollPane; 

	CommandInput(){
		commandIn = new JTextArea(10, 10);
		commandInScrollPane  = new JScrollPane(commandIn);
		setProperties("Serif", 16); 
	}

	public void setProperties(String fontName, int fontSize){
		commandIn.setFont(new Font(fontName, Font.ITALIC, fontSize));
		commandIn.setLineWrap(true);
		commandIn.setWrapStyleWord(true);
	}

	public JScrollPane getCommandInput() {
		return commandInScrollPane;
	}
}
