package model;

public class Pixel {
	/**
	 * @author Brandon Maul
	 * 
	 *         Pixels are what we use in each cell of the 2D array to build the
	 *         fractal. The Pixel class holds all the needed data for fractal
	 *         calculations (Its X and Y Coordinate). When a Pixel object is
	 *         constructed, _xCoord and _yCoord are defined immediately. Each
	 *         Pixel holds it's own escape-time as well. This is given to it by
	 *         the escape-time calculators in FractalAlgorithms
	 * 
	 */

	private int _xIndex;
	private int _yIndex;
	private double[] _coords;
	private int _escapeTime;

	/**
	 * Constructor for the Pixel. Also calculates the pixels Coordinates as if
	 * the pixel was on a Cartesian Coordinate Plane, and stores them itself.
	 * Pixels aren't supposed to be constructed outside of a 2D array - Which is
	 * why an X and Y index are needed for construction.
	 * 
	 * @param x
	 *            - The X INDEX of the Pixel in a 2D array.
	 * @param y
	 *            - The Y INDEX of the Pixel in a 2D array.
	 */
	public Pixel(int xIndex, int yIndex){
		_xIndex = xIndex;
		_yIndex = yIndex;
		_coords = new double[2];
	}

	/**
	 * The following methods are just simple getter and mutator methods for the
	 * variables in this class.
	 * 
	 */


	// Get x cord
	public int getX() {
		return _xIndex;
	}

	// Get y cord
	public int getY() {
		return _yIndex;
	}
	
	public double[] getCoords(){
		return _coords;
	}
	
	public void setCoords(double x, double y){
		_coords[0] = x;
		_coords[1] = y;
	}

	public int getEscapeTime() {
		return _escapeTime;
	}

	public void setEscapeTime(int input) {
		_escapeTime = input;
	}

}
