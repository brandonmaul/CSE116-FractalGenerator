package code;

public class TestDriver {
	
	/**
	 * @author Brandon Maul
	 * 
	 * Just a driver to test results during development.
	 */

	public static void main(String[] args) {
		FractalGenerator fractal = new FractalGenerator();
		fractal.genMandelbrot();
		fractal.getEscapeTimeArray();

		
		
	}

}
