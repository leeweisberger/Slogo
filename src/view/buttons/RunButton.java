package view.buttons;

import java.awt.event.ActionEvent;

public class RunButton extends HistoryButton{
	private String recentCommands; 

	RunButton(String buttonTitle) {
		super(buttonTitle);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		
		updateHistoryButtonText(recentCommands);
	}
	
	public void setRecentCommands(String recentCommands) {
		this.recentCommands = recentCommands;
	}
}
