package model;

import java.awt.image.IndexColorModel;
import java.util.ArrayList;
import observer_pattern.*;

/**
 * 
 * @author Brandon Maul
 * 
 * Class that holds the abstract model of the fractal as well as calls the actual Fractal Generator class that 
 * calculates the fractal.
 *
 */

public class Model implements Observable {
	
	private ArrayList<Observer> _observers;
	
	private FractalGenerator _fractalGenerator;
	
	private int _escapeDistance;
	//_fractalType is a numerical representation of the 4 different fractals. 1 = Mandelbrot ; 2 = Julia ; 3 = Burning Ship ; 4 = Multibrot
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
	
	/**
	 * Calls the generation method based on the information stored inside this model.
	 * 
	 * @return Numerical 2d array of integers that represent the escape time of each point on the fractal.
	 */
	
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
	
	/**
	 * Getter and Setter methods for each of the private instance variables.
	 */
	
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
