package ui;

import javax.swing.*;
import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fractalTypeMenuActionListener implements ActionListener {
	Model _model;
	
	public fractalTypeMenuActionListener(Model m){
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButtonMenuItem item = (JRadioButtonMenuItem) e.getSource();
		if(item.getName() == "Mandelbrot"){
			_model.setFractalType(1);
		}else if(item.getName() == "Julia"){
			_model.setFractalType(2);
		}else if(item.getName() == "Burning Ship"){
			_model.setFractalType(3);
		}else if(item.getName() == "Multibrot"){
			_model.setFractalType(4);
		}
	}
	
}
