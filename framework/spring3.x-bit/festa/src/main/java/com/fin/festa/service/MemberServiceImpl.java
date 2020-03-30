package com.fin.festa.service;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fin.festa.model.MemberDaoImpl;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.LoginVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.ProfileVo;

@Service
public class MemberServiceImpl implements MemberService {

	// ���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!

	@Autowired
	MemberDaoImpl memberDao;

	// �α���ó�� ����, ȸ���� ������ �ش�ȸ������ ��� v
	// �α��οϷ�� ������Ȱ��ȭ Ȱ��ȭ�� ������Ʈ v
	// �α��οϷ�� ����,�߹�,������ �������� üũ v
	// �α��οϷ�� �ش�ȸ���� ���Ա׷��� ��� v
	// �α��οϷ�� �ش�ȸ���� �ϸ�ũ��� ��� v
	// �α��οϷ�� ��õ�׷츮��Ʈ ��� v
	// �α��οϷ�� ��õķ���帮��Ʈ ��� v
	// �α��οϷ�� �����ƿ��� ��� v
	// �� �ȷ��׸���Ʈ ���(������ ���� ��Ƶα� �ٸ���������� ���ӽ� �ȷο� ����üũ�ϱ�����) v
	@Override
	public int login(HttpServletRequest req, LoginVo loginVo) {
		ProfileVo profile = memberDao.login(loginVo);
		if (profile.getProid() != null) {
			HttpSession session = req.getSession();
			session.setAttribute("login", profile);
			// ����,���� �ƴϸ�1 �ش��̸� 2
			MyAdminVo myAdmin = memberDao.stopAndKickMember(profile);
			if (myAdmin.getProstop() == 2) {
				// ����ȸ��
				return 1;
			} else if (myAdmin.getProkick() == 2) {
				// �߹�ȸ��
				return 2;
			} else if (myAdmin.getPropublic() == 3) {
				// ������
				return 3;
			} else {
				memberDao.inactiveUpdate(profile);
				List<JoinGroupVo> joinGroup = memberDao.myJoinGroupSelectAll(profile);
				List<MyBookMarkVo> bookMark = memberDao.myBookMarkSelectAll(profile);
				List<GroupVo> goodgroup = memberDao.goodGroupSelectAll();
				List<CampVo> goodcamp = memberDao.goodCampSelectAll();
				List<MyGoodVo> goodlist = memberDao.myGoodSelectAll(profile);
				List<MyFollowingVo> followlist = memberDao.myFollowingList(profile);

				session.setAttribute("joinGroup", joinGroup);
				session.setAttribute("bookMark", bookMark);
				session.setAttribute("goodgroup", goodgroup);
				session.setAttribute("goodcamp", goodcamp);
				session.setAttribute("goodlist", goodlist);
				session.setAttribute("followlist", followlist);

				return 0;
			}
		} else {
			return 4;
		}
	}

	// �ش�ȸ�� �α׾ƿ�ó��
	@Override
	public void logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
	}

	// ȸ������ ���ó��
	// �Ҽ�ȸ������,�Ϲ�ȸ������ ����
	// ȸ������ ��ϿϷ�� ���������̺� ����
	@Override
	public void memberInsertOne(Model model, ProfileVo profileVo) {
		// TODO Auto-generated method stub

	}

	// ���̵��ߺ�üũ
	@Override
	public void idCheck(Model model, LoginVo loginVo) {
		// TODO Auto-generated method stub

	}

	// ���̵�ã��
	@Override
	public ProfileVo findId(Model model, LoginVo loginVo) {
		StringBuffer sb = new StringBuffer(loginVo.getProidnum());
		sb.insert(4,"��");
		sb.insert(7, "��");
		String proidnum = sb.toString();
		proidnum +="��";
		loginVo.setProidnum(proidnum);
		
		ProfileVo profile = memberDao.findId(loginVo);
		return profile;
	}

	// ��й�ȣã��
	@Override
	public ProfileVo findPw(Model model, LoginVo loginVo) {
		StringBuffer sb = new StringBuffer(loginVo.getProidnum());
		sb.insert(4,"��");
		sb.insert(7, "��");
		String proidnum = sb.toString();
		proidnum +="��";
		loginVo.setProidnum(proidnum);
		ProfileVo profile = memberDao.findPw(loginVo);
		
		if(profile.getProid().contentEquals(loginVo.getId()) && profile.getProidnum().equals(loginVo.getProidnum())) {
			memberDao.pwUpdate(profile);
			return profile;
		}
		else {
			return null;
		}
	}
	//��й�ȣ �缳��
	@Override
	public String updatePw(Model model,ProfileVo profile) {
		System.out.println(profile.getPronum());
		System.out.println(profile.getPropw());
		memberDao.pwUpdate(profile);
		return "index";
	}

}
