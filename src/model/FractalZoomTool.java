package model;

public class FractalZoomTool extends FractalAlgorithms{

	public Pixel[][] zoomMandelbrot(Pixel[][] fractal, int maxDist, int maxPasses, int[] regionStart, int[] regionEnd) {
		double[] startCoords = fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], startCoords[1], endCoords[0], endCoords[1]};
		
		for(Pixel[] pixRow : fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, fractal.length);
				calcMandelbrotEscapeTime(p, maxDist, maxPasses);
			}
		}
		
		return fractal;
	}
	public Pixel[][] zoomJulia(Pixel[][] fractal, int maxDist, int maxPasses, int[] regionStart, int[] regionEnd) {
		double[] startCoords = fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], startCoords[1], endCoords[0], endCoords[1]};
		
		for(Pixel[] pixRow : fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, fractal.length);
				calcJuliaEscapeTime(p, maxDist, maxPasses);
			}
		}
		
		return fractal;
	}
	public Pixel[][] zoomBurningShip(Pixel[][] fractal, int maxDist, int maxPasses, int[] regionStart, int[] regionEnd) {
		double[] startCoords = fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], startCoords[1], endCoords[0], endCoords[1]};
		
		for(Pixel[] pixRow : fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, fractal.length);
				calcBurningShipEscapeTime(p, maxDist, maxPasses);
			}
		}
		
		return fractal;
	}
	public Pixel[][] zoomMultibrot(Pixel[][] fractal, int maxDist, int maxPasses, int[] regionStart, int[] regionEnd) {
		double[] startCoords = fractal[regionStart[0]][regionStart[1]].getCoords();
		double[] endCoords = fractal[regionEnd[0]][regionEnd[1]].getCoords();
		double[] newConstants = new double[]{startCoords[0], startCoords[1], endCoords[0], endCoords[1]};
		
		for(Pixel[] pixRow : fractal){
			for(Pixel p : pixRow){
				calcPixelCoordinates(p, newConstants, fractal.length);
				calcMultibrotEscapeTime(p, maxDist, maxPasses);
			}
		}
		
		return fractal;
	}
}
