package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import ui.*;
import model.*;

public class UITest {
	
	@Test
	public void constructUITest(){
		UI ui = new UI(new Model());
		assertNotNull(ui);
	}
	
	@Test
	public void displayFractalTest(){
		try{
			UI ui = new UI(new Model());
			ui.displayFractal();
			ui.clearFractal();
			
		}catch (Exception e){
			fail("Exception was thrown");
		}
	}
}
