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
	 * Order of each generator method in this Class:
	 * (Step 1) --> Initiation of the 2D Pixel Array.
	 * (Step 2) --> Add Pixels to each Position in the Array with the proper parameters. (Uses FractalAlgorithms Interface)
	 * (Step 3) --> Update pixels to calculate their individual escape-times and store them inside the pixels (Uses FractalAlgorithms Interface)
	 * (Step 4) --> Return Fractal; Send it out into the world.
	 * 
	 * From there you can use the return methods below the generators to acquire what you want from the fractal.
	 * NOTE: If you call return methods before the fractal has been generated, you will get a Null Pointer Exception.
	 * Don't do this. Please.
	 
	 * The method at the bottom, getEscapeTimeArray, simply returns the 2D array that is of
	 * type int, and is the exact same size as the fractal stored as an instance variable in this class. 
	 * Each pixel in the 2D Pixel array should have a escape time by the point this method is called.
	 * This method then takes the escape time of each pixel and stores that in the 2D integer array
	 * at the same index of the pixel it came from. Then finally it returns the 2D integer array it
	 * generated.
	 * 
	 */
	
	//---------------------------------------------------------------//
	//MANDLEBROT FRACTAL:
	//---------------------------------------------------------------//
	
	public Pixel[][] genMandelbrot(){
		
		_fractal = new Pixel[512][512];
		
		initMandelbrot(_fractal);
		
		updateMandelbrot(_fractal);
		
		return _fractal;

	}
	
	//---------------------------------------------------------------//
	//JULIA FRACTAL:
	//---------------------------------------------------------------//
	
	public Pixel[][] genJulia(){
		
		_fractal = new Pixel[512][512];
		
		initJulia(_fractal);
		
		updateJulia(_fractal);
		
		return _fractal;

	}
	
	//---------------------------------------------------------------//
	//BURNING SHIP FRACTAL:
	//---------------------------------------------------------------//
	
	public Pixel[][] genBurningShip(){
		
		_fractal = new Pixel[512][512];
		
		initBurningShip(_fractal);
		
		updateBurningShip(_fractal);
		
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
		boolean bool = false;
		outerloop:
		for(int x=0; x<_fractal.length; x++){
			for(int y=0; y<_fractal[0].length; y++){
				if (_fractal[x][y].getEscapeTime() == 0 | _fractal[x][y].getEscapeTime() == 1 ){
					bool = true;
					break outerloop;
				}
			}
		}
		return bool;
	}
	
	//---------------------------------------------------------------//
	//Need to figure out how to get this to work... This method makes me think that maybe the update functions are broken
	//---------------------------------------------------------------//
		
		public int getEscapeTimeOfPixel(double xCalc, double yCalc){
			
			int retVal = 0;
			
			outerloop:
			for(int x=0; x<_fractal.length; x++){
				for(int y=0; y<_fractal[0].length; y++){
					if (_fractal[x][y].getX() == xCalc && _fractal[x][y].getY() == yCalc){
						retVal = _fractal[x][y].getEscapeTime();
						break outerloop;
					}
				}
			}
			
			return retVal;
			
		}
}


