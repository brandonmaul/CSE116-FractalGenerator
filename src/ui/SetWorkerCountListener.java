package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class SetWorkerCountListener implements ActionListener {

	Model _model;
	UI _ui;
	
	public SetWorkerCountListener(Model m, UI ui){
		_ui = ui;
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.workerCountPrompt();
	}

}
