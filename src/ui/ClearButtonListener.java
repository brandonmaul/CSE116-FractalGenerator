package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {
	UI _ui;
	
	public ClearButtonListener(UI ui){
		_ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.clearFractal();
	}

}
