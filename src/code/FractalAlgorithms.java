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

}
