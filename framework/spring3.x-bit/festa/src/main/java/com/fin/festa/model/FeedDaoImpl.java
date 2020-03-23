package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;

@Repository
public class FeedDaoImpl implements FeedDao{

	@Autowired
	SqlSession sqlSession;
	
	//////////////////////////////////////////////////////////////////////
	///////////////////////////화면출력///////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//인기그룹피드 출력
	@Override
	public List<GroupPostVo> hotGroupFeedSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//인기그룹피드 댓글출력
	@Override
	public List<GroupCommentVo> hotGroupCommentSelectAll(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//인기개인피드 출력
	@Override
	public List<MyPostVo> hotMyFeedSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//인기개인피드 댓글출력
	@Override
	public List<MyCommentVo> hotMyCommentSelectAll(MyPostVo post) {
		// TODO Auto-generated method stub
		return null;
	}

	//////////////////////////////////////////////////////////////////////
	/////////////////////피드,댓글 수정,등록,삭제/////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//인기개인피드 댓글등록
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		
	}

	//인기그룹피드 댓글등록
	@Override
	public void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		
	}

	//인기개인피드 댓글삭제
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	//인기그룹피드 댓글삭제
	@Override
	public int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//인기개인피드 삭제
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//인기그룹피드 삭제
	@Override
	public int GroupFeedDeleteOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//인기개인피드 수정
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//인기그룹피드 수정
	@Override
	public int groupFeedUpdateOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//////////////////////////////////////////////////////////////////////
	/////////////////////피드,댓글 좋아요등록,해제////////////////////////
	//////////////////////////////////////////////////////////////////////

	//인기개인피드 좋아요등록
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}
	
	//인기그룹피드 좋아요등록
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//인기개인피드 좋아요해제
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//인기그룹피드 좋아요해제
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//인기개인피드 좋아요등록시 개인피드좋아요 갯수 +1
	@Override
	public int myFeedLikeOnePlus(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//인기그룹피드 좋아요등록시 그룹피드좋아요 갯수+1
	@Override
	public int groupFeedLikeOnePlus(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//인기개인피드 좋아요해제시 개인피드좋아요 갯수 -1
	@Override
	public int myFeedLikeOneMinus(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//인기그룹피드 좋아요해제시 그룹피드좋아요 갯수 -1
	@Override
	public int groupFeedLikeOneMinus(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내 좋아요목록 갱신
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////
	/////////////////////피드,댓글 신고등록///////////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//인기개인피드 신고등록
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}
	
	//인기그룹피드 신고등록
	@Override
	public void groupFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//해당 신고당한유저 신고당한횟수 +1
	@Override
	public int feedReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
