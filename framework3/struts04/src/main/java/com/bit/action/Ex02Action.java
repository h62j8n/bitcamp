package com.bit.action;

import org.apache.log4j.Logger;

import com.bit.model.entity.JavaBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class Ex02Action implements Action, ModelDriven, Preparable{
	Logger log=Logger.getLogger(this.getClass());
	private JavaBean bean;
	
	public JavaBean getBean(){
		return bean;
	}
	
	public String execute() throws Exception {
		log.debug(bean.getId());
		log.debug(bean.getPw());
		return this.SUCCESS;
	}

	public Object getModel() {
		return bean;
	}

	public void prepare() throws Exception {
		bean=new JavaBean();
	}

}
