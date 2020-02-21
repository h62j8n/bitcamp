package com.bit.prj03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.bit.prj03.model.EmpDao;
import com.bit.prj03.model.entity.EmpVo;

// 데이터베이스를 사용하지 않는 기능 (db를 사용할 경우 dao를 호출하면 된다.)
public interface EmpService {
	void list(Model model);
	
	void detail(Model model, int sabun);
	
	void insert(EmpVo bean);
	
	void update(EmpVo bean);
	
	void delete(int sabun);
}
