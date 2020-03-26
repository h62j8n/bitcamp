package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;

@Repository
public class GroupDaoImpl implements GroupDao{

	@Autowired
	SqlSession sqlSession;

	////////////////////////////////////////////////////////////////
	/////////////////////그룹화면출력 전 체크///////////////////////
	////////////////////////////////////////////////////////////////
	
	//공식그룹 유무 체크
	@Override
	public int groupVentureCheck(GroupVo group) {
		return sqlSession.selectOne("group.groupVentureCheck", group);
	}

	//가입된 그룹인지 체크
	@Override
	public int joinGroupCheck(UpdateWaitVo wait) {
		return sqlSession.selectOne("group.joinGroupCheck", wait);
	}

	//승인대기 체크
	public int updateGroupCheck(UpdateWaitVo wait) {
		return sqlSession.selectOne("group.updateGroupCheck", wait);
	}
	
	//그룹 가입신청
	@Override
	public void joinGroupRequest(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		
	}
	
	////////////////////////////////////////////////////////////////
	///////////////////////////화면출력/////////////////////////////
	////////////////////////////////////////////////////////////////
	
	//메인화면 그룹정보출력
	@Override
	public GroupVo groupSelectOne(GroupVo group) {
		return sqlSession.selectOne("group.groupSelectOne", group);
	}
	
	//그룹공지사항 출력
	@Override
	public List<GroupNoticeVo> groupNoticeSelectAll(GroupVo group) {
		return sqlSession.selectList("group.groupNotice", group);
	}

	//그룹공지사항 상세
	@Override
	public GroupNoticeVo groupNoticeSelectOne(GroupNoticeVo notice) {
		return sqlSession.selectOne("group.groupNoticeDetail", notice);
	}

	//그룹공지사항 댓글출력
	@Override
	public List<GroupNoticeCommentVo> groupNoticeCmmtSelectAll(GroupNoticeVo notice) {
		return sqlSession.selectList("group.groupNoticeCmmt", notice);
	}
	
	//그룹피드 댓글 더보기
	public List<GroupCommentVo> groupDetailCmmt(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("group.groupDetailCmmt", grouppost);
	}

	//그룹공지사항 댓글 더보기
	public List<GroupNoticeCommentVo> groupNoticeDetailCmmt(GroupNoticeVo groupnotice) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("group.groupNoticeDetailCmmt", groupnotice);
	}

	
	//그룹피드 출력
	@Override
	public List<GroupPostVo> groupFeedSelectAll(GroupVo group) {
		return sqlSession.selectList("group.groupFeed", group);
	}

	//그룹피드 댓글출력
	@Override
	public List<GroupCommentVo> groupFeedCmmtSelectAll(GroupVo group) {
		return sqlSession.selectList("group.groupFeedCmmt", group);
	}
	
	//그룹인원정보출력
	@Override
	public List<JoinGroupVo> groupUserInfo(GroupVo group) {
		return sqlSession.selectList("group.groupUserInfo", group);
	}

	//가입된그룹 탈퇴
	@Override
	public int groupOut(JoinGroupVo joinGroup) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	////////////////////////////////////////////////////////////////
	//////////////그룹 피드,공지,댓글 등록,수정,삭제////////////////
	////////////////////////////////////////////////////////////////
	
	//그룹공지사항 등록
	@Override
	public void groupNoticeInsert(GroupNoticeVo notice) {
		sqlSession.insert("group.groupNoticeInsert", notice);
	}

	//그룹피드 등록
	@Override
	public void groupFeedInsert(GroupPostVo post) {
		sqlSession.insert("group.groupFeedInsert", post);
	}

	//그룹 피드댓글 등록
	@Override
	public void groupFeedCmmtInsert(GroupCommentVo cmmt) {
		sqlSession.insert("group.groupFeedCmmtInsert", cmmt);
	}

	//그룹 피드댓글 삭제
	@Override
	public int groupFeedCmmtDelete(GroupCommentVo cmmt) {
		return sqlSession.delete("group.groupFeedCmmtDelete", cmmt);
	}
	
	//그룹공지사항 댓글등록
	@Override
	public void groupNoticeCmmtInsert(GroupNoticeCommentVo groupnoticecmmt) {
		sqlSession.insert("group.groupNoticeCmmtInsert", groupnoticecmmt);
	}

	//그룹공지사항 댓글삭제
	@Override
	public void groupNoticeCmmtDelete(GroupNoticeCommentVo groupnoticecmmt) {
		sqlSession.delete("group.groupNoticeCmmtDelete", groupnoticecmmt);
	}
	
	//그룹피드 수정
	@Override
	public int groupFeedUpdate(GroupPostVo post) {
		return 0;
	}

	//그룹 공지사항 수정
	@Override
	public int groupNoticeUpdate(GroupNoticeVo notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹 피드 삭제
	@Override
	public int groupFeedDelete(GroupPostVo post) {
		return sqlSession.delete("group.groupFeedDelete", post);
	}


	//그룹 공지사항 삭제
	@Override
	public int groupNoticeDelete(GroupNoticeVo notice) {
		// TODO Auto-generated method stub
		return sqlSession.delete("group.groupNoticeDelete", notice);
	}

	////////////////////////////////////////////////////////////////
	/////////////////////그룹,피드,공지 신고////////////////////////
	////////////////////////////////////////////////////////////////

	//그룹 신고등록
	@Override
	public void groupReportInsert(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//그룹피드 신고등록
	@Override
	public void groupFeedReportInsert(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//그룹공지사항 신고등록
	@Override
	public void groupNoticeReportInsert(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//신고당한 유저 신고당한횟수 +1
	@Override
	public int groupReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	/////////////////////피드좋아요 등록,해제///////////////////////
	////////////////////////////////////////////////////////////////

	//피드좋아요등록
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//피드좋아요해제
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//피드 좋아요 등록시 피드좋아요 갯수 +1
	@Override
	public int groupFeedLikeOnePlus(GroupPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//피드 좋아요 해제시 피드좋아요 갯수 -1
	@Override
	public int groupFeedLikeOneMinus(GroupPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내 좋아요목록 갱신
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////
	////////////////////팔로잉,팔로워등록,해제//////////////////////
	////////////////////////////////////////////////////////////////

	//내팔로잉 등록
	@Override
	public void myFollowingInsertOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		
	}

	//상대팔로워 등록
	@Override
	public void yourFollowerInsertOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		
	}

	//내팔로잉 해제
	@Override
	public int myFollowingDeleteOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		return 0;
	}

	//상대팔로워 해제
	@Override
	public int yourFollowerDeleteOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		return 0;
	}

	//내 팔로잉목록 갱신
	@Override
	public List<MyFollowingVo> myFollowingRenewal(MyFollowingVo following) {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////
	///////////////////////////그룹관리/////////////////////////////
	////////////////////////////////////////////////////////////////

	//그룹정보 수정
	@Override
	public int groupInfoUpdate(GroupVo group) {
		return sqlSession.update("group.groupInfoUpdate", group);
	}

	////////////////////////////////////////////////////////////////
	//////////////////////////그룹원관리////////////////////////////
	//////////////////////////화면출력//////////////////////////////
	////////////////////////////////////////////////////////////////

	//그룹에 가입된유저정보 출력
	@Override
	public List<ProfileVo> groupUserSelectAll(GroupVo group) {
		// TODO Auto-generated method stub
		return null;
	}

	//그룹에 가입된유저정보 검색값만 출력
	@Override
	public List<ProfileVo> groupUserSearch(GroupVo group) {
		// TODO Auto-generated method stub
		return null;
	}

	//가입유저조회 테이블 로우갯수 뽑기
	@Override
	public int groupUserTotalCount(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	//////////////////////////그룹원관리////////////////////////////
	//////////////////////////회원추방//////////////////////////////
	////////////////////////////////////////////////////////////////

	//그룹유저 추방
	@Override
	public int groupUserKick(JoinGroupVo join) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//그룹유저 추방 시 그룹총원감소 -@
	@Override
	public int groupTotalMinus(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	//그룹유저 모두추방 (그룹장 제외)
	@Override
	public int groupUserAllKick(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	////////////////////////가입신청조회////////////////////////////
	//////////////////////////화면출력//////////////////////////////
	////////////////////////////////////////////////////////////////

	//그룹 가입신청한 유저 출력
	@Override
	public List<UpdateWaitVo> groupRequestSelectAll(GroupVo group) {
		// TODO Auto-generated method stub
		return null;
	}

	//가입신청조회 테이블 로우갯수 뽑기
	@Override
	public int groupRequestTotalCount(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	////////////////////////가입신청조회////////////////////////////
	////////////////////////신청승인,거절///////////////////////////
	////////////////////////////////////////////////////////////////

	//가입신청 승인
	@Override
	public void groupRequestHello(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		
	}

	//가입신청 승인 시 그룹총원증가 +@
	@Override
	public int groupTotalPlus(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	//가입신청 거절
	@Override
	public int groupRequestSorry(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	//////////////////////////그룹삭제//////////////////////////////
	////////////////////////////////////////////////////////////////

	//그룹 삭제
	@Override
	public int groupDelete(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

}
