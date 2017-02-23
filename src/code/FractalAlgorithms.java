package code;

public interface FractalAlgorithms {
	/**
	 * @author Brandon Maul
	 * 
	 *         This interface holds all the methods needed to properly set up
	 *         and generate the escape times of each point on a fractal. The
	 *         Fractal Initiators add pixels to the 2D array and make sure each
	 *         of those pixels are given the proper parameters to fit the
	 *         fractal being made.
	 * 
	 *         The Escape Time Calculators take the pixels x and y coordinates
	 *         and calculate it's escape time.
	 * 
	 *         These methods should be called by Fractal Generator, but can be
	 *         used in JUnit tests as well.
	 * 
	 */

	/**
	 * 
	 * Fractal Initiators - adds pixels to an array.
	 * 
	 * After a pixel has been added the pixel calculates its own X and Y
	 * coordinates (Specified in the Pixel Class).
	 * 
	 * Immediately following, the Escape Time Calculator for the respective
	 * fractal is called for that pixel. That escape time is then stored inside
	 * that Pixel object.
	 * 
	 */

	/**
	 * Initialize Mandelbrot Array of Pixels -
	 * 
	 * @param pixelArray
	 *            - expected to be empty Pixel array.
	 *
	 */

	public default void initMandelbrot(Pixel[][] pixelArray) {
		for (int x = 0; x < pixelArray.length; x++) {// Row
			for (int y = 0; y < pixelArray[0].length; y++) {// Col
				pixelArray[x][y] = new Pixel(x, y, -2.15, 0.6, -1.3, 1.3);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcMandelbrotEscapeTime(p.getX(), p.getY()));
			}
		}
	}

	/**
	 * Initialize Julia Array of Pixels -
	 * 
	 * @param pixelArray
	 *            - expected to be empty Pixel array.
	 */
	public default void initJulia(Pixel[][] pixelArray) {
		for (int x = 0; x < pixelArray.length; x++) {
			for (int y = 0; y < pixelArray[0].length; y++) {
				pixelArray[x][y] = new Pixel(x, y, -1.7, 1.7, -1.0, 1.0);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcJuliaEscapeTime(p.getX(), p.getY()));
			}
		}
	}

	/**
	 * Initialize Burning Ship Array of Pixels -
	 * 
	 * @param pixelArray
	 *            - expected to be empty Pixel array.
	 */
	public default void initBurningShip(Pixel[][] pixelArray) {
		for (int x = 0; x < pixelArray.length; x++) {
			for (int y = 0; y < pixelArray[0].length; y++) {
				pixelArray[x][y] = new Pixel(x, y, -1.8, -1.7, -0.08, 0.025);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcBurningShipEscapeTime(p.getX(), p.getY()));
			}
		}
	}

	/**
	 * Initialize Multibrot Array of Pixels -
	 * 
	 * @param pixelArray
	 *            - expected to be empty Pixel array.
	 */
	public default void initMultibrot(Pixel[][] pixelArray) {
		for (int x = 0; x < pixelArray.length; x++) {
			for (int y = 0; y < pixelArray[0].length; y++) {
				pixelArray[x][y] = new Pixel(x, y, -1.0, 1.0, -1.3, 1.3);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcMultibrotEscapeTime(p.getX(), p.getY()));
			}
		}
	}

	/**
	 * Escape Time Calculators - There are two methods for each fractal. These
	 * methods have the same name, but different parameters. This is done so
	 * that if the Escape Distance is not specified (as it might be in later
	 * phases of the project) the escape distance is assumed to be 2.
	 *
	 */

	/**
	 * Calculate Escape Time for Mandelbrot -
	 * 
	 * @param xCoord
	 *            - X coordinate of Pixel
	 * @param yCoord
	 *            - Y coordinate of Pixel
	 * @return Escape Time of the input coordinate.
	 */
	public default int calcMandelbrotEscapeTime(double xCoord, double yCoord) {
		return calcMandelbrotEscapeTime(2, xCoord, yCoord);
	}

	public default int calcMandelbrotEscapeTime(int maxDist, double xCoord, double yCoord) {
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);

		int passes = 0;
		while (dist <= maxDist & passes < 255) {
			double xtemp = ((xCalc * xCalc) - (yCalc * yCalc)) + xCoord;
			yCalc = 2.0 * xCalc * yCalc + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}

	/**
	 * Calculate Escape Time for Julia -
	 * 
	 * @param xCoord
	 *            - X coordinate of Pixel
	 * @param yCoord
	 *            - Y coordinate of Pixel
	 * @return Escape Time of the input coordinate.
	 */
	public default int calcJuliaEscapeTime(double xCoord, double yCoord) {
		return calcJuliaEscapeTime(2, xCoord, yCoord);
	}

	public default int calcJuliaEscapeTime(int maxDist, double xCoord, double yCoord) {
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);

		int passes = 0;
		while (dist <= maxDist & passes < 255) {
			double xtemp = ((xCalc * xCalc) - (yCalc * yCalc)) + (-0.72689);
			yCalc = 2.0 * xCalc * yCalc + 0.188887;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}

	/**
	 * Calculate Escape Time for Burning Ship -
	 * 
	 * @param xCoord
	 *            - X coordinate of Pixel
	 * @param yCoord
	 *            - Y coordinate of Pixel
	 * @return Escape Time of the input coordinate.
	 */
	public default int calcBurningShipEscapeTime(double xCoord, double yCoord) {
		return calcBurningShipEscapeTime(2, xCoord, yCoord);
	}

	public default int calcBurningShipEscapeTime(int maxDist, double xCoord, double yCoord) {
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);

		int passes = 0;
		while (dist <= maxDist & passes < 255) {
			double xtemp = ((xCalc * xCalc) - (yCalc * yCalc)) + xCoord;
			yCalc = Math.abs(2.0 * xCalc * yCalc) + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}

	/**
	 * Calculate Escape Time for Multibrot -
	 * 
	 * @param xCoord
	 *            - X coordinate of Pixel
	 * @param yCoord
	 *            - Y coordinate of Pixel
	 * @return Escape Time of the input coordinate.
	 */
	public default int calcMultibrotEscapeTime(double xCoord, double yCoord) {
		return calcMultibrotEscapeTime(2, xCoord, yCoord);
	}

	public default int calcMultibrotEscapeTime(int maxDist, double xCoord, double yCoord) {
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);

		int passes = 0;
		while (dist <= maxDist & passes < 255) {
			double xtemp = (xCalc * xCalc * xCalc) - (3 * xCalc * (yCalc * yCalc)) + xCoord;
			yCalc = (3 * (xCalc * xCalc) * yCalc) - (yCalc * yCalc * yCalc) + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}

	/**
	 * Distance Calculator - Calculates the distance of the input to the point
	 * 0,0 on a Cartesian Coordinate Plane. Used by all of the above methods as
	 * part of the Escape Time calculations. Calculation is done via the
	 * Pythagorean Theorem.
	 * 
	 * @param xCoord
	 *            - X coordinate of a point
	 * @param yInput
	 *            - Y coordinate of a point
	 * @return The distance from 0,0 to the point input.
	 */
	public default double distanceCalculator(double xCoord, double yCoord) {
		double dist = Math.sqrt(((xCoord) * (xCoord)) + ((yCoord) * (yCoord)));
		return dist;
	}
}
