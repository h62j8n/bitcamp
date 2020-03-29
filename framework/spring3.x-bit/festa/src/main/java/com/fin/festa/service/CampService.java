package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

public interface CampService {

		void campSelectAll(Model model);
		
		void campLocation(Model model, CampVo campVo);
		
		void campSelectOne(Model model, CampVo campVo);
		
		void likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo);
		
		void bookInsertOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo);
		
		void bookDeleteOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo);
		
		void reviewInsertOne(HttpServletRequest req, CampReviewVo campReviewVo);
		
		void reviewDeleteOne(Model model, CampReviewVo campReviewVo);
		
		void campReport(Model model, ReportListVo reportListVo);
}
