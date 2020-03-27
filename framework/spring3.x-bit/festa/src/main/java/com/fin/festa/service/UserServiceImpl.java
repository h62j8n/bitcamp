package com.fin.festa.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.MemberDaoImpl;
import com.fin.festa.model.UserDaoImpl;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.LoginVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.MyVentureVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.util.UploadPhoto;

@Service
public class UserServiceImpl implements UserService {

	// ���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!

	@Autowired
	UserDaoImpl userDao;
	
	@Autowired
	MemberDaoImpl memberDao;

	//�߰�����
	//���� ��� ������ �񵿱�
	
	@Override
	public List<MyCommentVo> userDetailCmmt(Model model, MyPostVo post) {
		if(post.getPageSearch().getPage4()==1) {
			post.getPageSearch().setPage4(2);
		}
		model.addAttribute("paging",post.getPageSearch());
		return null;
	}
	
	// ��Ȱ��ȭ����, ��������, �߹���� üũ v
	// ������ ��� v
	// ���ǵ� ��� v
	// ���ǵ��� ��� v
	// ���ǵ尹�� ��� v
	// ���ȷ��װ��� ���  v
	// ���ȷο����� ��� v
	@Override
	public void feedSelectOne(HttpServletRequest req) {
		HttpSession session = req.getSession();
		ProfileVo profile = (ProfileVo) session.getAttribute("login");

		MyAdminVo myAdmin = userDao.adminCheck(profile);
		if (myAdmin.getPropublic() == 1 && myAdmin.getProstop() == 1 && myAdmin.getProkick() == 1) {
			profile = userDao.myInfo(profile);
			List<MyPostVo> myFeedSelectAll = userDao.myFeedSelectAll(profile); // �ǵ� ����Ʈ
			List<MyCommentVo> myFeedCmmtSelectAll = userDao.myFeedCmmtSelectAll(profile); //�ǵ� ��� ����Ʈ
			int myFeedCount = userDao.myFeedCount(profile);
			int myFollowerCount = userDao.myFollowerCount(profile);
			int myFollowingCount = userDao.myFollowingCount(profile);
			session.setAttribute("profile", profile);
			session.setAttribute("myFeedCount", myFeedCount);
			session.setAttribute("myFollowerCount", myFollowerCount);
			session.setAttribute("myFollowingCount", myFollowingCount);
			req.setAttribute("myFeedSelectAll", myFeedSelectAll);
			req.setAttribute("myFeedCmmtSelectAll", myFeedCmmtSelectAll);
			
		}
	}

	//���ǵ� ���
	@Override
	public void feedInsertOne(HttpServletRequest req,MultipartFile[] files, MyPostVo myPostVo) {
		UploadPhoto up = new UploadPhoto();
		String mpphoto = up.upload(files, req, myPostVo);
		
		myPostVo.setMpphoto(mpphoto);
		userDao.myFeedInsertOne(myPostVo);
	}


	// ���ǵ� ����
	@Override
	public void feedUpdateOne(Model model, MyPostVo myPostVo) {
		// TODO Auto-generated method stub

	}

	// ���ǵ� ����
	@Override
	public void feedDeleteOne(Model model, MyPostVo myPostVo) {
		// TODO Auto-generated method stub

	}

	// ���ǵ��� ���
	@Override
	public void feedCmmtInsertOne(Model model, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub

	}

	// ���ǵ��� ����
	@Override
	public void feedCmmtDeleteOne(Model model, MyCommentVo myCommentVo) {
		// TODO Auto-generated method stub

	}

	// ���ǵ� ���ƿ���
	// ���ǵ� ���ƿ��Ͻ� �ǵ����ƿ䰹�� +1
	// �� ���ƿ��� ����
	@Override
	public void likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub

	}

	// ���ǵ� ���ƿ�����
	// ���ǵ� ���ƿ������� �ǵ����ƿ䰹�� -1
	// �� ���ƿ��� ����
	@Override
	public void likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub

	}

	// ���ȷ��׸�Ͽ� ���
	// ����ȷο���Ͽ� ���
	// �� �ȷ��׸�� ����
	@Override
	public void followInsertOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		// TODO Auto-generated method stub

	}

	// ���ȷ��׸�Ͽ� ����
	// ����ȷο���Ͽ� ����
	// �� �ȷ��׸�� ����
	@Override
	public void followDeleteOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		// TODO Auto-generated method stub

	}

	// �����Ű���
	// �Ű�������� �Ű����Ƚ�� +1
	@Override
	public void userReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub

	}

	// �ǵ�Ű���
	// �Ű�������� �Ű����Ƚ�� +1
	@Override
	public void feedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub

	}

	// �׷� �������� üũ v
	// ����� �������� üũ v
	// ����� ������ �� ��Ͻ�û ���� üũ v
	// ����� ����� ��������� ���(���ǿ� �����) v
	// ķ���� �������� üũ v
	// ������������ ��� v
	@Override
	public void myProfile(HttpServletRequest req, ProfileVo profileVo) {
		HttpSession session = req.getSession();
		profileVo = (ProfileVo) session.getAttribute("profile");
		session.setAttribute("profile", userDao.myProfile(profileVo));
		
		int groupCheck = userDao.groupCheck(profileVo);
		System.out.println("groupCheck : "+groupCheck);
		int ventureCheck = userDao.ventureCheck(profileVo);
		
		System.out.println(profileVo.getPronum());
		BigInteger myVentureRequestCheck = userDao.myVentureRequestCheck(profileVo);
		
		MyVentureVo myVenture = userDao.myVentureInfo(profileVo);
		int campCheck = userDao.campCheck(myVenture);
		
		session.setAttribute("groupCheck", groupCheck);
		
		//if(myVentureRequestCheck == null &&  ventureCheck ==1 ) {
			session.setAttribute("myVenture", myVenture);
			session.setAttribute("ventureCheck", ventureCheck);
			session.setAttribute("campCheck", campCheck);
		//}
		//else if(myVentureRequestCheck != null) {
			session.setAttribute("myVentureRequestCheck", myVentureRequestCheck);
		//}
	}

	// �������� ����
	@Override
	public int myProfileUpdateOne(HttpServletRequest req, ProfileVo profileVo) {
		System.out.println(profileVo.getProintro());
		int result = userDao.myProfileUpdate(profileVo);
		req.setAttribute("profile1", profileVo);
		System.out.println(result);
		System.out.println(profileVo.getProintro());
		//req.setAttribute("result", result);
		
		
		return result;

	}

	// �Ҽȷα��� üũ
	// ���������� ���
	@Override
	public void myAdmin(Model model, ProfileVo prifileVo) {
		// TODO Auto-generated method stub

	}

	// �������� ����Ȯ��
	@Override
	public int myAdminCheck(Model model, LoginVo loginVo) {
		int result = userDao.identify(loginVo);
		return result;
	}

	// ���������� ����
	@Override
	public void myAdminUpdateOne(HttpServletRequest req, ProfileVo profileVo) {
		userDao.joinInfoUpdate(profileVo);
		HttpSession session = req.getSession();
		session.setAttribute("profile", profileVo);
		System.out.println(profileVo.getPronum());
	}

	// ��Ȱ��ȭ���� ó��
	// �׷� �������� üũ
	// �׷쿡 ���Ե� �ο��� üũ
	@Override
	public void myAdminInactive(Model model, MyAdminVo myAdminVo) {
		// TODO Auto-generated method stub

	}

	// ����Ż�� ó��
	// �׷� �������� üũ
	// �׷쿡 ���Ե� �ο��� üũ
	@Override
	public void myAdminGoodbye(Model model, ProfileVo profileVo) {
		// TODO Auto-generated method stub

	}

	// ����� ���� üũ(���ı׷�,����ı׷� �з�)
	// �׷� ���
	// �׷� ���
	@Override
	public GroupVo groupInsertOne(HttpServletRequest req, GroupVo groupVo) {;
		HttpSession session = req.getSession();
		ProfileVo profile = (ProfileVo) session.getAttribute("profile");
		
		userDao.groupInsert(groupVo);
		groupVo = userDao.groupmyGroup(profile);
		userDao.myGroupJoin(groupVo);

		List<JoinGroupVo> joinGroup = memberDao.myJoinGroupSelectAll(profile);

		session.setAttribute("joinGroup", joinGroup);
		session.setAttribute("group", groupVo);
		session.setAttribute("groupCheck", 1);
		req.setAttribute("detail", groupVo);
		
		return groupVo;
	}


	// ����ڵ�� ��û
	@Override
	public void ventureInsertOne(HttpServletRequest req, UpdateWaitVo updateWaitVo) {
		userDao.ventureRequest(updateWaitVo);
		
		HttpSession session = req.getSession();
		session.setAttribute("myVentureRequestCheck", 1);
	}

	// ��������� ���(����)
	@Override
	public void ventureAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		ProfileVo profile = (ProfileVo) session.getAttribute("profile");
		
		MyVentureVo myVenture = userDao.myVentureInfo(profile);
		req.setAttribute("myVenture", myVenture);
		session.setAttribute("myVenture", myVenture);
	}

	// ��������� ����
	// ķ�������� �ڵ�����(��������� ��������)
	@Override
	public void ventureAdminUpdateOne(HttpServletRequest req, MyVentureVo myVenture) {
		userDao.ventureUpdate(myVenture);
		userDao.campInfoUpdate(myVenture);
		
		HttpSession session = req.getSession();
		session.setAttribute("myVenture", myVenture);
	}

	// ķ���� ���
	@Override
	public void campInsertOne(Model model, CampVo campVo) {
		

	}

	// ���ǿ� ��� ����������� ķ�������� ���
	@Override
	public void campAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		MyVentureVo myVenture =  (MyVentureVo) session.getAttribute("myVenture");
		
		CampVo camp = userDao.myCampSelectOne(myVenture);
		System.out.println(camp.getCanum());
		session.setAttribute("myCamp", camp);
	}

	// ķ�������� ����
	@Override
	public void campUpdateOne(Model model, CampVo campVo) {
		int result = userDao.campUpdate(campVo);
		model.addAttribute("myCamp",campVo);
	}

	// �� �ȷο�����Ʈ ���
	@Override
	public void followerList(Model model, ProfileVo profile) {
		// TODO Auto-generated method stub

	}

	// �� �ȷ��׸���Ʈ ���
	@Override
	public void followList(Model model, ProfileVo profile) {
		// TODO Auto-generated method stub

	}

}
