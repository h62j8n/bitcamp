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

	//등록,수정,삭제가 최소2개이상 들어가는 메소드는 꼭 트랜잭션 적용할것!!
	
	@Autowired
	IndexDaoImpl indexDao;
	
	//메인화면출력 인원수많은순 그룹리스트-비로그인
	//가입하지않은 선호지역기반 그룹리스트-로그인 출력 
	//좋아요많은순 캠핑장리스트 출력
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
