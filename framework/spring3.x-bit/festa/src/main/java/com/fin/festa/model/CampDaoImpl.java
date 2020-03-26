package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

@Repository
public class CampDaoImpl implements CampDao{

	@Autowired
	SqlSession sqlSession;

	///////////////////////////////////////////////////////////////
	////////////////////ķ������ ȭ�����//////////////////////////
	///////////////////////////////////////////////////////////////
	
	//�ű�ķ���� ��� ���
	@Override
	public List<CampVo> newCampSelectAll() {
		return sqlSession.selectList("camp.newCampSelectAll");
	}

	//����ķ���� ��� ���
	@Override
	public List<CampVo> allLocationCamp() {
		return sqlSession.selectList("camp.allLocationCamp");
	}

	//�ش�����ķ���� ��� ���
	@Override
	public List<CampVo> locationCamp(CampVo campVo) {
		return sqlSession.selectList("camp.locationCamp", campVo);
	}

	///////////////////////////////////////////////////////////////
	////////////////ķ����� ���ı׷� üũ///////////////////////
	///////////////////////////////////////////////////////////////
	
	//�ش�ķ���忡 ���ı׷��� �ִ��� üũ
	@Override
	public int ventureGroupCheck(CampVo camp) {
		// TODO Auto-generated method stub
		return 0;
	}

	//���ı׷��� �����ÿ� ���ı׷����� ���
	@Override
	public GroupVo campVentureGroup(CampVo camp) {
		// TODO Auto-generated method stub
		return null;
	}

	///////////////////////////////////////////////////////////////
	///////////////////ķ����� ȭ�����/////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ�������� ���
	@Override
	public CampVo campInfoSelectOne(CampVo camp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//ķ���� ���������
	@Override
	public List<CampReviewVo> campReview(CampVo camp) {
		// TODO Auto-generated method stub
		return null;
	}

	//ķ���� ������ �Ѱ���
	@Override
	public int campReviewCount(CampVo camp) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�ش�ķ����� ���������� ķ������ ���
	@Override
	public List<CampVo> sameLocationCamp(CampVo camp) {
		// TODO Auto-generated method stub
		return null;
	}

	///////////////////////////////////////////////////////////////
	/////////////////ķ���������� ���,����////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� ��������
	@Override
	public void campReviewInsert(CampReviewVo campReview) {
		// TODO Auto-generated method stub
		
	}

	//ķ���� ������ ��Ͻ� ķ�������� ����ؼ� ������Ʈ
	@Override
	public int campAvgUpdate(CampReviewVo campReview) {
		// TODO Auto-generated method stub
		return 0;
	}

	//ķ���� ���������
	@Override
	public int campReviewDelete(CampReviewVo campReview) {
		// TODO Auto-generated method stub
		return 0;
	}

	///////////////////////////////////////////////////////////////
	/////////////////ķ���� ���ƿ���,����////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� ���ƿ���
	@Override
	public void campLikeInsert(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//ķ���� ���ƿ�����
	@Override
	public int campLikeDelete(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//ķ���� ���ƿ��Ͻ� ķ�������ƿ� ���� +1
	@Override
	public int campLikeOnePlus(CampVo camp) {
		// TODO Auto-generated method stub
		return 0;
	}

	//ķ���� ���ƿ������� ķ�������ƿ� ���� -1
	@Override
	public int campLikeOneMinus(CampVo camp) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�� ���ƿ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		// TODO Auto-generated method stub
		return null;
	}

	///////////////////////////////////////////////////////////////
	////////////////////////ķ���� �Ű���////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� �Ű���
	@Override
	public void campReport(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//ķ�������� �Ű����Ƚ�� +1
	@Override
	public int campReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}

	///////////////////////////////////////////////////////////////
	///////////////////ķ���� �ϸ�ũ���,����//////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� �ϸ�ũ���
	@Override
	public void campBookMarkInsert(MyBookMarkVo bookMark) {
		// TODO Auto-generated method stub
		
	}

	//ķ���� �ϸ�ũ����
	@Override
	public int campBookMarkDelete(MyBookMarkVo bookMark) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�� �ϸ�ũ��� ����
	@Override
	public List<MyBookMarkVo> myboodRenewal(MyBookMarkVo bookMark) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
