package code;

public class Pixel implements FractalAlgorithms {
	double xCalc;
	double yCalc;
	double dist;
	int escapeTime;
	
	public Pixel(int x, int y, double minX, double maxX, double minY, double maxY){
		xCalc = ((Math.abs(maxX - minX)/512) * (x - 256));
		yCalc = ((Math.abs(maxX - minY)/512) * (y - 256));
	}
	
	public void setDistance(){
		dist = Math.sqrt(((xCalc)*(xCalc)) + ((yCalc)*(yCalc))); //Sets distance from the point (0,0) using Pythagorean Theorem
	}
	
	public void setX(double x){ xCalc = x; }
	public void setY(double y){ yCalc = y; }
	
	public void setEscapeTime(int et){ escapeTime = et; }
	
	public double getX(){ return xCalc; }
	public double getY(){ return yCalc; }
}
