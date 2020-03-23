package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fin.festa.model.IndexDaoImpl;
import com.fin.festa.model.entity.ProfileVo;

@Service
@SessionAttributes("login")
public class IndexServiceImpl implements IndexService{

	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	IndexDaoImpl indexDao;
	
	//����ȭ����� �ο��������� �׷츮��Ʈ-��α���
	//������������ ��ȣ������� �׷츮��Ʈ-�α��� ��� 
	//���ƿ丹���� ķ���帮��Ʈ ���
	@Override
	public void index(HttpServletRequest req) {
		
		if(req.getAttribute("login")!=null) {
			req.setAttribute("grouplist", indexDao.addrGroupSelectAll((ProfileVo)req.getAttribute("login")));
		}
		//System.out.println(indexDao.totalGroupSelectAll());
		req.setAttribute("grouplist", indexDao.totalGroupSelectAll());
		req.setAttribute("camplist", indexDao.veryHotCampSelectAll());
	}


}
