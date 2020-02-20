package com.bit;

class Ball {					// �ζ� ��
	int num;
	String color;
	boolean check;				// �⺻�� false
	
	public Ball(int num) {
		check = false;
		this.num = num;
		if (num<10) {
			color = "�����";
		} else if (num<20) {
			color = "�Ķ���";
		} else if (num<30) {
			color = "������";
		} else if (num<40) {
			color = "�ʷϻ�";
		} else {
			color = "������";
		}
	}
}
public class Lotto3 {
	public static void main(String[] args) {
		Ball[] box = new Ball[45];
		for (int i=0; i<box.length; i++) {			// �� 45�� ����
			box[i] = new Ball(i+1);
		}
		
		String[] note = new String[6];				// �̾Ҵ� ���� ���ڿ� ������ �޸��� ����

		// box 0~44
		int ran = 0;
		for (int i=0; i<6; i++) {
			ran = (int)(Math.random()*45);
			Ball ball = box[ran];
			if (ball.check) {						// �̾Ҵ� ���̸�
				i--;									// �ٽ� �̱�
			} else {								// ó�� ���� ���̸�
				ball.check = true;						// �̾Ҵٴ� üũ ǥ��
				note[i] = ball.color+" "+ball.num+"��";	// ��Ʈ�� ���� ���� �Ӽ��� ���
			}
		}
		
		for (int i=0; i<note.length; i++) {
			System.out.println(note[i]);
		}
	}
}