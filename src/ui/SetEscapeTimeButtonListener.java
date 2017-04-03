package ui;

import model.Model;
import ui.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetEscapeTimeButtonListener implements ActionListener {
	Model _model;
	UI _ui;
	public SetEscapeTimeButtonListener(Model m, UI ui){
		_ui = ui;
		_model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.maxEscapeTimePrompt();
	}

}
