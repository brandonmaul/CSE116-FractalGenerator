package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import code.*;

public class CoordTest {

	@Test
	public void xMBtest() {
		
		FractalGenerator mbfractalx = new FractalGenerator();
		Pixel[][] mandelbrot = mbfractalx.genMandelbrot();
		// Index to xCord
		//xCord range is -2.15 to 0.6
		
		//mandelbrot[x][0].getX();
		//(0,0)
		assertEquals(-2.15,mandelbrot[0][0].getX(),.01);
		//(512,512)
		assertEquals(0.6,mandelbrot[511][0].getX(),.01);
		
		
		// System.out.print(mandelbrot[451][0].getX());
		
		
			}
	@Test
	public void yMBtest() {
		FractalGenerator mbfractaly = new FractalGenerator();
		Pixel[][] mandelbrot = mbfractaly.genMandelbrot();
		// Index to yCord
		//yCord range is -1.3 to 1.3
		
		//mandelbrot[x][0].getX();
		//(0,0)
		assertEquals(-1.3,mandelbrot[0][0].getY(),.01);
		//(512,512)
		assertEquals(1.3,mandelbrot[0][511].getY(),.01);
		//Half
		assertEquals(0.0,mandelbrot[0][255].getY(),.01);
	//System.out.print(mandelbrot[0][255].getY());
	
		
		
	}
	@Test
	public void xJtest() {
		FractalGenerator jfractalx = new FractalGenerator();
		Pixel[][] julia = jfractalx.genJulia();
		// Index to yCord
		//xCord range is -1.7 to 1.7
		
		
		//(0,..)
		assertEquals(-1.7,julia[0][0].getX(),.01);
		//(512,..)
		assertEquals(1.7,julia[511][0].getX(),.01);
		//Half
		assertEquals(0.0,julia[255][0].getX(),.01);
	//System.out.print(julia[0][255].getY());
		
	}
	@Test
	public void yJtest() {
		FractalGenerator jfractaly = new FractalGenerator();
		Pixel[][] julia = jfractaly.genJulia();
		// Index to yCord
		//yCord range is -1.0 to 1.0
		
	
		//(0,..)
		assertEquals(-1.0,julia[0][0].getY(),.01);
		//(512,..)
		assertEquals(1.0,julia[0][511].getY(),.01);
		//Half
		assertEquals(0.0,julia[0][255].getY(),.01);
	//System.out.print(julia[0][255].getY());
}
	@Test
	public void xBurntest() {
		FractalGenerator burnfractalx = new FractalGenerator();
		Pixel[][] burn = burnfractalx.genBurningShip();
		// Index to yCord
		//xCord range is -1.8 to -1.7
		
		
		//(0,..)
		//System.out.print(burn[1][0].getX());
		
		assertEquals(-1.8,burn[0][0].getX(),.1);
		//(512,..)
		assertEquals(-1.7,burn[511][0].getX(),.1);
	}	
	@Test
	public void yBurntest() {
		FractalGenerator burnfractaly = new FractalGenerator();
		Pixel[][] burn = burnfractaly.genBurningShip();
		
		//yCord range is -0.08 to 0.025
		
		
		//(0,..)
		//System.out.print(burn[0][0].getX());
		
		assertEquals(-0.08,burn[0][0].getY(),.1);
		//(512,..)
		assertEquals(0.025,burn[0][511].getY(),.1);
	}	
}
