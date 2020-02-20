package ch06;

class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	MyTv() {
		this.channel = 100;
		this.volume = 0;
	}
	void turnOnOff() { // isPowerOn�� ���� true�� false��, false�� true�� �ٲ۴�.
		isPowerOn = !isPowerOn;
	}

	void volumeUp() { // volume�� ���� MAX_VOLUME���� ���� ���� ���� 1 ������Ų��
		if (volume < MAX_VOLUME) {
			volume++;
		}
	}

	void volumeDown() { // volume�� ���� MIN_VOLUME���� Ŭ ���� ���� 1 ���ҽ�Ų��
		if (volume > MIN_CHANNEL) {
			volume--;
		}
	}

	void channelUp() { // channel�� ���� 1 ������Ų��. (�����÷ο�)
		if (channel != MAX_CHANNEL) {
			channel++;
		} else {
			channel = MIN_CHANNEL;
		}
	}

	void channelDown() { // channel�� ���� 1 ���ҽ�Ų��. (�����÷ο�)
		if (channel != MIN_CHANNEL) {
			channel--;
		} else {
			channel = MAX_CHANNEL;
		}
	}
}

public class Ex21 {
	public static void main(String[] args) {
		MyTv t = new MyTv();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
		
		t.channelDown();
		t.volumeDown();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
		
		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);

	}
}
