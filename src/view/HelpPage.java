package view;

/* HtmlDemo.java needs no other files. */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HelpPage extends JPanel {
	private JLabel label;
	private String htmlString;
	private JPanel panel; 
	private JScrollPane helpPageScrollPane; 

	public HelpPage() {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		try {
			htmlString = readFile("help.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		label = new JLabel(htmlString);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		helpPageScrollPane = new JScrollPane(label);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Help"),
				BorderFactory.createEmptyBorder(10,10,10,10)));
		panel.add(helpPageScrollPane);

		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		add(Box.createRigidArea(new Dimension(10,0)));
		add(panel);
	}

	String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				//sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

	public static void createAndShowHelpPage() {
		//Create and set up the window.
		JFrame frame = new JFrame("Help");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Add content to the window.
		frame.add(new HelpPage());

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}