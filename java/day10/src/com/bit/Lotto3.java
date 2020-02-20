package com.bit;

class Ball {					// 로또 볼
	int num;
	String color;
	boolean check;				// 기본값 false
	
	public Ball(int num) {
		check = false;
		this.num = num;
		if (num<10) {
			color = "노랑색";
		} else if (num<20) {
			color = "파랑색";
		} else if (num<30) {
			color = "빨강색";
		} else if (num<40) {
			color = "초록색";
		} else {
			color = "검정색";
		}
	}
}
public class Lotto3 {
	public static void main(String[] args) {
		Ball[] box = new Ball[45];
		for (int i=0; i<box.length; i++) {			// 공 45개 생성
			box[i] = new Ball(i+1);
		}
		
		String[] note = new String[6];				// 뽑았던 공의 숫자와 색깔을 메모할 공간

		// box 0~44
		int ran = 0;
		for (int i=0; i<6; i++) {
			ran = (int)(Math.random()*45);
			Ball ball = box[ran];
			if (ball.check) {						// 뽑았던 공이면
				i--;									// 다시 뽑기
			} else {								// 처음 뽑은 공이면
				ball.check = true;						// 뽑았다는 체크 표시
				note[i] = ball.color+" "+ball.num+"번";	// 노트에 뽑은 공의 속성을 기록
			}
		}
		
		for (int i=0; i<note.length; i++) {
			System.out.println(note[i]);
		}
	}
}