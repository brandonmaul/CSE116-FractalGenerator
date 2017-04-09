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
	
	public void initMandelbrot(Pixel[][] pixelArray, int[] regionStart, int[] regionEnd, int escapeDistance, int maxPasses) {
		double xC_0 = -2.15;
		double xC_511 = .6;
		double yC_0 = -1.3;
		double yC_511 = 1.3;
		
		double deltaX = ((xC_511 - xC_0)/pixelArray.length); 
		double deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcMandelbrotEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
			}
		}
		
		//Zoom method:
		
		xC_0 = pixelArray[regionStart[0]][regionStart[1]].getX();
		xC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getX();
		yC_0 = pixelArray[regionStart[0]][regionStart[1]].getY();
		yC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getY();
		
		deltaX = ((xC_511 - xC_0)/pixelArray.length);
		deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcMandelbrotEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
			}
		}
	}

	/**
	 * Initialize Julia Array of Pixels -
	 * 
	 * @param pixelArray
	 *            - expected to be empty Pixel array.
	 */
	public void initJulia(Pixel[][] pixelArray, int[] regionStart, int[] regionEnd, int escapeDistance, int maxPasses) {
		double xC_0 = -1.7;
		double xC_511 = 1.7;
		double yC_0 = -1.0;
		double yC_511 = 1.0;
		
		double deltaX = ((xC_511 - xC_0)/pixelArray.length); 
		double deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcJuliaEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
			}
		}
		
		//Zoom method:
		
		xC_0 = pixelArray[regionStart[0]][regionStart[1]].getX();
		xC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getX();
		yC_0 = pixelArray[regionStart[0]][regionStart[1]].getY();
		yC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getY();
		
		deltaX = ((xC_511 - xC_0)/pixelArray.length);
		deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcJuliaEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
			}
		}
	}

	/**
	 * Initialize Burning Ship Array of Pixels -
	 * 
	 * @param pixelArray
	 *            - expected to be empty Pixel array.
	 */
	public void initBurningShip(Pixel[][] pixelArray, int[] regionStart, int[] regionEnd, int escapeDistance, int maxPasses) {		
		double xC_0 = -1.8;
		double xC_511 = -1.7;
		double yC_0 = -0.08;
		double yC_511 = 0.025;
		
		double deltaX = ((xC_511 - xC_0)/pixelArray.length); 
		double deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcBurningShipEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
			}
		}
		
		//Zoom method:
		
		xC_0 = pixelArray[regionStart[0]][regionStart[1]].getX();
		xC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getX();
		yC_0 = pixelArray[regionStart[0]][regionStart[1]].getY();
		yC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getY();
		
		deltaX = ((xC_511 - xC_0)/pixelArray.length);
		deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcBurningShipEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
			}
		}
	}

	/**
	 * Initialize Multibrot Array of Pixels -
	 * 
	 * @param pixelArray
	 *            - expected to be empty Pixel array.
	 */
	public void initMultibrot(Pixel[][] pixelArray, int[] regionStart, int[] regionEnd, int escapeDistance, int maxPasses) {
		double xC_0 = -1.0;
		double xC_511 = 1.0;
		double yC_0 = -1.3;
		double yC_511 = 1.3;
		
		double deltaX = ((xC_511 - xC_0)/pixelArray.length); 
		double deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcMultibrotEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
			}
		}
		
		//Zoom method:
		
		xC_0 = pixelArray[regionStart[0]][regionStart[1]].getX();
		xC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getX();
		yC_0 = pixelArray[regionStart[0]][regionStart[1]].getY();
		yC_511 = pixelArray[regionEnd[0]][regionEnd[1]].getY();
		
		deltaX = ((xC_511 - xC_0)/pixelArray.length);
		deltaY = ((yC_511 - yC_0)/pixelArray.length);
		
		for (int xIndex = 0; xIndex < pixelArray.length; xIndex++) {// Row
			for (int yIndex = 0; yIndex < pixelArray[0].length; yIndex++) {// Col
				double xCoord = xC_0 + (xIndex * deltaX);
				double yCoord = yC_0 + (yIndex * deltaY);
				Pixel p = new Pixel(xCoord, yCoord, xIndex, yIndex);
				pixelArray[xIndex][yIndex] = p;
				p.setEscapeTime(calcMultibrotEscapeTime(escapeDistance, p.getX(), p.getY(), maxPasses));
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

	public int calcMandelbrotEscapeTime(int maxDist, double xCoord, double yCoord, int maxPasses) {
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
	public int calcJuliaEscapeTime(int maxDist, double xCoord, double yCoord, int maxPasses) {
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

	public int calcBurningShipEscapeTime(int maxDist, double xCoord, double yCoord, int maxPasses) {
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

	public int calcMultibrotEscapeTime(int maxDist, double xCoord, double yCoord, int maxPasses) {
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
	public double distanceCalculator(double xCoord, double yCoord) {
		double dist = Math.sqrt(((xCoord) * (xCoord)) + ((yCoord) * (yCoord)));
		return dist;
	}
}
