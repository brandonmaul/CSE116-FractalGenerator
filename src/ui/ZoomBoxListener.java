package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;

public class ZoomBoxListener implements MouseListener {
	
	private Model _model;
	private UI _ui;
	private int[] _dispRegion;

	ZoomBoxListener(Model model, UI ui){
		_ui = ui;
		_model = model;
		_dispRegion = new int[]{0,0,511,511};
	}


	@Override
	public void mousePressed(MouseEvent e) {
		_dispRegion[0] = e.getX();
		_dispRegion[1] = e.getY();
		System.out.println("MousePressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_dispRegion[2] = e.getX();
		_dispRegion[3] = e.getY();
		System.out.println("MouseReleased");
		
		if(_dispRegion[0] == _dispRegion[2] && _dispRegion[1] == _dispRegion[3]){
			return;
		}else{
			_model.setDisplayRegion(_dispRegion[0], _dispRegion[1], _dispRegion[2], _dispRegion[3]);
			_ui.update();
		}	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("MouseClicked");
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
