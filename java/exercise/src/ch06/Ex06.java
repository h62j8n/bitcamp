package ch06;

class MyPoint {
	int x;
	int y;
	
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	double getDistance(int x1, int y1) {
		double result = Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
		return result;
	}
}
public class Ex06 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		System.out.println(p.getDistance(2, 2));
	}
}
