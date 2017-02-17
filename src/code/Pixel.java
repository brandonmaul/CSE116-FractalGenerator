package code;

public class Pixel {
	/**
	 * @author Brandon Maul
	 * 
	 * Pixels are what we use in each cell of the 2D array to build the fractal.
	 * The Pixel class holds all the needed data for fractal calculations. 
	 * When a Pixel object is instantiated, xCalc and yCalc are defined immediately.
	 * Then the Pixel calculates it's distance from (0,0) and store it internally.
	 * Pixels can calculate their distance from the point (0,0) on the graph by using the setDistance method. 
	 * Each Pixel also holds it's own escape-time and number of passes when being updated by a update method in FractalAlgorithms.
	 * Updates - found in Fractal Generator 
	 * Seperate update for each fractal 
	 */
	
	private double _xCalc;
	private double _yCalc;
	private double _dist;
	private int _escapeTime;
	private int _passes; // How many times it is updates

	// The escaoe time is then equal to the # of passes
	
	public Pixel(int x, int y,  double minX, double maxX, double minY, double maxY){
		_xCalc = minX + (x * (maxX - minX)/511);
		_yCalc = minY + (y * (maxY - minY)/511);
		this.setDistance();
		this.setPasses(0);
	}
	
	public void setDistance(){
		//From origin
		_dist = Math.sqrt(((0 - _xCalc)*(0 - _xCalc))+ ((0 - _yCalc)*(0 - _yCalc)));
		
			
		//Sets distance from the point (0,0) using Pythagorean Theorem
	}
	public double getDistance(){ return _dist; }
	
	//Set x cord
	public void setX(double x){ _xCalc = x; }
	//Get x cord
	public double getX(){ return _xCalc; }
	//Set y cord
	public void setY(double y){ _yCalc = y; }
	//Get y cord
	public double getY(){ return _yCalc; }
	//
	public void setPasses(int pass){ _passes = pass; }
	public int getPasses(){ return _passes; }
	
	public void setEscapeTime(){ _escapeTime = _passes; }
	public int getEscapeTime(){ return _escapeTime; }
	
	
}
