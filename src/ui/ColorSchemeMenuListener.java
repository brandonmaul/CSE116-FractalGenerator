package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.IndexColorModel;

import javax.swing.JRadioButtonMenuItem;

import model.Model;

public class ColorSchemeMenuListener implements ActionListener {
	
	Model _model;
	UI _ui;
	IndexColorModel _myColorModel;
	
	public ColorSchemeMenuListener(Model m, UI ui, IndexColorModel myColorScheme) {
		_model = m;
		_ui = ui;
		_myColorModel = myColorScheme;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.setColorModel(_myColorModel);
		JRadioButtonMenuItem thisButton = (JRadioButtonMenuItem) e.getSource();
		thisButton.setSelected(true);
		_ui.update();
	}

}
