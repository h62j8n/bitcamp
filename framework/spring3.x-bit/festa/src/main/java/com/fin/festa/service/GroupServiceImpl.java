package com.fin.festa.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.GroupDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.util.UploadPhoto;

@Service
public class GroupServiceImpl implements GroupService{

	//등록,수정,삭제가 최소2개이상 들어가는 메소드는 꼭 트랜잭션 적용할것!!
	
	@Autowired
	GroupDaoImpl groupDao;
	

	//가입된 그룹인지 체크
	@Override
	public int joinGroup(HttpServletRequest req, UpdateWaitVo updateWaitVo) {
		int result=groupDao.joinGroupCheck(updateWaitVo);
		int result2=groupDao.updateGroupCheck(updateWaitVo);
		int check=0;
		if(result == 0 && result2 ==0) {				//가입된 그룹이 아님
			return check;
		} else if (result == 0 && result2 == 1){		//승인 대기중
			check=1;
			return check;
		} else {										//그룹원
			check=2;
			return check;
		}
	}

	//공식그룹인지 체크
	//그룹정보출력
	//그룹피드출력
	//그룹공지사항출력
	//그룹피드댓글출력
	@Override
	public void groupSelectOne(HttpServletRequest req, GroupVo groupVo) {
		req.setAttribute("check", groupDao.groupVentureCheck(groupVo));
		req.setAttribute("detail", groupDao.groupSelectOne(groupVo));
		req.setAttribute("feed", groupDao.groupFeedSelectAll(groupVo));
		req.setAttribute("ntc", groupDao.groupNoticeSelectAll(groupVo));
		req.setAttribute("feedcmmt", groupDao.groupFeedCmmtSelectAll(groupVo));
	}

	//공지사항댓글 더보기 비동기
	@Override
	public List<GroupNoticeCommentVo> groupNoticeDetailCmmt(Model model, GroupNoticeVo groupnotice) {
		return groupDao.groupNoticeDetailCmmt(groupnotice);
	}

	//그룹피드댓글 더보기 비동기
	@Override
	public List<GroupCommentVo> groupDetailCmmt(Model model, GroupPostVo grouppost) {
		return groupDao.groupDetailCmmt(grouppost);
	}
	
	//그룹인원정보 출력
	@Override
	public void groupMemberList(HttpServletRequest req, GroupVo groupVo) {
		req.setAttribute("member", groupDao.groupUserInfo(groupVo));
	}
	
	//그룹 신고등록
	//신고당한유저 신고당한횟수 +1
	@Override
	public void groupReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//공지사항 등록
	@Override
	public void noticeInsertOne(HttpServletRequest req, MultipartFile[] files, GroupNoticeVo groupNoticeVo) {
		UploadPhoto up = new UploadPhoto();
		String gnPhoto=up.upload(files, req, groupNoticeVo);
		groupNoticeVo.setGnphoto(gnPhoto);
		groupDao.groupNoticeInsert(groupNoticeVo);
	}

	//공지사항 상세정보출력
	//공지사항 댓글출력
	@Override
	public void noticeSelectOne(HttpServletRequest req, GroupNoticeVo groupNoticeVo) {
		GroupVo group=new GroupVo();
		group.setGrnum(groupNoticeVo.getGrnum());
		req.setAttribute("detail", groupDao.groupSelectOne(group));
		req.setAttribute("ntc", groupDao.groupNoticeSelectAll(group));
		req.setAttribute("ntcDetail", groupDao.groupNoticeSelectOne(groupNoticeVo));
		req.setAttribute("ntcCmmt", groupDao.groupNoticeCmmtSelectAll(groupNoticeVo));
	}
	

	//공지사항 수정
	@Override
	public void noticeUpdateOne(Model model, GroupNoticeVo groupNoticeVo) {
		
	}

	//공지사항 삭제
	@Override
	public void noticeDeleteOne(Model model, GroupNoticeVo groupNoticeVo) {
		groupDao.groupNoticeDelete(groupNoticeVo);
	}

	//공지사항 댓글등록
	@Override
	public void noticeCmmtInsertOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo) {
		groupDao.groupNoticeCmmtInsert(groupNoticeCommentVo);
	}

	//공지사항 댓글삭제
	@Override
	public void noticeCmmtDeleteOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo) {
		groupDao.groupNoticeCmmtDelete(groupNoticeCommentVo);
	}

	//공지사항 신고등록
	//해당유저 신고횟수 +1
	@Override
	public void noticeReport(Model model, ReportListVo reportListVo) {
	}

	//그룹피드 등록
	@Override
	public void groupFeedInsertOne(HttpServletRequest req, MultipartFile[] files, GroupPostVo groupPostVo) {
		UploadPhoto up = new UploadPhoto();
		String mpPhoto=up.upload(files, req, groupPostVo);
		groupPostVo.setGpphoto(mpPhoto);
		groupDao.groupFeedInsert(groupPostVo);
	}

	
	//그룹피드 수정
	@Override
	public void groupFeedUpdateOne(Model model, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}

	//그룹피드 삭제
	@Override
	public void groupFeedDeleteOne(Model model, GroupPostVo groupPostVo) {
		groupDao.groupFeedDelete(groupPostVo);
	}

	//그룹피드 댓글등록
	@Override
	public void groupFeedCmmtInsertOne(HttpServletRequest req, GroupCommentVo groupCommentVo) {
		groupDao.groupFeedCmmtInsert(groupCommentVo);
	}

	//그룹피드 댓글삭제
	@Override
	public void groupFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo) {
		groupDao.groupFeedCmmtDelete(groupCommentVo);
	}

	//그룹피드 좋아요등록
	//피드 좋아요 갯수 +1
	@Override
	public void FeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//그룹피드 좋아요해제
	//피드 좋아요 갯수 -1
	@Override
	public void FeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//그룹피드 신고등록
	//신고당한유저 신고당한횟수 +1
	@Override
	public void groupFeedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//채팅 아직 미구현..
	@Override
	public void groupChat(Model model) {
		// TODO Auto-generated method stub
		
	}

	//그룹관리정보출력

	
	//그룹총원출력
	@Override
	public void groupAdminSelectOne(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//그룹관리 수정
	@Override
	public void groupAdminUpdateOne(HttpServletRequest req, GroupVo groupVo) {
		groupDao.groupInfoUpdate(groupVo);
	}

	//가입된 유저정보 출력
	//페이지 한페이지에 10개 로우
	//검색으로 값이 넘어올경우 검색조건 유저정보 출력(keyword!=null)
	//페이지기능을 위한 가입유저조회 테이블 로우갯수 뽑기
	@Override
	public void groupUserAdminSelectAll(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//가입된 유저 강퇴
	//그룹 가입총원 -@
	@Override
	public void groupUserKick(Model model, JoinGroupVo joinGroupVo) {
		// TODO Auto-generated method stub
		
	}

	//가입된 유저 전부강퇴 (그룹장 제외)
	//그룹 가입총원 -@
	@Override
	public void groupUserAllKick(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//가입신청 유저정보 출력
	//페이지 한페이지에 5개 로우
	//페이지기능을 위한 가입신청조회 테이블 로우갯수 뽑기
	@Override
	public void groupRequestSelectAll(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//가입신청 유저등록
	//그룹 가입총원 +@
	//업데이트테이블 데이터삭제(가입신청 거절 메소드 사용)
	@Override
	public void groupRequestHello(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//가입신청 유저 모두등록(가입신청 승인 메소드 사용)
	//그룹 가입총원 +@
	//업데이트테이블 데이터삭제(가입신청 거절 메소드 사용)
	@Override
	public void groupRequestEverybodyHello(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//가입신청 거절
	@Override
	public void groupRequestSorry(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//가입신청 모두거절(가입신청 거절 메소드 사용)
	@Override
	public void groupRequestVeryverySorry(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//그룹 삭제
	@Override
	public void groupDeleteOne(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//가입된그룹 탈퇴
	@Override
	public void groupOut(Model model, JoinGroupVo joinGroup) {
		// TODO Auto-generated method stub
		
	}

	//회원 팔로잉등록
	//상대 팔로워등록
	//내 팔로잉목록 갱신
	@Override
	public void followInsertOne(HttpServletRequest req, MyFollowingVo myFollowing) {
		// TODO Auto-generated method stub
		
	}

	//회원 팔로잉해제
	//상대 팔로워해제
	//내 팔로잉목록 갱신
	@Override
	public void followDeleteOne(HttpServletRequest req, MyFollowingVo myFollowing) {
		// TODO Auto-generated method stub
		
	}



}
