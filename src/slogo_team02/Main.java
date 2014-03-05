package slogo_team02;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.View;

import model.Model;
import view.Display;

public class Main {
	private static final String TITLE = "SLogo";
	public static final Dimension SIZE = new Dimension(1200, 900);
	public static void main(String[] args) {
		Main main = new Main();
		Controller c = new Controller();
		Model model = new Model();
<<<<<<< HEAD
		model.setState(0, 0, 0,0);
		main.initializeView(model);
		c.go(model);

	}
	private void initializeView(Model model){
		Display display = new Display(model, null); 
		JFrame frame = new JFrame(TITLE); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
>>>>>>> branch 'master' of https://github.com/duke-compsci308-spring2014/slogo_team02

		model.setState(0, 0, 0,0);
//		main.initializeView();
	
                ViewController vc = new ViewController();
                vc.initializeView(model);  		
                
                
		c.go(model);
  

	}


}
