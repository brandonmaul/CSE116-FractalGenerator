package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import edu.buffalo.fractal.FractalPanel;
import model.Model;

public class ZoomBoxListener implements MouseListener, MouseMotionListener{
	
	private Model _model;
	private UI _ui;
	private FractalPanel _fp;
	private int[] _dispRegion;

	ZoomBoxListener(Model model, UI ui, FractalPanel fp){
		_ui = ui;
		_model = model;
		_fp = fp;
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
			_ui.updateFractalDetails();
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


	@Override
	public void mouseDragged(MouseEvent e) {
		
		int width = e.getX() - _dispRegion[0];
		int height = e.getY() - _dispRegion[1];
		Graphics g = _fp.getGraphics();
		g.setColor(new Color(0, 255, 0, 50));
		g.drawRect(_dispRegion[0],_dispRegion[1], width, height);
		System.out.println("MouseDragged");
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
