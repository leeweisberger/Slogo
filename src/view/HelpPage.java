package view;

/* HtmlDemo.java needs no other files. */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HelpPage extends JPanel implements ActionListener {
	private JLabel label;
	private String htmlString;
	private JPanel panel; 
	private JScrollPane helpPageScrollPane; 
	private JMenu help; 
	private JMenuItem getHelpPage; 
	
	public HelpPage() {	
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		getHelpPage = initialiseMenuItem(getHelpPage, "Help Page"); 
		help = initialiseMenu(help, "Help", getHelpPage);	
		try {
			htmlString = readFile("help.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		helpPageScrollPane = new JScrollPane(setUpLabel(label));
		panel = setUpPanel(panel, helpPageScrollPane);

		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(Box.createRigidArea(new Dimension(10,0)));
		add(panel);
	}
	
	public JLabel setUpLabel(JLabel label){
		label = new JLabel(htmlString);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label; 
	}
	
	public JPanel setUpPanel(JPanel panel, JScrollPane scrollPane){
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Help"),
				BorderFactory.createEmptyBorder(10,10,10,10)));
		panel.add(scrollPane);
		
		return panel; 
	}

	public JMenu initialiseMenu(JMenu menu, String menuName, JMenuItem menuItem){
		menu = new JMenu(menuName); 
		menu.add(menuItem);
		return menu; 
	}
	
	public JMenuItem initialiseMenuItem(JMenuItem menuItem, String menuItemName){
		menuItem = new JMenuItem(menuItemName);
		menuItem.addActionListener(this); 
		return menuItem; 
	}
	
	String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
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

	public JMenu getHelp() {
		return help;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getHelpPage){
			createAndShowHelpPage();
		}		
	}

}