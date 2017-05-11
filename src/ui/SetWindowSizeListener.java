package ui;

import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetWindowSizeListener implements ActionListener {
	
	private Model _model;
	private UI _ui;
	
	public SetWindowSizeListener(Model m, UI ui){
		_ui = ui;
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_ui.setWindowSizePrompt();
	}

}
