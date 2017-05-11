package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetWindowSizeListener implements ActionListener {
	
	private UI _ui;
	
	public SetWindowSizeListener(UI ui){
		_ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.setWindowSizePrompt();
	}

}
