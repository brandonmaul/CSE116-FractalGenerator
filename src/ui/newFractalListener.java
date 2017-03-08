package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newFractalListener implements ActionListener {
	UI _ui;
	
	public newFractalListener(UI ui){
		_ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.clearFractal();
		_ui.update();
	}

}
