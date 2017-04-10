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

	private Pixel[][] _fractal;
	private FractalGenerator _fractalGenerator;
	private FractalZoomTool _fractalZoomTool;
	private int _escapeDistance; //1 = Mandelbrot; 2 = Julia; 3 = Burning Ship; 4 = Multibrot;
	private int _fractalType;
	private int _maxPasses;
	private int _regionStart[];
	private int _regionEnd[];
	private IndexColorModel _colorModel; 
	
	public Model(){

		_observers = new ArrayList<Observer>();
		
		_fractal = new Pixel[512][512];
		for (int xIndex = 0; xIndex < _fractal.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < _fractal[0].length; yIndex++) {// Col
				_fractal[xIndex][yIndex] =  new Pixel(xIndex, yIndex);
			}
		}
		_fractalGenerator = new FractalGenerator(_fractal);
		_fractalZoomTool = new FractalZoomTool(_fractal);
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
	
	public Pixel[][] generateFractal(){
		
		if (_fractalType == 1){
			_fractal = _fractalGenerator.genMandelbrot(_escapeDistance, _maxPasses);
		}else if (_fractalType == 2){
			_fractal = _fractalGenerator.genJulia(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
		}else if (_fractalType == 3){
			_fractal = _fractalGenerator.genBurningShip(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
		}else if (_fractalType == 4){
			_fractal = _fractalGenerator.genMultibrot(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
		}
		return _fractal;
	}
	
	public Pixel[][] zoomFractal(){
		
		if (_fractalType == 1){
			_fractalZoomTool.zoomMandelbrot(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
		}else if (_fractalType == 2){
			_fractalZoomTool.zoomJulia(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
		}else if (_fractalType == 3){
			_fractalZoomTool.zoomBurningShip(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
		}else if (_fractalType == 4){
			_fractalZoomTool.zoomMultibrot(_regionStart, _regionEnd, _escapeDistance, _maxPasses);
		}
		
		setDisplayRegion(0, 0, 511, 511);
		return _fractal;
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
	
	/**
	 * 2D Escape Time Array - After a generator has been called, call this
	 * method to return an Array of Integers, the same size as _fractal. If a
	 * generator has not been called before you call this method, you're gonna
	 * have a bad time.
	 * 
	 * @return 2D array of Integers that correspond to each Pixel (of the same
	 *         index) in _fractal.
	 */
	public int[][] getEscapeTimeArray() {

		int[][] escapeTimes = new int[_fractal.length][_fractal.length];
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				escapeTimes[p.getX()][p.getY()] = p.getEscapeTime();
			}
		}
		
		return escapeTimes;
	}
	
	//Observer Methods...

	@Override
	public void notifyObservers() {
		for (Observer o : _observers) {
			o.updateFractal();
		}
	}

	@Override
	public void addObserver(Observer o) {
		_observers.add(o);
		
	}

	
}
