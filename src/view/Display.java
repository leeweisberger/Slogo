
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
    
    private static Model myModel;
    private static TurtleGraphicsWindow turtleGrahicsWindow =  TurtleGraphicsWindow.getInstance(); 
    private final JTabbedPane tabbedPane; 
    private int selectedIndex = 0;

    public Display(Model model, String language) {
        super(new GridLayout(1, 1));
        Model model1 = new Model();
        Model model2 = new Model();
        
        tabbedPane = new JTabbedPane();
        
        tab1 = new DisplayTab(model, "English"); 
        tab1.setTurtleGraphicsWindow(turtleGrahicsWindow);
        tab2 = new DisplayTab(model1, "English");
//        tab2.setTurtleGraphicsWindow(turtleGrahicsWindow);
        tab3 = new DisplayTab(model2, "English");
//        tab3.setTurtleGraphicsWindow(turtleGrahicsWindow);

        tabbedPane.addTab("tab 1", null, tab1, "first workspace");
        tabbedPane.addTab("tab 2", null, tab2, "second workspace");
        tabbedPane.addTab("tab 3", null, tab3, "third workspace");
        tabbedPane.addChangeListener(this);

        add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
    }
    
    @Override
    public void stateChanged(ChangeEvent e){
        if ( tabbedPane.getSelectedIndex() != selectedIndex ) {
            System.out.println("Tab: " + tabbedPane.getSelectedIndex());
            ((DisplayTab) tabbedPane.getSelectedComponent()).setTurtleGraphicsWindow(turtleGrahicsWindow);
            int prevIndex = selectedIndex;
            selectedIndex = tabbedPane.getSelectedIndex();
            
        }
    }
    
    public DisplayTab getTab1() {
        return tab1;
    }
    
}
