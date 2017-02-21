package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.FractalGenerator;

public class EscTimeMaxPassesTest {
	/**
	 * @author Thankam Abish
	 */

	@Test
	public void MBEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255,fractal.calcMandelbrotEscapeTime(0.3207031250000001, -0.07109374999999386),0.01);
	}

	@Test
	public void JEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255,fractal.calcJuliaEscapeTime(1.0492187499999897, -0.234375),0.01);
	}

	@Test
	public void BurnEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255,fractal.calcBurningShipEscapeTime(-1.7443359374999874, -0.017451171875000338),0.01);
	}
	
	@Test
	public void MultiEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(255,fractal.calcMultibrotEscapeTime(0.5859375, 0.24375000000000108),0.01);
	}

}
