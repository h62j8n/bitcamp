package com.bit.plan;

import com.bit.service.*;

public class PlanJava {

	public static void main(String[] args) {
		Remote remote=new Remote();
//		Remote remote=new Remote(new Radio());
		remote.setRemote(new Radio());
		remote.func3();
	}

}
