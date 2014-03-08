package view.buttons;

import java.awt.event.ActionEvent;

public class ClearButton extends HistoryButton{

	ClearButton(String buttonTitle) {
		super(buttonTitle);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		updateHistoryButtonText(""); 
	}

}
