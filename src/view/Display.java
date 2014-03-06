
package view;

/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import jgame.platform.JGEngine;

public class Display extends JPanel implements ChangeListener{
	private DisplayTab tab1; 
	private DisplayTab tab2; 
	private DisplayTab tab3; 
	private static Model model;
	private static TurtleGraphicsWindow turtleGrahicsWindow = new TurtleGraphicsWindow(); 
	private JTabbedPane tabbedPane; 
	private int selectedIndex; 

	public Display() {
		super(new GridLayout(1, 1));

		tabbedPane = new JTabbedPane();

		model = new Model();
		tab1 = new DisplayTab(model, null); 
		tab1.setTurtleGraphicsWindow(turtleGrahicsWindow);

		tab2 = new DisplayTab(model, null); 


		tab3 = new DisplayTab(model, null);

		tabbedPane.addTab("tab 1", tab1);
		tabbedPane.addTab("tab 2", tab2);
		tabbedPane.addTab("tab 3", tab3);
		tabbedPane.addChangeListener(this); 
		//Add the tabbed pane to this panel.
		add(tabbedPane);

		//The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	public DisplayTab getTab1() {
		return tab1;
	}
	
	public static TurtleGraphicsWindow getTurtleGrahicsWindow() {
		return turtleGrahicsWindow;
	}


	public void stateChanged(ChangeEvent e){
		 if ( tabbedPane.getSelectedIndex() != selectedIndex ) { 
	        ((DisplayTab) tabbedPane.getSelectedComponent()).setTurtleGraphicsWindow(turtleGrahicsWindow);
	        selectedIndex = tabbedPane.getSelectedIndex();
	        }
	}


}
