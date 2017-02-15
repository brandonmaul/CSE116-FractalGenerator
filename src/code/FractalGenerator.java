package code;

public class FractalGenerator implements FractalAlgorithms{
	
	Pixel[][] cartPlane;
	int[][] returnedFractal;
	
	public FractalGenerator(){
		cartPlane = new Pixel[512][512]; 
		returnedFractal = new int[512][512];
	}
	
	/**
	 * @author Brandon Maul
	 * 
	 * Each of the following functions creates a fractal on a 2D grid.
	 * The fractals design is specified by the FractalAlgorithims interface which just supplies the method for making
	 * the fractal to each pixel on the 2D array.
	 * 
	 * That method is called by the Pixel to update it's X and Y coordinates. Then we update the pixel's escape time.
	 * 
	 * Once the fractal breaks the loops, either by exceeding the distance it can travel or by moving around 'too much'
	 * the pixel's escape time (in number of passes) is set and added to the array of Escape Times per pixel.
	 * 
	 * The array of escape times is returnedFractal and is what is ultimately returned by the methods in this class.
	 * 
	 */
	
	//---------------------------------------------------------------//
	//MANDLEBROT FRACTAL:
	//---------------------------------------------------------------//
	
	public Pixel[][] genMandelbrot(){
		
		initMandlebrot(cartPlane);
		for(int x=0; x<cartPlane.length; x++){
			for(int y=0; y<cartPlane[0].length; y++){
				System.out.println("Pixel ("+ x +", "+y+") has the coord ("+cartPlane[x][y].getX()+", "+cartPlane[x][y].getY()+").");
			}
		}
		for(int x=0; x<cartPlane.length; x++){
			for(int y=0; y<cartPlane[0].length; y++){
				Pixel p = cartPlane[x][y];
				p.setDistance();
				int passes = 0;
				while(p.dist <= 4 && passes < 255){
					p.updateMandelbrot(p);
					passes++;
					p.setDistance();
				}
				p.setEscapeTime(passes);
				
				returnedFractal[x][y] = passes;
			}
		}
		return cartPlane;
		//return returnedFractal;
	}
	
	//---------------------------------------------------------------//
	//JULIA FRACTAL:
	//---------------------------------------------------------------//
	
	public int[][] genJulia(){

		initJulia(cartPlane);
		
		for(int x=0; x<cartPlane.length; x++){
			for(int y=0; y<cartPlane[0].length; y++){
				Pixel p = cartPlane[x][y];
				p.setDistance();
				int passes = 0;
				while(p.dist <= 4 && passes < 255){
					p.updateJulia(p);
					passes++;
					p.setDistance();
				}
				p.setEscapeTime(passes);
				
				returnedFractal[x][y] = passes;
			}
		}
		
		return returnedFractal;
	}
	
	//---------------------------------------------------------------//
	//BURNING SHIP FRACTAL:
	//---------------------------------------------------------------//
	public int[][] genBurningShip(){
		
		initBurningShip(cartPlane);
		
		for(int x=0; x<cartPlane.length; x++){
			for(int y=0; y<cartPlane[0].length; y++){
				Pixel p = cartPlane[x][y];
				p.setDistance();
				int passes = 0;
				while(p.dist <= 4 && passes < 255){
					p.updateBurningShip(p);
					passes++;
					p.setDistance();
				}
				p.setEscapeTime(passes);
				
				returnedFractal[x][y] = passes;
			}
		}
		
		return returnedFractal;
	}
}
