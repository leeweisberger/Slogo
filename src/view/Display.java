
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

import model.Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
 
public class Display extends JPanel {
	private DisplayTab tab1; 


	private DisplayTab tab2; 
	private DisplayTab tab3; 
	private Model model1;
	private Model model2;
	private Model model3;
	
    public Display() {
        super(new GridLayout(1, 1));
         
        JTabbedPane tabbedPane = new JTabbedPane();
        
        model1 = new Model();
        tab1 = new DisplayTab(model1, null); 
        
        model2 = new Model();
        tab2 = new DisplayTab(model2, null); 
        
        model3 = new Model();
        tab3 = new DisplayTab(model3, null);
        
        tabbedPane.addTab("tab 1", tab1);
        tabbedPane.addTab("tab 2", tab2);
        tabbedPane.addTab("tab 3", tab3);
    
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
	public DisplayTab getTab1() {
		return tab1;
	}


 
}
