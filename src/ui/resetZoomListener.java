package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class resetZoomListener implements ActionListener {
	
	private Model _model;
	private UI _ui;
	
	public resetZoomListener(Model m, UI ui){
		_model = m;
		_ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_model.setDisplayRegion(0, 0, 511, 511);
		_ui.update();

	}

}
