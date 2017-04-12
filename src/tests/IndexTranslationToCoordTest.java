package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.*;

public class IndexTranslationToCoordTest {
	/**
	 * @author Giselle
	 */
	
	Model _model = new Model();
	
	@Test
	public void xMBtest() {
		
		_model.setFractalType(1); // Set fractal to Mandelbrot
		Pixel[][] mandelbrot = _model.generateFractal(); // Generate Fractal
		
		// Index to xCord
		// xCord range is -2.15 to 0.6

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = mandelbrot[0][0].getCoords();
		
		// TEST Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = mandelbrot[511][511].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-2.15, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(0.6, coord_511_511[0], .1);

	}

	@Test
	public void yMBtest() {
		
		Pixel[][] mandelbrot = _model.generateFractal(); // Generate Fractal
		
		// yCord range is -1.3 to 1.3

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = mandelbrot[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = mandelbrot[511][511].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.3, coord_0_0[1], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1.3, coord_511_511[1], .1);

		// TEST Halfway point
		assertEquals(0.0, mandelbrot[255][255].getCoords()[1], .1);
		
	}

	@Test
	public void xJtest() {
		_model.setFractalType(2); // Set fractal to Julia
		Pixel[][] julia = _model.generateFractal(); // Generate Fractal

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = julia[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = julia[511][511].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.7, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1.7, coord_511_511[0], .1);
		
		// TEST Halfway point
		assertEquals(0.0, julia[255][255].getCoords()[0], .1);
	}

	@Test
	public void yJtest() {
		
		_model.setFractalType(2); // Set fractal to Julia
		Pixel[][] julia = _model.generateFractal(); // Generate Fractal
		
		// Index to xCord
		// xCord range is -2.15 to 0.6

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = julia[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = julia[511][511].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1, coord_0_0[1], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1, coord_511_511[1], .1);
		
		// TEST Halfway point
		assertEquals(0.0, julia[255][255].getCoords()[1], .1);
	}

	@Test
	public void xBurntest() {
		_model.setFractalType(3); // Set fractal to Burning Ship
		Pixel[][] burningship = _model.generateFractal(); // Generate Fractal

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = burningship[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = burningship[511][511].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.8, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(-1.7, coord_511_511[0], .1);
	}

	@Test
	public void yBurntest() {
	_model.setFractalType(3); // Set fractal to Burning Ship
	Pixel[][] burningship = _model.generateFractal(); // Generate Fractal

	// Get coordinates of the Pixel at (0,0)
	double[] coord_0_0 = burningship[0][0].getCoords();
	
	// Get coordinates of the Pixel at (511,511)
	double[] coord_511_511 = burningship[511][511].getCoords();
	
	// TEST Check the X Coordinate of the Pixel at (0,0)
	assertEquals(-0.08, coord_0_0[1], .1);
	
	// TEST Check the X Coordinate of the Pixel at (511,511)
	assertEquals(0.025, coord_511_511[1], .1);
	}

	@Test
	public void xMultitest() {
		_model.setFractalType(4); // Set fractal to Multibrot
		Pixel[][] multibrot = _model.generateFractal(); // Generate Fractal

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = multibrot[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = multibrot[511][511].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1, coord_511_511[0], .1);
	}

	@Test
	public void yMultiest() {
		_model.setFractalType(4); // Set fractal to Multibrot
		Pixel[][] multibrot = _model.generateFractal(); // Generate Fractal

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = multibrot[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = multibrot[511][511].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.3, coord_0_0[1], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1.3, coord_511_511[1], .1);
	}
}
