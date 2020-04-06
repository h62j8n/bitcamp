package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fin.festa.model.NewsDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;

@Service
public class NewsServiceImpl implements NewsService{

	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	NewsDaoImpl newsDao;
	
	//�����ǵ� ���(�׷��ǵ�,�����ǵ� ���ļ�)
	@Override
	public void newsFeedSelectAll(Model model, MyFollowingVo myFollowingVo) {
		model.addAttribute("fwFeedList", newsDao.followFeedSelectAll(myFollowingVo));
		model.addAttribute("fwCmmtList", newsDao.followCommentSelectAll(myFollowingVo));
		model.addAttribute("gpFeedList", newsDao.joinGroupFeedSelectAll(myFollowingVo));
		model.addAttribute("gpCmmtList", newsDao.joinGroupCommentSelectAll(myFollowingVo));
	}

	//�����ǵ� ��۵��(�׷��ǵ�,�����ǵ� �����ؼ� ���)
	@Override
	public void newsFeedCmmtInsertOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ� ��ۻ���(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void newsFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ� ���ƿ���(�׷��ǵ�,�����ǵ� �����ؼ� ���ƿ���)
	//�����ǵ� ���ƿ䰹�� +1
	//�� ���ƿ��� ����
	@Override
	public void newsLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ� ���ƿ�����(�׷��ǵ�,�����ǵ� �����ؼ� ���ƿ�����)
	//�����ǵ� ���ƿ䰹�� -1
	//�� ���ƿ��� ����
	@Override
	public void newsLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ� �Ű���(�׷��ǵ�,�����ǵ� �����ؼ� �Ű���)
	//�Ű�������� �Ű����Ƚ�� +1
	@Override
	public void newsFeedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ� ����(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void newsFeedUpdateOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ� ����(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void newsFeedDeleteOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {
		// TODO Auto-generated method stub
		
	}

}
