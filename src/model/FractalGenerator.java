package model;

public class FractalGenerator extends FractalAlgorithms {

	private Pixel[][] _fractal;

	public FractalGenerator() {
	}

	/**
	 * @author Brandon Maul
	 * 
	 *         Each of the following functions creates a fractal on a 2D grid.
	 *         The fractals design is specified by the FractalAlgorithims
	 *         abstract class which supplies the methods for making the fractal
	 *         to each pixel on the 2D array. FractalAlgorithms also has the
	 *         Escape-Time generation methods which calculates each pixel's
	 *         escape time.
	 * 
	 *         Once the fractal has been initiated properly, and the escape time
	 *         of each pixel has been calculated by using the update function,
	 *         the final fractal is ready to be returned. The final fractal is a
	 *         2D array of integers that represents each pixel's (of the same
	 *         index) escape-time. This is done by calling @code
	 *         getEscapeTimeArray
	 * 
	 *         Order of each fractal method in this Class:
	 * 
	 *         (Step 1) --> Creates new 2D Pixel Array.
	 * 
	 *         (Step 2.1) --> Calls init_____ function with the input of the 2D
	 *         Pixel Array. This fills each index in the 2D array with Pixels
	 *         with the proper parameters. (Uses FractalAlgorithms abstract
	 *         class)
	 * 
	 *         (Step 2.2) --> After a pixel is created it's individual
	 *         escape-time is calculated and stored created it's individual
	 *         escape-time is calculated and stored inside the pixel. (Uses
	 *         FractalAlgorithms abstract class)
	 * 
	 *         (Step 3) --> After this has happened for every index in the
	 *         Array, The fractal is returned. This fractal is a 2D array of
	 *         Pixels each with their own properly calculated escape-time.
	 * 
	 *         The method at the bottom, getEscapeTimeArray, simply returns the
	 *         2D array of INTEGERS that is the same size as the fractal. This
	 *         2D array of Integers contains the escape time for each pixel of
	 *         the same index in the fractal
	 * 
	 *         Ex: _fractal[0][0].getEscapeTime == 4; So...
	 *         escapeTimeArray[0][0] == 4; (THIS IS WHAT WE NEED TO RETURN FOR
	 *         PHASE I)
	 * 
	 *         Each pixel in the 2D Pixel array should have a escape time by the
	 *         point this method is called. If the getEscapeTimeArray is called
	 *         before a fractal generation method, you're gonna have a bad time.
	 * 
	 */

	/**
	 * Mandelbrot Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genMandelbrot() {
		_fractal = new Pixel[512][512];
		initMandelbrot(_fractal);
		return _fractal;

	}

	/**
	 * Julia Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genJulia() {
		_fractal = new Pixel[512][512];
		initJulia(_fractal);
		return _fractal;

	}

	/**
	 * Burning Ship Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genBurningShip() {
		_fractal = new Pixel[512][512];
		initBurningShip(_fractal);
		return _fractal;
	}

	/**
	 * Multibrot Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genMultibrot() {
		_fractal = new Pixel[512][512];
		initMultibrot(_fractal);
		return _fractal;

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

		int[][] fractal = new int[_fractal.length][_fractal[0].length];

		for (int x = 0; x < _fractal.length; x++) {
			for (int y = 0; y < _fractal[0].length; y++) {
				fractal[x][y] = _fractal[x][y].getEscapeTime();
			}
		}
		return fractal;
	}

	/**
	 * Does the fractal contain any 0's or 1's?
	 * 
	 * Searches through each pixel in _fractal and checks to see if their escape
	 * time is 0 or a 1. Used for the Burning Ship test.
	 * 
	 * @return false if a 0 or 1 was found, true if none were found.
	 */
	public boolean boolContainsNoZerosOrOnes() {
		for (int x = 0; x < _fractal.length; x++) {
			for (int y = 0; y < _fractal[0].length; y++) {
				if (_fractal[x][y].getEscapeTime() == 0 | _fractal[x][y].getEscapeTime() == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
