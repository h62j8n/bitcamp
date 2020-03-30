package com.fin.festa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.FeedDaoImpl;
import com.fin.festa.model.entity.FeedVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.util.DateCalculate;
import com.fin.festa.util.UploadPhoto;

@Service
public class FeedServiceImpl implements FeedService{

	//등록,수정,삭제가 최소2개이상 들어가는 메소드는 꼭 트랜잭션 적용할것!!
	
	@Autowired
	FeedDaoImpl feedDao;
	
	//인기피드 출력(그룹피드,개인피드 합쳐서)
	@Override
	public void hotFeedSelectAll(Model model) {

		DateCalculate cal=new DateCalculate();
		FeedVo feed = new FeedVo();
		List<FeedVo> groupFeedList = feedDao.hotGroupFeedSelectAll();
		List<FeedVo> myFeedList = feedDao.hotMyFeedSelectAll();
		
		//그룹피드댓글뽑음
		feed.setFeedList(groupFeedList);
		model.addAttribute("groupFeedCmmt", feedDao.hotGroupCommentSelectAll(feed));
		//개인피드댓글뽑음
		feed.setFeedList(myFeedList);
		model.addAttribute("myFeedCmmt", feedDao.hotMyCommentSelectAll(feed));
		//피드 날짜순 정렬
		model.addAttribute("feedList", cal.VoDateReturn(groupFeedList, myFeedList));
		
	}

	//인기그룹피드 댓글더보기
	@Override
	public List<GroupCommentVo> groupFeedCmmtMore(Model model, GroupPostVo groupPostVo) {
		
		return feedDao.groupFeedCmmtMore(groupPostVo);
	}

	//인기개인피드 댓글더보기
	@Override
	public List<MyCommentVo> myFeedCmmtMore(Model model, MyPostVo myPostVo) {
		
		return feedDao.myFeedCmmtMore(myPostVo);
	}

	//인기피드 댓글등록(그룹피드,개인피드 구별해서 등록)
	@Override
	public void hotFeedCmmtInsertOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {

		//개인피드 댓글등록
		if(groupCommentVo.getGpnum()==0) {
			feedDao.myFeedCmmtInsertOne(myCommentVo);
		//그룹피드 댓글등록
		}else {
			feedDao.groupFeedCmmtInsertOne(groupCommentVo);
		}
	}

	//인기피드 댓글삭제(그룹피드,개인피드 구별해서 삭제)
	@Override
	public void hotFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {

		//그룹피드,개인피드 구분
		if(groupCommentVo.getGcnum()==0) {
			feedDao.myFeedCmmtDeleteOne(myCommentVo);
		}else {
			feedDao.groupFeedCmmtDeleteOne(groupCommentVo);
		}
	}

	//인기피드 좋아요등록(그룹피드,개인피드 구별해서 좋아요등록)
	//인기피드 좋아요갯수 +1
	//내 좋아요목록 갱신
	@Transactional
	@Override
	public void hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {

		//개인피드일때
		if(myGoodVo.getGpnum()==0) {
			feedDao.myFeedLikeInsertOne(myGoodVo);
			
			MyPostVo post=new MyPostVo();
			post.setMpnum(myGoodVo.getMpnum());
			
			feedDao.myFeedLikeOnePlus(post);
		//그룹피드일때
		}else {
			feedDao.groupFeedLikeInsertOne(myGoodVo);
			
			GroupPostVo grouppost=new GroupPostVo();
			grouppost.setGpnum(myGoodVo.getGpnum());
			
			feedDao.groupFeedLikeOnePlus(grouppost);
		}
		req.getSession().setAttribute("goodlist", feedDao.myGoodRenewal(myGoodVo));
	}

	//인기피드 좋아요해제(그룹피드,개인피드 구별해서 좋아요해제)
	//인기피드 좋아요갯수 -1
	//내 좋아요목록 갱신
	@Transactional
	@Override
	public void hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {

		//개인피드일때
		if(myGoodVo.getGpnum()==0) {
			feedDao.myFeedLikeDeleteOne(myGoodVo);
			
			MyPostVo post=new MyPostVo();
			post.setMpnum(myGoodVo.getMpnum());
			
			feedDao.myFeedLikeOneMinus(post);
		//그룹피드일때
		}else {
			feedDao.groupFeedLikeDeleteOne(myGoodVo);
			
			GroupPostVo grouppost=new GroupPostVo();
			grouppost.setGpnum(myGoodVo.getGpnum());
			
			feedDao.groupFeedLikeOneMinus(grouppost);
		}
		req.getSession().setAttribute("goodlist", feedDao.myGoodRenewal(myGoodVo));
	}

	//인기피드 신고등록(그룹피드,개인피드 구별해서 신고등록)
	//해당 신고당한유저 신고당한횟수 +1
	@Transactional
	@Override
	public void hotFeedReport(HttpServletRequest req, ReportListVo reportListVo, MultipartFile[] files) {

		UploadPhoto up = new UploadPhoto();
		String rlphoto = up.upload(files, req, reportListVo);
		reportListVo.setRlphoto(rlphoto);
		
		//기타버튼눌렀다가 다른거체크하고 넘어온경우 다른거체크값으로 대체
		String rlreport = reportListVo.getRlreport();
		String[] report = rlreport.split(",");
		if(report.length>1) {
			if(report[0].equals("기타")) {
				rlreport = report[1];
			}else {
				rlreport = report[0];
			}
		}else {
			rlreport=rlreport.substring(0, rlreport.length()-1);
		}
		reportListVo.setRlreport(rlreport);
		
		//개인피드인지 그룹피드인지 체크
		if(reportListVo.getGpnum()==0) {
			feedDao.myFeedReportInsertOne(reportListVo);
		}else {
			feedDao.groupFeedReportInsertOne(reportListVo);
		}
		
		feedDao.feedReportCountUpdate(reportListVo);
	}

	//인기피드 수정(그룹피드,개인피드 구별해서 수정)
	@Override
	public void hotFeedUpdateOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {
		// TODO Auto-generated method stub
		
	}

	//인기피드 삭제(그룹피드,개인피드 구별해서 삭제)
	@Override
	public void hotFeedDeleteOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {

		//그룹피드,개인피드 구분
		if(groupPostVo.getGpnum()==0) {
			feedDao.myFeedDeleteOne(myPostVo);
		}else {
			feedDao.GroupFeedDeleteOne(groupPostVo);
		}
	}


}
