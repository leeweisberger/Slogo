package slogo_team02;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.View;

import model.Model;
import view.Display;

public class Main {
	private static final String TITLE = "SLogo";
//	public static final Dimension SIZE = new Dimension(1200, 900);
	public static final Dimension SIZE = new Dimension(1000, 800);
	
	public static void main(String[] args) {
		Main main = new Main();
		Controller c = new Controller();
		Model model = new Model();

		model.setState(0, 0, 0,0);
//		main.initializeView();
	
                ViewController vc = new ViewController();
                vc.initializeView(model);  		
                
                
		c.go(model);
  

	}


}
