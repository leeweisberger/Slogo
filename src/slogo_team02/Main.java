package slogo_team02;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.View;

import model.Model;
import view.Display;
import view.DisplayTab;

public class Main {
	private static final String TITLE = "SLogo";
	public static void main(String[] args) {
		Main main = new Main();
		Controller c = new Controller();
		Model model = new Model();
		model.setState(0, 0, 0,0);
		
		
		ViewController vc = new ViewController();
		vc.initializeView(model);
//		vc.drawPath();

		c.go(model);
		
	}
}
