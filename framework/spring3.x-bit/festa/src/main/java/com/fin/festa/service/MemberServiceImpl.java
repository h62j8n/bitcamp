package com.fin.festa.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

	// 로그인처리 유무, 회원이 있을시 해당회원정보 출력 v
	// 로그인완료시 계정비활성화 활성화로 업데이트 v
	// 로그인완료시 정지,추방,관리자 계정인지 체크 v
	// 로그인완료시 해당회원의 가입그룹목록 출력 v
	// 로그인완료시 해당회원의 북마크목록 출력 v
	// 로그인완료시 추천그룹리스트 출력 v
	// 로그인완료시 추천캠핑장리스트 출력 v
	// 로그인완료시 내좋아요목록 출력 v
	// 내 팔로잉리스트 출력(세션이 값만 담아두기 다른사람프로필 접속시 팔로우 유무체크하기위함) v
	@Override
	public ProfileVo login(HttpServletRequest req,HttpServletResponse resp, LoginVo loginVo) {
		ProfileVo profile = memberDao.login(loginVo);
		System.out.println(profile);
		if (profile.getLogincheck() != 0) {
			HttpSession session = req.getSession();
			session.setAttribute("login", profile);
			// 정지,강퇴 아니면1 해당이면 2ش��̸� 2
			MyAdminVo myAdmin = memberDao.stopAndKickMember(profile);
			if (myAdmin.getProstop() == 2) {
				// 정지회원
				profile.setProrn(1);
			} else if (myAdmin.getProkick() == 2) {
				// 추방회원
				profile.setProrn(2);
			} else if (myAdmin.getPropublic() == 3) {
				// 관리자
				Cookie userCookie = new Cookie("loginCookie",profile.getProid());
				userCookie.setMaxAge(60*60*24);
				userCookie.setPath("/");
				resp.addCookie(userCookie);
				
				profile.setProrn(3);
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

				Cookie userCookie = new Cookie("loginCookie",profile.getProid());
				userCookie.setMaxAge(60*60*24);
				userCookie.setPath("/");
				resp.addCookie(userCookie);
				
				profile.setProrn(0);
			}
		} else {
			profile.setProrn(4);
		}
		return profile;
	}

	// 해당회원 로그아웃처리
	@Override
	public void logout(HttpServletRequest req,HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		Cookie[] userCookies = req.getCookies();
	    for(int i=0; i<userCookies.length; i++) {
	         userCookies[i].setMaxAge(0);
	         userCookies[i].setPath("/");
	         resp.addCookie(userCookies[i]);
	    }
	}

	// ȸ������ ���ó��
	// �Ҽ�ȸ������,�Ϲ�ȸ������ ����
	// ȸ������ ��ϿϷ�� ���������̺� ����
	@Override
	public void memberInsertOne(Model model, ProfileVo profileVo) {
		if(profileVo.getProprovide() == 0) {
			String proidnum = profileVo.getProidnum();
			StringBuffer sb = new StringBuffer(proidnum);
			
			sb.insert(4,"��");
			sb.insert(7, "��");
			proidnum = sb.toString();
			proidnum +="��";
			
			profileVo.setProidnum(proidnum);
			
			memberDao.memberInsert_nomal(profileVo);
			profileVo = memberDao.find_pronum(profileVo);
			memberDao.myadminInsert(profileVo);
			model.addAttribute("join",profileVo);
		}else {
			memberDao.memberInsert_social(profileVo);
			profileVo = memberDao.find_pronum(profileVo);
			memberDao.myadminInsert(profileVo);
		}

	}

	// ���̵��ߺ�üũ
	@Override
	public int idCheck(Model model, LoginVo loginVo) {
		int result = memberDao.idDuplicate(loginVo);
		model.addAttribute("result",result);
		return result;
	}

	// ���̵�ã��
	@Override
	public ProfileVo findId(Model model, LoginVo loginVo) {
		ProfileVo profile = null;
		if(loginVo.getProidnum().length()==8 && loginVo.getProidnum() != null) {
			StringBuffer sb = new StringBuffer(loginVo.getProidnum());
			sb.insert(4,"��");
			sb.insert(7, "��");
			String proidnum = sb.toString();
			proidnum +="��";
			loginVo.setProidnum(proidnum);
			profile = memberDao.findId(loginVo);
		}
		return profile;
	}

	// ��й�ȣã��
	@Override
	public ProfileVo findPw(Model model, LoginVo loginVo) {
		ProfileVo profile = null;
		if(loginVo.getProidnum().length()==8) {
			StringBuffer sb = new StringBuffer(loginVo.getProidnum());
			sb.insert(4,"��");
			sb.insert(7, "��");
			String proidnum = sb.toString();
			proidnum +="��";
			loginVo.setProidnum(proidnum);
			profile = memberDao.findPw(loginVo);
//			System.out.println("profile.getproid : "+profile.getProid());
//			System.out.println("login.getid : "+loginVo.getId());
//			System.out.println("profile.getproidnum : "+profile.getProidnum());
//			System.out.println("login.getidnum : "+loginVo.getProidnum());
			if(profile.getProid().contentEquals(loginVo.getId()) && profile.getProidnum().equals(loginVo.getProidnum())) {
				memberDao.pwUpdate(profile);
			}
		}
		return profile;
	}
	//��й�ȣ �缳��
	@Override
	public String updatePw(Model model,ProfileVo profile) {
		System.out.println(profile.getPronum());
		System.out.println(profile.getPropw());
		memberDao.pwUpdate(profile);
		return "index";
	}

	//로그인유지
		@Override
		public ProfileVo loginCookie(HttpServletRequest req, HttpServletResponse resp, LoginVo loginVo) {

			ProfileVo profile = memberDao.loginCookie(loginVo);
			loginVo.setPw(profile.getPropw());
			
			profile = memberDao.login(loginVo);
			System.out.println(profile);
			if (profile.getLogincheck() != 0) {
				HttpSession session = req.getSession();
				session.setAttribute("login", profile);
				// ����,���� �ƴϸ�1 �ش��̸� 2
				MyAdminVo myAdmin = memberDao.stopAndKickMember(profile);
				if (myAdmin.getProstop() == 2) {
					// ����ȸ��
					profile.setProrn(1);
				} else if (myAdmin.getProkick() == 2) {
					// �߹�ȸ��
					profile.setProrn(2);
				} else if (myAdmin.getPropublic() == 3) {
					// ������
					Cookie userCookie = new Cookie("loginCookie", profile.getProid());
					userCookie.setMaxAge(60*60*24);
					userCookie.setPath("/");
					resp.addCookie(userCookie);
					
					profile.setProrn(3);
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
					
					Cookie userCookie = new Cookie("loginCookie", profile.getProid());
					userCookie.setMaxAge(60*60*24);
					userCookie.setPath("/");
					resp.addCookie(userCookie);

					profile.setProrn(0);
					
				}
			} else {
				profile.setProrn(4);
			}
			return profile;
		}
}
