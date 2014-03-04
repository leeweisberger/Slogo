package slogo_team02;

import java.awt.Dimension;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import model.Model;
import model.TurtleState;
import view.Display;

/*
 * The Controller class serves as a bridge between the View and the Model
 */
public class Controller {

	public static final Dimension SIZE = new Dimension(1200, 900);
	public static final String TITLE = "Slogo";

	/**
	 * Do the commands in the model.
	 *
	 * @param input the raw user input
	 * @param model the model to be called
	 */
	public void doModel(String input, Model model) {
		model.doCommands(input);
		Map<Integer, List<TurtleState>> historyMap = model.getMyHistoryMap();
	}

	private void doView() {
		Display display = new Display(null, null);
		JFrame frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add our user interface components to Frame and show it
		frame.getContentPane().add(display);
		frame.setSize(SIZE);
		frame.setVisible(true);
	}

	public void go(Model model) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			doModel(input, model);
		}

	}

}
