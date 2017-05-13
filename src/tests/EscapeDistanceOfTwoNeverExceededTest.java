package tests;

import static org.junit.Assert.*;

import model.*;
import org.junit.Test;

public class EscapeDistanceOfTwoNeverExceededTest {
	/**
	 * @author Brandon Maul
	 */
	
	//Mandelbrot Set
	@Test
	public void MandelbrotEscapeDistanceOfTwoNeverExceededTest() {
		Pixel p = new Pixel(0,0);
		p.setCoords(0.3207031250000001, -0.07109374999999386);
		model.FractalAlgorithms.calcMandelbrotEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}
	
	// Julia Set
	@Test
	public void JuliaEscapeDistanceOfTwoNeverExceededTest() {
		Pixel p = new Pixel(0,0);
		p.setCoords(1.0492187499999897, -0.234375);
		model.FractalAlgorithms.calcJuliaEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}

	
	//Burning Ship Set
	@Test
	public void BurningShipEscapeDistanceOfTwoNeverExceededTest() {
		Pixel p = new Pixel(0,0);
		p.setCoords(-1.7443359374999874, -0.017451171875000338);
		model.FractalAlgorithms.calcBurningShipEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}
	
	//Multibrot Set
	@Test
	public void MultibrotEscapeDistanceOfTwoNeverExceededTest() {
		Pixel p = new Pixel(0,0);
		p.setCoords(0.5859375, 0.24375000000000108);
		model.FractalAlgorithms.calcMultibrotEscapeTime(p, 2, 135);
		
		assertEquals(135, p.getEscapeTime(), 0.01);
	}
}
