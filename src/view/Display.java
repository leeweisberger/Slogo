package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.Model;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import javax.swing.text.BadLocationException;
import javax.swing.GroupLayout.*;


public class Display extends JPanel implements DocumentListener{
    private static final Dimension SIZE = new Dimension(800, 600);
    private static final String DRAW_BOX_TITLE = "Draw";
    private static final String HISTORY_BOX_TITLE = "History";
    private static final String COMMAND_BOX_TITLE = "Command";
    private static Model myModel;
    private static ResourceBundle myResources;
    private JTextArea output;
    private JScrollPane scrollPane;


    public Display (Model model, String language){
        myModel = model;
        //    myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        // add components to frame
        setLayout(new BorderLayout());
        // must be first since other panels may refer to page
        add(makeCommandInputBox(), BorderLayout.SOUTH);
//        add(makeCommandHistoryBox(), BorderLayout.EAST);
//        add(makeTurtleStatusBox(), BorderLayout.SOUTH);
//        add(makeDrawTurtleWindow(), BorderLayout.CENTER);
        add(makeMenuBar(), BorderLayout.NORTH);
        // control the navigation
        enableButtons();
    }
    
    public JMenuBar makeMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
        
        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                                                       KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        return menuBar;
    }

    public JTextArea makeCommandInputBox() {
        JTextArea textArea = new JTextArea(
                                          "Please enter here the command according to which the turtle will move."
                );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.getDocument().addDocumentListener(this);

        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(1200, 250));
//        getTypedCommand();
        return textArea;

    }    

    private void enableButtons () {
        // TODO Auto-generated method stub

    }




    private Component makeCommandHistoryBox () {
        // TODO Auto-generated method stub
        return null;
    }

    private Component makeTurtleStatusBox () {
        // TODO Auto-generated method stub
        return null;
    }

    private Component makeDrawTurtleWindow() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insertUpdate (DocumentEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeUpdate (DocumentEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void changedUpdate (DocumentEvent e) {
        // TODO Auto-generated method stub
        
    }






}
