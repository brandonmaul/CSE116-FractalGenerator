package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class EscTimeExceedsMaxPassesTest {
	/**
	 * @author Thankam Abish
	 * 			This test checks if the program can accurately calculate the the escape time for a coordinate whose distance from the 
	 * 			origin exceeds the escape distance after a single loop pass for each fractal. 
	 */
	FractalGenerator _fractal = new FractalGenerator(new Pixel[0][0]);
	Pixel _testPixel = new Pixel(0,0);
	
	@Test
	public void MBEscTest() {
		_testPixel.setCoords(0.3207031250000001, -0.07109374999999386);
		model.FractalAlgorithms.calcMandelbrotEscapeTime(_testPixel, 2, 255);
		assertEquals(255, _testPixel.getEscapeTime(), 0.01);
	}

	@Test
	public void JEscTest() {
		_testPixel.setCoords(1.0492187499999897, -0.234375);
		model.FractalAlgorithms.calcJuliaEscapeTime(_testPixel, 2, 255);
		assertEquals(255, _testPixel.getEscapeTime(), 0.01);
	}

	@Test
	public void BurnEscTest() {
		_testPixel.setCoords(-1.7443359374999874, -0.017451171875000338);
		model.FractalAlgorithms.calcBurningShipEscapeTime(_testPixel, 2, 255);
		assertEquals(255, _testPixel.getEscapeTime(), 0.01);
	}

	@Test
	public void MultiEscTest() {
		_testPixel.setCoords(0.5859375, 0.24375000000000108);
		model.FractalAlgorithms.calcMultibrotEscapeTime(_testPixel, 2, 255);
		assertEquals(255, _testPixel.getEscapeTime(), 0.01);
	}

}
