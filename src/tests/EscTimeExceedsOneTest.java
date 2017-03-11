package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.FractalGenerator;

public class EscTimeExceedsOneTest {

	@Test
	public void MBEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(1, fractal.calcMandelbrotEscapeTime(2, 0.5946289062500001, 1.2949218750000122, 255), 0.01);
	}

	@Test
	public void JEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(1, fractal.calcJuliaEscapeTime(2, 1.6933593749999853, 0.9765625, 255), 0.01);
	}

	@Test
	public void MultiEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(1, fractal.calcMultibrotEscapeTime(2, 0.9921875, 1.05625, 255), 0.01);
	}

}