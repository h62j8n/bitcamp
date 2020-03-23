package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

public interface SearchService {

		void search(Model model, PageSearchVo pageSearchVo);
		
		void searchFeedDetail(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo);
		
		void searchFeedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo);
		
		void searchFeedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo);
		
		void searchFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo);
		
		void searchFeedCmmtDeletetOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo);
		
		void searchFeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void searchFeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void searchFeedReport(Model model, ReportListVo reportListVo);
}
