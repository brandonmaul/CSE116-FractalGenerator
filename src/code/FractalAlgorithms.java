package code;

public interface FractalAlgorithms {
	/**
	 * @author Brandon Maul
	 * 
	 * This interface holds all the methods needed to properly set up and generate the escape times
	 * of each point on a fractal.
	 * The Fractal Initiators add pixels to the 2D array and make sure each of those pixels
	 * are given the proper parameters to fit the fractal being made.
	 * 
	 * The Escape Time Calculators take the pixels x and y coordinates and calculate it's escape time.
	 * 
	 */
	
	//==================================================================================================//
	//====FRACTAL INITIATORS - PUTS PIXELS INTO ARRAY AND GIVES THEM THEIR INITIAL X/Y COORDINATES======//
	//=======THEN GIVES THE PIXELS THEIR ESCAPE TIME BY CALLING ON THE ESCAPE TIME CALCULATORS==========//
	//==================================================================================================//
	
	//Coordinates of pixel are separate from indices 

	//<<<--------------------------------------------------------->>>//	
	//<<<-----------------------MandelBrot------------------------>>>//
	//<<<--------------------------------------------------------->>>//
	public default void initMandelbrot(Pixel[][] pixelArray){
		for(int x=0; x<pixelArray.length; x++){//Row
			for(int y=0; y<pixelArray[0].length; y++){//Col
				pixelArray[x][y] = new Pixel(x, y, -2.15, 0.6, -1.3, 1.3);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcMandelbrotEscapeTime(p.getX(), p.getY()));
			}
		}
	}
	
	//<<<---------------------------------------------------------->>>//
	//<<<---------------------------Julia-------------------------->>>//
	//<<<---------------------------------------------------------->>>//
	public default void initJulia(Pixel[][] pixelArray){
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				pixelArray[x][y] = new Pixel(x, y, -1.7, 1.7, -1.0, 1.0);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcJuliaEscapeTime(p.getX(), p.getY()));
			}
		}
	}
	
	//<<<---------------------------------------------------------->>>//
	//<<<-----------------------Burning Ship----------------------->>>//
	//<<<---------------------------------------------------------->>>//
	public default void initBurningShip(Pixel[][] pixelArray){
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				pixelArray[x][y] = new Pixel(x, y, -1.8, -1.7, -0.08, 0.025);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcBurningShipEscapeTime(p.getX(), p.getY()));
			}
		}
	}
	
	//<<<---------------------------------------------------------->>>//
	//<<<-------------------------Multibrot------------------------>>>//
	//<<<---------------------------------------------------------->>>//
	public default void initMultibrot(Pixel[][] pixelArray){
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				pixelArray[x][y] = new Pixel(x, y, -1.0, 1.0, -1.3, 1.3);
				Pixel p = pixelArray[x][y];
				p.setEscapeTime(calcMultibrotEscapeTime(p.getX(), p.getY()));
			}
		}
	}
	
	
	//<<<=====================================================================================================>>>//
	//<<<======ESCAPE TIME CALCULATORS - CALCULATES THE ESCAPE TIME OF A PIXEL GIVEN ITS COORDINATES==========>>>//	
	//<<<=====================================================================================================>>>//
	
		
	//<<<--------------------------------------------------------->>>//	
	//<<<-----------------------MandelBrot------------------------>>>//
	//<<<--------------------------------------------------------->>>//
	
	//If no max distance is given, it is assumed to be 4
	public default int calcMandelbrotEscapeTime(double xCoord, double yCoord){
		return calcMandelbrotEscapeTime(4, xCoord, yCoord);
	}
	
	public default int calcMandelbrotEscapeTime(int maxDist, double xCoord, double yCoord){
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);
		
		int passes = 0;
		while(dist <= maxDist & passes < 255){
			double xtemp = ((xCalc*xCalc) - (yCalc*yCalc)) + xCoord;
			yCalc = 2.0 * xCalc * yCalc + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}
	
	//<<<---------------------------------------------------------->>>//
	//<<<---------------------------Julia-------------------------->>>//
	//<<<---------------------------------------------------------->>>//
	
	//If no max distance is given, it is assumed to be 4
	public default int calcJuliaEscapeTime(double xCoord, double yCoord){
		return calcJuliaEscapeTime(4, xCoord, yCoord);
	}
	
	public default int calcJuliaEscapeTime(int maxDist, double xCoord, double yCoord){
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);
		
		int passes = 0;
		while(dist <= maxDist & passes < 255){
			double xtemp = ((xCalc*xCalc) - (yCalc*yCalc)) + (-0.72689);
			yCalc = 2.0 * xCalc * yCalc + 0.188887;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}
	
	//<<<---------------------------------------------------------->>>//
	//<<<-----------------------Burning Ship----------------------->>>//
	//<<<---------------------------------------------------------->>>//
	
	//If no max distance is given, it is assumed to be 4
	public default int calcBurningShipEscapeTime(double xCoord, double yCoord){
		return calcBurningShipEscapeTime(4, xCoord, yCoord);
	}
	
	public default int calcBurningShipEscapeTime(int maxDist, double xCoord, double yCoord){
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);
		
		int passes = 0;
		while(dist <= maxDist & passes < 255){
			double xtemp = ((xCalc*xCalc) - (yCalc*yCalc)) + xCoord;
			yCalc = Math.abs(2.0 * xCalc * yCalc) + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}
	
	//<<<---------------------------------------------------------->>>//
	//<<<------------------------Multibrot------------------------->>>//
	//<<<---------------------------------------------------------->>>//
	
	//If no max distance is given, it is assumed to be 4
	public default int calcMultibrotEscapeTime(double xCoord, double yCoord){
		return calcBurningShipEscapeTime(4, xCoord, yCoord);
	}
	
	public default int calcMultibrotEscapeTime(int maxDist, double xCoord, double yCoord){
		double xCalc = xCoord;
		double yCalc = yCoord;

		double dist = distanceCalculator(xCalc, yCalc);
		
		int passes = 0;
		while(dist <= maxDist & passes < 255){
			double xtemp = (xCalc*xCalc*xCalc) - (3 * xCalc * (yCalc * yCalc)) + xCoord;
			yCalc = (3 * (xCalc * xCalc) * yCalc) - (yCalc * yCalc * yCalc) + yCoord;
			xCalc = xtemp;
			passes = passes + 1;
			dist = distanceCalculator(xCalc, yCalc);
		}
		int escapeTime = passes;
		return escapeTime;
	}
	
	//<<<=====================================================================================================>>>//
	//<<<===================DISTANCE CALCULATOR - CALCULATES THE DISTANCE OF INPUT TO (0,0)===================>>>//	
	//<<<=====================================================================================================>>>//
	
	public default double distanceCalculator(double xInput, double yInput){
		double dist = Math.sqrt(((xInput)*(xInput)) + ((yInput)*(yInput)));
		return dist;
	}
}
