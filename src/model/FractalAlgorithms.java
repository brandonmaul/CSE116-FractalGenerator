package model;

public abstract class FractalAlgorithms {
	/**
	 * @author Brandon Maul
	 * 
	 *         This abstract class holds all the methods needed to properly set up
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
	 * Calculate Escape Time for Mandelbrot -
	 * 
	 * @param p
	 *            - Pixel who's index and coordinates have already been set.
	 * @param maxDist
	 *            - The maximum escape distance allowed for the Pixel while calculating its escape time.
	 * @param maxPasses
	 * 			  - The maximum escape time allowed for each pixel on the fractal.
	 */
	public void calcMandelbrotEscapeTime(Pixel p, int maxDist, int maxPasses) {
		
		double[] coords = p.getCoords();
		double xCoord = coords[0];
		double yCoord = coords[1];
		
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);

		int passes = 0;
		while (dist <= maxDist & passes < maxPasses) {
			double xtemp = ((xCalc * xCalc) - (yCalc * yCalc)) + xCoord;
			yCalc = 2.0 * xCalc * yCalc + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		p.setEscapeTime(escapeTime);
		p.setCoords(xCoord, yCoord);
	}

	/**
	 * Calculate Escape Time for Julia -
	 * 
	 * @param p
	 *            - Pixel who's index and coordinates have already been set.
	 * @param maxDist
	 *            - The maximum escape distance allowed for the Pixel while calculating its escape time.
	 * @param maxPasses
	 * 			  - The maximum escape time allowed for each pixel on the fractal.
	 */
	public void calcJuliaEscapeTime(Pixel p, int maxDist, int maxPasses) {
		
		double[] coords = p.getCoords();
		double xCoord = coords[0];
		double yCoord = coords[1];
		
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);

		int passes = 0;
		while (dist <= maxDist & passes < maxPasses) {
			double xtemp = ((xCalc * xCalc) - (yCalc * yCalc)) + (-0.72689);
			yCalc = 2.0 * xCalc * yCalc + 0.188887;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		p.setEscapeTime(escapeTime);
		p.setCoords(xCoord, yCoord);
	}

	/**
	 * Calculate Escape Time for Burning Ship -
	 * 
	 * @param p
	 *            - Pixel who's index and coordinates have already been set.
	 * @param maxDist
	 *            - The maximum escape distance allowed for the Pixel while calculating its escape time.
	 * @param maxPasses
	 * 			  - The maximum escape time allowed for each pixel on the fractal.
	 */
	public void calcBurningShipEscapeTime(Pixel p, int maxDist, int maxPasses) {
		
		double[] coords = p.getCoords();
		double xCoord = coords[0];
		double yCoord = coords[1];
		
		double xCalc = xCoord;
		double yCalc = yCoord;
		
		double dist = distanceCalculator(xCalc, yCalc);
	
		int passes = 0;
		while (dist <= maxDist & passes < maxPasses) {
			double xtemp = ((xCalc * xCalc) - (yCalc * yCalc)) + xCoord;
			yCalc = Math.abs(2.0 * xCalc * yCalc) + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		p.setEscapeTime(escapeTime);
		p.setCoords(xCoord, yCoord);
	}

	/**
	 * Calculate Escape Time for Multibrot -
	 * 
	 * @param p
	 *            - Pixel who's index and coordinates have already been set.
	 * @param maxDist
	 *            - The maximum escape distance allowed for the Pixel while calculating its escape time.
	 * @param maxPasses
	 * 			  - The maximum escape time allowed for each pixel on the fractal.
	 */
	public void calcMultibrotEscapeTime(Pixel p, int maxDist, int maxPasses) {
		
		double[] coords = p.getCoords();
		double xCoord = coords[0];
		double yCoord = coords[1];
		
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);

		int passes = 0;
		while (dist <= maxDist & passes < maxPasses) {
			double xtemp = (xCalc * xCalc * xCalc) - (3 * xCalc * (yCalc * yCalc)) + xCoord;
			yCalc = (3 * (xCalc * xCalc) * yCalc) - (yCalc * yCalc * yCalc) + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		p.setEscapeTime(escapeTime);
		p.setCoords(xCoord, yCoord);
	}
	
	/**
	 * Calculates the pixel's coordinates in the region bounded by the constants.
	 * Honestly, I'm ashamed to say I didn't think of this method weeks ago...
	 * Would have made life a lot easier. 
	 * 
	 * @param p
	 *            - Pixel who's xIndex and yIndex have already been set.
	 * @param constants
	 *            - The coordinate bounds of the region the pixel will have to reside in. 
	 * @param arrayLength
	 * 			  - The length of the whole array, so that the pixels index can have some context.
	 */
	public void calcPixelCoordinates(Pixel p, double[] constants, int arrayLength){
		double xC_0 = constants[0];
		double xC_511 = constants[1];
		double yC_0 = constants[2];
		double yC_511 = constants[3];
		
		double deltaX = ((xC_511 - xC_0) / arrayLength); 
		double deltaY = ((yC_511 - yC_0) / arrayLength);
		
		double xCoord = xC_0 + (p.getX() * deltaX);
		double yCoord = yC_0 + (p.getY() * deltaY);
		
		p.setCoords(xCoord, yCoord);
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
	public double distanceCalculator(double xCoord, double yCoord) {
		double dist = Math.sqrt(((xCoord) * (xCoord)) + ((yCoord) * (yCoord)));
		return dist;
	}
}
