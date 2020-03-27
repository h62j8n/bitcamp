package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fin.festa.model.CampDaoImpl;
import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.ReportListVo;

@Service
public class CampServiceImpl implements CampService{

	//등록,수정,삭제가 최소2개이상 들어가는 메소드는 꼭 트랜잭션 적용할것!!
	
	@Autowired
	CampDaoImpl campDao;
	
	//신규캠핑장 목록 출력
	//전국캠핑장 목록 출력
	@Override
	public void campSelectAll(Model model) {
		model.addAttribute("newCampList", campDao.newCampSelectAll());
		model.addAttribute("campList", campDao.allLocationCamp());
	}

	//해당지역 캠핑장 목록 출력
	@Override
	public void campLocation(Model model, CampVo campVo) {
		model.addAttribute("campList", campDao.locationCamp(campVo));
	}
	
	//해당 캠핑장이 공식그룹이 있는지 체크
	//공식그룹이 있으면 공식그룹 데이터값 저장(모델에 담아두기)
	//해당 캠핑장 정보 출력
	//한줄평 출력
	//한줄평 갯수 출력
	//해당캠핑장과 같은지역의 캠핑장 목록 출력
	@Override
	public void campSelectOne(Model model, CampVo campVo) {
		int ventureGroupCheck = campDao.ventureGroupCheck(campVo);
		if (ventureGroupCheck > 0) {
			model.addAttribute("ventureGroup", campDao.campVentureGroup(campVo));
		}
		
		model.addAttribute("camp", campDao.campInfoSelectOne(campVo));
		
		campLocation(model, campVo);
	}

	//캠핑장 좋아요등록
	//캠핑장 좋아요 등록시 좋아요 갯수 +1
	//내 좋아요목록 갱신
	@Override
	public void likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//캠핑장 좋아요해제
	//캠핑장 좋아요 해제시 좋아요 갯수 -1
	//내 좋아요목록 갱신
	@Override
	public void likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//캠핑장 북마크등록
	//내 북마크목록 갱신
	@Override
	public void bookInsertOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		// TODO Auto-generated method stub
		
	}

	//캠핑장 북마크해제
	//내 북마크목록 갱신
	@Override
	public void bookDeleteOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		// TODO Auto-generated method stub
		
	}

	//한줄평 등록
	//한줄평 등록시 캠핑장 평점업데이트
	@Override
	public void reviewInsertOne(Model model, CampReviewVo campReviewVo) {
		// TODO Auto-generated method stub
		
	}

	//한줄평 삭제
	@Override
	public void reviewDeleteOne(Model model, CampReviewVo campReviewVo) {
		// TODO Auto-generated method stub
		
	}

	//해당 캠핑장 신고
	//캠핑장주인 신고당한횟수 +1
	@Override
	public void campReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}



}
