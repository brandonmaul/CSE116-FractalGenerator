package code;

public class FractalGenerator implements FractalAlgorithms{
	
	Pixel[][] _fractal;
	
	public FractalGenerator(){
	}
	
	/**
	 * @author Brandon Maul
	 * 
	 * Each of the following functions creates a fractal on a 2D grid.
	 * The fractals design is specified by the FractalAlgorithims interface which supplies the methods for making
	 * the fractal to each pixel on the 2D array. FractalAlgorithms also has the update methods which calculate each 
	 * pixel's escape time.
	 * 
	 * Once the fractal has been initiated properly, and the escape time of each pixel has been calculated by using the update function,
	 * the final fractal is ready to be returned. The final fractal is a 2D array of integers that represents each pixel's (of the same index)
	 * escape-time.
	 * 
	 * Order of Operation of each method in this Class:
	 * Initiation of the 2D Pixel Array --> Update pixels to calculate their individual escape time --> return 2D Integer Array of each Pixel's escape-time
	 */
	
	//---------------------------------------------------------------//
	//MANDLEBROT FRACTAL:
	//---------------------------------------------------------------//
	
	public int[][] genMandelbrot(){
		
		_fractal = new Pixel[512][512];
		
		initMandelbrot(_fractal);
		
		updateMandelbrot(_fractal);
		
		return getFractal(_fractal);
	}
	
	//---------------------------------------------------------------//
	//JULIA FRACTAL:
	//---------------------------------------------------------------//
	
	public int[][] genJulia(){
		
		_fractal = new Pixel[512][512];
		
		initJulia(_fractal);
		
		updateJulia(_fractal);
		
		return getFractal(_fractal);
	}
	
	//---------------------------------------------------------------//
	//BURNING SHIP FRACTAL:
	//---------------------------------------------------------------//
	
	public int[][] genBurningShip(){
		
		_fractal = new Pixel[512][512];
		
		initBurningShip(_fractal);
		
		updateBurningShip(_fractal);
		
		return getFractal(_fractal);
	}
}
