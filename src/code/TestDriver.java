package code;

public class TestDriver {
	 
	/**
	 * @author Brandon Maul
	 * 
	 * Just a driver to test results during development.
	 */

	public static void main(String[] args) {
		
		FractalGenerator fractal = new FractalGenerator();
		
		//these first 3 should be 255
		fractal.genMandelbrot();
		System.out.println("Mandelbrot Escape Time: " + fractal.calcMandlebrotEscapeTime(0.3207031250000001, -0.07109374999999386));
		System.out.println(fractal.boolContainsNoZerosOrOnes());
		
		fractal.genJulia();
		System.out.println("Julia Escape Time: " + fractal.calcJuliaEscapeTime(1.0492187499999897, -0.234375));
		System.out.println(fractal.boolContainsNoZerosOrOnes());

		fractal.genBurningShip();
		System.out.println("Burning Ship Escape Time: " + fractal.calcBurningShipEscapeTime(-1.7443359374999874, -0.017451171875000338));
		System.out.println(fractal.boolContainsNoZerosOrOnes());
		
		//these next 2 should be < 255
		fractal.genMandelbrot();
		System.out.println("Mandelbrot Escape Time: " + fractal.calcMandlebrotEscapeTime(0.5946289062500001, 1.2949218750000122));

		
		fractal.genJulia();
		System.out.println("Julia Escape Time: " + fractal.calcJuliaEscapeTime(1.6933593749999853, 0.9765625));
		
		fractal.genMandelbrot();
		System.out.println("Mandelbrot Escape Time: " + fractal.calcMandlebrotEscapeTime(0.0, 0.0));
		
		
		
	}

}
