package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fin.festa.model.SearchDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

@Service
public class SearchServiceImpl implements SearchService{

	//쿼리문 다시 손볼것
	//등록,수정,삭제가 최소2개이상 들어가는 메소드는 꼭 트랜잭션 적용할것!!
	
	@Autowired
	SearchDaoImpl searchDao;
	
	//검색조건으로 캠핑장, 그룹, 피드출력 (정렬순 좋아요)
	//캠핑장 - 캠핑장이름으로 출력
	//그룹 - 그룹명으로 출력
	//피드(개인,그룹) - 해시태그로 출력
	@Override
	public void search(Model model, PageSearchVo pageSearchVo) {
		// TODO Auto-generated method stub
		
	}

	//피드상세페이지 출력(그룹피드,개인피드 구분) 
	@Override
	public void searchFeedDetail(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}

	//피드수정(내피드,그룹피드 구분)
	@Override
	public void searchFeedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}

	//피드삭제(내피드,그룹피드 구분)
	@Override
	public void searchFeedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}
	
	//피드댓글등록(내피드,그룹피드 구분)
	@Override
	public void searchFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//피드댓글삭제(내피드,그룹피드 구분)
	@Override
	public void searchFeedCmmtDeletetOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//피드신고(내피드,그룹피드 구분)
	//신고당한사람 신고당한횟수 +1
	@Override
	public void searchFeedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//피드좋아요등록(내피드,그룹피드 구분)
	//해당피드 좋아요 갯수 +1
	//내 좋아요목록 갱신
	@Override
	public void searchFeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//피드좋아요해제(내피드,그룹피드 구분)
	//해당피드 좋아요 갯수 -1
	//내 좋아요목록 갱신
	@Override
	public void searchFeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	

}
