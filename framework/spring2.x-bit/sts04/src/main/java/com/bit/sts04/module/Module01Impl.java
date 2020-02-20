package com.bit.sts04.module;

public class Module01Impl implements Module01{

	Module02 module;

	public void setModule(Module02 module) {
		this.module = module;
	}
	
	public void func01() {
		String msg=module.getMsg();
		System.out.println(msg);
	}

	public void func02() {
		System.out.println("run...");
	}

	public void func03() {
		System.out.println("에러가 발생할겁니다...");
		int su=0/0;
	}

}
