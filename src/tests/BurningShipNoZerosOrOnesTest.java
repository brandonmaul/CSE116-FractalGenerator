package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.FractalGenerator;

/**
 * 
 * @author Giselle
 *
 */

public class BurningShipNoZerosOrOnesTest {
	@Test
	public void BurnEscTimeTest() {
		FractalGenerator fractal = new FractalGenerator();

		fractal.genBurningShip(2, 255);

		assertTrue(fractal.boolContainsNoZerosOrOnes());

	}
}
