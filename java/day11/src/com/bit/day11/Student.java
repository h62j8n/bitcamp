package com.bit.day11;

public class Student {
	int num;
	int kor;
	int math;
	int eng;
	int sum;
	double avg;
	
	Student() {
		this(0, 0, 0, 0);
	}
	Student(int num, int kor, int eng, int math) {
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor+eng+math;
		this.avg = sum*100/3/100.0;
	}
	void result(int num, int kor, int eng, int math) {
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor+eng+math;
		this.avg = sum*100/3/100.0;
	}
	public String resultToString() {
		String result = "|"+num+"\t|"+kor+"\t|"+eng+"\t|"+math+"\t|"+sum+"\t|"+avg+"\t|";
		return result;
	}
}
