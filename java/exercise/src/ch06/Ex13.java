package ch06;

public class Ex13 {
	long add(int a, int b) {return a+b;}
//	long add(int x, int y) {return x+y;}		// a. 중복 메소드
	long add(long a, long b) {return a+b;}		// b.
	int add(byte a, byte b) {return a+b;}		// c.
	int add(long a, int b) {return (int)(a+b);}	// d.
}
