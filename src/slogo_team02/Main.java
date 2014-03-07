package slogo_team02;



import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.View;

import model.Model;
import view.Display;


public class Main {
	private static final String TITLE = "SLogo";
	public static void main(String[] args) {
		Controller c = new Controller();
		Model model = new Model();
		
		ViewController vc = new ViewController();
		vc.initializeView(model);
		
		c.go(model);
		
	}
}
