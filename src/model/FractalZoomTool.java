package model;

public class FractalZoomTool extends FractalAlgorithms{
	Pixel[][] _fractal;
	
	public FractalZoomTool(Pixel[][] fractal){
		_fractal = fractal;
	}
	
	public void zoomMandelbrot(int[] regionStart, int[] regionEnd, int maxDist, int maxPasses){
		double[] startCoords = _fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = _fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], endCoords[0], startCoords[1], endCoords[1]};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, _fractal.length);
				calcMandelbrotEscapeTime(p, maxDist, maxPasses);
			}
		}
	}
	
	public void zoomJulia(int[] regionStart, int[] regionEnd, int maxDist, int maxPasses){
		double[] startCoords = _fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = _fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], endCoords[0], startCoords[1], endCoords[1]};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, _fractal.length);
				calcJuliaEscapeTime(p, maxDist, maxPasses);
			}
		}
	}
	public void zoomBurningShip(int[] regionStart, int[] regionEnd, int maxDist, int maxPasses){
		double[] startCoords = _fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = _fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], endCoords[0], startCoords[1], endCoords[1]};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, _fractal.length);
				calcBurningShipEscapeTime(p, maxDist, maxPasses);
			}
		}
	}
	public void zoomMultibrot(int[] regionStart, int[] regionEnd, int maxDist, int maxPasses){
		double[] startCoords = _fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = _fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], endCoords[0], startCoords[1], endCoords[1]};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, _fractal.length);
				calcMultibrotEscapeTime(p, maxDist, maxPasses);
			}
		}
	}
}
