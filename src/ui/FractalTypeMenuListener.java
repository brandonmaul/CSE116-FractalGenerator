package ui;

import javax.swing.*;
import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalTypeMenuListener implements ActionListener {
	
	Model _model;
	UI _ui;
	
	public FractalTypeMenuListener(Model m, UI ui){
		_model = m;
		_ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButtonMenuItem thisButton = (JRadioButtonMenuItem) e.getSource();
		_model.setFractalType(thisButton.getText());
		thisButton.setSelected(true);
		_ui.updateFractal();
	}
	
}
