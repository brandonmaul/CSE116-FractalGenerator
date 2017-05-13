package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
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
		_dispRegion = new int[]{0, 0, _model.getGridSize() - 1, _model.getGridSize() - 1};
	}


	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getX() + ", " + e.getY()); //debug tool :)
		_dispRegion[0] = e.getX() * 2;
		_dispRegion[1] = e.getY() * 2;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println(e.getX() + ", " + e.getY()); //debug tool :) 
		try{
			_dispRegion[2] = e.getX() * 2;
			_dispRegion[3] = e.getY() * 2;
			
			if(_dispRegion[0] >= _dispRegion[2] || _dispRegion[1] >= _dispRegion[3]){
				_fp.repaint();
				return;
			}else{
				_model.setDisplayRegion(_dispRegion[0], _dispRegion[1], _dispRegion[2], _dispRegion[3]);
				_model.generateFractal();
				_ui.updateFractal();
			}
		}catch(ArrayIndexOutOfBoundsException except){
			_fp.repaint();
			return;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		_fp.repaint();
		return;
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		_fp.repaint();
		return;		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		
		int width = e.getX() - _dispRegion[0] / 2;
		int height = e.getY() - _dispRegion[1] / 2;
		
		Graphics2D g = (Graphics2D) _fp.getGraphics();
		_fp.paint(g);
		g.setColor(new Color(255,255,255,255));
		g.setStroke(new BasicStroke(3));
		g.drawRect(_dispRegion[0]/ 2,_dispRegion[1] / 2, width, height);
		
		return;
		
		
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
