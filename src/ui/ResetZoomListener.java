package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class ResetZoomListener implements ActionListener {
	
	private Model _model;
	private UI _ui;
	
	public ResetZoomListener(Model m, UI ui){
		_model = m;
		_ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_model.setFractalChanged(true);
		_ui.updateFractal();

	}

}
