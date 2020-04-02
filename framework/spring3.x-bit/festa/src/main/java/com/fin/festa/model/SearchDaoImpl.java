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
		return sqlSession.selectList("search.searchCampSelectAll", search);
	}

	//�˻������� �׷����� ���
	@Override
	public List<GroupVo> searchGroupSelectAll(PageSearchVo search) {
		return sqlSession.selectList("search.searchGroupSelectAll", search);
	}

	//�˻������� ���ǵ����� ���
	@Override
	public List<MyPostVo> searchMyFeedSelectAll(PageSearchVo search) {
		return sqlSession.selectList("search.searchMyFeedSelectAll", search);
	}

	//�˻������� �׷��ǵ����� ���
	@Override
	public List<GroupPostVo> searchGroupFeedSelectAll(PageSearchVo search) {
		return sqlSession.selectList("search.searchGroupFeedSelectAll", search);
	}

	/////////////////////////////////////////////////////////
	/////////////////�ǵ�������� ���/////////////////////
	/////////////////////////////////////////////////////////
	
	//�����ǵ� ��������
	@Override
	public MyPostVo myFeedDetail(MyPostVo post) {
		return sqlSession.selectOne("search.myFeedDetail", post);
	}

	//�׷��ǵ� ��������
	@Override
	public GroupPostVo groupFeedDetail(GroupPostVo grouppost) {
		return sqlSession.selectOne("search.groupFeedDetail", grouppost);
	}

	//���ǵ� ������
	@Override
	public List<MyCommentVo> myFeedCmmtSelectAll(MyPostVo post) {
		return sqlSession.selectList("search.myFeedCmmtSelectAll", post);
	}

	//�׷��ǵ� ������
	@Override
	public List<GroupCommentVo> groupFeedCmmtSelectAll(GroupPostVo grouppost) {
		return sqlSession.selectList("search.groupFeedCmmtSelectAll", grouppost);
	}

	/////////////////////////////////////////////////////////
	///////////////�ǵ�,��� ���,����,����//////////////////
	/////////////////////////////////////////////////////////
	
	//���ǵ����
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		return sqlSession.update("search.myFeedUpdateOne", post);
	}

	//�׷��ǵ����
	@Override
	public int groupFeedUpdateOne(GroupPostVo grouppost) {
		return sqlSession.update("search.groupFeedUpdateOne", grouppost);
	}

	//���ǵ����
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		return sqlSession.delete("search.myFeedDeleteOne", post);
	}

	//�׷��ǵ����
	@Override
	public int groupFeedDeleteOne(GroupPostVo grouppost) {
		return sqlSession.delete("search.groupFeedDeleteOne", grouppost);
	}

	//���ǵ� ��۵��
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {
		sqlSession.insert("search.myFeedCmmtInsertOne", cmmt);
	}

	//�׷��ǵ� ��۵��
	@Override
	public void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt) {
		sqlSession.insert("search.groupFeedCmmtInsertOne", groupcmmt);
	}

	//���ǵ� ��ۻ���
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		return sqlSession.delete("search.myFeedCmmtDeleteOne", cmmt);
	}

	//�׷��ǵ� ��ۻ���
	@Override
	public int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt) {
		return sqlSession.delete("search.groupFeedCmmtDeleteOne", groupcmmt);
	}

	/////////////////////////////////////////////////////////
	/////////////////�ǵ� ���ƿ���,����////////////////////
	/////////////////////////////////////////////////////////
	
	//���ǵ� ���ƿ���
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {
		sqlSession.insert("search.myFeedLikeInsertOne", good);
	}

	//�׷��ǵ� ���ƿ���
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		sqlSession.insert("search.groupFeedLikeInsertOne", good);
	}

	//���ǵ� ���ƿ�����
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		return sqlSession.delete("search.myFeedLikeDeleteOne", good);
	}

	//�׷��ǵ� ���ƿ�����
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		return sqlSession.delete("search.groupFeedLikeDeleteOne", good);
	}

	//���ǵ� ���ƿ��Ͻ� �ǵ����ƿ� ����+1
	@Override
	public int myFeedLikePlusOne(MyGoodVo good) {
		return sqlSession.update("search.myFeedLikePlusOne", good);
	}

	//�׷��ǵ� ���ƿ��Ͻ� �ǵ����ƿ� ����+1
	@Override
	public int groupFeedLikePlusOne(MyGoodVo good) {
		return sqlSession.update("search.groupFeedLikePlusOne", good);
	}

	//���ǵ� ���ƿ������� �ǵ����ƿ� ����-1
	@Override
	public int myFeedLikeMinusOne(MyGoodVo good) {
		return sqlSession.update("search.myFeedLikeMinusOne", good);
	}

	//�׷��ǵ� ���ƿ������� �ǵ����ƿ� ����-1
	@Override
	public int groupFeedLikeMinusOne(MyGoodVo good) {
		return sqlSession.update("search.groupFeedLikeMinusOne", good);
	}

	//�� ���ƿ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		return sqlSession.selectList("search.myGoodRenewal", good);
	}

	/////////////////////////////////////////////////////////
	////////////////////�ǵ� �Ű���////////////////////////
	/////////////////////////////////////////////////////////
	
	//���ǵ�Ű���
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {
		sqlSession.insert("search.myFeedReportInsertOne", report);
	}

	//�׷��ǵ�Ű���
	@Override
	public void groupFeedReportInsertOne(ReportListVo report) {
		sqlSession.insert("search.groupFeedReportInsertOne", report);
	}
	
	//�ǵ�Ű��Ͻ� �Ű���ѻ�� �Ű����Ƚ�� +1
	@Override
	public int feedUserReportCountUpdate(ReportListVo report) {
		return sqlSession.update("search.feedUserReportCountUpdate", report);
	}


}
