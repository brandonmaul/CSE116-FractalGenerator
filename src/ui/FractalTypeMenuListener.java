package ui;

import javax.swing.*;
import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalTypeMenuListener implements ActionListener {
	
	Model _model;
	UI _ui;
	int _myFractalID;
	
	public FractalTypeMenuListener(Model m, UI ui, int myFractalID){
		_model = m;
		_ui = ui;
		_myFractalID = myFractalID;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.setFractalType(_myFractalID);
		JRadioButtonMenuItem thisButton = (JRadioButtonMenuItem) e.getSource();
		thisButton.setSelected(true);
		_ui.updateFractal();
	}
	
}
