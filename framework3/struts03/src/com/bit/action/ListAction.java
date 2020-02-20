package com.bit.action;

import java.util.List;

import com.bit.model.Emp02Dao;
import com.bit.model.entity.Emp02Vo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action{

	private List<Emp02Vo> list;
   
	public List<Emp02Vo> getList() {
		return list;
	}
	
	@Override
	public String execute() throws Exception {
      
		Emp02Dao dao = new Emp02Dao();
		list = dao.selectAll();
      
		return this.SUCCESS;
	}
}