package com.fin.festa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
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
	//ķ���� ������ ����Ʈ
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String campSelectAll(Model model, CampVo campVo) {
		String caaddrsel = campVo.getCaaddrsel();
		if (caaddrsel == null) {		// ù ������ �ʱ�ȭ
			campVo.setCaaddrsel("");
		}
		campService.campSelectAll(model);
		campService.campLocation(model, campVo);
		return "camp/index";
	}
	
	//ķ���� ��������
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String campSelectOne(Model model, CampVo campVo) {
		campService.campSelectOne(model, campVo);
		campService.sameLocation(model, campVo);
		return "camp/detail/index";
	}
	
	//ķ���� ���ƿ�
	@RequestMapping(value = "detail/likeadd", method = RequestMethod.POST)
	public String likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "camp/detail/index";
	}
	
	//ķ���� ���ƿ� ���
	@RequestMapping(value = "detail/likedel", method = RequestMethod.POST)
	public String likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "camp/detail/index";
	}
	
	//ķ���� �ϸ�ũ
	@RequestMapping(value = "detail/bookadd", method = RequestMethod.POST)
	public String bookInsertOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		return "camp/detail/index";
	}
	
	//ķ���� �ϸ�ũ ���
	@RequestMapping(value = "detail/bookdel", method = RequestMethod.POST)
	public String bookDeleteOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		return "camp/detail/index";
	}
	
	//ķ���� ������ �Է�
	@RequestMapping(value = "detail/revadd", method = RequestMethod.POST)
	public String reviewInsertOne(HttpServletRequest req, CampReviewVo campReviewVo) {
		campService.reviewInsertOne(req, campReviewVo);
		return "camp/detail/index";
	}
	
	//ķ���� ������ ���� (�����˾� ���)
	@RequestMapping(value = "detail/revdel", method = RequestMethod.POST)
	public String reviewDeleteOne(CampReviewVo campReviewVo) {
		campService.reviewDeleteOne(campReviewVo);
		return "camp/detail/index";
	}

	//ķ���� �Ű� (�˾�)
	@RequestMapping(value = "detail/report", method = RequestMethod.GET)
	public String campReport(Model model, CampVo campVo) {
		model.addAttribute("campReport", campVo);
		return "camp/detail/report";
	}
	
	//ķ���� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "detail/report", method = RequestMethod.POST)
	public String campReport(HttpServletRequest req, MultipartFile[] files, ReportListVo reportListVo) {
		campService.campReport(req, files, reportListVo);
		System.out.println(reportListVo);
		return "camp/detail/index";
	}
}
