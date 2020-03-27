package com.fin.festa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;

public interface GroupService {

		void groupSelectOne(HttpServletRequest req, GroupVo groupVo);

		void groupReport(Model model, ReportListVo reportListVo);

		void noticeInsertOne(HttpServletRequest req, MultipartFile[] files, GroupNoticeVo groupNoticeVo);
		
		void noticeSelectOne(HttpServletRequest req, GroupNoticeVo groupNoticeVo);
		
		void noticeUpdateOne(Model model, GroupNoticeVo groupNoticeVo);
		
		void noticeDeleteOne(Model model, GroupNoticeVo groupNoticeVo);
		
		void noticeCmmtInsertOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo);
		
		void noticeCmmtDeleteOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo);
		
		void noticeReport(Model model, ReportListVo reportListVo);
		
		void groupFeedInsertOne(HttpServletRequest req, MultipartFile[] files, GroupPostVo groupPostVo);

		void groupFeedUpdateOne(Model model, GroupPostVo groupPostVo);
		
		void groupFeedDeleteOne(Model model, GroupPostVo groupPostVo);
		
		void groupFeedCmmtInsertOne(HttpServletRequest req, GroupCommentVo groupCommentVo);
		
		void groupFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo);
		
		void FeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void FeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void groupFeedReport(Model model, ReportListVo reportListVo);

		void groupChat(Model model);
		
		void groupAdminSelectOne(Model model, GroupVo groupVo);
		
		void groupAdminUpdateOne(HttpServletRequest req, GroupVo groupVo);
		
		void groupUserAdminSelectAll(HttpServletRequest req, GroupVo groupVo, PageSearchVo pageSearchVo);
		
		void groupUserKick(Model model, JoinGroupVo joinGroupVo);
		
		void groupUserAllKick(Model model, GroupVo groupVo);
		
		void groupRequestSelectAll(HttpServletRequest req, GroupVo groupVo, PageSearchVo pageSearchVo);
		
		void groupRequestHello(Model model, UpdateWaitVo updateWaitVo);
		
		void groupRequestEverybodyHello(Model model, UpdateWaitVo updateWaitVo);
		
		void groupRequestSorry(Model model, UpdateWaitVo updateWaitVo);
		
		void groupRequestVeryverySorry(Model model, UpdateWaitVo updateWaitVo);

		void groupDeleteOne(HttpServletRequest req, GroupVo groupVo);
		
		void groupOut(Model model, JoinGroupVo joinGroup);
		
		void followInsertOne(HttpServletRequest req, MyFollowingVo myFollowing);
		
		void followDeleteOne(HttpServletRequest req, MyFollowingVo myFollowing);
		
		void groupMemberList(HttpServletRequest req, GroupVo groupVo);
		
		int joinGroup(HttpServletRequest req, UpdateWaitVo updateWaitVo);

		List<GroupCommentVo> groupDetailCmmt(Model model, GroupPostVo grouppost);

		List<GroupNoticeCommentVo> groupNoticeDetailCmmt(Model model, GroupNoticeVo groupnotice);

}
