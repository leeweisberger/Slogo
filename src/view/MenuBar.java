package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JInternalFrame;

public class MenuBar implements ActionListener {
    private JMenuBar menuBar;
    private JMenu file, format, help, subMenu1, subMenu2;
    private JMenuItem open, save, chooseTurtleImage, changeColor, bBlack, bRed, bGreen, bBlue, bYellow
    , pBlack, pRed, pGreen, pBlue, pYellow;
    private JFileChooser fileChooser;
    private HelpPage helpPage; 
    private File importedFile; 
    private File savedFile; 

    private CommandInput commandInput; 

    MenuBar(CommandInput commandInput){
        //Create the menu bar.
        menuBar = new JMenuBar();
        file = new JMenu("File");
        format = new JMenu("Format");
        subMenu1 = new JMenu("Change Background Color");
        subMenu2 = new JMenu("Change Pen Color");
        help = new JMenu("Help");
        fileChooser = new JFileChooser(); 
        helpPage = new HelpPage(); 
        this.commandInput = commandInput; 
        savedFile = new File("saved commands.txt");

        addMenus();
        createAndAddMenuItems(); 
    }

    public void createAndAddMenuItems(){
        open = new JMenuItem("Open File",
                             KeyEvent.VK_T);
        open.addActionListener(this); 

        save = new JMenuItem("Save File",
                             KeyEvent.VK_T);
        save.addActionListener(this);
        /*Ask TA here to make it shorter*/
        bBlack = new JMenuItem("Black as BackGroundColor",
                               KeyEvent.VK_T);
        bBlack.addActionListener(this);

        bRed = new JMenuItem("Red as BackGroundColor",
                             KeyEvent.VK_T);
        bRed.addActionListener(this);

        bGreen = new JMenuItem("Green as BackGroundColor",
                               KeyEvent.VK_T);
        bGreen.addActionListener(this);

        bBlue = new JMenuItem("Blue as BackGroundColor",
                              KeyEvent.VK_T);
        bBlue.addActionListener(this);

        bYellow = new JMenuItem("Yello as BackGroundColor",
                                KeyEvent.VK_T);
        bYellow.addActionListener(this);

        pBlack = new JMenuItem("Black as Pen Color",
                               KeyEvent.VK_T);
        pBlack.addActionListener(this);

        pRed = new JMenuItem("Red as Pen Color",
                             KeyEvent.VK_T);
        pRed.addActionListener(this);

        pGreen = new JMenuItem("Green as Pen Color",
                               KeyEvent.VK_T);
        pGreen.addActionListener(this);

        pBlue = new JMenuItem("Blue as Pen Color",
                              KeyEvent.VK_T);
        pBlue.addActionListener(this);

        pYellow = new JMenuItem("Yello as Pen Color",
                                KeyEvent.VK_T);
        pYellow.addActionListener(this);

        changeColor = new JMenuItem("Change Pen Color",
                                    KeyEvent.VK_T);
        changeColor.addActionListener(this); 

        chooseTurtleImage = new JMenuItem("Choose Turtle Image",
                                          KeyEvent.VK_T);
        chooseTurtleImage.addActionListener(this); 

        help.addActionListener(this);

        file.add(open);
        file.add(save);

        subMenu1.add(bBlack);
        subMenu1.add(bRed);
        subMenu1.add(bGreen);
        subMenu1.add(bBlue);
        subMenu1.add(bYellow);

        subMenu2.add(pBlack);
        subMenu2.add(pRed);
        subMenu2.add(pGreen);
        subMenu2.add(pBlue);
        subMenu2.add(pYellow);

        format.add(subMenu1);
        format.add(subMenu2); 
    }

    public void addMenus(){
        menuBar.add(file);
        menuBar.add(format);
        menuBar.add(help);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int temp; 
        Component temp1 = null; 
        if(e.getSource() == open){
            temp = fileChooser.showOpenDialog(temp1);

            if (temp == JFileChooser.APPROVE_OPTION) {
                importedFile = fileChooser.getSelectedFile();
                commandInput.insertCommandsFromFile(importedFile); 
            }
        }
        if(e.getSource() == save){
            temp = fileChooser.showSaveDialog(temp1);

            if(temp == JFileChooser.APPROVE_OPTION) {
                savedFile = commandInput.saveCommandsToFile(savedFile);
            }


        }
        if(e.getSource() == bBlack){

        }
        
        
        if(e.getSource() == changeColor){

        }
        if(e.getSource() == chooseTurtleImage){

        }
        if(e.getSource() == help){
            helpPage.createAndShowHelpPage();

        }

    }
}