package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.FractalGenerator;
import code.Pixel;

public class FractalArrayTest {
	/**
	 * @author Thankam Abish
	 */
	@Test
	public void MBSizeTest() {
		FractalGenerator fractal = new FractalGenerator();
		Pixel[][] a = fractal.genMandelbrot();
		//length of a column
		assertEquals(512, a[0].length);
		//length of a row
		assertEquals(512, a.length);
	}
	
	@Test
	public void JSizeTest() {
		FractalGenerator fractal = new FractalGenerator();
		Pixel[][] a = fractal.genJulia();
		//length of a column
		assertEquals(512, a[0].length);
		//length of a row
		assertEquals(512, a.length);
	}

	@Test
	public void BurnSizeTest() {
		FractalGenerator fractal = new FractalGenerator();
		Pixel[][] a = fractal.genBurningShip();
		//length of a column
		assertEquals(512, a[0].length);
		//length of a row
		assertEquals(512, a.length);
	}
}
