package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.AllCountVo;
import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyFollowerVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.MyVentureVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.PreferableLocationVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.model.entity.WeekCountVo;
import com.fin.festa.model.entity.WeekVo;
import com.fin.festa.util.DateCalculate;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	SqlSession sqlSession;

	//////////////////////////////////////////////////////////////
	/////////////////////��ú��� ȭ�����////////////////////////
	//////////////////////////////////////////////////////////////
	
	//��ú��� ��ü�����,�׷�,�����,ķ����� ���
	@Override
	public AllCountVo allCount() {
		
		return sqlSession.selectOne("admin.allCount");
	}

	//��ú��� ��ü�����,�׷�,�����,ķ����� ��� ��������
	@Override
	public AllCountVo allCount_yesterday(String time) {
		
		return sqlSession.selectOne("admin.allCount_yesterday", time);
	}

	//��ú��� ������ �ű��̿������� ���
	@Override
	public WeekVo lastWeekNewUser(DateCalculate cal) {
		
		return sqlSession.selectOne("admin.lastWeekNewUser", cal);
	}

	//��ú��� �̹��� �ű�������Ȳ ���
	@Override
	public WeekCountVo weekNewUserCount(DateCalculate cal) {
		
		return sqlSession.selectOne("admin.weekNewUserCount", cal);
	}

	//��ú��� ��üȸ���� ������� ��� (ȸ�����ɺ����� ������ ����)
	@Override
	public List<ProfileVo> allUserCount() {
		
		return sqlSession.selectList("admin.allUserCount");
	}

	//��ú��� ��ȣ������������ ���
	@Override
	public List<PreferableLocationVo> preferLocation() {
		
		return sqlSession.selectList("admin.preferLocation");
	}

	//////////////////////////////////////////////////////////////
	/////////////////////////�׷����/////////////////////////////
	//////////////////////////////////////////////////////////////

	//�׷�� �� �������� ���ϱ�
	@Override
	public int adminGroupCount(PageSearchVo search) {
		
		return sqlSession.selectOne("admin.adminGroupCount", search);
	}

	//�׷�����������
	@Override
	public List<GroupVo> adminGroupSelectAll(PageSearchVo search) {
		
		return sqlSession.selectList("admin.adminGroupSelectAll", search);
	}

	//�׷���� +@
	@Override
	public int groupDelete(GroupVo group) {
		
		return sqlSession.delete("admin.groupDelete", group);
	}
	
	//�׷������
	@Override
	public GroupVo groupInfo(GroupVo group) {
		
		return sqlSession.selectOne("admin.groupInfo", group);
	}

	//�׷�����������
	@Override
	public List<GroupNoticeVo> groupNoticeInfo(GroupVo group) {
		
		return sqlSession.selectList("admin.groupNoticeInfo", group);
	}

	//�׷�������� �����������
	@Override
	public GroupNoticeVo groupNoticeDetail(GroupNoticeVo groupnotice) {
		
		return sqlSession.selectOne("admin.groupNoticeDetail", groupnotice);
	}

	//�׷�����ǵ� ��۴����� �񵿱�
	@Override
	public List<GroupNoticeCommentVo> adminGroupNoticeCmmt(GroupNoticeVo groupnotice) {
		
		return sqlSession.selectList("admin.adminGroupNoticeCmmt", groupnotice);
	}

	//�׷�������� ������
	@Override
	public List<GroupNoticeCommentVo> groupNoticeCmmtInfo(GroupNoticeVo groupnotice) {
		
		return sqlSession.selectList("admin.groupNoticeCmmtInfo", groupnotice);
	}
	
	//�׷��ǵ� ���
	@Override
	public List<GroupPostVo> groupFeedInfoSelectAll(GroupVo group) {
		
		return sqlSession.selectList("admin.groupFeedInfoSelectAll", group);
	}

	//�׷��ǵ� ������
	@Override
	public List<GroupCommentVo> groupFeedCmmtInfoSelectAll(GroupVo group) {
		
		return sqlSession.selectList("admin.groupFeedCmmtInfoSelectAll", group);
	}
	
	//�׷��ǵ��� ������ �񵿱�
	@Override
	public List<GroupCommentVo> adminGroupDetailCmmt(GroupPostVo grouppost) {
		
		return sqlSession.selectList("admin.adminGroupDetailCmmt", grouppost);
	}

	
	//�׷�������Ʈ ���
	@Override
	public List<JoinGroupVo> adminGroupMemberList(GroupVo group) {
		
		return sqlSession.selectList("admin.adminGroupMemberList", group);
	}

	//�׷�������� ����ó��
	@Override
	public int groupNoticeDelete(GroupNoticeVo groupnotice) {
		
		return sqlSession.delete("admin.groupNoticeDelete", groupnotice);
	}

	//�׷�������״�� ����ó��
	@Override
	public int groupNoticeCmmtDelete(GroupNoticeCommentVo groupnoticecmmt) {
		
		return sqlSession.delete("admin.groupNoticeCmmtDelete", groupnoticecmmt);
	}

	//�׷��ǵ� ����ó��
	@Override
	public int groupFeedDelete(GroupPostVo grouppost) {
		
		return sqlSession.delete("admin.groupFeedDelete", grouppost);
	}

	//�׷��ǵ� ��ۻ���ó��
	@Override
	public int groupFeedCmmtDelete(GroupCommentVo groupcmmt) {
		
		return sqlSession.delete("admin.groupFeedCmmtDelete", groupcmmt);
	}

	//////////////////////////////////////////////////////////////
	/////////////////////////��������/////////////////////////////
	//////////////////////////////////////////////////////////////
	
	//�˻��� ���� ��ȸ���� ���
	@Override
	public int adminUserCount(PageSearchVo pageSearchVo) {
		
		return sqlSession.selectOne("admin.adminUserCount", pageSearchVo);
	}
	
	//������������ ��ü ���
	@Override
	public List<ProfileVo> adminUserSelectAll(PageSearchVo search) {
		
		return sqlSession.selectList("admin.adminUserSelectAll", search);
	}

	//������������ ������� ���
	@Override
	public List<ProfileVo> adminUserStopSelectAll(PageSearchVo search) {
		
		return sqlSession.selectList("admin.adminUserStopSelectAll", search);
	}

	//���� ����
	@Override
	public int userStop(MyAdminVo admin) {
		
		return sqlSession.update("admin.userStop", admin);
	}

	//���� ����
	@Override
	public int userKick(MyAdminVo admin) {
		
		return sqlSession.update("admin.userKick", admin);
	}

	//////////////////////////////////////////////////////////////
	//////////////////////���� ��������/////////////////////////
	//////////////////////////////////////////////////////////////
	
	//��������(��������)
	@Override
	public ProfileVo userInfo(ProfileVo profile) {
		
		return sqlSession.selectOne("admin.userInfo", profile);
	}

	//�����ǵ����
	@Override
	public List<MyPostVo> userFeed(ProfileVo profile) {
		
		return sqlSession.selectList("admin.userFeed", profile);
	}

	//�����ǵ� ������
	@Override
	public List<MyCommentVo> userCmmt(ProfileVo profile) {
		
		return sqlSession.selectList("admin.userCmmt", profile);
	}
	
	//�����ǵ� ��� ���������
	@Override
	public List<MyCommentVo> adminUserDetailCmmt(MyPostVo post) {
		
		return sqlSession.selectList("admin.adminUserDetailCmmt", post);
	}
	
	//�����ǵ尹�� ���
	@Override
	public int userFeedCount(ProfileVo profile) {
		
		return sqlSession.selectOne("admin.userFeedCount", profile);
	}

	//���� �ȷ��׼� ���
	@Override
	public int userFollowingCount(ProfileVo profile) {
		
		return sqlSession.selectOne("admin.userFollowingCount", profile);
	}

	//���� �ȷο��� ���
	@Override
	public int userFollowerCount(ProfileVo profile) {
		
		return sqlSession.selectOne("admin.userFollowerCount", profile);
	}
	
	//�ش����� �ȷο�����Ʈ
	@Override
	public List<MyFollowerVo> adminUserfollowerList(ProfileVo profile) {
		
		return sqlSession.selectList("admin.adminUserfollowerList", profile);
	}

	//�ش����� �ȷ��׸���Ʈ
	@Override
	public List<MyFollowingVo> adminUserfollowList(ProfileVo profile) {
		
		return sqlSession.selectList("admin.adminUserfollowList", profile);
	}

	//���ǵ� ����
	@Override
	public int myFeedDelete(MyPostVo post) {
		
		return sqlSession.delete("admin.myFeedDelete", post);
	}
	
	//���ǵ��� ����
	@Override
	public int myFeedCmmtDelete(MyCommentVo cmmt) {

		return sqlSession.delete("admin.myFeedCmmtDelete", cmmt);
	}

	//�������� ����Ʈ�� �̾ƿ���
	@Override
	public List<ProfileVo> stopUserList() {
		
		return sqlSession.selectList("admin.stopUserList");
	}

	//�������� 0�϶� ����Ǯ��
	@Override
	public int updateStop_zero(ProfileVo profile) {
		
		return sqlSession.update("admin.updateStop_zero", profile);
	}

	//�������� 1�̻��϶� ������ ������Ʈ
	@Override
	public int updateStop_over(ProfileVo profile) {
		
		return sqlSession.update("admin.updateStop_over", profile);
	}

	//////////////////////////////////////////////////////////////
	////////////////////////ķ�������////////////////////////////
	//////////////////////////////////////////////////////////////

	//ķ���� ������ ��Żī��Ʈ���� ���ϴ°�
	@Override
	public int adminCampCount(PageSearchVo pageSearchVo) {
		
		return sqlSession.selectOne("admin.adminCampCount", pageSearchVo);
	}

	//ķ����������� ���
	@Override
	public List<CampVo> adminCampSelectAll(PageSearchVo search) {
		
		return sqlSession.selectList("admin.adminCampSelectAll", search);
	}

	//ķ������� +@
	@Override
	public int campDelete(CampVo camp) {
		
		return sqlSession.delete("admin.campDelete", camp);
	}
	
	//ķ�������� ���
	@Override
	public CampVo campInfo(CampVo camp) {
		
		return sqlSession.selectOne("admin.campInfo", camp);
	}
	
	//�ش�ķ���� ����ó��
	@Override
	public int campDeleteOne(CampVo camp) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//�ش�ķ���� ���ı׷����� üũ
	@Override
	public int groupVentureCheck(CampVo camp) {
		
		return sqlSession.selectOne("admin.groupVentureCheck", camp);
	}

	//ķ���� ���������
	@Override
	public List<CampReviewVo> campReviewInfo(CampVo camp) {
		
		return sqlSession.selectList("admin.campReviewInfo", camp);
	}

	//�ش�ķ���� �����򰹼�
	@Override
	public int campReviewCount(CampVo camp) {
		
		return sqlSession.selectOne("admin.campReviewCount", camp);
	}
	
	//�ش�ķ���������� ����ó��
	@Override
	public int campReviewDeleteOne(CampReviewVo campreview) {
		
		return sqlSession.delete("admin.campReviewDeleteOne", campreview);
	}

	//���ı׷������� ���ı׷��������
	@Override
	public GroupVo ventureGroup(CampVo camp) {
		
		return sqlSession.selectOne("admin.ventureGroup", camp);
	}
	
	//////////////////////////////////////////////////////////////
	////////////////////////����ڰ���////////////////////////////
	//////////////////////////////////////////////////////////////
	
	//����ڰ������� ���(�˻���-����ڹ�ȣ)
	@Override
	public List<MyAdminVo> adminVentureSelectAll_mvnumber(PageSearchVo search) {
		
		return sqlSession.selectList("admin.adminVentureSelectAll_mvnumber", search);
	}

	//����ڰ������� ���(�˻���-ķ�����̸�)
	@Override
	public List<MyAdminVo> adminVentureSelectAll_caname(PageSearchVo search) {
		
		return sqlSession.selectList("admin.adminVentureSelectAll_caname", search);
	}

	//����ڰ������� �ο찹��(�˻���-����ڹ�ȣ)
	@Override
	public int adminVentureCount_ventureNumber(PageSearchVo pageSearchVo) {
		
		return sqlSession.selectOne("admin.adminVentureCount_ventureNumber", pageSearchVo);
	}

	//����ڰ������� �ο찹��(�˻���-ķ�����̸�)
	@Override
	public int adminVentureCount_campName(PageSearchVo pageSearchVo) {
		
		return sqlSession.selectOne("admin.adminVentureCount_campName", pageSearchVo);
	}
	
	//�ش� ����ڻ������
	@Override
	public MyVentureVo AdminVentureImg(MyVentureVo myVentureVo) {
		// TODO Auto-generated method stub
		return null;
	}

	//����� ����ó�� +@
	@Override
	public int ventureDelete(MyVentureVo venture) {
		
		return sqlSession.delete("admin.ventureDelete", venture);
	}
	
	//����� ������ ���ı׷� �ִ»�� ����
	@Override
	public List<GroupVo> ventureGroupCheck(MyVentureVo venture) {
		
		return sqlSession.selectList("admin.ventureGroupCheck", venture);
	}

	//���ı׷� ����� �Ϲݱ׷����� ������Ʈ
	@Override
	public int ventureGroupDelete(GroupVo group) {
		
		return sqlSession.update("admin.ventureGroupDelete", group);
	}

	//////////////////////////////////////////////////////////////
	//////////////////////����ڵ�ϰ���//////////////////////////
	//////////////////////////////////////////////////////////////
	
	//����ڵ�Ͻ�û���� ���(�˻���-����ڹ�ȣ)
	@Override
	public List<UpdateWaitVo> adminVentureRequestSelectAll_mvnumber(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//����ڵ�Ͻ�û���� ���(�˻���-ķ�����̸�)
	@Override
	public List<UpdateWaitVo> adminVentureRequestSelectAll_caname(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//����ڵ�Ͻ��� ó�� +@
	@Override
	public void ventureInsert(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		
	}

	//���δ�����̺� �������� or ����ڵ�� ����ó�� +@ (�Ѵ� ����)
	@Override
	public int updateDelete(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		return 0;
	}

	//����ڵ��ó�� �� �׷��ִ� ������ �׷���������
	@Override
	public List<GroupVo> groupCheck(UpdateWaitVo wait) {
		// TODO Auto-generated method stub
		return null;
	}

	//����ڵ��ó�� �� �׷������ϸ� ���ı׷����� ������Ʈ
	@Override
	public int groupVentureUpdate(GroupVo group) {
		// TODO Auto-generated method stub
		return 0;
	}

	//////////////////////////////////////////////////////////////
	/////////////////////////�Ű����/////////////////////////////
	//////////////////////////////////////////////////////////////
	
	//�Ű�������� ��� 
	@Override
	public List<ReportListVo> adminReportSelectAll(PageSearchVo search) {
		// TODO Auto-generated method stub
		return null;
	}

	//�Ű� ó���Ϸ������Ʈ
	@Override
	public int adminReportUpdate(ReportListVo report) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�Ű�����������
	@Override
	public ReportListVo adminReportSelectOne(ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		return null;
	}



}
