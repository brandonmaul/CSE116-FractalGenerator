package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.FractalGenerator;
import model.Pixel;

public class IndexTranslationToCoordTest {
	/**
	 * @author Giselle
	 */
	@Test
	public void xMBtest() {

		FractalGenerator mbfractalx = new FractalGenerator();
		Pixel[][] mandelbrot = mbfractalx.genMandelbrot(2);
		// Index to xCord
		// xCord range is -2.15 to 0.6

		// (0,0)
		assertEquals(-2.15, mandelbrot[0][0].getX(), .01);
		// (512,512)
		assertEquals(0.6, mandelbrot[511][0].getX(), .01);

	}

	@Test
	public void yMBtest() {
		FractalGenerator mbfractaly = new FractalGenerator();
		Pixel[][] mandelbrot = mbfractaly.genMandelbrot(2);
		// Index to yCord
		// yCord range is -1.3 to 1.3

		// (0,0)
		assertEquals(-1.3, mandelbrot[0][0].getY(), .01);
		// (512,512)
		assertEquals(1.3, mandelbrot[0][511].getY(), .01);
		// Half
		assertEquals(0.0, mandelbrot[0][255].getY(), .01);
	}

	@Test
	public void xJtest() {
		FractalGenerator jfractalx = new FractalGenerator();
		Pixel[][] julia = jfractalx.genJulia(2);
		// Index to yCord
		// xCord range is -1.7 to 1.7

		// (0,..)
		assertEquals(-1.7, julia[0][0].getX(), .01);
		// (512,..)
		assertEquals(1.7, julia[511][0].getX(), .01);
		// Half
		assertEquals(0.0, julia[255][0].getX(), .01);
	}

	@Test
	public void yJtest() {
		FractalGenerator jfractaly = new FractalGenerator();
		Pixel[][] julia = jfractaly.genJulia(2);
		// Index to yCord
		// yCord range is -1.0 to 1.0

		// (0,..)
		assertEquals(-1.0, julia[0][0].getY(), .01);
		// (512,..)
		assertEquals(1.0, julia[0][511].getY(), .01);
		// Half
		assertEquals(0.0, julia[0][255].getY(), .01);
	}

	@Test
	public void xBurntest() {
		FractalGenerator burnfractalx = new FractalGenerator();
		Pixel[][] burn = burnfractalx.genBurningShip(2);
		// Index to yCord
		// xCord range is -1.8 to -1.7

		// (0,..)
		assertEquals(-1.8, burn[0][0].getX(), .1);

		// (512,..)
		assertEquals(-1.7, burn[511][0].getX(), .1);
	}

	@Test
	public void yBurntest() {
		FractalGenerator burnfractaly = new FractalGenerator();
		Pixel[][] burn = burnfractaly.genBurningShip(2);
		// yCord range is -0.08 to 0.025

		// (0,..)
		assertEquals(-0.08, burn[0][0].getY(), .1);
		// (512,..)
		assertEquals(0.025, burn[0][511].getY(), .1);
	}

	@Test
	public void xMultitest() {
		FractalGenerator multifractalx = new FractalGenerator();
		Pixel[][] multi = multifractalx.genMultibrot(2);
		// Index to yCord
		// xCord range is -1 to -1

		// (0,..)
		assertEquals(-1, multi[0][0].getX(), .1);

		// (512,..)
		assertEquals(1, multi[511][0].getX(), .1);
	}

	@Test
	public void yMultiest() {
		FractalGenerator multifractaly = new FractalGenerator();
		Pixel[][] multi = multifractaly.genMultibrot(2);
		// yCord range is -1.3 to 1.3

		// (0,..)
		assertEquals(-1.3, multi[0][0].getY(), .1);
		// (512,..)
		assertEquals(1.3, multi[0][511].getY(), .1);
	}
}
