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
				calcMandelbrotEscapeTime(p, newConstants, p.getX(), p.getY(), maxDist, maxPasses, _fractal.length);
			}
		}
	}
	
	public void zoomJulia(int[] regionStart, int[] regionEnd, int maxDist, int maxPasses){
		double[] startCoords = _fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = _fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], endCoords[0], startCoords[1], endCoords[1]};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				calcJuliaEscapeTime(p, newConstants, p.getX(), p.getY(), maxDist, maxPasses, _fractal.length);
			}
		}
	}
	public void zoomBurningShip(int[] regionStart, int[] regionEnd, int maxDist, int maxPasses){
		double[] startCoords = _fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = _fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], endCoords[0], startCoords[1], endCoords[1]};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				calcBurningShipEscapeTime(p, newConstants, p.getX(), p.getY(), maxDist, maxPasses, _fractal.length);
			}
		}
	}
	public void zoomMultibrot(int[] regionStart, int[] regionEnd, int maxDist, int maxPasses){
		double[] startCoords = _fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = _fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], endCoords[0], startCoords[1], endCoords[1]};
		
		for(Pixel[] pixRow : _fractal){
			for(Pixel p : pixRow){
				calcMultibrotEscapeTime(p, newConstants, p.getX(), p.getY(), maxDist, maxPasses, _fractal.length);
			}
		}
	}
}
