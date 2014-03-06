/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
package view;
 
/* HtmlDemo.java needs no other files. */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class HelpPage extends JPanel
                      implements ActionListener {
    JLabel theLabel;
    String initialText;
 
    public HelpPage() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
 
        initialText = "<html>\n" +
                "Color and font test:\n" +
                "<ul>\n" +
                "<li><font color=red>red</font>\n" +
                "<li><font color=blue>blue</font>\n" +
                "<li><font color=green>green</font>\n" +
                "<li><font size=-2>small</font>\n" +
                "<li><font size=+2>large</font>\n" +
                "<li><i>italic</i>\n" +
                "<li><b>bold</b>\n" +
                "</ul>\n";
 
      

 
        theLabel = new JLabel(initialText) {
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
            public Dimension getMinimumSize() {
                return new Dimension(200, 200);
            }
            public Dimension getMaximumSize() {
                return new Dimension(200, 200);
            }
        };
        theLabel.setVerticalAlignment(SwingConstants.CENTER);
        theLabel.setHorizontalAlignment(SwingConstants.CENTER);
 


 
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Help"),
                        BorderFactory.createEmptyBorder(10,10,10,10)));
        rightPanel.add(theLabel);
 
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 
        add(Box.createRigidArea(new Dimension(10,0)));
        add(rightPanel);
    }
 
    //React to the user pushing the Change button.
    public void actionPerformed(ActionEvent e) {
        theLabel.setText(initialText);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void createAndShowHelpPage() {
        //Create and set up the window.
        JFrame frame = new JFrame("Help");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new HelpPage());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(){
    	
    }
 

}