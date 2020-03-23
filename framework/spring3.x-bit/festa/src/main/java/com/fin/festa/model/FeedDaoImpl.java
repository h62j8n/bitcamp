package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;

@Repository
public class FeedDaoImpl implements FeedDao{

	@Autowired
	SqlSession sqlSession;
	
	//////////////////////////////////////////////////////////////////////
	///////////////////////////ȭ�����///////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//�α�׷��ǵ� ���
	@Override
	public List<GroupPostVo> hotGroupFeedSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//�α�׷��ǵ� ������
	@Override
	public List<GroupCommentVo> hotGroupCommentSelectAll(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//�αⰳ���ǵ� ���
	@Override
	public List<MyPostVo> hotMyFeedSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//�αⰳ���ǵ� ������
	@Override
	public List<MyCommentVo> hotMyCommentSelectAll(MyPostVo post) {
		// TODO Auto-generated method stub
		return null;
	}

	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� ����,���,����/////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//�αⰳ���ǵ� ��۵��
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		
	}

	//�α�׷��ǵ� ��۵��
	@Override
	public void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		
	}

	//�αⰳ���ǵ� ��ۻ���
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�α�׷��ǵ� ��ۻ���
	@Override
	public int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//�αⰳ���ǵ� ����
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�α�׷��ǵ� ����
	@Override
	public int GroupFeedDeleteOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�αⰳ���ǵ� ����
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�α�׷��ǵ� ����
	@Override
	public int groupFeedUpdateOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� ���ƿ���,����////////////////////////
	//////////////////////////////////////////////////////////////////////

	//�αⰳ���ǵ� ���ƿ���
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}
	
	//�α�׷��ǵ� ���ƿ���
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//�αⰳ���ǵ� ���ƿ�����
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//�α�׷��ǵ� ���ƿ�����
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//�αⰳ���ǵ� ���ƿ��Ͻ� �����ǵ����ƿ� ���� +1
	@Override
	public int myFeedLikeOnePlus(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�α�׷��ǵ� ���ƿ��Ͻ� �׷��ǵ����ƿ� ����+1
	@Override
	public int groupFeedLikeOnePlus(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�αⰳ���ǵ� ���ƿ������� �����ǵ����ƿ� ���� -1
	@Override
	public int myFeedLikeOneMinus(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�α�׷��ǵ� ���ƿ������� �׷��ǵ����ƿ� ���� -1
	@Override
	public int groupFeedLikeOneMinus(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�� ���ƿ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� �Ű���///////////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//�αⰳ���ǵ� �Ű���
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}
	
	//�α�׷��ǵ� �Ű���
	@Override
	public void groupFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//�ش� �Ű�������� �Ű����Ƚ�� +1
	@Override
	public int feedReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
