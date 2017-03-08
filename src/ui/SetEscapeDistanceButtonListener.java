package ui;

import model.Model;
import ui.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetEscapeDistanceButtonListener implements ActionListener {
	Model _model;
	UI _ui;
	public SetEscapeDistanceButtonListener(Model m, UI ui){
		_ui = ui;
		_model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.escapeDistancePrompt();
	}

}
