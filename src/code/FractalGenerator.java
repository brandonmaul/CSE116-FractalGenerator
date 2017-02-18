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
	 * the fractal to each pixel on the 2D array. FractalAlgorithms also has the Escape-Time generation methods which calculates each 
	 * pixel's escape time.
	 * 
	 * Once the fractal has been initiated properly, and the escape time of each pixel has been calculated by using the update function,
	 * the final fractal is ready to be returned. The final fractal is a 2D array of integers that represents each pixel's (of the same index)
	 * escape-time. This is done by calling @code getEscapeTimeArray
	 * 
	 * Order of each fractal method in this Class:
	 * (Step 1) --> Creates new 2D Pixel Array.
	 * (Step 2.1) --> Calls init_____ function with the input of the 2D Pixel Array. This fills each index in the 2D array with Pixels with the proper parameters. (Uses FractalAlgorithms Interface)
	 * (Step 2.2) --> After a pixel is created it's individual escape-time is calculated and stored inside the pixel. (Uses FractalAlgorithms Interface)
	 * (Step 3) --> After this has happened for every index in the Array, The fractal is returned. This fractal is a 2D array of Pixels each with their own properly calculated escape-time.
	 * 
	 * The method at the bottom, getEscapeTimeArray, simply returns the 2D array of INTEGERS that is the
	 * same size as the fractal. This 2D array of Integers contains the escape time for each pixel of the same index in the fractal
	 * 
	 * Ex: _fractal[0][0].getEscapeTime == 4; So... escapeTimeArray[0][0] == 4; (THIS IS WHAT WE NEED TO RETURN FOR PHASE I)
	 * 
	 * Each pixel in the 2D Pixel array should have a escape time by the point this method is called.
	 * If the getEscapeTimeArray is called before a fractal generation method, you're gonna have a bad time.
	 * 
	 */
	
	//---------------------------------------------------------------//
	//MANDLEBROT FRACTAL:
	//---------------------------------------------------------------//
	//Pixel is the 2d array - This is fractal MandelBrot
	//From the pixel class
	
	public Pixel[][] genMandelbrot(){
		_fractal = new Pixel[512][512];
		initMandelbrot(_fractal);
		return _fractal;

	}
	
	//---------------------------------------------------------------//
	//JULIA FRACTAL:
	//---------------------------------------------------------------//
	
	public Pixel[][] genJulia(){
		_fractal = new Pixel[512][512];
		initJulia(_fractal);
		return _fractal;

	}
	
	//---------------------------------------------------------------//
	//BURNING SHIP FRACTAL:
	//---------------------------------------------------------------//
	
	public Pixel[][] genBurningShip(){
		_fractal = new Pixel[512][512];
		initBurningShip(_fractal);
		return _fractal;
	}
	
	//---------------------------------------------------------------//
	//PHASE 1 ESCAPE-TIME GENERATOR - GENERATES 2D ARRAY OF TYPE INT THAT CONTAINS THE ESCAPE TIME OF EACH PIXEL
	//---------------------------------------------------------------//
		
		public int[][] getEscapeTimeArray(){
			
			int[][] fractal = new int[_fractal.length][_fractal[0].length];
			
			for(int x=0; x<_fractal.length; x++){
				for(int y=0; y<_fractal[0].length; y++){
					fractal[x][y] = _fractal[x][y].getEscapeTime();
				}
			}
			return fractal;
		}
	
	//---------------------------------------------------------------//
	//OTHER RETURN METHODS: Could be useful for some of the unit tests... maybe. Idk. ¯\_(ツ)_/¯
	//---------------------------------------------------------------//
	
	public Pixel[][] getFractal() { //return the raw fractal stored in this class
		return _fractal;
	}

	public int getEscapeTimeFromIndex(int x, int y) { //get just one escape time from a single pixel (given index)
		return _fractal[x][y].getEscapeTime();
	}
	
	public boolean boolContainsNoZerosOrOnes(){ //if the escape time of ANY of the pixels is 1 or 0, this returns true. Otherwise, returns false.
		for(int x=0; x<_fractal.length; x++){
			for(int y=0; y<_fractal[0].length; y++){
				if (_fractal[x][y].getEscapeTime() == 0 | _fractal[x][y].getEscapeTime() == 1 ){
					return false;
				}
			}
		}
		return true;
	}
}


