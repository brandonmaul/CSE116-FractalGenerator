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
	
	private int _gridSize;
	private int _workerCount;
	private ArrayList<Observer> _observers;
	private Pixel[][] _fractal;
	private FractalGenerator _fractalGenerator;
	private String _fractalType;
	private boolean _fractalChanged;
	private int _escapeDistance;
	private int _maxPasses;
	private int _regionStart[];
	private int _regionEnd[];
	private IndexColorModel _colorModel; 
	
	private MultiThreadingTool[] _workerArray;
	
	public Model(){
		_observers = new ArrayList<Observer>();
		
		_gridSize = 2048;
		_workerCount = 1;
		
		_fractal = new Pixel[_gridSize][_gridSize];
		_fractalGenerator = new FractalGenerator(_fractal);
		
		for (int xIndex = 0; xIndex < _fractal.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < _fractal[0].length; yIndex++) {// Col
				_fractal[xIndex][yIndex] =  new Pixel(xIndex, yIndex);
			}
		}
		
		_fractalType = "Mandelbrot";
		setFractalChanged(true);
		_escapeDistance = 2;
		_maxPasses = 255;
		_regionStart = new int[]{0, 0}; 
		_regionEnd = new int[]{_gridSize - 1, _gridSize - 1};
	}
	
	/**
	 * Calls the generation method based on the information stored inside this model.
	 * 
	 * @return Numerical 2d array of integers that represent the escape time of each point on the fractal.
	 */
	
	public int[][] generateFractal(){
		if(isFractalChanged()){
			_fractal = _fractalGenerator.generateFractal(_fractalType, _escapeDistance, _maxPasses);
			setDisplayRegion(0, 0, _gridSize - 1, _gridSize - 1);
			setFractalChanged(false);
			return getEscapeTimeArray();
		}else{
			_fractalGenerator.zoomFractal(_fractalType, _escapeDistance, _maxPasses, _regionStart, _regionEnd);
			setDisplayRegion(0, 0, _gridSize - 1, _gridSize - 1);
			return getEscapeTimeArray();
		}
		
	}
	
	/**
	 * Getter and Setter methods for each of the private instance variables.
	 */
	
	public void setFractalType(String s) {
		_fractalType = s;
		setFractalChanged(true);
	}
	public String getFractalType() {
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
	
	public Pixel[][] getRawFractal(){
		return _fractal;
	}
	
	public void setDisplayRegion(int xRegionStart, int yRegionStart, int xRegionEnd, int yRegionEnd){
		_regionStart[0] = xRegionStart;
		_regionStart[1]= yRegionStart;
		_regionEnd[0] = xRegionEnd;
		_regionEnd[1] = yRegionEnd;
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
	
	public void setGridSize(int i){
		_gridSize = i;
	}
	
	public int getGridSize(){
		return _gridSize;
	}
	
	public void setWorkerCount(int input){
		_workerCount = input;
		generateWorkerArray();
	}
	
	public int getWorkerCount(){
		return _workerCount;
	}
	
	public boolean isFractalChanged() {
		return _fractalChanged;
	}

	public void setFractalChanged(boolean fractalChanged) {
		_fractalChanged = fractalChanged;
	}
	
	public MultiThreadingTool[] getWorkers(){
		return _workerArray;
	}
	
	public MultiThreadingTool[] generateWorkerArray(){
		_workerArray = new MultiThreadingTool[_workerCount];
		
		for(int i=0; i < _workerCount; i++){
			_workerArray[i] = new MultiThreadingTool(this);
		}
		
		return _workerArray;
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
