package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

@Repository
public class SearchDaoImpl implements SearchDao{

	@Autowired
	SqlSession sqlSession;

	/////////////////////////////////////////////////////////
	///////////////////�˻������� ���///////////////////////
	/////////////////////////////////////////////////////////
	
	//�˻������� ķ�������� ���
	@Override
	public List<CampVo> searchCampSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//�˻������� �׷����� ���
	@Override
	public List<GroupVo> searchGroupSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//�˻������� ���ǵ����� ���
	@Override
	public List<MyPostVo> searchMyFeedSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//�˻������� �׷��ǵ����� ���
	@Override
	public List<GroupPostVo> searchGroupFeedSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////
	/////////////////�ǵ�������� ���/////////////////////
	/////////////////////////////////////////////////////////
	
	//�����ǵ� ��������
	@Override
	public MyPostVo myFeedDetail(MyPostVo post) {
		// TODO Auto-generated method stub
		return null;
	}

	//�׷��ǵ� ��������
	@Override
	public GroupPostVo groupFeedDetail(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return null;
	}

	//���ǵ� ������
	@Override
	public List<MyCommentVo> myFeedCmmtSelectAll(MyPostVo post) {
		// TODO Auto-generated method stub
		return null;
	}

	//�׷��ǵ� ������
	@Override
	public List<GroupCommentVo> groupFeedCmmtSelectAll(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////
	///////////////�ǵ�,��� ���,����,����//////////////////
	/////////////////////////////////////////////////////////
	
	//���ǵ����
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷��ǵ����
	@Override
	public int groupFeedUpdateOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//���ǵ����
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷��ǵ����
	@Override
	public int groupFeedDeleteOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//���ǵ� ��۵��
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		
	}

	//�׷��ǵ� ��۵��
	@Override
	public void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		
	}

	//���ǵ� ��ۻ���
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷��ǵ� ��ۻ���
	@Override
	public int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	/////////////////////////////////////////////////////////
	/////////////////�ǵ� ���ƿ���,����////////////////////
	/////////////////////////////////////////////////////////
	
	//���ǵ� ���ƿ���
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//�׷��ǵ� ���ƿ���
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//���ǵ� ���ƿ�����
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷��ǵ� ���ƿ�����
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//���ǵ� ���ƿ��Ͻ� �ǵ����ƿ� ����+1
	@Override
	public int myFeedLikePlusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷��ǵ� ���ƿ��Ͻ� �ǵ����ƿ� ����+1
	@Override
	public int groupFeedLikePlusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//���ǵ� ���ƿ������� �ǵ����ƿ� ����-1
	@Override
	public int myFeedLikeMinusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷��ǵ� ���ƿ������� �ǵ����ƿ� ����-1
	@Override
	public int groupFeedLikeMinusOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�� ���ƿ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////
	////////////////////�ǵ� �Ű���////////////////////////
	/////////////////////////////////////////////////////////
	
	//���ǵ�Ű���
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//�׷��ǵ�Ű���
	@Override
	public void groupFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}
	
	//�ǵ�Ű��Ͻ� �Ű���ѻ�� �Ű����Ƚ�� +1
	@Override
	public int feedUserReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}


}
