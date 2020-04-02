package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.ProfileVo;

@Repository
public class IndexDaoImpl implements IndexDao{

	@Autowired
	SqlSession sqlSession;
	
	//////////////////////////////////////////////////////////////////////
	//////////////////////////����ȭ�� ���///////////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	
	//�� �����ο������� �׷���� -��α���
	@Override
	public List<GroupVo> totalGroupSelectAll() {
		
		return sqlSession.selectList("index.totalGroupList");
	}
	
	//������������ ��ȣ������� �׷���� -�α���
	@Override
	public List<GroupVo> addrGroupSelectAll(ProfileVo profile) {
		
		return sqlSession.selectList("index.addrGroupList",profile);
	}
	
	//���ƿ� ���� ķ�������
	@Override
	public List<CampVo> veryHotCampSelectAll() {
		
		return sqlSession.selectList("index.campList");
	}

	
}
