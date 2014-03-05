package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import model.Model;
import model.TurtleState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Display extends JPanel implements ActionListener{
	private static final Dimension SIZE = new Dimension(800, 600);
	private static final String DRAW_BOX_TITLE = "Draw";
	private static final String HISTORY_BOX_TITLE = "History";
	private static final String COMMAND_BOX_TITLE = "Command";
	private static Model myModel;
	private static ResourceBundle myResources;
	private JTextArea output;
	private JScrollPane scrollPane;
	private MenuBar menuBar;
	private CommandInput commandInput; 
	private Container pane;
	private JButton run;
	private JButton stop;
	private JButton clear;
	private JButton history;
	private JLabel historyLabel;
	private JTextPane turtleStatus = new JTextPane(); 
	private TurtleGraphicsWindow turtleGraphicsWindow;
	private Dimension GRAPHIC_WINDOW_SIZE;
	private Map<Integer, List<TurtleState>> myHistoryMap;
	
	public Display (Model model, String language){

		myModel = model;
		//    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		setLayout(new BorderLayout());
		//        add(makeCommandHistoryBox(), BorderLayout.EAST);
		//        add(makeTurtleStatusBox(), BorderLayout.SOUTH);
		//        add(makeDrawTurtleWindow(), BorderLayout.CENTER);
		menuBar = new MenuBar(); 
		commandInput = new CommandInput(); 

		turtleGraphicsWindow = new TurtleGraphicsWindow(); 
		run = new JButton("run");
		stop = new JButton("stop");
		clear = new JButton("clear");
		history = new JButton("History");

		pane = new Container();	
		addComponentsToLayout(); 
	}

	private void addComponentsToLayout(){
		add(menuBar.getMenuBar(), BorderLayout.NORTH);
		add(commandInput.getCommandInput(), BorderLayout.SOUTH);
		add(layoutButtons(pane),  BorderLayout.EAST);
		add(history,  BorderLayout.WEST);
		add(turtleGraphicsWindow, BorderLayout.CENTER);
//		System.out.println("turtleGraphicsWindow added");
		
		
		GRAPHIC_WINDOW_SIZE = turtleGraphicsWindow.getSize();
		System.out.println(turtleGraphicsWindow.pfWidth() + turtleGraphicsWindow.pfHeight());
		System.out.println(turtleGraphicsWindow.viewWidth() + turtleGraphicsWindow.viewHeight());
		System.out.println(turtleGraphicsWindow.displayWidth() + turtleGraphicsWindow.displayHeight());
		
	}
	private Container layoutButtons(Container pane){
		pane.setLayout(new GridBagLayout()); 
		pane.add(turtleStatus, setComponentConstraints(0,0));
		pane.add(run, setComponentConstraints(0,1));
		pane.add(stop, setComponentConstraints(0,2));
		pane.add(clear, setComponentConstraints(0,3));

		return pane; 
	}

	private void addActionListenerToComponents(){
		run.addActionListener(this);
		stop.addActionListener(this);
		clear.addActionListener(this);
		history.addActionListener(this);
	}

	private GridBagConstraints setComponentConstraints(int x, int y){
		GridBagConstraints c = new GridBagConstraints();
		c.weightx= 0.5;
		c.gridx = x; 
		c.gridy = y; 
		return c; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == run){
			
		}
		if(e.getSource() == stop){

		}
		if(e.getSource() == clear){

		}
		if(e.getSource() == history){

		}

	}

    public TurtleGraphicsWindow getTurtleGraphicsWindow () {
        return turtleGraphicsWindow;
        // TODO Auto-generated method stub
        
    }

}
