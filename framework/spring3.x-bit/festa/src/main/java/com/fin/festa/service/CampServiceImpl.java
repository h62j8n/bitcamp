package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.CampDaoImpl;
import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.util.CampAvg;
import com.fin.festa.util.UploadPhoto;

@Service
public class CampServiceImpl implements CampService{

	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	CampDaoImpl campDao;
	
	//�ű�ķ���� ��� ���
	//����ķ���� ��� ���
	@Override
	public void campSelectAll(Model model) {
		model.addAttribute("newCampList", campDao.newCampSelectAll());
		model.addAttribute("campList", campDao.allLocationCamp());
	}

	//Ư������ ķ���� ��� ���
	@Override
	public void campLocation(Model model, CampVo campVo) {
		model.addAttribute("campList", campDao.locationCamp(campVo));
	}
	
	//�ش� ķ������ ���ı׷��� �ִ��� üũ
	//���ı׷��� ������ ���ı׷� �����Ͱ� ����(�𵨿� ��Ƶα�)
	//�ش� ķ���� ���� ���
	//������ ���� ���
	//������ ���
	//�ش�ķ����� ���������� ķ���� ��� ���
	@Override
	public void campSelectOne(Model model, CampVo campVo) {
		model.addAttribute("ventureGroup", campDao.campVentureGroup(campVo));	// ���ı׷� �����Ͱ� ����(�𵨿� ��Ƶα�)
		
		model.addAttribute("camp", campDao.campInfoSelectOne(campVo));			// �ش� ķ���� ���� ���
		
		int campReviewCount = campDao.campReviewCount(campVo);
		if (campReviewCount > 0) {
			model.addAttribute("campReviewCount", campReviewCount);				// ������ ���� ���
			if(campVo.getPageSearch() == null) {								// ������ ������ �ʱ�ȭ (ù ������)
				PageSearchVo pageSearch = new PageSearchVo();
				pageSearch.setPage2(1);
				campVo.setPageSearch(pageSearch);
			}
			campVo.getPageSearch().setTotalCount2(campReviewCount);				// ������ ������ �� �ο찹��
			model.addAttribute("campReviewList", campDao.campReview(campVo));	// ������ ���
		}
	}
	
	@Override
	public void sameLocation(Model model, CampVo campVo) {
		model.addAttribute("sameList", campDao.sameLocationCamp(campVo));
	}

	//ķ���� ���ƿ���
	//ķ���� ���ƿ� ���� ������Ʈ
	//�� ���ƿ��� ����
	@Transactional
	@Override
	public void likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		campDao.campLikeInsert(myGoodVo);
		
		CampVo camp = new CampVo();
		camp.setCanum(myGoodVo.getCanum());
		campDao.campLikeUpdate(camp);
		
		req.getSession().setAttribute("goodlist", campDao.myGoodRenewal(myGoodVo));
	}

	//ķ���� ���ƿ�����
	//ķ���� ���ƿ� ���� ������Ʈ
	//�� ���ƿ��� ����
	@Transactional
	@Override
	public void likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		campDao.campLikeDelete(myGoodVo);
		
		CampVo camp = new CampVo();
		camp.setCanum(myGoodVo.getCanum());
		campDao.campLikeUpdate(camp);
		
		req.getSession().setAttribute("goodlist", campDao.myGoodRenewal(myGoodVo));
	}

	//ķ���� �ϸ�ũ���
	//�� �ϸ�ũ��� ����
	@Override
	public void bookInsertOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		campDao.campBookMarkInsert(myBookMarkVo);
		req.getSession().setAttribute("bookMark", campDao.mybookRenewal(myBookMarkVo));
		System.out.println(myBookMarkVo);
	}

	//ķ���� �ϸ�ũ����
	//�� �ϸ�ũ��� ����
	@Override
	public void bookDeleteOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		campDao.campBookMarkDelete(myBookMarkVo);
		req.getSession().setAttribute("bookMark", campDao.mybookRenewal(myBookMarkVo));
		System.out.println(myBookMarkVo);
	}

	//������ ���
	//ķ���� ����������Ʈ
	@Transactional
	@Override
	public void reviewInsertOne(HttpServletRequest req, CampReviewVo campReviewVo) {
		campDao.campReviewInsert(campReviewVo);
		campDao.campAvgUpdate(campReviewVo);
	}

	//������ ����
	//ķ���� ����������Ʈ
	@Transactional
	@Override
	public void reviewDeleteOne(CampReviewVo campReviewVo) {
		campDao.campReviewDelete(campReviewVo);
		campDao.campAvgUpdate(campReviewVo);
	}

	//�ش� ķ���� �Ű�
	//ķ�������� �Ű����Ƚ�� +1
	@Transactional
	@Override
	public void campReport(HttpServletRequest req, MultipartFile[] files, ReportListVo reportListVo) {
		UploadPhoto up = new UploadPhoto();
		String rlphoto = up.upload(files, req, reportListVo);
		reportListVo.setRlphoto(rlphoto);
		
		//��Ÿ��ư�����ٰ� �ٸ��� üũ�ϰ� �Ѿ�°�� �ٸ��� üũ������ ��ü
		String rlreport = reportListVo.getRlreport();
		String[] report = rlreport.split(",");
		if(report.length>1) {
			if(report[0].equals("��Ÿ")) {
				rlreport = report[1];
			}else {
				rlreport = report[0];
			}
		}else {
			rlreport=rlreport.substring(0, rlreport.length()-1);
		}
		reportListVo.setRlreport(rlreport);
		
		campDao.campReport(reportListVo);
		campDao.campReportCountUpdate(reportListVo);
	}
}
