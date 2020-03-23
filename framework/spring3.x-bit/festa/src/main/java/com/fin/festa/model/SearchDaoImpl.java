package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

@Repository
public class SearchDaoImpl implements SearchDao{

	@Autowired
	SqlSession sqlSession;

	/////////////////////////////////////////////////////////
	///////////////////검색페이지 출력///////////////////////
	/////////////////////////////////////////////////////////
	
	//검색했을시 캠핑장정보 출력
	@Override
	public List<CampVo> searchCampSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//검색했을시 그룹정보 출력
	@Override
	public List<GroupVo> searchGroupSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//검색했을시 내피드정보 출력
	@Override
	public List<MyPostVo> searchMyFeedSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//검색했을시 그룹피드정보 출력
	@Override
	public List<GroupPostVo> searchGroupFeedSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////
	/////////////////피드상세페이지 출력/////////////////////
	/////////////////////////////////////////////////////////
	
	//개인피드 상세페이지
	@Override
	public MyPostVo myFeedDetail(MyPostVo post) {
		// TODO Auto-generated method stub
		return null;
	}

	//그룹피드 상세페이지
	@Override
	public GroupPostVo groupFeedDetail(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return null;
	}

	//내피드 댓글출력
	@Override
	public List<MyCommentVo> myFeedCmmtSelectAll(MyPostVo post) {
		// TODO Auto-generated method stub
		return null;
	}

	//그룹피드 댓글출력
	@Override
	public List<GroupCommentVo> groupFeedCmmtSelectAll(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////
	///////////////피드,댓글 등록,수정,삭제//////////////////
	/////////////////////////////////////////////////////////
	
	//내피드수정
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹피드수정
	@Override
	public int groupFeedUpdateOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내피드삭제
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹피드삭제
	@Override
	public int groupFeedDeleteOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내피드 댓글등록
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		
	}

	//그룹피드 댓글등록
	@Override
	public void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		
	}

	//내피드 댓글삭제
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹피드 댓글삭제
	@Override
	public int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	/////////////////////////////////////////////////////////
	/////////////////피드 좋아요등록,해제////////////////////
	/////////////////////////////////////////////////////////
	
	//내피드 좋아요등록
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//그룹피드 좋아요등록
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//내피드 좋아요해제
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹피드 좋아요해제
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내피드 좋아요등록시 피드좋아요 갯수+1
	@Override
	public int myFeedLikePlusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹피드 좋아요등록시 피드좋아요 갯수+1
	@Override
	public int groupFeedLikePlusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내피드 좋아요해제시 피드좋아요 갯수-1
	@Override
	public int myFeedLikeMinusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹피드 좋아요해제시 피드좋아요 갯수-1
	@Override
	public int groupFeedLikeMinusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내 좋아요목록 갱신
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////
	////////////////////피드 신고등록////////////////////////
	/////////////////////////////////////////////////////////
	
	//내피드신고등록
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//그룹피드신고등록
	@Override
	public void groupFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}
	
	//피드신고등록시 신고당한사람 신고당한횟수 +1
	@Override
	public int feedUserReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}


}
