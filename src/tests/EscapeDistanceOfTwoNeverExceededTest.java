package tests;

import static org.junit.Assert.*;

import model.*;
import org.junit.Test;

public class DistanceNeverExceedsEscapeDistanceTest {
	/**
	 * @author Brandon Maul
	 */
	
	//Mandelbrot Set
	@Test
	public void MandelbrotEscapeDistanceOfTwoNeverExceededTest() {
		FractalGenerator fractal = new FractalGenerator(new Pixel[0][0]);
		Pixel p = new Pixel(0,0);
		p.setCoords(0.3207031250000001, -0.07109374999999386);
		fractal.calcMandelbrotEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}
	
	// Julia Set
	@Test
	public void JuliaEscapeDistanceOfTwoNeverExceededTest() {
		FractalGenerator fractal = new FractalGenerator(new Pixel[0][0]);
		Pixel p = new Pixel(0,0);
		p.setCoords(1.0492187499999897, -0.234375);
		fractal.calcJuliaEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}

	
	//Burning Ship Set
	@Test
	public void BurningShipEscapeDistanceOfTwoNeverExceededTest() {
		FractalGenerator fractal = new FractalGenerator(new Pixel[0][0]);
		Pixel p = new Pixel(0,0);
		p.setCoords(-1.7443359374999874, -0.017451171875000338);
		fractal.calcBurningShipEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}
	
	//Multibrot Set
	@Test
	public void MultibrotEscapeDistanceOfTwoNeverExceededTest() {
		FractalGenerator fractal = new FractalGenerator(new Pixel[0][0]);
		Pixel p = new Pixel(0,0);
		p.setCoords(0.5859375, 0.24375000000000108);
		fractal.calcMultibrotEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}
}
