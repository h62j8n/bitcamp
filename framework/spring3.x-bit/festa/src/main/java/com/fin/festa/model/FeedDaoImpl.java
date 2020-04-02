package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.FeedVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
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
	public List<FeedVo> hotGroupFeedSelectAll() {
		
		return sqlSession.selectList("feed.hotGroupFeedList");
	}

	//�α�׷��ǵ� ������
	@Override
	public List<GroupCommentVo> hotGroupCommentSelectAll(FeedVo feed) {

		return sqlSession.selectList("feed.hotGroupCommentList", feed);
	}
	
	//�αⰳ���ǵ� ���
	@Override
	public List<FeedVo> hotMyFeedSelectAll() {
		
		return sqlSession.selectList("feed.hotMyFeedList");
	}
	
	//�αⰳ���ǵ� ������
	@Override
	public List<MyCommentVo> hotMyCommentSelectAll(FeedVo feed) {
		
		return sqlSession.selectList("feed.hotMyCommentList", feed);
	}

	//�α�׷��ǵ� ��۴�����
	@Override
	public List<GroupCommentVo> groupFeedCmmtMore(GroupPostVo grouppost) {
		
		return sqlSession.selectList("feed.groupFeedCmmtMore", grouppost);
	}

	//�αⰳ���ǵ� ��۴�����
	@Override
	public List<MyCommentVo> myFeedCmmtMore(MyPostVo mypost) {
		
		return sqlSession.selectList("feed.myFeedCmmtMore", mypost);
	}

	//�α�׷��ǵ� �����˾� �����
	@Override
	public FeedVo groupFeedSelectOne(GroupPostVo grouppost) {

		return sqlSession.selectOne("feed.groupFeedSelectOne", grouppost);
	}

	//�αⰳ���ǵ� �����˾� �����
	@Override
	public FeedVo myFeedSelectOne(MyPostVo mypost) {

		return sqlSession.selectOne("feed.myFeedSelectOne", mypost);
	}

	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� ����,���,����/////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//�αⰳ���ǵ� ��۵��
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {

		sqlSession.insert("feed.myFeedCmmtInsert", cmmt);
	}

	//�α�׷��ǵ� ��۵��
	@Override
	public void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt) {

		sqlSession.insert("feed.groupFeedCmmtInsert", groupcmmt);
	}

	//�αⰳ���ǵ� ��ۻ���
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		
		return sqlSession.delete("feed.myFeedCmmtDelete", cmmt);
	}

	//�α�׷��ǵ� ��ۻ���
	@Override
	public int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt) {
		
		return sqlSession.delete("feed.groupFeedCmmtDelete", groupcmmt);
	}
	
	//�αⰳ���ǵ� ����
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		
		return sqlSession.delete("feed.myFeedDelete", post);
	}

	//�α�׷��ǵ� ����
	@Override
	public int GroupFeedDeleteOne(GroupPostVo grouppost) {
		
		return sqlSession.delete("feed.groupFeedDelete", grouppost);
	}

	//�αⰳ���ǵ� ����
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		
		return sqlSession.update("feed.myFeedUpdate", post);
	}

	//�α�׷��ǵ� ����
	@Override
	public int groupFeedUpdateOne(GroupPostVo grouppost) {
		
		return sqlSession.update("feed.groupFeedUpdate", grouppost);
	}

	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� ���ƿ���,����////////////////////////
	//////////////////////////////////////////////////////////////////////

	//�αⰳ���ǵ� ���ƿ���
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {

		sqlSession.insert("feed.myFeedLikeInsert", good);
	}
	
	//�α�׷��ǵ� ���ƿ���
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {

		sqlSession.insert("feed.groupFeedLikeInsert", good);
	}

	//�αⰳ���ǵ� ���ƿ�����
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		
		return sqlSession.delete("feed.myFeedLikeDelete", good);
	}
	
	//�α�׷��ǵ� ���ƿ�����
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		
		return sqlSession.delete("feed.groupFeedLikeDelete", good);
	}
	
	//�αⰳ���ǵ� ���ƿ��Ͻ� �����ǵ����ƿ� ���� +1
	@Override
	public int myFeedLikeOnePlus(MyPostVo post) {

		return sqlSession.update("feed.myFeedLikeOnePlus", post);
	}

	//�α�׷��ǵ� ���ƿ��Ͻ� �׷��ǵ����ƿ� ����+1
	@Override
	public int groupFeedLikeOnePlus(GroupPostVo grouppost) {
		
		return sqlSession.update("feed.groupFeedLikeOnePlus", grouppost);
	}

	//�αⰳ���ǵ� ���ƿ������� �����ǵ����ƿ� ���� -1
	@Override
	public int myFeedLikeOneMinus(MyPostVo post) {
		
		return sqlSession.update("feed.myFeedLikeOneMinus", post);
	}

	//�α�׷��ǵ� ���ƿ������� �׷��ǵ����ƿ� ���� -1
	@Override
	public int groupFeedLikeOneMinus(GroupPostVo grouppost) {
		
		return sqlSession.update("feed.groupFeedLikeOneMinus", grouppost);
	}

	//�� ���ƿ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		
		return sqlSession.selectList("feed.myGoodRenewal", good);
	}
	
	//////////////////////////////////////////////////////////////////////
	/////////////////////�ǵ�,��� �Ű���///////////////////////////////
	//////////////////////////////////////////////////////////////////////
	
	//�αⰳ���ǵ� �Ű���
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {

		sqlSession.insert("feed.myFeedReportInsert", report);
	}
	
	//�α�׷��ǵ� �Ű���
	@Override
	public void groupFeedReportInsertOne(ReportListVo report) {

		sqlSession.insert("feed.groupFeedReportInsert", report);
	}

	//�ش� �Ű�������� �Ű����Ƚ�� +1
	@Override
	public int feedReportCountUpdate(ReportListVo report) {

		return sqlSession.update("feed.feedReportCountUpdate", report);
	}

	

}
