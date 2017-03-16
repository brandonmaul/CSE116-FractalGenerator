package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.Driver;
public class UITest {

	@Test
	public void test() {
		try{
			Driver.main(null);
		}catch(Exception e){
			fail("The Driver did not execute properly and threw a checked Exception");
		}
	}
}
