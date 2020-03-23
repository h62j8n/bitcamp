package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;

public interface FeedService {

		void hotFeedSelectAll(Model model);
		
		void hotFeedCmmtInsertOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo);
		
		void hotFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo);
		
		void hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void hotFeedReport(Model model, ReportListVo reportListVo);
		
		void hotFeedUpdateOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo);
		
		void hotFeedDeleteOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo);
}
