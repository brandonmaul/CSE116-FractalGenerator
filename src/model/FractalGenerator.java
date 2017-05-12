package model;

public class FractalGenerator {

	private Pixel[][] _fractal;

	private FractalZoomTool _fractalZoomTool;

	public FractalGenerator(Pixel[][] fractal) {
		_fractal = fractal;
		_fractalZoomTool = new FractalZoomTool();
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
	public Pixel[][] generateFractal(String fractalType, int escapeDistance, int maxPasses){ 
		switch (fractalType){
			case "Mandelbrot":
					_fractal = genMandelbrot(escapeDistance, maxPasses);
					break;
					
			case "Julia": 
					_fractal = genJulia(escapeDistance, maxPasses);
					break;
					
			case "Burning Ship": 
					_fractal = genBurningShip(escapeDistance, maxPasses);
					break;
					
			case "Multibrot": 
					_fractal = genMultibrot(escapeDistance, maxPasses);
					break;
		}
		return _fractal;
	}
	
	public Pixel[][] zoomFractal(int escapeDistance, int maxPasses, int[] regionStart, int[] regionEnd){ 
		_fractal = _fractalZoomTool.zoomFractal(_fractal, escapeDistance, maxPasses, regionStart, regionEnd);
		return _fractal;
	}

	/**
	 * Mandelbrot Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genMandelbrot(int maxDist, int maxPasses) {
		double[] constants = new double[]{-2.15, -1.3, .6, 1.3};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				model.FractalAlgorithms.calcPixelCoordinates(p, constants, _fractal.length);
				model.FractalAlgorithms.calcMandelbrotEscapeTime(p, maxDist, maxPasses);
			}
		
		}
		
		return _fractal;
	}

	/**
	 * Julia Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genJulia(int maxDist, int maxPasses) {
		double[] constants = new double[]{-1.7, -1.0, 1.7, 1.0};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				model.FractalAlgorithms.calcPixelCoordinates(p, constants, _fractal.length);
				model.FractalAlgorithms.calcJuliaEscapeTime(p, maxDist, maxPasses);
			}
		
		}
		return _fractal;
	}

	/**
	 * Burning Ship Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genBurningShip(int maxDist, int maxPasses) {
		double[] constants = new double[]{-1.8, -.08, -1.7, .025};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				model.FractalAlgorithms.calcPixelCoordinates(p, constants, _fractal.length);
				model.FractalAlgorithms.calcBurningShipEscapeTime(p, maxDist, maxPasses);
			}
		
		}
		return _fractal;
	}

	/**
	 * Multibrot Fractal Generator -
	 * 
	 * @return _fractal, a 2D array of Pixels. Each with their own
	 *         locally-stored escape time and X/Y Coordinates
	 */
	public Pixel[][] genMultibrot(int maxDist, int maxPasses) {
		double[] constants = new double[]{-1, -1.3, 1, 1.3};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				model.FractalAlgorithms.calcPixelCoordinates(p, constants, _fractal.length);
				model.FractalAlgorithms.calcMultibrotEscapeTime(p, maxDist, maxPasses);
			}
		
		}
		return _fractal;
	}
}
