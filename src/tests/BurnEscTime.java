package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.FractalGenerator;

/**
 * 
 * @author Giselle
 *
 */

public class BurnEscTime {
	@Test
	public void BurnEscTimeTest() {
		FractalGenerator fractal = new FractalGenerator();

		fractal.genBurningShip();

		assertTrue(fractal.boolContainsNoZerosOrOnes());

	}
}
