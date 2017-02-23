package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import code.FractalGenerator;

public class EscTimeMaxDist {

	@Test
	public void MBEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(1, fractal.calcMandelbrotEscapeTime(0.5946289062500001, 1.2949218750000122), 0.01);
	}

	@Test
	public void JEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(1, fractal.calcJuliaEscapeTime(1.6933593749999853, 0.9765625), 0.01);
	}

	@Test
	public void MultiEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(1, fractal.calcMultibrotEscapeTime(0.9921875, 1.05625), 0.01);
	}

}