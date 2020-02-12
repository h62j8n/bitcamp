package com.bit.action;

import com.bit.model.Emp02Dao;
import com.opensymphony.xwork2.Action;

public class InsertAction implements Action {
	private int sabun;
	private String name;
	private int pay;
	private String errMsg;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	@Override
	public String execute() throws Exception {
		if (sabun == 0) {
			errMsg = "<div class=\"alert alert-danger\" role=\"alert\">사번을 확인하세요</div>";
			return this.INPUT;
		} else if (name.isEmpty()) {
			errMsg = "<div class=\"alert alert-danger\" role=\"alert\">이름을 확인하세요</div>";
			return this.INPUT;
		}
		
		Emp02Dao dao = new Emp02Dao();
		dao.insertOne(sabun, name, pay);
		
		return this.SUCCESS;
	}
}
