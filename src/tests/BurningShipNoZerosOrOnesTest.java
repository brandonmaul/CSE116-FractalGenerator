package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

/**
 * 
 * @author Giselle
 *
 */

public class BurningShipNoZerosOrOnesTest {
	
	/**
	 * Does the fractal contain any 0's or 1's?
	 * 
	 * Searches through each pixel in _fractal and checks to see if their escape
	 * time is 0 or a 1. Used for the Burning Ship test.
	 * 
	 * @return false if a 0 or 1 was found, true if none were found.
	 */
	public boolean boolContainsNoZerosOrOnes(Pixel[][] fractal) {
		for (int x = 0; x < fractal.length; x++) {
			for (int y = 0; y < fractal[0].length; y++) {
				if (fractal[x][y].getEscapeTime() == 0 | fractal[x][y].getEscapeTime() == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Test
	public void BurnEscTimeTest() {
		Model m = new Model();
		m.setFractalType(3); //Set the fractal to the burning ship
		Pixel[][] fractal = m.generateFractal();

		assertTrue(boolContainsNoZerosOrOnes(fractal));

	}
}
