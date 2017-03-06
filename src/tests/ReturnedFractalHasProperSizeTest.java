package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.FractalGenerator;

public class ReturnedFractalHasProperSizeTest {
	/**
	 * @author Thankam Abish
	 * 			This test checks if the method to calculate the fractal returns a 2-d array with 512 rows and 512 columns.
	 */

	@Test
	public void MBSizeTest() {
		FractalGenerator fractal = new FractalGenerator();
		fractal.genMandelbrot();
		int[][] a = fractal.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}

	@Test
	public void JSizeTest() {
		FractalGenerator fractal = new FractalGenerator();
		fractal.genJulia();
		int[][] a = fractal.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}

	@Test
	public void BurnSizeTest() {
		FractalGenerator fractal = new FractalGenerator();
		fractal.genBurningShip();
		int[][] a = fractal.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}

	@Test
	public void MultiSizeTest() {
		FractalGenerator fractal = new FractalGenerator();
		fractal.genMultibrot();
		int[][] a = fractal.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}
}
