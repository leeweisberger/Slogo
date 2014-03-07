package view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SuperButton implements ActionListener{
	private JButton button; 
	
	SuperButton(String buttonTitle){
		button = new JButton(buttonTitle);
		button.setActionCommand(buttonTitle);
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
	
	
}
