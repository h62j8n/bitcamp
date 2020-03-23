package com.fin.festa.service;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	// 등록,수정,삭제가 최소2개이상 들어가는 메소드는 꼭 트랜잭션 적용할것!!

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
	public int login(HttpServletRequest req, LoginVo loginVo) {
		ProfileVo profile = memberDao.login(loginVo);
		if (profile.getProid() != null) {
			HttpSession session = req.getSession();
			session.setAttribute("login", profile);
			// 정지,강퇴 아니면1 해당이면 2
			MyAdminVo myAdmin = memberDao.stopAndKickMember(profile);
			if (myAdmin.getProstop() == 2) {
				// 정지회원
				return 1;
			} else if (myAdmin.getProkick() == 2) {
				// 추방회원
				return 2;
			} else if (myAdmin.getPropublic() == 3) {
				// 관리자
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

	// 해당회원 로그아웃처리
	@Override
	public void logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
	}

	// 회원가입 등록처리
	// 소셜회원가입,일반회원가입 구분
	// 회원가입 등록완료시 내관리테이블 생성
	@Override
	public void memberInsertOne(Model model, ProfileVo profileVo) {
		// TODO Auto-generated method stub

	}

	// 아이디중복체크
	@Override
	public void idCheck(Model model, LoginVo loginVo) {
		// TODO Auto-generated method stub

	}

	// 아이디찾기
	@Override
	public void findId(Model model, LoginVo loginVo) {
		// TODO Auto-generated method stub

	}

	// 비밀번호찾기
	// 비밀번호 재설정
	@Override
	public void findPw(Model model, LoginVo loginVo) {
		// TODO Auto-generated method stub

	}

}
