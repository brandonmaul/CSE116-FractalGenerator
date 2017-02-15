package code;

public interface FractalAlgorithms {
	
	//---------------------------------------------------------------//
	//FRACTAL UPDATERS - UPDATES PIXEL POSITIONS FOR THE FRACTAL BASED ON ALGORITHM
	//---------------------------------------------------------------//
	
	public default void updateMandelbrot(Pixel p){
		double currentX = p.getX();
		double currentY = p.getY();
		
		double newX = (((currentX)*(currentX)) - ((currentY)*(currentY))) + currentX;
		double newY = (2 * currentX * currentY) + currentY;
		
		p.setX(newX); 
		p.setY(newY);
	}
	
	public default void updateJulia(Pixel p){
		double currentX = p.getX();
		double currentY = p.getY();
		
		
		double newX = (((currentX)*(currentX)) - ((currentY)*(currentY))) + (-0.72689);
		double newY = (2 * currentX * currentY) + 0.188887;
		
		p.setX(newX); 
		p.setY(newY);
	}
	
	public default void updateBurningShip(Pixel p){
		double currentX = p.getX();
		double currentY = p.getY();
		
		double newX = (((currentX)*(currentX)) - ((currentY)*(currentY))) + currentX;
		double newY = Math.abs((2 * currentX * currentY) + currentY);
		
		p.setX(newX); 
		p.setY(newY);
	}
	
	//---------------------------------------------------------------//
	//FRACTAL INITIATORS - PUTS PIXELS INTO ARRAY AND GIVES THEM THEIR INITIAL X/Y COORDINATES
	//---------------------------------------------------------------//
	
	//Honestly there's probably a simpler way of doing these. Might need to rethink this
	
	public default void initMandlebrot(Pixel[][] pixelArray){
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				pixelArray[x][y] = new Pixel(x, y, -2.15, .6, -1.3, 1.3);
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
}
