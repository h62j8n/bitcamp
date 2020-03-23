package com.fin.festa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.service.CampService;

@Controller
@RequestMapping("/camp/")
public class CampController {

//////////////////////////////////////////////////////////////////////
//////////////////////////////캠핑장 관련//////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private CampService campService;
	
	//캠핑장 리스트
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String campSelectAll(Model model) {
		return "camp/index";
	}
	
	//캠핑장 지역별 리스트
	@RequestMapping(value = "location", method = RequestMethod.GET)
	public String campLocation(Model model, PageSearchVo pageSearchVo) {
		return "camp/index";
	}
	
	//캠핑장 상세페이지
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String campSelectOne(Model model, CampVo campVo) {
		return "camp/detail";
	}
	
	//캠핑장 좋아요
	@RequestMapping(value = "detail/likeadd", method = RequestMethod.POST)
	public String likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "camp/detail";
	}
	
	//캠핑장 좋아요 취소
	@RequestMapping(value = "detail/likedel", method = RequestMethod.POST)
	public String likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "camp/detail";
	}
	
	//캠핑장 북마크
	@RequestMapping(value = "detail/bookadd", method = RequestMethod.POST)
	public String bookInsertOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		return "camp/detail";
	}
	
	//캠핑장 북마크 취소
	@RequestMapping(value = "detail/bookdel", method = RequestMethod.POST)
	public String bookDeleteOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		return "camp/detail";
	}
	
	//캠핑장 한줄평 입력
	@RequestMapping(value = "detail/revadd", method = RequestMethod.POST)
	public String reviewInsertOne(Model model, CampReviewVo campReviewVo) {
		return "camp/detail";
	}
	
	//캠핑장 한줄평 삭제 (내부팝업 기능)
	@RequestMapping(value = "detail/revdel", method = RequestMethod.POST)
	public String reviewDeleteOne(Model model, CampReviewVo campReviewVo) {
		return "camp/detail";
	}

	//캠핑장 신고 (팝업)
	@RequestMapping(value = "detail/report", method = RequestMethod.GET)
	public String campReport() {
		return "camp/report";
	}
	
	//캠핑장 신고 (팝업>팝업 내 기능)
	@RequestMapping(value = "detail/report", method = RequestMethod.POST)
	public String campReport(Model model, ReportListVo reportListVo) {
		return "camp/detail";
	}
}
