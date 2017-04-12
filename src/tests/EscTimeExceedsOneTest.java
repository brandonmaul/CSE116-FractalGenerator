package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.FractalGenerator;
import model.Pixel;

public class EscTimeExceedsOneTest {
	
	FractalGenerator _fractal = new FractalGenerator(new Pixel[0][0]);
	Pixel _testPixel = new Pixel(0,0);
	
	@Test
	public void MBEscTest() {
		_testPixel.setCoords(0.5946289062500001, 1.2949218750000122);
		_fractal.calcMandelbrotEscapeTime(_testPixel, 2, 255);
		assertEquals(1, _testPixel.getEscapeTime(), 0.01);  
	}

	@Test
	public void JEscTest() {
		_testPixel.setCoords(1.6933593749999853, 0.9765625);
		_fractal.calcJuliaEscapeTime(_testPixel, 2, 255);
		assertEquals(1, _testPixel.getEscapeTime(), 0.01);
	}

	@Test
	public void MultiEscTest() {
		_testPixel.setCoords(0.9921875, 1.05625);
		_fractal.calcBurningShipEscapeTime(_testPixel, 2, 255);
		assertEquals(1, _testPixel.getEscapeTime(), 0.01);
	}

}