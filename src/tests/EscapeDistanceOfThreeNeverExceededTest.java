package tests;
// Escape distance of 3 is never achieved after 10 passes of the loop
import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class EscapeDistanceOfThreeNeverExceededTest {
	
	//Mandelbrot Set: (0.46007827788650374, -0.3383561643835661)
	@Test
	public void MB3test() {
		Pixel p = new Pixel(0,0);
		p.setCoords(0.46007827788650374, -0.3383561643835661);
		model.FractalAlgorithms.calcMandelbrotEscapeTime(p, 3, 10);
		
		assertEquals(10, p.getEscapeTime(), 0.01);
	}
	
	// Julia Set:1.4538160469667272, -0.13502935420743645)
	@Test
	public void J3Test() {
		Pixel p = new Pixel(0,0);
		p.setCoords(1.4538160469667272, -0.13502935420743645);
		model.FractalAlgorithms.calcJuliaEscapeTime(p, 3, 10);
		
		assertEquals(10, p.getEscapeTime(), 0.01);
	}

	
	//Burning Ship Set: (-1.6999999999999802, 0.0030136986301371603)
	@Test
	public void Burn3Test() {
		Pixel p = new Pixel(0,0);
		p.setCoords(-1.6999999999999802, 0.0030136986301371603);
		model.FractalAlgorithms.calcBurningShipEscapeTime(p, 3, 10);
		
		assertEquals(10, p.getEscapeTime(), 0.01);
	}
	
	//Multibrot Set: (0.7025440313111545, -0.5520547945205528)
	@Test
	public void Multi3Test() {
		Pixel p = new Pixel(0,0);
		p.setCoords(0.7025440313111545, -0.5520547945205528);
		model.FractalAlgorithms.calcMultibrotEscapeTime(p, 3, 10);
		
		assertEquals(10, p.getEscapeTime(), 0.01);
	}


}
