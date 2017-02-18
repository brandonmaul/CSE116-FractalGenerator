package code;

public class Pixel {
	/**
	 * @author Brandon Maul
	 * 
	 * Pixels are what we use in each cell of the 2D array to build the fractal.
	 * The Pixel class holds all the needed data for fractal calculations. 
	 * When a Pixel object is constructed, xCalc and yCalc are defined immediately.
	 * Each Pixel holds it's own escape-time as well. This is given to it by the escape-time calculators in FractalAlgorithms
	 * 
	 */
	
	private double _xCoord;
	private double _yCoord;
	private int _escapeTime;

	// The escape time is then equal to the # of passes
	
	public Pixel(int x, int y,  double minX, double maxX, double minY, double maxY){
		_xCoord = minX + (x * (maxX - minX)/511);
		_yCoord = minY + (y * (maxY - minY)/511);
	}
	
	//Set x cord
	public void setX(double x){ _xCoord = x; }
	//Get x cord
	public double getX(){ return _xCoord; }
	//Set y cord
	public void setY(double y){ _yCoord = y; }
	//Get y cord
	public double getY(){ return _yCoord; }
	
	public int getEscapeTime(){ return _escapeTime; }
	public void setEscapeTime(int input){ _escapeTime = input;}
	
	
}
