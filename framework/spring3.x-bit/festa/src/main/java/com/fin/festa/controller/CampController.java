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
//////////////////////////////ķ���� ����//////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private CampService campService;
	
	//ķ���� ����Ʈ
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String campSelectAll(Model model) {
		return "camp/index";
	}
	
	//ķ���� ������ ����Ʈ
	@RequestMapping(value = "location", method = RequestMethod.GET)
	public String campLocation(Model model, PageSearchVo pageSearchVo) {
		return "camp/index";
	}
	
	//ķ���� ��������
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String campSelectOne(Model model, CampVo campVo) {
		return "camp/detail";
	}
	
	//ķ���� ���ƿ�
	@RequestMapping(value = "detail/likeadd", method = RequestMethod.POST)
	public String likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "camp/detail";
	}
	
	//ķ���� ���ƿ� ���
	@RequestMapping(value = "detail/likedel", method = RequestMethod.POST)
	public String likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "camp/detail";
	}
	
	//ķ���� �ϸ�ũ
	@RequestMapping(value = "detail/bookadd", method = RequestMethod.POST)
	public String bookInsertOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		return "camp/detail";
	}
	
	//ķ���� �ϸ�ũ ���
	@RequestMapping(value = "detail/bookdel", method = RequestMethod.POST)
	public String bookDeleteOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		return "camp/detail";
	}
	
	//ķ���� ������ �Է�
	@RequestMapping(value = "detail/revadd", method = RequestMethod.POST)
	public String reviewInsertOne(Model model, CampReviewVo campReviewVo) {
		return "camp/detail";
	}
	
	//ķ���� ������ ���� (�����˾� ���)
	@RequestMapping(value = "detail/revdel", method = RequestMethod.POST)
	public String reviewDeleteOne(Model model, CampReviewVo campReviewVo) {
		return "camp/detail";
	}

	//ķ���� �Ű� (�˾�)
	@RequestMapping(value = "detail/report", method = RequestMethod.GET)
	public String campReport() {
		return "camp/report";
	}
	
	//ķ���� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "detail/report", method = RequestMethod.POST)
	public String campReport(Model model, ReportListVo reportListVo) {
		return "camp/detail";
	}
}
