package model;

import java.awt.image.IndexColorModel;
import java.util.ArrayList;
import observer_pattern.*;

public class Model implements Observable {
	
	private ArrayList<Observer> _observers;
	
	private FractalGenerator _fractalGenerator;
	
	private int _escapeDistance;
	private int _fractalType;
	private IndexColorModel _colorModel; 
	
	public Model(){

		_observers = new ArrayList<Observer>();
		
		_fractalGenerator = new FractalGenerator();
		
		_fractalType = 1;
		_escapeDistance = 2;
		
	}
	
	public int[][] generateFractal(){
		int[][] completedFractal = null;
		
		if (_fractalType == 1){
			_fractalGenerator.genMandelbrot(_escapeDistance);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("Mandelbrot Fractal Has Been Made with an escape distance of " + _escapeDistance);
		}else if (_fractalType == 2){
			_fractalGenerator.genJulia(_escapeDistance);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("Julia Fractal Has Been Made with an escape distance of " + _escapeDistance);
		}else if (_fractalType == 3){
			_fractalGenerator.genBurningShip(_escapeDistance);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("BurningShip Fractal Has Been Made with an escape distance of " + _escapeDistance);
		}else if (_fractalType == 4){
			_fractalGenerator.genMultibrot(_escapeDistance);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("Mulibrot Fractal Has Been Made with an escape distance of " + _escapeDistance);
		}
		
		return completedFractal;
	}
	
	public void setFractalType(int i) {
		_fractalType = i;
	}
	public int getFractalType() {
		return _fractalType;
	}
	
	public void setEscapeDistance(int i) {
		_escapeDistance = i;
	}
	public int getEscapeDistance() {
		return _escapeDistance;
	}
	
	public void setColorModel(IndexColorModel i){
		_colorModel = i;
	}
	public IndexColorModel getColorModel() {
		return _colorModel;
	}

	
	
	
	
	//Observer Methods...

	@Override
	public void notifyObservers() {
		for (Observer o : _observers) {
			o.update();
		}
	}

	@Override
	public void addObserver(Observer o) {
		_observers.add(o);
		
	}
}
