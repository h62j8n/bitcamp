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
	void turnOnOff() { // isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
		isPowerOn = !isPowerOn;
	}

	void volumeUp() { // volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다
		if (volume < MAX_VOLUME) {
			volume++;
		}
	}

	void volumeDown() { // volume의 값이 MIN_VOLUME보다 클 때만 값을 1 감소시킨다
		if (volume > MIN_CHANNEL) {
			volume--;
		}
	}

	void channelUp() { // channel의 값을 1 증가시킨다. (오버플로우)
		if (channel != MAX_CHANNEL) {
			channel++;
		} else {
			channel = MIN_CHANNEL;
		}
	}

	void channelDown() { // channel의 값을 1 감소시킨다. (오버플로우)
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
