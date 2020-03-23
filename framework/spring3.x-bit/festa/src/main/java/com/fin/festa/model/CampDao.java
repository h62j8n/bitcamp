package com.fin.festa.model;

import java.util.List;

import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

public interface CampDao {
	
	List<CampVo> newCampSelectAll();
	
	List<CampVo> allLocationCamp();
	
	List<CampVo> locationCamp(PageSearchVo search);
	
	CampVo campInfoSelectOne(CampVo camp);
	
	int ventureGroupCheck(CampVo camp);
	
	GroupVo campVentureGroup(CampVo camp);
	
	List<CampReviewVo> campReview(CampVo camp);
	
	int campReviewCount(CampVo camp);
	
	void campReviewInsert(CampReviewVo campReview);
	
	int campAvgUpdate(CampReviewVo campReview);
	
	int campReviewDelete(CampReviewVo campReview);
	
	List<CampVo> sameLocationCamp(CampVo camp);
	
	void campLikeInsert(MyGoodVo good);
	
	int campLikeDelete(MyGoodVo good);
	
	int campLikeOnePlus(CampVo camp);
	
	int campLikeOneMinus(CampVo camp);
	
	void campReport(ReportListVo report);
	
	void campBookMarkInsert(MyBookMarkVo bookMark);
	
	int campBookMarkDelete(MyBookMarkVo bookMark);
	
	List<MyGoodVo> myGoodRenewal(MyGoodVo good);
	
	List<MyBookMarkVo> myboodRenewal(MyBookMarkVo bookMark);
	
	int campReportCountUpdate(ReportListVo report);
}