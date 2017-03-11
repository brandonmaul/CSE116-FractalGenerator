package model;

import java.awt.image.IndexColorModel;
import java.util.ArrayList;
import observer_pattern.*;

public class Model implements Observable {
	
	private ArrayList<Observer> _observers;
	
	private FractalGenerator _fractalGenerator;
	
	private int _escapeDistance;
	private int _fractalType;
	private int _maxPasses;
	private IndexColorModel _colorModel; 
	
	public Model(){

		_observers = new ArrayList<Observer>();
		_fractalGenerator = new FractalGenerator();
		_fractalType = 1;
		_escapeDistance = 2;
		_maxPasses = 255;
		
	}
	
	public int[][] generateFractal(){
		int[][] completedFractal = null;
		
		if (_fractalType == 1){
			_fractalGenerator.genMandelbrot(_escapeDistance, _maxPasses);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
		}else if (_fractalType == 2){
			_fractalGenerator.genJulia(_escapeDistance, _maxPasses);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
		}else if (_fractalType == 3){
			_fractalGenerator.genBurningShip(_escapeDistance, _maxPasses);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
		}else if (_fractalType == 4){
			_fractalGenerator.genMultibrot(_escapeDistance, _maxPasses);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
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
	
	public void setMaxPasses(int i){
		_maxPasses = i;
	}
	public int getMaxPasses(){
		return _maxPasses;
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
