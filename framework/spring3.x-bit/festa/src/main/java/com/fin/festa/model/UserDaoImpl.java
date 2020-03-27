package com.fin.festa.model;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.LoginVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyFollowerVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.MyVentureVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	SqlSession sqlSession;
	
	////////////////////////////////////////////////////////////
	///////////////////���������� ȭ�����//////////////////////
	////////////////////////////////////////////////////////////
	
	//������ ��Ȱ��ȭ,����,�߹� üũ
	@Override
	public MyAdminVo adminCheck(ProfileVo profile) {
		return sqlSession.selectOne("user.inactiveAndStopAndKick",profile);
	}
	
	//���ǵ��������
	@Override
	public ProfileVo myInfo(ProfileVo profile) {
		return sqlSession.selectOne("user.myInfo",profile);
	}

	//���ǵ帮��Ʈ ���
	@Override
	public List<MyPostVo> myFeedSelectAll(ProfileVo profile) {
		return sqlSession.selectList("user.myFeedSelectAll",profile);
	}

	//���ǵ� ��۸���Ʈ ���
	@Override
	public List<MyCommentVo> myFeedCmmtSelectAll(ProfileVo profile) {
		return sqlSession.selectList("user.myFeedCmmtSelectAll",profile);
	}

	//���ǵ尹�� ���
	@Override
	public int myFeedCount(ProfileVo profile) {
		return sqlSession.selectOne("user.myFeedCount",profile);
	}

	//���ȷο����� ���
	@Override
	public int myFollowerCount(ProfileVo profile) {
		return sqlSession.selectOne("user.myFollowerCount",profile);
	}

	//���ȷ��װ��� ���
	@Override
	public int myFollowingCount(ProfileVo profile) {
		return sqlSession.selectOne("user.myFollowingCount",profile);
	}

	//���ȷο���� ���
	@Override
	public List<MyFollowerVo> myFollowerSelectAll(ProfileVo profile) {
		return sqlSession.selectList("user.myFollowerList",profile);
	}

	//���ȷ��׸�� ���
	@Override
	public List<MyFollowingVo> myFollowingSelectAll(ProfileVo profile) {
		return sqlSession.selectList("user.myFollowingList",profile);
	}

	////////////////////////////////////////////////////////////
	////////////////�ǵ�,��� ���,����,����////////////////////
	////////////////////////////////////////////////////////////	
	
	//���ǵ� ���
	@Override
	public void myFeedInsertOne(MyPostVo post) {
		sqlSession.insert("user.myFeedInsert",post);
	}

	//���ǵ� ����
	@Override
	public int myFeedUpdateOne(MyPostVo post) {
		return sqlSession.update("user.myFeedUpdate",post);
	}

	//���ǵ� ����
	@Override
	public int myFeedDeleteOne(MyPostVo post) {
		return sqlSession.delete("user.myFeedDelete",post);
	}

	//���ǵ��� ���
	@Override
	public void myFeedCmmtInsertOne(MyCommentVo cmmt) {
		sqlSession.insert("user.myFeedCmmtInsert",cmmt);
	}

	//���ǵ��� ����
	@Override
	public int myFeedCmmtDeleteOne(MyCommentVo cmmt) {
		return sqlSession.delete("user.myFeedCmmtDelete",cmmt);
	}

	////////////////////////////////////////////////////////////
	/////////////////////�ȷο� ���,����///////////////////////
	////////////////////////////////////////////////////////////	
	
	//���ȷ��� ���
	@Override
	public void myFollowingInsertOne(MyFollowingVo following) {
		sqlSession.insert("user.myFollowingInsert",following);
	}

	//�����ȷο� ���
	@Override
	public void yourFollowerInsertOne(MyFollowingVo following) {
		sqlSession.insert("user.yourFollowerInsert",following);
	}

	//���ȷ��� ���� 
	@Override
	public int myFollowingDeleteOne(MyFollowingVo following) {
		return sqlSession.delete("user.myFollowingDelete",following);
	}

	//�����ȷο� ����
	@Override
	public int yourFollowerDeleteOne(MyFollowingVo following) {
		return sqlSession.delete("user.yourFollowerDelete");
	}

	//�� �ȷ��׸�� ����
	@Override
	public List<MyFollowingVo> myFollowingRenewal(MyFollowingVo following) {
		return sqlSession.selectList("user.myFollowingRenewal",following);
	}

	////////////////////////////////////////////////////////////
	//////////////////�ǵ����ƿ� ���,����//////////////////////
	////////////////////////////////////////////////////////////	

	//���ǵ� ���ƿ���
	@Override
	public void myFeedLikeInsertOne(MyGoodVo good) {
		sqlSession.insert("user.myFeedLikeInsert",good);
	}

	//���ǵ� ���ƿ�����
	@Override
	public int myFeedLikeDeleteOne(MyGoodVo good) {
		return sqlSession.delete("user.myFeedLikeDelete",good);
	}

	//���ǵ� ���ƿ䰹�� +1
	@Override
	public int myFeedLikeOnePlus(MyPostVo post) {
		return sqlSession.update("user.myFeedLikeOnePlus",post);
	}

	//���ǵ� ���ƿ䰹�� -1
	@Override
	public int myFeedLikeOneMinus(MyPostVo post) {
		return sqlSession.update("user.myFeedLikeOneMinus",post);
	}

	//�� ���ƿ� ��� ����
	@Override
	public List<MyGoodVo> myGoodRenewal(MyGoodVo good) {
		return sqlSession.selectList("user.myGoodRenewal",good);
	}

	////////////////////////////////////////////////////////////
	//////////////////����,�ǵ� �Ű���////////////////////////
	////////////////////////////////////////////////////////////	

	//���ǵ� �Ű���
	@Override
	public void myFeedReportInsertOne(ReportListVo report) {
		sqlSession.insert("user.myFeedReport",report);
	}

	//�����Ű���
	@Override
	public void userReportInsertOne(ReportListVo report) {
		sqlSession.insert("user.userReport",report);
	}

	//�Ű�������� �Ű����Ƚ��+1
	@Override
	public int userReportCountUpdate(ReportListVo report) {
		return sqlSession.update("user.userReportCountUpdate",report);
	}

	////////////////////////////////////////////////////////////
	//////////////////���������� ���,����//////////////////////
	////////////////////////////////////////////////////////////	

	//���׷� �������� üũ
	@Override
	public int groupCheck(ProfileVo profile) {
		return sqlSession.selectOne("user.myGroupCheck",profile);
	}

	//������� �������� üũ
	@Override
	public int ventureCheck(ProfileVo profile) {
		return sqlSession.selectOne("user.myVentureCheck",profile);
	}

	//��������� ���� �� ����������� ��Ƶα�
	@Override
	public MyVentureVo myVentureInfo(ProfileVo profile) {
		return sqlSession.selectOne("user.myVentureInfo",profile);
	}

	//��������� ������ �� ������� üũ (���� null �̸� ���°�)
	@Override
	public BigInteger myVentureRequestCheck(ProfileVo profile) {
		return sqlSession.selectOne("user.myVentureRequestCheck",profile);
	}

	//��ķ���� �������� üũ
	@Override
	public int campCheck(MyVentureVo myVenture) {
		return sqlSession.selectOne("user.myCampCheck",myVenture);
	}

	//�������� ����Ȯ��
	@Override
	public int identify(LoginVo login) {
		return sqlSession.selectOne("user.identify",login);
	}

	//������������ ���
	@Override
	public ProfileVo myProfile(ProfileVo profile) {
		return sqlSession.selectOne("user.myProfileInfo",profile);
	}

	//������������ ����
	@Override
	public int myProfileUpdate(ProfileVo profile) {
		return sqlSession.update("user.myProfileUpdate",profile);
	}

	////////////////////////////////////////////////////////////
	//////////////////���������� ���,����//////////////////////
	////////////////////////////////////////////////////////////	
	
	//�Ҽȷα��� ���� üũ
	@Override
	public int socialMemberCheck(ProfileVo profile) {
		return sqlSession.selectOne("user.socialMemberCheck",profile);
	}
	
	//�� �������� ���
	@Override
	public ProfileVo joinInfo(ProfileVo profile) {
		return sqlSession.selectOne("user.myJoinInfo",profile);
	}

	//�� �������� ����
	@Override
	public int joinInfoUpdate(ProfileVo profile) {
		return sqlSession.update("user.myJoinUpdate",profile);
	}

	////////////////////////////////////////////////////////////
	/////////////////������Ȱ��ȭ,Ż��ó��//////////////////////
	////////////////////////////////////////////////////////////	
	
	//���� ��Ȱ��ȭó��
	@Override
	public int inactiveUpdate(ProfileVo profile) {
		return sqlSession.update("user.inactiveUpdate",profile);
	}

	//����Ż��ó��
	@Override
	public int userGoodBye(ProfileVo profile) {
		return sqlSession.delete("user.userGoodBye",profile);
	}

	//���׷쿡 ���Ե� �ο��� üũ
	@Override
	public int groupUserCount(GroupVo group) {
		return sqlSession.selectOne("user.myGroupUserCount",group);
	}

	////////////////////////////////////////////////////////////
	///////////////////////�׷���ó��/////////////////////////
	////////////////////////////////////////////////////////////	
	
	//�׷���ó�� (�����)
	@Override
	public void groupInsert(GroupVo group) {
		sqlSession.insert("user.myGroupInsert",group);
	}

	//�׷���ó�� (����)
	@Override
	public void groupVentureInsert(GroupVo group) {
		sqlSession.insert("user.myVentureGroupInsert",group);
	}
	
	//�׷��ȣ
	@Override
	public GroupVo groupmyGroup(ProfileVo profile) {
		return sqlSession.selectOne("myGroup",profile);
	}
	
	//�׷��� ����ó��
	@Override
	public void myGroupJoin(GroupVo group) {
		sqlSession.insert("myGroupJoin", group);
	}


	////////////////////////////////////////////////////////////
	///////////////////////����ڰ���///////////////////////////
	///////////////////////����ڵ��///////////////////////////
	////////////////////////////////////////////////////////////	
	//����ڵ�� ��û
	@Override
	public void ventureRequest(UpdateWaitVo updateWait) {
		sqlSession.insert("user.myVentureRequest",updateWait);
	}

	////////////////////////////////////////////////////////////
	///////////////////////����ڰ���///////////////////////////
	////////////////////////////////////////////////////////////	
	
	//��������� ����
	@Override
	public int ventureUpdate(MyVentureVo venture) {
		return sqlSession.update("user.myVentureUpdate",venture);
	}

	//��������� ������ ķ���������� ����(ķ�����̸�, ������)
	@Override
	public int campInfoUpdate(MyVentureVo venture) {
		return sqlSession.update("user.campInfoUpdate",venture);
	}


	////////////////////////////////////////////////////////////
	///////////////////////ķ�������///////////////////////////
	///////////////////////ķ������///////////////////////////
	////////////////////////////////////////////////////////////	
	
	//ķ������
	@Override
	public void campInsert(CampVo camp) {
		sqlSession.insert("user.myCampInsert",camp);
	}

	////////////////////////////////////////////////////////////
	///////////////////////ķ�������///////////////////////////
	////////////////////////////////////////////////////////////	
	
	//��ķ�������� ���
	@Override
	public CampVo myCampSelectOne(MyVentureVo venture) {
		return sqlSession.selectOne("user.myCampSelectOne",venture);
	}
	
	//ķ�������� ����
	@Override
	public int campUpdate(CampVo camp) {
		return sqlSession.update("user.myCampUpdate",camp);
	}

}	
