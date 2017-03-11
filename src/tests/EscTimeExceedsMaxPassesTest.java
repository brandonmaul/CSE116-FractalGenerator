package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.FractalGenerator;

public class EscTimeExceedsMaxPassesTest {
	/**
	 * @author Thankam Abish
	 * 			This test checks if the program can accurately calculate the the escape time for a coordinate whose distance from the 
	 * 			origin exceeds the escape distance after a single loop pass for each fractal. 
	 */

	@Test
	public void MBEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255, fractal.calcMandelbrotEscapeTime(2, 0.3207031250000001, -0.07109374999999386, 255), 0.01);
	}

	@Test
	public void JEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255, fractal.calcJuliaEscapeTime(2, 1.0492187499999897, -0.234375, 255), 0.01);
	}

	@Test
	public void BurnEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255, fractal.calcBurningShipEscapeTime(2, -1.7443359374999874, -0.017451171875000338, 255), 0.01);
	}

	@Test
	public void MultiEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255, fractal.calcMultibrotEscapeTime(2, 0.5859375, 0.24375000000000108, 255), 0.01);
	}

}
