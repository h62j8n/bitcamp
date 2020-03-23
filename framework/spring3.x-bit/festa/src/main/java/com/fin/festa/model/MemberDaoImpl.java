package com.fin.festa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.LoginVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.ProfileVo;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSession sqlSession;
	
	////////////////////////////////////////////////////////////
	///////////////////////�α���ó��///////////////////////////
	//////////////////�α��� �� ���� ������/////////////////////
	////////////////////////////////////////////////////////////
	
	//�α���ó�� �� �ش� ȸ���������
	@Override
	public ProfileVo login(LoginVo login) {
		return sqlSession.selectOne("member.login",login);
	}

	//�α��ΰ� �����۾�  ���� ��Ȱ��ȭ���� ������Ʈ(1=Ȱ��ȭ, 2=��Ȱ��ȭ)
	@Override
	public void inactiveUpdate(ProfileVo profile) {
		sqlSession.update("member.inactive",profile);
	}
	
	//�α��ΰ� �����۾�  ����,�߹����,���������� üũ
	@Override
	public MyAdminVo stopAndKickMember(ProfileVo profile) {
		return sqlSession.selectOne("member.stopAndKick",profile) ;
	}
	
	//�α��ΰ� �����۾�(�α��οϷ� �Ǹ�)  �ش�ȸ���� ���Ա׷������
	@Override
	public List<JoinGroupVo> myJoinGroupSelectAll(ProfileVo profile) {
		return sqlSession.selectList("member.myJoinGroupList", profile);
	}
	
	//�α��ΰ� �����۾�(�α��οϷ� �Ǹ�)  �ش�ȸ���� �ϸ�ũ������
	@Override
	public List<MyBookMarkVo> myBookMarkSelectAll(ProfileVo profile) {
		return sqlSession.selectList("member.myBookMarkList",profile);
	}

	//��õ�׷츮��Ʈ ���
	@Override
	public List<GroupVo> goodGroupSelectAll() {
		return sqlSession.selectList("member.groupList");
	}

	//��õķ���帮��Ʈ ���
	@Override
	public List<CampVo> goodCampSelectAll() {
		return sqlSession.selectList("member.campList");
	}

	//�����ƿ��� ���
	@Override
	public List<MyGoodVo> myGoodSelectAll(ProfileVo profile) {
		return sqlSession.selectList("member.myGoodSelectAll",profile);
	}

	//�� �ȷ��׸���Ʈ ���(���ǿ� ���� �������ֱ�)
	@Override
	public List<MyFollowingVo> myFollowingList(ProfileVo profile) {
		return sqlSession.selectList("member.myFollowing",profile);
	}
	
	////////////////////////////////////////////////////////////
	/////////////////////ȸ������ó��///////////////////////////
	////////////////////////////////////////////////////////////
	
	//ȸ������ ���̵��ߺ�ó��
	@Override
	public int idDuplicate(LoginVo login) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//ȸ�����Ե��ó�� - �Ϲ�
	@Override
	public void memberInsert_nomal(ProfileVo profile) {
		// TODO Auto-generated method stub
		
	}

	//ȸ�����Ե��ó�� - �Ҽ�
	@Override
	public void memberInsert_social(ProfileVo profile) {
		// TODO Auto-generated method stub
		
	}

	//ȸ������ ������ ���������̺� ����
	@Override
	public void myadminInsert(ProfileVo profile) {
		// TODO Auto-generated method stub
		
	}
	
	////////////////////////////////////////////////////////////
	///////////////////////���̵�ã��///////////////////////////
	////////////////////////////////////////////////////////////
	
	//���̵�ã��
	@Override
	public ProfileVo findId(LoginVo login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	////////////////////////////////////////////////////////////
	/////////////////////////���ã��///////////////////////////
	////////////////////////////////////////////////////////////
	
	//��й�ȣã��
	@Override
	public ProfileVo findPw(LoginVo login) {
		// TODO Auto-generated method stub
		return null;
	}

	//���ã�� �� �������
	@Override
	public int pwUpdate(ProfileVo profile) {
		// TODO Auto-generated method stub
		return 0;
	}





	


}
