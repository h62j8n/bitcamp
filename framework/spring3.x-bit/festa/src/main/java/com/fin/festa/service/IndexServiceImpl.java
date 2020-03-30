package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		HttpSession session = req.getSession();
		if(session.getAttribute("login")!=null) {
			session.setAttribute("grouplist", indexDao.addrGroupSelectAll((ProfileVo)session.getAttribute("login")));
		}else {
			session.setAttribute("grouplist", indexDao.totalGroupSelectAll());
		}
		session.setAttribute("camplist", indexDao.veryHotCampSelectAll());
	}


}
