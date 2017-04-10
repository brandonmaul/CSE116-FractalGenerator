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
	 * @param xIndex
	 *            - X index of Pixel
	 * @param yIndex
	 *            - Y index of Pixel
	 * @return Escape Time of the input coordinate.
	 */
	
	public void calcMandelbrotEscapeTime(Pixel p, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double[] constants = new double[]{-2.15, .6, -1.3, 1.3};
		calcMandelbrotEscapeTime(p, constants, xIndex, yIndex, maxDist, maxPasses, arrayLength);
	}
	
	public void calcMandelbrotEscapeTime(Pixel p, double[] constants, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double xC_0 = constants[0];
		double xC_511 = constants[1];
		double yC_0 = constants[2];
		double yC_511 = constants[3];
		
		double deltaX = ((xC_511 - xC_0) / arrayLength); 
		double deltaY = ((yC_511 - yC_0) / arrayLength);
		
		double xCoord = xC_0 + (xIndex * deltaX);
		double yCoord = yC_0 + (yIndex * deltaY);
		
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
	 * @param xCoord
	 *            - X index of Pixel
	 * @param yCoord
	 *            - Y index of Pixel
	 * @return Escape Time of the input coordinate.
	 */
	public void calcJuliaEscapeTime(Pixel p, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double[] constants = new double[]{-1.7, 1.7, -1.0, 1.0};
		calcJuliaEscapeTime(p, constants, xIndex, yIndex, maxDist, maxPasses, arrayLength);
	}
	
	public void calcJuliaEscapeTime(Pixel p, double[] constants, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double xC_0 = constants[0];
		double xC_511 = constants[1];
		double yC_0 = constants[2];
		double yC_511 = constants[3];
		
		double deltaX = ((xC_511 - xC_0) / arrayLength); 
		double deltaY = ((yC_511 - yC_0) / arrayLength);
		
		double xCoord = xC_0 + (xIndex * deltaX);
		double yCoord = yC_0 + (yIndex * deltaY);
		
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
	 * @param xCoord
	 *            - X index of Pixel
	 * @param yCoord
	 *            - Y index of Pixel
	 * @return Escape Time of the input coordinate.
	 */

	public void calcBurningShipEscapeTime(Pixel p, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double[] constants = new double[]{-1.8, -1.7, -.08, .025};
		calcBurningShipEscapeTime(p, constants, xIndex, yIndex, maxDist, maxPasses, arrayLength);
	}
	
	public void calcBurningShipEscapeTime(Pixel p, double[] constants, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double xC_0 = constants[0];
		double xC_511 = constants[1];
		double yC_0 = constants[2];
		double yC_511 = constants[3];
		
		double deltaX = ((xC_511 - xC_0) / arrayLength); 
		double deltaY = ((yC_511 - yC_0) / arrayLength);
		
		double xCoord = xC_0 + (xIndex * deltaX);
		double yCoord = yC_0 + (yIndex * deltaY);
		
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
	 * @param xCoord
	 *            - X index of Pixel
	 * @param yCoord
	 *            - Y index of Pixel
	 * @return Escape Time of the input coordinate.
	 */

	public void calcMultibrotEscapeTime(Pixel p, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double[] constants = new double[]{-1, 1, -1.3, 1.3};
		calcMultibrotEscapeTime(p, constants, xIndex, yIndex, maxDist, maxPasses, arrayLength);
	}
	
	public void calcMultibrotEscapeTime(Pixel p, double[] constants, int xIndex, int yIndex, int maxDist, int maxPasses, int arrayLength) {
		double xC_0 = constants[0];
		double xC_511 = constants[1];
		double yC_0 = constants[2];
		double yC_511 = constants[3];
		
		double deltaX = ((xC_511 - xC_0) / arrayLength); 
		double deltaY = ((yC_511 - yC_0) / arrayLength);
		
		double xCoord = xC_0 + (xIndex * deltaX);
		double yCoord = yC_0 + (yIndex * deltaY);
		
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
