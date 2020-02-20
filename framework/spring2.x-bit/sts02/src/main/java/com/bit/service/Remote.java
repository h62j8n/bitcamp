package com.bit.service;

public class Remote {
	Machine remote;
	
//	public Remote(Machine machine) {
//		remote=machine;
//	}
	
	public void setRemote(Machine remote) {
		this.remote = remote;
	}

	public void func1() {
		Tv tv =new Tv();
		tv.on();
		tv.work();
		tv.off();
	}
	
	public void func2() {
		Radio radio=new Radio();
		radio.on();
		radio.work();
		radio.off();
	}
	
	public void func3() {
		
		remote.on();
		remote.work();
		remote.off();
	}
}













