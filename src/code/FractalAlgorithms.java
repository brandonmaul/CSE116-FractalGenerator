package code;

public interface FractalAlgorithms {
	/**
	 * Ah here it is. The big kahuna.
	 * @author Brandon Maul
	 * 
	 * This interface holds all the methods needed to properly set up and update a fractal.
	 * The Fractal Initiators add pixels to the 2D array and make sure each of those pixels
	 * are given the proper parameters to fit the fractal being made.
	 * 
	 * The Fractal Updater methods cycle through each pixel on the 2D array and then calculate 
	 * the escape time of each pixel and store that escape in the respective pixel.
	 * 
	 * The final method at the bottom, getFractal, simply returns the 2D array that is of
	 * type int, and is the exact same size as the @param pixels of a 2D pixel array. Each pixel
	 * in the 2D Pixel array should have a escape time by the point this method is called.
	 * This method then takes the escape time of each pixel and stores that in the 2D integer array
	 * at the same index of the pixel it came from. Then finally it returns the 2D integer array it
	 * generated.
	 * 
	 */
	
	//---------------------------------------------------------------//
	//FRACTAL INITIATORS - PUTS PIXELS INTO ARRAY AND GIVES THEM THEIR INITIAL X/Y COORDINATES
	//---------------------------------------------------------------//
		
		public default void initMandelbrot(Pixel[][] pixelArray){
			for(int x=0; x<pixelArray.length; x++){
				for(int y=0; y<pixelArray[0].length; y++){
					pixelArray[x][y] = new Pixel(x, y, -2.15, 0.6, -1.3, 1.3);
				}
			}
		}
		
		public default void initJulia(Pixel[][] pixelArray){
			for(int x=0; x<pixelArray.length; x++){
				for(int y=0; y<pixelArray[0].length; y++){
					pixelArray[x][y] = new Pixel(x, y, -1.7, 1.7, -1.0, 1.0);
				}
			}
		}
		
		public default void initBurningShip(Pixel[][] pixelArray){
			for(int x=0; x<pixelArray.length; x++){
				for(int y=0; y<pixelArray[0].length; y++){
					pixelArray[x][y] = new Pixel(x, y, -1.8, -1.7, -0.08, 0.025);

				}
			}
		}
		
	//---------------------------------------------------------------//
	//FRACTAL UPDATERS - UPDATES PIXEL POSITIONS FOR THE FRACTAL BASED ON ALGORITHM
	//---------------------------------------------------------------//
	
	public default void updateMandelbrot(Pixel[][] pixelArray){
		
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				
				Pixel p = pixelArray[x][y];
				
				p.setDistance();
				p.setPasses(0);
				
				while(p.getDistance() <= 4 && p.getPasses() < 255){
					p._passes++;
					
					double currentX = p.getX();
					double currentY = p.getY();
					
					double newX = (((currentX)*(currentX)) - ((currentY)*(currentY))) + currentX;
					double newY = (2 * currentX * currentY) + currentY;
					
					p.setX(newX); 
					p.setY(newY);
					
					p.setDistance();
				}
				
				p.setEscapeTime();
				
			}
		}
	}
	
	public default void updateJulia(Pixel[][] pixelsArray){
		
		for(int x=0; x<pixelsArray.length; x++){
			for(int y=0; y<pixelsArray[0].length; y++){
				
				Pixel p = pixelsArray[x][y];
				
				p.setDistance();
				p.setPasses(0);
				
				while(p.getDistance() <= 4 && p.getPasses() < 255){
					p._passes++;
					
					double currentX = p.getX();
					double currentY = p.getY();
					
					double newX = (((currentX)*(currentX)) - ((currentY)*(currentY))) + (-0.72689);
					double newY = (2 * currentX * currentY) + 0.188887;
					
					p.setX(newX); 
					p.setY(newY);
					
					p.setDistance();
				}
				
				p.setEscapeTime();
				
			}
		}
	}
	
	public default void updateBurningShip(Pixel[][] pixelArray){
		
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				
				Pixel p = pixelArray[x][y];
				
				p.setDistance();
				p.setPasses(0);
				
				while(p.getDistance() <= 4 && p.getPasses() < 255){
					p._passes++;
					
					double currentX = p.getX();
					double currentY = p.getY();
					
					double newX = (((currentX)*(currentX)) - ((currentY)*(currentY))) + currentX;
					double newY = Math.abs((2 * currentX * currentY) + currentY);
					
					p.setX(newX); 
					p.setY(newY);
					
					p.setDistance();
				}
				
				p.setEscapeTime();
				
			}
		}
	}
	
	//---------------------------------------------------------------//
	//PHASE 1 ESCAPE-TIME GENERATOR - GENERATES 2D ARRAY OF TYPE INT THAT PROVIDES THE ESCAPE TIME OF EACH PIXEL
	//---------------------------------------------------------------//
	
	public default int[][] getFractal(Pixel[][] pixelArray){
		
		int[][] fractal = new int[pixelArray.length][pixelArray[0].length];
		
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				fractal[x][y] = pixelArray[x][y].getEscapeTime();
			}
		}

		return fractal;
	}
}
