package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fin.festa.model.FeedDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;

@Service
public class FeedServiceImpl implements FeedService{

	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	FeedDaoImpl feedDao;
	
	//�α��ǵ� ���(�׷��ǵ�,�����ǵ� ���ļ�)
	@Override
	public void hotFeedSelectAll(Model model) {
		// TODO Auto-generated method stub
		
	}

	//�α��ǵ� ��۵��(�׷��ǵ�,�����ǵ� �����ؼ� ���)
	@Override
	public void hotFeedCmmtInsertOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//�α��ǵ� ��ۻ���(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void hotFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub
		
	}

	//�α��ǵ� ���ƿ���(�׷��ǵ�,�����ǵ� �����ؼ� ���ƿ���)
	//�α��ǵ� ���ƿ䰹�� +1
	//�� ���ƿ��� ����
	@Override
	public void hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//�α��ǵ� ���ƿ�����(�׷��ǵ�,�����ǵ� �����ؼ� ���ƿ�����)
	//�α��ǵ� ���ƿ䰹�� -1
	//�� ���ƿ��� ����
	@Override
	public void hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//�α��ǵ� �Ű���(�׷��ǵ�,�����ǵ� �����ؼ� �Ű���)
	//�ش� �Ű�������� �Ű����Ƚ�� +1
	@Override
	public void hotFeedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//�α��ǵ� ����(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void hotFeedUpdateOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {
		// TODO Auto-generated method stub
		
	}

	//�α��ǵ� ����(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void hotFeedDeleteOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {
		// TODO Auto-generated method stub
		
	}


}
