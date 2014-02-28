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
		setProperties(); 
	}

	public void setProperties(){
		commandIn.setFont(new Font("Serif", Font.ITALIC, 16));
		commandIn.setLineWrap(true);
		commandIn.setWrapStyleWord(true);
	}

	public JScrollPane getCommandInput() {
		return commandInScrollPane;
	}
}
