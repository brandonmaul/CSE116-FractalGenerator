package tests;
// Escape distance set to 3 after 10 passes of the loop 
import static org.junit.Assert.*;

import org.junit.Test;

import model.FractalGenerator;

public class Esc3Test {
	//Mandelbrot Set: (0.46007827788650374, -0.3383561643835661)
	@Test
	public void MB3test() {
		
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(10, fractal.calcMandelbrotEscapeTime(3,0.46007827788650374, -0.3383561643835661 , 10), 0.01);
	}
	// Julia Set:1.4538160469667272, -0.13502935420743645)
	@Test
	public void J3Test() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(10, fractal.calcJuliaEscapeTime(3, 1.4538160469667272, -0.13502935420743645, 10), 0.01);
	}

	
	//Burning Ship Set: (-1.6999999999999802, 0.0030136986301371603)
	@Test
	public void Burn3Test() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(10, fractal.calcBurningShipEscapeTime(3, -1.6999999999999802, 0.0030136986301371603, 10), 0.01);
	}
	//Multibrot Set: (0.7025440313111545, -0.5520547945205528)

	@Test
	public void Multi3Test() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(10, fractal.calcMultibrotEscapeTime(3, 0.7025440313111545, -0.5520547945205528, 10), 0.01);
	}


}
