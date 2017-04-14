package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.TimeUnit;

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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		try{
			_dispRegion[2] = e.getX();
			_dispRegion[3] = e.getY();
			
			if(_dispRegion[0] >= _dispRegion[2] || _dispRegion[1] >= _dispRegion[3]){
				_fp.repaint();
				return;
			}else{
				_model.setDisplayRegion(_dispRegion[0], _dispRegion[1], _dispRegion[2], _dispRegion[3]);
				_ui.updateFractalDetails();
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
		
		int width = e.getX() - _dispRegion[0];
		int height = e.getY() - _dispRegion[1];
		
		_fp.repaint(_dispRegion[0],_dispRegion[1], width, height);
		Graphics2D g = (Graphics2D) _fp.getGraphics();
		g.setColor(new Color(255,255,255,100));
		g.setStroke(new BasicStroke(5));
		g.drawRect(_dispRegion[0],_dispRegion[1], width, height);
		System.out.println("Painted on " + e.getX() + ", " + e.getY());
		
		return;
		
		
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("MouseMoved");
		
		
	}

}
