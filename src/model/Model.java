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
	
	private int _escapeDistance; //1 = Mandelbrot; 2 = Julia; 3 = Burning Ship; 4 = Multibrot;
	private int _fractalType;
	private int _maxPasses;
	private int _regionStart[];
	private int _regionEnd[];
	private IndexColorModel _colorModel; 
	
	public Model(){

		_observers = new ArrayList<Observer>();
		_fractalGenerator = new FractalGenerator();
		_fractalType = 1;
		_escapeDistance = 2;
		_maxPasses = 255;
		_regionStart = new int[]{0, 0}; 
		_regionEnd = new int[]{511, 511};
		
	}
	
	/**
	 * Calls the generation method based on the information stored inside this model.
	 * 
	 * @return Numerical 2d array of integers that represent the escape time of each point on the fractal.
	 */
	
	public int[][] generateFractal(){
		int[][] completedFractal = null;
		
		if (_fractalType == 1){
			_fractalGenerator.genMandelbrot(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
		}else if (_fractalType == 2){
			_fractalGenerator.genJulia(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
		}else if (_fractalType == 3){
			_fractalGenerator.genBurningShip(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
			completedFractal = _fractalGenerator.getEscapeTimeArray();
		}else if (_fractalType == 4){
			_fractalGenerator.genMultibrot(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
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
	
	public void setMaxEscapeTime(int inputNum) {
		_maxPasses = inputNum;
		
	}

	public int getEscapeTime() {
		return _maxPasses;
	}
	
	public boolean setDisplayRegion(int xRegionStart, int yRegionStart, int xRegionEnd, int yRegionEnd){
		boolean retVal = false;
		if(xRegionStart >= 0 && xRegionStart < 512){
			if(yRegionStart >= 0 && yRegionStart < 512){
				if(xRegionEnd >= 0 && xRegionEnd < 512){
					if(yRegionEnd >= 0 && yRegionEnd < 512){
						_regionStart[0] = xRegionStart;
						_regionStart[1]= yRegionStart;
						_regionEnd[0] = xRegionEnd;
						_regionEnd[1] = yRegionEnd;
						
						retVal = true;
					}
				}
			}
		}
		return retVal;
		//im so sorry for this horrible method... Ill figure out a way to make it better... eventually...
	}
	
	public String getDisplayRegion() {
		return "(" + _regionStart[0] + ", " + _regionStart[1] + ") and (" + _regionEnd[0] + ", " + _regionEnd[1] + ")";
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
