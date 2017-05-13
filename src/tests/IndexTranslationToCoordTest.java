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
		
		_model.setFractalType("Mandelbrot"); // Set fractal to Mandelbrot
		_model.setWorkerCount(4);
		_model.generateFractal(); // Generate Fractal
		Pixel[][] mandelbrot = _model.getRawFractal();
		
		// Index to xCord
		// xCord range is -2.15 to 0.6

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = mandelbrot[0][0].getCoords();
		
		// TEST Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = mandelbrot[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-2.15, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(0.6, coord_511_511[0], .1);

	}

	@Test
	public void yMBtest() {
		
		_model.setFractalType("Mandelbrot"); // Set fractal to Mandelbrot
		_model.setWorkerCount(4);
		_model.generateFractal(); // Generate Fractal
		Pixel[][] mandelbrot = _model.getRawFractal();
		
		// yCord range is -1.3 to 1.3

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = mandelbrot[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = mandelbrot[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.3, coord_0_0[1], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1.3, coord_511_511[1], .1);
		
	}

	@Test
	public void xJtest() {
		_model.setFractalType("Julia"); // Set fractal to Julia
		_model.setWorkerCount(4);		
		_model.generateFractal(); // Generate Fractal
		Pixel[][] julia = _model.getRawFractal();
		
		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = julia[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = julia[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.7, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1.7, coord_511_511[0], .1);
	}

	@Test
	public void yJtest() {
		
		_model.setFractalType("Julia"); // Set fractal to Julia

		_model.setWorkerCount(4);
		_model.generateFractal(); // Generate Fractal
		Pixel[][] julia = _model.getRawFractal();
		
		// Index to xCord
		// xCord range is -2.15 to 0.6

		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = julia[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = julia[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1, coord_0_0[1], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1, coord_511_511[1], .1);
	}

	@Test
	public void xBurntest() {
		_model.setFractalType("Burning Ship"); // Set fractal to Burning Ship

		_model.setWorkerCount(4);
		_model.generateFractal(); // Generate Fractal
		Pixel[][] burningship = _model.getRawFractal();
		
		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = burningship[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = burningship[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.8, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(-1.7, coord_511_511[0], .1);
	}

	@Test
	public void yBurntest() {
	_model.setFractalType("Burning Ship"); // Set fractal to Burning Ship

	_model.setWorkerCount(4);
	_model.generateFractal(); // Generate Fractal
	Pixel[][] burningship = _model.getRawFractal();
	
	// Get coordinates of the Pixel at (0,0)
	double[] coord_0_0 = burningship[0][0].getCoords();
	
	// Get coordinates of the Pixel at (511,511)
	double[] coord_511_511 = burningship[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
	
	// TEST Check the X Coordinate of the Pixel at (0,0)
	assertEquals(-0.08, coord_0_0[1], .1);
	
	// TEST Check the X Coordinate of the Pixel at (511,511)
	assertEquals(0.025, coord_511_511[1], .1);
	}

	@Test
	public void xMultitest() {
		_model.setFractalType("Multibrot"); // Set fractal to Multibrot

		_model.setWorkerCount(4);
		_model.generateFractal(); // Generate Fractal
		Pixel[][] multibrot = _model.getRawFractal();
		
		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = multibrot[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = multibrot[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1, coord_0_0[0], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1, coord_511_511[0], .1);
	}

	@Test
	public void yMultiest() {
		_model.setFractalType("Multibrot"); // Set fractal to Multibrot

		_model.setWorkerCount(4);
		_model.generateFractal(); // Generate Fractal
		Pixel[][] multibrot = _model.getRawFractal();
		
		// Get coordinates of the Pixel at (0,0)
		double[] coord_0_0 = multibrot[0][0].getCoords();
		
		// Get coordinates of the Pixel at (511,511)
		double[] coord_511_511 = multibrot[_model.getGridSize() -1][_model.getGridSize() -1].getCoords();
		
		// TEST Check the X Coordinate of the Pixel at (0,0)
		assertEquals(-1.3, coord_0_0[1], .1);
		
		// TEST Check the X Coordinate of the Pixel at (511,511)
		assertEquals(1.3, coord_511_511[1], .1);
	}
}
