package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fin.festa.model.CampDaoImpl;
import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.util.CampAvg;

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

	//ķ���� ���ƿ���
	//ķ���� ���ƿ� ��Ͻ� ���ƿ� ���� +1
	//�� ���ƿ��� ����
	@Override
	public void likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//ķ���� ���ƿ�����
	//ķ���� ���ƿ� ������ ���ƿ� ���� -1
	//�� ���ƿ��� ����
	@Override
	public void likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//ķ���� �ϸ�ũ���
	//�� �ϸ�ũ��� ����
	@Override
	public void bookInsertOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		// TODO Auto-generated method stub
		
	}

	//ķ���� �ϸ�ũ����
	//�� �ϸ�ũ��� ����
	@Override
	public void bookDeleteOne(HttpServletRequest req, MyBookMarkVo myBookMarkVo) {
		// TODO Auto-generated method stub
		
	}

	//������ ���
	//������ ��Ͻ� ķ���� ����������Ʈ
	@Override
	public void reviewInsertOne(HttpServletRequest req, CampReviewVo campReviewVo) {
		campDao.campReviewInsert(campReviewVo);
		System.out.println(campReviewVo.toString());
//		System.out.println(campReviewVo.getCrgood());
		CampAvg avg = new CampAvg();
		avg.avgCalculate(campReviewVo);
//		System.out.println(avg.avgCalculate(campReviewVo));
		campDao.campAvgUpdate(campReviewVo);
		
	}

	//������ ����
	@Override
	public void reviewDeleteOne(Model model, CampReviewVo campReviewVo) {
		campDao.campReviewDelete(campReviewVo);
	}

	//�ش� ķ���� �Ű�
	//ķ�������� �Ű����Ƚ�� +1
	@Override
	public void campReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}



}
