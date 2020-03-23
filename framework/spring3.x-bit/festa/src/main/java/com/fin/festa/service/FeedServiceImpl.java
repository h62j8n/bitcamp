package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fin.festa.model.FeedDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;

@Service
public class FeedServiceImpl implements FeedService{

	//등록,수정,삭제가 최소2개이상 들어가는 메소드는 꼭 트랜잭션 적용할것!!
	
	@Autowired
	FeedDaoImpl feedDao;
	
	//인기피드 출력(그룹피드,개인피드 합쳐서)
	@Override
	public void hotFeedSelectAll(Model model) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 댓글등록(그룹피드,개인피드 구별해서 등록)
	@Override
	public void hotFeedCmmtInsertOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 댓글삭제(그룹피드,개인피드 구별해서 삭제)
	@Override
	public void hotFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 좋아요등록(그룹피드,개인피드 구별해서 좋아요등록)
	//인기피드 좋아요갯수 +1
	//내 좋아요목록 갱신
	@Override
	public void hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 좋아요해제(그룹피드,개인피드 구별해서 좋아요해제)
	//인기피드 좋아요갯수 -1
	//내 좋아요목록 갱신
	@Override
	public void hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 신고등록(그룹피드,개인피드 구별해서 신고등록)
	//해당 신고당한유저 신고당한횟수 +1
	@Override
	public void hotFeedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 수정(그룹피드,개인피드 구별해서 수정)
	@Override
	public void hotFeedUpdateOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 삭제(그룹피드,개인피드 구별해서 삭제)
	@Override
	public void hotFeedDeleteOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {
		// TODO Auto-generated method stub
		
	}


}
