package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import code.FractalGenerator;




public class EscTimeMaxDist {

	@Test
	public void MBEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(2,fractal.calcMandlebrotEscapeTime(0.5946289062500001, 1.2949218750000122),0.01);
	}

	@Test
	public void JEscTest() {
		FractalGenerator fractal = new FractalGenerator();
		assertEquals(2,fractal.calcJuliaEscapeTime(1.6933593749999853, 0.9765625),0.01);
	}


}