package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Pixel;

public class PixelSetCoordAndReturnEscapeTimeTest {
	//made these tests last minute to please Web-CAT

	@Test
	public void setEscapeTimeTest() {
		Pixel p = new Pixel(0,0);
		p.setEscapeTime(9069); // its over 9000
		assertEquals(9069, p.getEscapeTime());
	}

	@Test
	public void setXCoordTest() {
		Pixel p = new Pixel(0,0);
		p.setX(124.00);
		assertEquals(124.00, p.getX(), .01);
	}

	@Test
	public void setYCoordTest() {
		Pixel p = new Pixel(0,0);
		p.setY(54.00);
		assertEquals(54.00, p.getY(), .01);

	}

}
