package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class generateButtonListener implements ActionListener {
	private Model _model;
	
	public generateButtonListener(Model m){
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.generateFractal();
	}

}
