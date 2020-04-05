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
	public int ventureGroupCheck(CampVo campVo) {
		return sqlSession.selectOne("camp.ventureGroupCheck", campVo);
	}

	//���ı׷��� �����ÿ� ���ı׷����� ���
	@Override
	public GroupVo campVentureGroup(CampVo campVo) {
		return sqlSession.selectOne("camp.campVentureGroup", campVo);
	}

	///////////////////////////////////////////////////////////////
	///////////////////ķ����� ȭ�����/////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ�������� ���
	@Override
	public CampVo campInfoSelectOne(CampVo campVo) {
		return sqlSession.selectOne("camp.campInfoSelectOne", campVo);
	}
	
	//ķ���� ������ �Ѱ���
	@Override
	public int campReviewCount(CampVo campVo) {
		return sqlSession.selectOne("camp.campReviewCount", campVo);
	}
	
	//ķ���� ���������
	@Override
	public List<CampReviewVo> campReview(CampVo campVo) {
		return sqlSession.selectList("camp.campReview", campVo);
	}
	
	//�ش�ķ����� ���������� ķ������ ���
	@Override
	public List<CampVo> sameLocationCamp(CampVo campVo) {
		return sqlSession.selectList("camp.sameLocationCamp", campVo);
	}

	///////////////////////////////////////////////////////////////
	/////////////////ķ���������� ���,����////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� ��������
	@Override
	public void campReviewInsert(CampReviewVo campReviewVo) {
		sqlSession.insert("campReviewInsert", campReviewVo);
	}

	//ķ���� ������ ��Ͻ� ķ�������� ����ؼ� ������Ʈ
	@Override
	public int campAvgUpdate(CampReviewVo campReviewVo) {
		return sqlSession.update("camp.campAvgUpdate", campReviewVo);
	}

	//ķ���� ���������
	@Override
	public int campReviewDelete(CampReviewVo campReviewVo) {
		return sqlSession.delete("camp.campReviewDelete", campReviewVo);
	}

	///////////////////////////////////////////////////////////////
	/////////////////ķ���� ���ƿ���,����////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� ���ƿ���
	@Override
	public void campLikeInsert(MyGoodVo myGoodVo) {
		sqlSession.insert("camp.campLikeInsert", myGoodVo);
	}

	//ķ���� ���ƿ�����
	@Override
	public int campLikeDelete(MyGoodVo myGoodVo) {
		return sqlSession.delete("camp.campLikeDelete", myGoodVo);
	}
	
	//ķ���� ���ƿ� ����
	@Override
	public int campLikeUpdate(CampVo campVo) {
		return sqlSession.update("camp.campLikeUpdate", campVo);
	}

	//�� ���ƿ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo myGoodVo) {
		return sqlSession.selectList("camp.myGoodRenewal", myGoodVo);
	}

	///////////////////////////////////////////////////////////////
	////////////////////////ķ���� �Ű���////////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� �Ű���
	@Override
	public void campReport(ReportListVo reportListVo) {
		sqlSession.insert("camp.campReport", reportListVo);
	}

	//ķ�������� �Ű����Ƚ�� +1
	@Override
	public int campReportCountUpdate(ReportListVo reportListVo) {
		return sqlSession.update("camp.campReportCountUpdate", reportListVo);
	}

	///////////////////////////////////////////////////////////////
	///////////////////ķ���� �ϸ�ũ���,����//////////////////////
	///////////////////////////////////////////////////////////////
	
	//ķ���� �ϸ�ũ���
	@Override
	public void campBookMarkInsert(MyBookMarkVo myBookMarkVo) {
		sqlSession.insert("camp.campBookMarkInsert", myBookMarkVo);
	}

	//ķ���� �ϸ�ũ����
	@Override
	public int campBookMarkDelete(MyBookMarkVo myBookMarkVo) {
		return sqlSession.delete("camp.campBookMarkDelete", myBookMarkVo);
	}

	//�� �ϸ�ũ��� ����
	@Override
	public List<MyBookMarkVo> mybookRenewal(MyBookMarkVo bookMarkVo) {
		return sqlSession.selectList("camp.mybookRenewal", bookMarkVo);
	}
}
