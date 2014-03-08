package slogo_team02;



import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.View;

import model.Model;
import view.Display;


public class Main {
	private static final String TITLE = "SLogo";
	private static final Dimension SIZE = new Dimension(1200, 900);
	private static Model myModel; 
	
	public static void main(String[] args) {
		Main myMain = new Main(); 
		myMain.initializeModel();
		myMain.initializeView(myModel); 	
	}
	
	public void initializeModel(){
		myModel = new Model();
		myModel.setFirstTurtleState(0, 0, 0,0);
	}
	
	 public void initializeView(Model model){
	        Display display = new Display(model, null); 
	        JFrame frame = new JFrame(TITLE); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(display);        
	        frame.setSize(SIZE);
	        frame.setVisible(true);                
	}
}
