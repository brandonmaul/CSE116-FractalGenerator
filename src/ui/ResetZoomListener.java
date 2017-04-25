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
		_model.setDisplayRegion(0, 0, _model.getGridSize() - 1, _model.getGridSize() - 1);
		_ui.updateFractal();

	}

}
