package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class ReturnedFractalHasProperSizeTest {
	/**
	 * @author Thankam Abish
	 * 			This test checks if the method to calculate the fractal returns a 2-d array with 512 rows and 512 columns.
	 */
	
	Model _model = new Model();

	@Test
	public void MBSizeTest() {
		_model.setFractalType("Mandelbrot"); // Set fractal to Mandelbrot
		_model.generateFractal();
		int[][] a = _model.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}

	@Test
	public void JSizeTest() {
		_model.setFractalType("Julia"); // Set fractal to Julia
		_model.generateFractal();
		int[][] a = _model.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}

	@Test
	public void BurnSizeTest() {
		_model.setFractalType("Burning Ship"); // Set fractal to BurningShip
		_model.generateFractal();
		int[][] a = _model.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}

	@Test
	public void MultiSizeTest() {
		_model.setFractalType("Multibrot"); // Set fractal to Multibrot
		_model.generateFractal();
		int[][] a = _model.getEscapeTimeArray();
		// length of a column
		assertEquals(512, a[0].length);
		// length of a row
		assertEquals(512, a.length);
	}
}
