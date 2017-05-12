package model;

public class FractalZoomTool extends FractalAlgorithms{

	public Pixel[][] zoomFractal(Pixel[][] fractal, int maxDist, int maxPasses, int[] regionStart, int[] regionEnd) {
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
