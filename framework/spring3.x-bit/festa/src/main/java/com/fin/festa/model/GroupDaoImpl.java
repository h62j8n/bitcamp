package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;

@Repository
public class GroupDaoImpl implements GroupDao{

	@Autowired
	SqlSession sqlSession;

	////////////////////////////////////////////////////////////////
	/////////////////////�׷�ȭ����� �� üũ///////////////////////
	////////////////////////////////////////////////////////////////
	
	//���ı׷� ���� üũ
	@Override
	public int groupVentureCheck(GroupVo group) {
		return sqlSession.selectOne("group.groupVentureCheck", group);
	}

	//���Ե� �׷����� üũ
	@Override
	public int joinGroupCheck(UpdateWaitVo wait) {
		return sqlSession.selectOne("group.joinGroupCheck", wait);
	}

	//���δ�� üũ
	public int updateGroupCheck(UpdateWaitVo wait) {
		return sqlSession.selectOne("group.updateGroupCheck", wait);
	}
	
	//�׷� ���Խ�û
	@Override
	public void joinGroupRequest(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		
	}
	
	////////////////////////////////////////////////////////////////
	///////////////////////////ȭ�����/////////////////////////////
	////////////////////////////////////////////////////////////////
	
	//����ȭ�� �׷��������
	@Override
	public GroupVo groupSelectOne(GroupVo group) {
		return sqlSession.selectOne("group.groupSelectOne", group);
	}
	
	//�׷�������� ���
	@Override
	public List<GroupNoticeVo> groupNoticeSelectAll(GroupVo group) {
		return sqlSession.selectList("group.groupNotice", group);
	}

	//�׷�������� ��
	@Override
	public GroupNoticeVo groupNoticeSelectOne(GroupNoticeVo notice) {
		return sqlSession.selectOne("group.groupNoticeDetail", notice);
	}

	//�׷�������� ������
	@Override
	public List<GroupNoticeCommentVo> groupNoticeCmmtSelectAll(GroupNoticeVo notice) {
		return sqlSession.selectList("group.groupNoticeCmmt", notice);
	}
	
	//�׷��ǵ� ��� ������
	public List<GroupCommentVo> groupDetailCmmt(GroupPostVo grouppost) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("group.groupDetailCmmt", grouppost);
	}

	//�׷�������� ��� ������
	public List<GroupNoticeCommentVo> groupNoticeDetailCmmt(GroupNoticeVo groupnotice) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("group.groupNoticeDetailCmmt", groupnotice);
	}

	
	//�׷��ǵ� ���
	@Override
	public List<GroupPostVo> groupFeedSelectAll(GroupVo group) {
		return sqlSession.selectList("group.groupFeed", group);
	}

	//�׷��ǵ� ������
	@Override
	public List<GroupCommentVo> groupFeedCmmtSelectAll(GroupVo group) {
		return sqlSession.selectList("group.groupFeedCmmt", group);
	}
	
	//�׷��ο��������
	@Override
	public List<JoinGroupVo> groupUserInfo(GroupVo group) {
		return sqlSession.selectList("group.groupUserInfo", group);
	}

	//���Եȱ׷� Ż��
	@Override
	public int groupOut(JoinGroupVo joinGroup) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	////////////////////////////////////////////////////////////////
	//////////////�׷� �ǵ�,����,��� ���,����,����////////////////
	////////////////////////////////////////////////////////////////
	
	//�׷�������� ���
	@Override
	public void groupNoticeInsert(GroupNoticeVo notice) {
		sqlSession.insert("group.groupNoticeInsert", notice);
	}

	//�׷��ǵ� ���
	@Override
	public void groupFeedInsert(GroupPostVo post) {
		sqlSession.insert("group.groupFeedInsert", post);
	}

	//�׷� �ǵ��� ���
	@Override
	public void groupFeedCmmtInsert(GroupCommentVo cmmt) {
		sqlSession.insert("group.groupFeedCmmtInsert", cmmt);
	}

	//�׷� �ǵ��� ����
	@Override
	public int groupFeedCmmtDelete(GroupCommentVo cmmt) {
		return sqlSession.delete("group.groupFeedCmmtDelete", cmmt);
	}
	
	//�׷�������� ��۵��
	@Override
	public void groupNoticeCmmtInsert(GroupNoticeCommentVo groupnoticecmmt) {
		sqlSession.insert("group.groupNoticeCmmtInsert", groupnoticecmmt);
	}

	//�׷�������� ��ۻ���
	@Override
	public void groupNoticeCmmtDelete(GroupNoticeCommentVo groupnoticecmmt) {
		sqlSession.delete("group.groupNoticeCmmtDelete", groupnoticecmmt);
	}
	
	//�׷��ǵ� ����
	@Override
	public int groupFeedUpdate(GroupPostVo post) {
		return 0;
	}

	//�׷� �������� ����
	@Override
	public int groupNoticeUpdate(GroupNoticeVo notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷� �ǵ� ����
	@Override
	public int groupFeedDelete(GroupPostVo post) {
		return sqlSession.delete("group.groupFeedDelete", post);
	}


	//�׷� �������� ����
	@Override
	public int groupNoticeDelete(GroupNoticeVo notice) {
		// TODO Auto-generated method stub
		return sqlSession.delete("group.groupNoticeDelete", notice);
	}

	////////////////////////////////////////////////////////////////
	/////////////////////�׷�,�ǵ�,���� �Ű�////////////////////////
	////////////////////////////////////////////////////////////////

	//�׷� �Ű���
	@Override
	public void groupReportInsert(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//�׷��ǵ� �Ű���
	@Override
	public void groupFeedReportInsert(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//�׷�������� �Ű���
	@Override
	public void groupNoticeReportInsert(ReportListVo report) {
		// TODO Auto-generated method stub
		
	}

	//�Ű���� ���� �Ű����Ƚ�� +1
	@Override
	public int groupReportCountUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	/////////////////////�ǵ����ƿ� ���,����///////////////////////
	////////////////////////////////////////////////////////////////

	//�ǵ����ƿ���
	@Override
	public void groupFeedLikeInsertOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		
	}

	//�ǵ����ƿ�����
	@Override
	public int groupFeedLikeDeleteOne(MyGoodVo good) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�ǵ� ���ƿ� ��Ͻ� �ǵ����ƿ� ���� +1
	@Override
	public int groupFeedLikeOnePlus(GroupPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�ǵ� ���ƿ� ������ �ǵ����ƿ� ���� -1
	@Override
	public int groupFeedLikeOneMinus(GroupPostVo post) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�� ���ƿ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////
	////////////////////�ȷ���,�ȷο����,����//////////////////////
	////////////////////////////////////////////////////////////////

	//���ȷ��� ���
	@Override
	public void myFollowingInsertOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		
	}

	//����ȷο� ���
	@Override
	public void yourFollowerInsertOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		
	}

	//���ȷ��� ����
	@Override
	public int myFollowingDeleteOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		return 0;
	}

	//����ȷο� ����
	@Override
	public int yourFollowerDeleteOne(MyFollowingVo following) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�� �ȷ��׸�� ����
	@Override
	public List<MyFollowingVo> myFollowingRenewal(MyFollowingVo following) {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////
	///////////////////////////�׷����/////////////////////////////
	////////////////////////////////////////////////////////////////

	//�׷����� ����
	@Override
	public int groupInfoUpdate(GroupVo group) {
		return sqlSession.update("group.groupInfoUpdate", group);
	}

	////////////////////////////////////////////////////////////////
	//////////////////////////�׷������////////////////////////////
	//////////////////////////ȭ�����//////////////////////////////
	////////////////////////////////////////////////////////////////

	//�׷쿡 ���Ե��������� ���
	@Override
	public List<ProfileVo> groupUserSelectAll(GroupVo group) {
		// TODO Auto-generated method stub
		return null;
	}

	//�׷쿡 ���Ե��������� �˻����� ���
	@Override
	public List<ProfileVo> groupUserSearch(GroupVo group) {
		// TODO Auto-generated method stub
		return null;
	}

	//����������ȸ ���̺� �ο찹�� �̱�
	@Override
	public int groupUserTotalCount(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	//////////////////////////�׷������////////////////////////////
	//////////////////////////ȸ���߹�//////////////////////////////
	////////////////////////////////////////////////////////////////

	//�׷����� �߹�
	@Override
	public int groupUserKick(JoinGroupVo join) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//�׷����� �߹� �� �׷��ѿ����� -@
	@Override
	public int groupTotalMinus(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�׷����� ����߹� (�׷��� ����)
	@Override
	public int groupUserAllKick(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	////////////////////////���Խ�û��ȸ////////////////////////////
	//////////////////////////ȭ�����//////////////////////////////
	////////////////////////////////////////////////////////////////

	//�׷� ���Խ�û�� ���� ���
	@Override
	public List<UpdateWaitVo> groupRequestSelectAll(GroupVo group) {
		// TODO Auto-generated method stub
		return null;
	}

	//���Խ�û��ȸ ���̺� �ο찹�� �̱�
	@Override
	public int groupRequestTotalCount(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	////////////////////////���Խ�û��ȸ////////////////////////////
	////////////////////////��û����,����///////////////////////////
	////////////////////////////////////////////////////////////////

	//���Խ�û ����
	@Override
	public void groupRequestHello(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		
	}

	//���Խ�û ���� �� �׷��ѿ����� +@
	@Override
	public int groupTotalPlus(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	//���Խ�û ����
	@Override
	public int groupRequestSorry(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////////
	//////////////////////////�׷����//////////////////////////////
	////////////////////////////////////////////////////////////////

	//�׷� ����
	@Override
	public int groupDelete(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

}
