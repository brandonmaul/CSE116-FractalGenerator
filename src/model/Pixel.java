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

	private double _xCoord;
	private double _yCoord;
	private int[] _index;
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
	 * @param minX
	 *            - Minimum X coordinate allowed for a Cartesian Plane
	 * @param maxX
	 *            - Maximum X coordinate allowed for a Cartesian Plane
	 * @param minY
	 *            - Minimum Y coordinate allowed for a Cartesian Plane
	 * @param maxY
	 *            - Maximum Y coordinate allowed for a Cartesian Plane
	 */
	public Pixel(double xCoord, double yCoord, int xIndex, int yIndex){
		_xCoord = xCoord;
		_yCoord = yCoord;
		_index = new int[]{xIndex, yIndex};
	}

	/**
	 * The following methods are just simple getter and mutator methods for the
	 * variables in this class.
	 * 
	 */

	// Set x cord
	public void setX(double x) {
		_xCoord = x;
	}

	// Get x cord
	public double getX() {
		return _xCoord;
	}

	// Set y cord
	public void setY(double y) {
		_yCoord = y;
	}

	// Get y cord
	public double getY() {
		return _yCoord;
	}

	public int getEscapeTime() {
		return _escapeTime;
	}
	
	public int[] getIndex(){
		return _index;
	}

	public void setEscapeTime(int input) {
		_escapeTime = input;
	}

}
