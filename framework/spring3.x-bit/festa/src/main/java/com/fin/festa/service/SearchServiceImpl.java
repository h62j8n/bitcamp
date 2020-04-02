package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.fin.festa.model.GroupDaoImpl;
import com.fin.festa.model.SearchDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

@Service
public class SearchServiceImpl implements SearchService{

	//������ �ٽ� �պ���
	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	SearchDaoImpl searchDao;

	@Autowired
	GroupDaoImpl groupDao;
	
	//�˻��������� ķ����, �׷�, �ǵ���� (���ļ� ���ƿ�)
	//ķ���� - ķ�����̸����� ���
	//�׷� - �׷������ ���
	//�ǵ�(����,�׷�) - �ؽ��±׷� ���
	@Transactional
	@Override
	public void search(Model model, PageSearchVo pageSearchVo) {
		
		model.addAttribute("searchCamp", searchDao.searchCampSelectAll(pageSearchVo));
		model.addAttribute("searchGroup", searchDao.searchGroupSelectAll(pageSearchVo));
		model.addAttribute("searchGRFeed", searchDao.searchMyFeedSelectAll(pageSearchVo));
		model.addAttribute("searchFeed", searchDao.searchGroupFeedSelectAll(pageSearchVo));
		
		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(pageSearchVo.getPage()==0) {
			pageSearchVo.setPage(1);
		}		
		GroupVo groupVo=new GroupVo();
		groupVo.setPageSearch(pageSearchVo);		
		groupVo.getPageSearch().setTotalCount(groupDao.groupUserTotalCount(groupVo));
		model.addAttribute("userdetail", groupDao.groupUserSearch(groupVo));
		model.addAttribute("pageSearch", groupVo.getPageSearch());
	}

	//�ǵ�������� ���(�׷��ǵ�,�����ǵ� ����) 
	@Override
	public void searchFeedDetail(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}

	//�ǵ����(���ǵ�,�׷��ǵ� ����)
	@Override
	public void searchFeedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}

	//�ǵ����(���ǵ�,�׷��ǵ� ����)
	@Override
	public void searchFeedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}
	
	//�ǵ��۵��(���ǵ�,�׷��ǵ� ����)
	@Override
	public void searchFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//�ǵ��ۻ���(���ǵ�,�׷��ǵ� ����)
	@Override
	public void searchFeedCmmtDeletetOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//�ǵ�Ű�(���ǵ�,�׷��ǵ� ����)
	//�Ű���ѻ�� �Ű����Ƚ�� +1
	@Override
	public void searchFeedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//�ǵ����ƿ���(���ǵ�,�׷��ǵ� ����)
	//�ش��ǵ� ���ƿ� ���� +1
	//�� ���ƿ��� ����
	@Override
	public void searchFeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//�ǵ����ƿ�����(���ǵ�,�׷��ǵ� ����)
	//�ش��ǵ� ���ƿ� ���� -1
	//�� ���ƿ��� ����
	@Override
	public void searchFeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	

}
