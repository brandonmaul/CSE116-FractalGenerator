package code;

public class Pixel implements FractalAlgorithms {
	double xCalc;
	double yCalc;
	double dist;
	int escapeTime;
	
	public void setDistance(){
		dist = Math.sqrt(((xCalc)*(xCalc)) + ((yCalc)*(yCalc))); //Sets distance from the point (0,0) using Pythagorean Theorem
	}
	
	public void setX(double x){ xCalc = x; }
	public void setY(double y){ yCalc = y; }
	public void setEscapeTime(int et){ escapeTime = et; }
	
	public double getX(){ return xCalc; }
	public double getY(){ return yCalc; }
}
