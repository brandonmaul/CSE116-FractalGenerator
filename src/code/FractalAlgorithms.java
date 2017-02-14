package code;

public interface FractalAlgorithms {
	
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
	
	public default void initMandlebrot(Pixel[][] pixelArray){
		pixelArray[0][0].setX(-2.15);
		pixelArray[0][0].setY(-1.3);
		
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				if(x != 0){
					pixelArray[x][y].setX((pixelArray[x-1][y] + 0.00537109375));
				}elif(y !=0){
					pixelArray[x][y].setY((pixelArray[x][y-1] + 0.005078125));
				}
			}
		}
	}
	
	public default void initJulia(Pixel[][] pixelArray){
		pixelArray[0][0].setX(-1.7);
		pixelArray[0][0].setY(-1.0);
		
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				if(x != 0){
					pixelArray[x][y].setX((pixelArray[x-1][y] + 0.0052734375));
				}elif(y !=0){
					pixelArray[x][y].setY((pixelArray[x][y-1] + 0.00390625));
				}
			}
		}
	}
	
	public default void initBurningShip(Pixel[][] pixelArray){
		pixelArray[0][0].setX(-1.8);
		pixelArray[0][0].setY(-0.08);
		
		for(int x=0; x<pixelArray.length; x++){
			for(int y=0; y<pixelArray[0].length; y++){
				if(x != 0){
					pixelArray[x][y].setX((pixelArray[x-1][y] + 0.0068359375));
				}elif(y !=0){
					pixelArray[x][y].setY((pixelArray[x][y-1] + 0.00020507812));
				}
			}
		}
	}


}
