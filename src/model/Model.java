package model;

import ui.*;

public class Model {
	private UI _ui;
	
	private FractalGenerator _fractalGenerator;
	
	private int _escapeDistance = 2;
	private int _fractalType; //1 == Mandelbrot // 2 == Julia // 3 == BurningShip // 4 == Multibrot
	private int _colorModel; 
	
	public Model(){
		_ui = new UI(this);
		
	}
	
	public int[][] generateFractal(){
		int[][] retVal = null;
		
		if (_fractalType == 1){
			_fractalGenerator.genMandelbrot();
			retVal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("Mandelbrot Fractal Has Been Made");
		}else if (_fractalType == 2){
			_fractalGenerator.genJulia();
			retVal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("Julia Fractal Has Been Made");
		}else if (_fractalType == 3){
			_fractalGenerator.genBurningShip();
			retVal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("BurningShip Fractal Has Been Made");
		}else if (_fractalType == 4){
			_fractalGenerator.genMultibrot();
			retVal = _fractalGenerator.getEscapeTimeArray();
			System.out.println("Mulibrot Fractal Has Been Made");
		}
		return retVal;
	}

	public int getEscapeDistance() {
		return _escapeDistance;
	}

	public void setFractalType(int i) {
		_fractalType = i;
		
	}
	
	
	
	

}
