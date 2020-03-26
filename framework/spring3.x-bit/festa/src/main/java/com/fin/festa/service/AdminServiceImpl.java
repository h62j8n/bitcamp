package com.fin.festa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.fin.festa.model.AdminDaoImpl;
import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.MyVentureVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.util.AgeCalculate;
import com.fin.festa.util.DateCalculate;
import com.fin.festa.util.StopUser;

@EnableScheduling
@Service
public class AdminServiceImpl implements AdminService{

	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	AdminDaoImpl adminDao;
	
	//��ú��� ��ü�����,�׷�,�����,ķ����� ��� (�� �۾�-�� �ٿ�)
	//��ú��� ��ü�����,�׷�,�����,ķ����� ��� �������� (�� �۾�-�� �ٿ�)
	//��ú��� ������ �ű��̿������� ��� (�� �۾�-�� �ٿ�)
	//��ú��� �̹��� �ű�������Ȳ ��� (�� �۾�-�� �ٿ�)
	//��ú��� ��üȸ���� ������� ��� (ȸ�����ɺ����� ������ ����)// (�� �ٿ�-�� �۾�)
	//��ú��� ��ȣ������������ ��� (�� �۾�-�� �ٿ�)
	@Override
	public void adminDashBoard(Model model) {
		
		DateCalculate cal=new DateCalculate();
		AgeCalculate age=new AgeCalculate();
		
		model.addAttribute("today", cal.getTime());											//����ð���
		model.addAttribute("allUser", adminDao.allCount());									//������ڰ�
		model.addAttribute("yesterday", adminDao.allCount_yesterday(cal.yesterday()));		//������ڰ� ��������
		model.addAttribute("lastWeek", adminDao.lastWeekNewUser(cal.lastWeekNewUser()));	//������ �ű԰�����
		model.addAttribute("week", adminDao.weekNewUserCount(cal.weekNewUser()));			//�̹��� �ű�������Ȳ
		model.addAttribute("prefer", adminDao.preferLocation());							//��ȣ��������
		model.addAttribute("userAge", age.userAgeDistribution(adminDao.allUserCount()));	//ȸ�� ���ɺ���
	}

	//�׷�����������
	@Override
	public void adminGroupSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(pageSearchVo.getPage()==0) {
			pageSearchVo.setPage(1);
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� null�� ���Ƿ� mysql�� null�ϰ� ""�ϰ� ���� �ٸ��⶧���� ""�� ������
		if(pageSearchVo.getKeyword()==null) {
			pageSearchVo.setKeyword("");
		}
		
		pageSearchVo.setTotalCount(adminDao.adminGroupCount(pageSearchVo));
		
		model.addAttribute("grouplist", adminDao.adminGroupSelectAll(pageSearchVo));
		model.addAttribute("paging", pageSearchVo);
	}

	//�׷���� +@
	@Override
	public void adminGroupDeleteOne(Model model, GroupVo groupVo) {

		adminDao.groupDelete(groupVo);
	}
	
	//�׷��������
	//�׷�����������
	//�׷��ǵ����
	//�׷������
	@Override
	public void adminGroupDetail(Model model, GroupVo groupVo) {

		model.addAttribute("groupinfo", adminDao.groupInfo(groupVo));
		model.addAttribute("groupnotice", adminDao.groupNoticeInfo(groupVo));
		model.addAttribute("groupfeed", adminDao.groupFeedInfoSelectAll(groupVo));
		model.addAttribute("groupcmmt", adminDao.groupFeedCmmtInfoSelectAll(groupVo));
	}

	//�׷��ǵ��� ������ �񵿱�
	@Override
	public List<GroupCommentVo> adminGroupDetailCmmt(Model model, GroupPostVo grouppost) {
		
		return adminDao.adminGroupDetailCmmt(grouppost);
	}

	//�������׻����
	//�������״�����
	@Override
	public void adminGroupDetailNotice(Model model, GroupNoticeVo groupnoticeVo) {
		
		model.addAttribute("noticedetail", adminDao.groupNoticeDetail(groupnoticeVo));
		model.addAttribute("noticecmmt", adminDao.groupNoticeCmmtInfo(groupnoticeVo));
	}

	//�׷�����ǵ� ��۴����� �񵿱�
	@Override
	public List<GroupNoticeCommentVo> adminGroupNoticeCmmt(Model model, GroupNoticeVo groupnotice) {
		
		return adminDao.adminGroupNoticeCmmt(groupnotice);
	}
	
	//�������׻���
	@Override
	public void adminGroupDetailNoticeDelete(Model model, GroupNoticeVo groupNoticeVo) {
		
		adminDao.groupNoticeDelete(groupNoticeVo);
	}
	
	//�������״�ۻ���
	@Override
	public void adminGroupDetailNoticeCmmtDelete(Model model, GroupNoticeCommentVo groupNoticeCommentVo) {

		adminDao.groupNoticeCmmtDelete(groupNoticeCommentVo);
	}
	
	//�׷��ǵ����
	@Override
	public void adminGroupDetailDelete(Model model, GroupPostVo groupPostVo) {

		adminDao.groupFeedDelete(groupPostVo);
	}

	//�׷��ۻ���
	@Override
	public void adminGroupDetailCmmtdelete(Model model, GroupCommentVo groupCommentVo) {
		
		adminDao.groupFeedCmmtDelete(groupCommentVo);
	}

	//�׷����� ��� 
	@Override
	public void adminGroupMemberList(HttpServletRequest req, GroupVo groupVo) {
		
		req.setAttribute("joingroup", adminDao.adminGroupMemberList(groupVo));
	}

	//������������ ��� (��ü,������ ����ó��)
	//��ȸ���� �� ���ϱ�
	@Override
	public void adminUserSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		pageSearchVo.setSearch("");
		
		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(pageSearchVo.getPage2()==0) {
			pageSearchVo.setPage2(1);
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� null�� ���Ƿ� mysql�� null�ϰ� ""�ϰ� ���� �ٸ��⶧���� ""�� ������
		if(pageSearchVo.getKeyword()==null) {
			pageSearchVo.setKeyword("");
		}

		//ī�װ��� �������� ������,��ü�� �� ����
		if(pageSearchVo.getCategory()==null||pageSearchVo.getCategory().equals("")) {
			pageSearchVo.setCategory("��ü");
		}else if(pageSearchVo.getCategory().equals("���� ��")){
			pageSearchVo.setSearch("2");
		}
		
		//Ű���尪������ ���������� �˻������� ���Ϲ޾Ƽ� �������� �־���
		pageSearchVo.setTotalCount2(adminDao.adminUserCount(pageSearchVo));
		
		//ī�װ��� ��ü�϶�, �������϶� �Ѹ��°� ó��
		if(pageSearchVo.getCategory().equals("��ü")) {
			
			model.addAttribute("userlist", adminDao.adminUserSelectAll(pageSearchVo));
			
		}else if(pageSearchVo.getCategory().equals("���� ��")) {
			
			model.addAttribute("userlist", adminDao.adminUserStopSelectAll(pageSearchVo));
		}
		
		
		model.addAttribute("paging", pageSearchVo);
	}

	//���� ����ó��
	@Override
	public void adminUserStop(Model model, MyAdminVo myAdminVo) {
			
		adminDao.userStop(myAdminVo);
	}

	//���� ����ó��
	@Override
	public void adminUserKick(Model model, MyAdminVo myAdminVo) {

		adminDao.userKick(myAdminVo);
	}

	//������������(��������)
	//�����ȷ��׼�
	//�����ȷο���
	//�����ǵ��
	//�����ǵ����
	//�����ǵ������
	@Override
	public void adminUserDetail(HttpServletRequest req, ProfileVo profileVo) {
		
		
		req.setAttribute("userdetail", adminDao.userInfo(profileVo));
		req.setAttribute("userfeed", adminDao.userFeed(profileVo));
		req.setAttribute("usercmmt", adminDao.userCmmt(profileVo));
		req.setAttribute("userfeedcount", adminDao.userFeedCount(profileVo));
		req.setAttribute("userfollowing", adminDao.userFollowingCount(profileVo));
		req.setAttribute("userfollower", adminDao.userFollowerCount(profileVo));
	}

	//�����ǵ��۴����� �񵿱�
	@Override
	public List<MyCommentVo> adminUserDetailCmmt(Model model, MyPostVo post) {
		
		return adminDao.adminUserDetailCmmt(post);
	}

	//�����ǵ� ����
	@Override
	public void adminUserDelete(Model model, MyPostVo myPostVo) {
		
		adminDao.myFeedDelete(myPostVo);
	}
	
	//�����ǵ��� ����
	@Override
	public void adminUserCmmtdelete(Model model, MyCommentVo myCommentVo) {

		adminDao.myFeedCmmtDelete(myCommentVo);
	}

	//���� �ȷο�����Ʈ��� 
	@Override
	public void adminUserfollowerList(Model model, ProfileVo profile) {
		
		System.out.println(adminDao.adminUserfollowerList(profile));
		model.addAttribute("myfollower", adminDao.adminUserfollowerList(profile));
	}

	//���� �ȷ��׸���Ʈ��� 
	@Override
	public void adminUserfollowList(Model model, ProfileVo profile) {
		
		model.addAttribute("myfollowing", adminDao.adminUserfollowList(profile));
	}

	//ķ�����������
	@Override
	public void adminCampSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(pageSearchVo.getPage()==0) {
			pageSearchVo.setPage(1);
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� null�� ���Ƿ� mysql�� null�ϰ� ""�ϰ� ���� �ٸ��⶧���� ""�� ������
		if(pageSearchVo.getKeyword()==null) {
			pageSearchVo.setKeyword("");
		}
		
		pageSearchVo.setTotalCount(adminDao.adminCampCount(pageSearchVo));
		
		model.addAttribute("camplist", adminDao.adminCampSelectAll(pageSearchVo));
		model.addAttribute("paging", pageSearchVo);
	}

	//ķ���� ����ó�� +@
	@Override
	public void adminCampDeleteOne(Model model, CampVo campVo) {
		
		adminDao.campDelete(campVo);
	}
	
	//ķ���� ���ı׷�����üũ
	//�ش�ķ���� �׷��������
	//ķ�����������
	//ķ�������������
	//ķ���������򰹼����
	@Override
	public void adminCampDetail(Model model, CampVo campVo) {
		
		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(campVo.getPageSearch()==null) {
			PageSearchVo search = new PageSearchVo();
			search.setPage2(1);
			campVo.setPageSearch(search);
		}
		
		int campReviewCount=adminDao.campReviewCount(campVo);
		int ventureCheck=adminDao.groupVentureCheck(campVo);
		
		//������ �� �ο찹�� 
		campVo.getPageSearch().setTotalCount2(campReviewCount);
		
		//���ı׷� ����� �׷���������
		if(ventureCheck==1) {
			model.addAttribute("venturegroup", adminDao.ventureGroup(campVo));		//���ı׷� ����� �׷���������
		}
		
		model.addAttribute("campdetail", adminDao.campInfo(campVo));				//ķ�������� ���
		model.addAttribute("campreview", adminDao.campReviewInfo(campVo));			//�ش�ķ���� ������ ���
		model.addAttribute("reviewcount", campReviewCount);							//�ش�ķ���� �����򰹼� ���
		model.addAttribute("venturecheck", ventureCheck);							//�ش�ķ���� ���ı׷����� ��� (0 = x, 1 = o)
		model.addAttribute("paging", campVo.getPageSearch());
	}

	//�ش�ķ���������� ����
	@Override
	public void reviewDeleteOne(Model model, CampReviewVo campReviewVo) {

		adminDao.campReviewDeleteOne(campReviewVo);
	}
	
	//������������(�˻��� ����ڹ�ȣ,ķ�����̸� ����ó��)
	@Override
	public void adminVentureSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(pageSearchVo.getPage()==0) {
			pageSearchVo.setPage(1);
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� null�� ���Ƿ� mysql�� null�ϰ� ""�ϰ� ���� �ٸ��⶧���� ""�� ������
		if(pageSearchVo.getKeyword()==null) {
			pageSearchVo.setKeyword("");
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� ī�װ��� �⺻ ķ���������
		if(pageSearchVo.getCategory()==null||pageSearchVo.getCategory().equals("")) {
			pageSearchVo.setCategory("ķ�����");
		}
		
		String category=pageSearchVo.getCategory();

		//ī�װ������� ��¸���Ʈ,������ ��Żī��Ʈ�� ���
		if(category.equals("ķ�����")) {
			pageSearchVo.setTotalCount(adminDao.adminVentureCount_campName(pageSearchVo));
			model.addAttribute("venture", adminDao.adminVentureSelectAll_caname(pageSearchVo));
		}else if(category.equals("����ڵ�Ϲ�ȣ")) {
			pageSearchVo.setTotalCount(adminDao.adminVentureCount_ventureNumber(pageSearchVo));
			model.addAttribute("venture", adminDao.adminVentureSelectAll_mvnumber(pageSearchVo));
		}
		model.addAttribute("paging", pageSearchVo);
	}

	//����ڻ���ó�� +@
	//����� ����ó���� ���ı׷��ִ»�� ���� -> ����Ʈ�� ���Ϲ������� GroupVo�� groupList���ٰ� ����
	//���ı׷� ����� �Ϲݱ׷����� ������Ʈ
	@Transactional
	@Override
	public void adminVentureDeleteOne(Model model, MyVentureVo myVentureVo) {

		GroupVo group=new GroupVo();
		
		//���ı׷��ִ»���� ����
		group.setGroupList(adminDao.ventureGroupCheck(myVentureVo));
		
		//�ش� ���ı׷�� �Ϲݱ׷����� ������Ʈ
		if(!group.getGroupList().isEmpty()) {
			adminDao.ventureGroupDelete(group);
		}
		
		//�ش� ����ڵ� ����
		adminDao.ventureDelete(myVentureVo);
		
	}
	
	//����ڵ���� �̹������
	@Override
	public void AdminVentureImg(Model model, MyVentureVo myVentureVo) {
		// TODO Auto-generated method stub
		
	}

	//����ڵ���������(�˻��� ����ڹ�ȣ,ķ�����̸� ����ó��)
	@Override
	public void adminVentureRequestSelectAll(Model model, PageSearchVo pageSearchVo) {

		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(pageSearchVo.getPage()==0) {
			pageSearchVo.setPage(1);
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� null�� ���Ƿ� mysql�� null�ϰ� ""�ϰ� ���� �ٸ��⶧���� ""�� ������
		if(pageSearchVo.getKeyword()==null) {
			pageSearchVo.setKeyword("");
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� ī�װ��� �⺻ ķ���������
		if(pageSearchVo.getCategory()==null||pageSearchVo.getCategory().equals("")) {
			pageSearchVo.setCategory("ķ�����");
		}
		
		String category=pageSearchVo.getCategory();

		//ī�װ������� ��¸���Ʈ,������ ��Żī��Ʈ�� ���
		if(category.equals("ķ�����")) {
			pageSearchVo.setTotalCount(adminDao.adminVentureRequestCount_campName(pageSearchVo));
			model.addAttribute("ventureRequest", adminDao.adminVentureRequestSelectAll_caname(pageSearchVo));
		}else if(category.equals("����ڵ�Ϲ�ȣ")) {
			pageSearchVo.setTotalCount(adminDao.adminVentureRequestCount_ventureNumber(pageSearchVo));
			model.addAttribute("ventureRequest", adminDao.adminVentureRequestSelectAll_mvnumber(pageSearchVo));
		}
		model.addAttribute("paging", pageSearchVo);
	}

	//����ڵ�Ͻ���ó�� +@
	//���δ�����̺� ����ó��
	//���� �ÿ� �׷��ִ����� �׷��������� -> ����Ʈ�� ���Ϲ������� GroupVo�� groupList���ٰ� ����
	//�׷� ���� �ÿ� ���ı׷���ȯ
	@Transactional
	@Override
	public void adminVentureRequestHello(Model model, UpdateWaitVo updateWaitVo) {
		
		//���ε� ����߿� �׷��� �����ϸ� �׷찪 �̰� ���ı׷����� ������Ʈ
		GroupVo group=new GroupVo();
		group.setGroupList(adminDao.groupCheck(updateWaitVo));
		if(!group.getGroupList().isEmpty()) {
			adminDao.groupVentureUpdate(group);
		}
		
		//����ڵ�� ����ó��
		adminDao.ventureInsert(updateWaitVo);
		
		//���εȻ�� ���δ�����̺� ����
		adminDao.updateDelete(updateWaitVo);
	}

	//����ڵ�ϰ���ó�� +@
	@Override
	public void adminVentureRequestSorry(Model model, UpdateWaitVo updateWaitVo) {
		
		adminDao.updateDelete(updateWaitVo);
	}

	//�Ű�����������
	@Override
	public void adminReportSelectAll(Model model, PageSearchVo pageSearchVo) {
		

		//ùȭ��ҷ��ö� �������ѹ��� 0�̴ϱ� 1�� ������
		if(pageSearchVo==null||pageSearchVo.getPage()==0) {
			pageSearchVo.setPage(1);
		}
		
		//ùȭ��ҷ��Ë��� �˻����Ҷ� ī�װ��� �⺻ ķ���������
		if(pageSearchVo==null||pageSearchVo.getCategory()==null) {
			pageSearchVo.setCategory("");
		}
		
		//ùȭ��ҷ��ö��� �˻����Ҷ� ����Ʈ�ڽ��� ""�� �����ϰ�
		//����Ʈ�ڽ����� ��ü/ó���Ϸ�/���� �ϋ� ������
		if(pageSearchVo==null||pageSearchVo.getSearch()==null||pageSearchVo.getSearch().equals("��ü")) {
			pageSearchVo.setSearch("");
		}else if(pageSearchVo.getSearch().equals("����")) {
			pageSearchVo.setSearch("1");
		}else if(pageSearchVo.getSearch().equals("ó���Ϸ�")) {
			pageSearchVo.setSearch("2");
		}
		
		pageSearchVo.setTotalCount(adminDao.adminReportCount(pageSearchVo));
		
		model.addAttribute("reportlist", adminDao.adminReportSelectAll(pageSearchVo));
		model.addAttribute("paging", pageSearchVo);
		
		System.out.println(adminDao.adminReportSelectAll(pageSearchVo));
		System.out.println(pageSearchVo);
	}
	
	//�Ű�ó���Ϸ�� ������Ʈ +@
	@Override
	public void adminReportComplete(Model model, ReportListVo reportListVo) {
		
		adminDao.adminReportUpdate(reportListVo);
	}

	//�Ű�����������
	@Override
	public void adminReportSelectOne(Model model, ReportListVo reportListVo) {
		
		model.addAttribute("reportdetail", adminDao.adminReportSelectOne(reportListVo));
	}

	long i;		//����ų�� �ѹ� �����ϹǷ� �װ� ���¿�
	
	//�������� ��¥ī��Ʈ -1ó�� (���� Ų�ð� �������� 24�ð����� ī����)
	@Scheduled(fixedDelay = 60000*60*24)
	public void stopUserCheck() {
		
		if(i>1) {
			List<ProfileVo> stopUser = adminDao.stopUserList();
			//���������� �����Ұ�� ����
			if(!stopUser.isEmpty()) {
				StopUser stop = new StopUser();
				Object[] obj = null;
				obj = stop.StopUserCount(adminDao.stopUserList());
				
				//�ٿ�ĳ������������ ���赵�� ������������ ����
				//StopUser Ŭ�������� List<ProfileVo> Ÿ������ Object[]�� ��ұ⶧���� �� �������� �����
				@SuppressWarnings("unchecked")
				List<ProfileVo> stop_zero = (List<ProfileVo>) obj[0];
				@SuppressWarnings("unchecked")
				List<ProfileVo> stop_over = (List<ProfileVo>) obj[1];
				
				ProfileVo profile1 = new ProfileVo();
				ProfileVo profile2 = new ProfileVo();
				
				profile1.setProfileList(stop_zero);
				profile2.setProfileList(stop_over);
				
		
				//�������� 0�϶� ����Ǯ��
				if(!profile1.getProfileList().isEmpty()) {
					adminDao.updateStop_zero(profile1);
				}
				
				//�������� 1�̻��϶� ������ ������Ʈ
				if(!profile2.getProfileList().isEmpty()) {
					adminDao.updateStop_over(profile2);
				}
			}
		}
		
		i++;
	}
	
}
