package ui;

import javax.swing.*;
import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalTypeMenuListener implements ActionListener {
	Model _model;
	int _myFractalID;
	
	public FractalTypeMenuListener(Model m, int myFractalID){
		_model = m;
		_myFractalID = myFractalID;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.setFractalType(_myFractalID);
		JRadioButtonMenuItem thisButton = (JRadioButtonMenuItem) e.getSource();
		thisButton.setSelected(true);
	}
	
}
