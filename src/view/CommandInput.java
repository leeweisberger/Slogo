package view;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class CommandInput {

    private JTextArea commandIn;
    private DocumentListener documentListener; 
    private JScrollPane commandInScrollPane; 
    private BufferedReader br = null;


    CommandInput(){
        commandIn = new JTextArea("Please type your command here", 5, 10);
        commandInScrollPane  = new JScrollPane(commandIn);
        setProperties("Sanserif", 16); 
    }

    public void setProperties(String fontName, int fontSize){
        commandIn.setFont(new Font(fontName, Font.ITALIC, fontSize));
        commandIn.setLineWrap(true);
        commandIn.setWrapStyleWord(true);
    }

    public JScrollPane getCommandInput() {
        return commandInScrollPane;
    }

    public String getValue() {
        return commandIn.getText();
    }

//    TODO
    /*used to check if the user input is null*/
    private boolean handleEmptyTextField(DocumentEvent e) {
        if (e.getDocument().getLength() <= 0) {
            return false;
        }
        else 
            return true;
    }

    public void insertCommandsFromFile(File file){
        br = null;
        String CurrentLine, fullText = null;
        try {
            br = new BufferedReader(new FileReader(file));

            while ((CurrentLine = br.readLine()) != null) {
                fullText+=CurrentLine; 
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        commandIn.setText(fullText);
    }

    public File saveCommandsToFile(File file){
        try {	 
            String content = commandIn.getText();

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;		
    }

}
