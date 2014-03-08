package view.buttons;

import java.awt.event.ActionEvent;

public class HistoryButton extends SuperButton{
	private String historyButtonText; 

	HistoryButton(String buttonTitle) {
		super(buttonTitle);
	}
	
	public void updateHistoryButtonText(String text){
		historyButtonText = text; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		rerunHistory(); 		
	}
	
	public void rerunHistory(){
		
	}

}
