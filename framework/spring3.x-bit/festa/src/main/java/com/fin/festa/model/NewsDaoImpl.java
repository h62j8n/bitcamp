package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;

@Repository
public class NewsDaoImpl implements NewsDao{

	@Autowired
	SqlSession sqlSession;
	
	//////////////////////////////////////////////////////////////////////
	///////////////////////////ȭ�����///////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//���ȷο��� �ǵ�����
	@Override
	public List<MyPostVo> followFeedSelectAll(MyFollowingVo following) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//���ȷο��� �ǵ�۴�����
	@Override
	public List<MyCommentVo> followCommentSelectAll(MyPostVo post) {
		// TODO Auto-generated method stub
		return null;
	}

	//�����Ա׷��� �ǵ�����
	@Override
	public List<GroupPostVo> joinGroupFeedSelectAll(ProfileVo profile) {
		// TODO Auto-generated method stub
		return null;
	}

	//�����Ա׷��� �ǵ�۴�����
	@Override
	public List<GroupCommentVo> joinGroupCommentSelectAll(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� ����,���,����/////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//�����ǵ�(�����ǵ�) ��۵��
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ�(�׷��ǵ�) ��۵��
	@Override
	public void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ�(�����ǵ�) ��ۻ���
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�׷��ǵ�) ��ۻ���
	@Override
	public int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//�����ǵ�(�����ǵ�) ����
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�׷��ǵ�) ����
	@Override
	public int groupFeedDeleteOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�����ǵ�) ����
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�׷��ǵ�) ����
	@Override
	public int groupFeedUpdateOne(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� ���ƿ���,����////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//�����ǵ�(�����ǵ�) ���ƿ���
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ�(�׷��ǵ�) ���ƿ���
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ�(�����ǵ�) ���ƿ�����
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�׷��ǵ�) ���ƿ�����
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�����ǵ�) ���ƿ��Ͻ� �����ǵ����ƿ� ���� +1
	@Override
	public int myFeedLikeOnePlus(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�׷��ǵ�) ���ƿ��Ͻ� �׷��ǵ����ƿ� ����+1
	@Override
	public int groupFeedLikeOnePlus(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�����ǵ�) ���ƿ������� �����ǵ����ƿ� ���� -1
	@Override
	public int myFeedLikeOneMinus(MyPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�����ǵ�(�׷��ǵ�) ���ƿ������� �׷��ǵ����ƿ� ���� -1
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
	
	//�����ǵ�(�����ǵ�) �Ű���
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//�����ǵ�(�׷��ǵ�) �Ű���
	@Override
	public void groupFeedReportInsertOne(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//�Ű�������� �Ű����Ƚ�� +1
	@Override
	public int feedReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
