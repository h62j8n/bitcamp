package com.bit.sts12.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts12.model.entity.EmpDao;
import com.bit.sts12.model.entity.EmpVo;

@Service
public class EmpServiceImpl implements EmpService {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void selectAll(Model model) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
//		System.out.println("리스트 출력");
	}

	@Override
	public void selectOne(int key, Model model) {
		System.out.println("레코드 출력");
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		model.addAttribute("bean", dao.selectOne(key));
	}

	@Override
	public void insertOne(EmpVo bean) throws Exception {
		System.out.println("데이터베이스 입력");
//		int su = 0/0;
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
	}

	@Override
	public int updateOne(EmpVo bean) {
		log.debug("레코드 수정");
		System.out.println("레코드 수정");
		return 1;
	}

	@Override
	public int deleteOne(int key) {
		log.debug("레코드 삭제");
		System.out.println("레코드 삭제");
		return 0;
	}

}
