package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateButtonListener implements ActionListener {
	private UI _ui;
	
	public GenerateButtonListener(UI ui){
		_ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.updateFractal();
		_ui.displayFractal();
	}

}
