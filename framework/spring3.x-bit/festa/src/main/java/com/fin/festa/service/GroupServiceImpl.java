package com.fin.festa.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.GroupDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyBookMarkVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.util.UploadPhoto;

@Service
public class GroupServiceImpl implements GroupService{

	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	GroupDaoImpl groupDao;
	

	//���Ե� �׷����� üũ
	@Override
	public int joinGroup(HttpServletRequest req, UpdateWaitVo updateWaitVo) {
		int result=groupDao.joinGroupCheck(updateWaitVo);
		int result2=groupDao.updateGroupCheck(updateWaitVo);
		int check=0;
		if(result == 0 && result2 ==0) {				//���Ե� �׷��� �ƴ�
			return check;
		} else if (result == 0 && result2 == 1){		//���� �����
			check=1;
			return check;
		} else {										//�׷��
			check=2;
			return check;
		}
	}

	//���ı׷����� üũ
	//�׷��������
	//�׷��ǵ����
	//�׷�����������
	//�׷��ǵ������
	@Override
	public void groupSelectOne(HttpServletRequest req, GroupVo groupVo) {
		req.setAttribute("check", groupDao.groupVentureCheck(groupVo));
		req.setAttribute("detail", groupDao.groupSelectOne(groupVo));
		req.setAttribute("feed", groupDao.groupFeedSelectAll(groupVo));
		req.setAttribute("ntc", groupDao.groupNoticeSelectAll(groupVo));
		req.setAttribute("feedcmmt", groupDao.groupFeedCmmtSelectAll(groupVo));
	}

	//�������״�� ������ �񵿱�
	@Override
	public List<GroupNoticeCommentVo> groupNoticeDetailCmmt(Model model, GroupNoticeVo groupnotice) {
		return groupDao.groupNoticeDetailCmmt(groupnotice);
	}

	//�׷��ǵ��� ������ �񵿱�
	@Override
	public List<GroupCommentVo> groupDetailCmmt(Model model, GroupPostVo grouppost) {
		return groupDao.groupDetailCmmt(grouppost);
	}
	
	//�׷��ο����� ���
	@Override
	public void groupMemberList(HttpServletRequest req, GroupVo groupVo) {
		req.setAttribute("member", groupDao.groupUserInfo(groupVo));
	}
	
	//�׷� �Ű���
	//�Ű�������� �Ű����Ƚ�� +1
	@Override
	public void groupReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//�������� ���
	@Override
	public void noticeInsertOne(HttpServletRequest req, MultipartFile[] files, GroupNoticeVo groupNoticeVo) {
		UploadPhoto up = new UploadPhoto();
		String gnPhoto=up.upload(files, req, groupNoticeVo);
		groupNoticeVo.setGnphoto(gnPhoto);
		groupDao.groupNoticeInsert(groupNoticeVo);
	}

	//�������� ���������
	//�������� ������
	@Override
	public void noticeSelectOne(HttpServletRequest req, GroupNoticeVo groupNoticeVo) {
		GroupVo group=new GroupVo();
		group.setGrnum(groupNoticeVo.getGrnum());
		req.setAttribute("detail", groupDao.groupSelectOne(group));
		req.setAttribute("ntc", groupDao.groupNoticeSelectAll(group));
		req.setAttribute("ntcDetail", groupDao.groupNoticeSelectOne(groupNoticeVo));
		req.setAttribute("ntcCmmt", groupDao.groupNoticeCmmtSelectAll(groupNoticeVo));
	}
	

	//�������� ����
	@Override
	public void noticeUpdateOne(Model model, GroupNoticeVo groupNoticeVo) {
		
	}

	//�������� ����
	@Override
	public void noticeDeleteOne(Model model, GroupNoticeVo groupNoticeVo) {
		groupDao.groupNoticeDelete(groupNoticeVo);
	}

	//�������� ��۵��
	@Override
	public void noticeCmmtInsertOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo) {
		groupDao.groupNoticeCmmtInsert(groupNoticeCommentVo);
	}

	//�������� ��ۻ���
	@Override
	public void noticeCmmtDeleteOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo) {
		groupDao.groupNoticeCmmtDelete(groupNoticeCommentVo);
	}

	//�������� �Ű���
	//�ش����� �Ű�Ƚ�� +1
	@Override
	public void noticeReport(Model model, ReportListVo reportListVo) {
	}

	//�׷��ǵ� ���
	@Override
	public void groupFeedInsertOne(HttpServletRequest req, MultipartFile[] files, GroupPostVo groupPostVo) {
		UploadPhoto up = new UploadPhoto();
		String mpPhoto=up.upload(files, req, groupPostVo);
		groupPostVo.setGpphoto(mpPhoto);
		groupDao.groupFeedInsert(groupPostVo);
	}

	
	//�׷��ǵ� ����
	@Override
	public void groupFeedUpdateOne(Model model, GroupPostVo groupPostVo) {
		// TODO Auto-generated method stub
		
	}

	//�׷��ǵ� ����
	@Override
	public void groupFeedDeleteOne(Model model, GroupPostVo groupPostVo) {
		groupDao.groupFeedDelete(groupPostVo);
	}

	//�׷��ǵ� ��۵��
	@Override
	public void groupFeedCmmtInsertOne(HttpServletRequest req, GroupCommentVo groupCommentVo) {
		groupDao.groupFeedCmmtInsert(groupCommentVo);
	}

	//�׷��ǵ� ��ۻ���
	@Override
	public void groupFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo) {
		groupDao.groupFeedCmmtDelete(groupCommentVo);
	}

	//�׷��ǵ� ���ƿ���
	//�ǵ� ���ƿ� ���� +1
	@Override
	public void FeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//�׷��ǵ� ���ƿ�����
	//�ǵ� ���ƿ� ���� -1
	@Override
	public void FeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		// TODO Auto-generated method stub
		
	}

	//�׷��ǵ� �Ű���
	//�Ű�������� �Ű����Ƚ�� +1
	@Override
	public void groupFeedReport(Model model, ReportListVo reportListVo) {
		// TODO Auto-generated method stub
		
	}

	//ä�� ���� �̱���..
	@Override
	public void groupChat(Model model) {
		// TODO Auto-generated method stub
		
	}

	//�׷�����������

	
	//�׷��ѿ����
	@Override
	public void groupAdminSelectOne(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//�׷���� ����
	@Override
	public void groupAdminUpdateOne(HttpServletRequest req, GroupVo groupVo) {
		groupDao.groupInfoUpdate(groupVo);
	}

	//���Ե� �������� ���
	//������ ���������� 10�� �ο�
	//�˻����� ���� �Ѿ�ð�� �˻����� �������� ���(keyword!=null)
	//����������� ���� ����������ȸ ���̺� �ο찹�� �̱�
	@Override
	public void groupUserAdminSelectAll(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//���Ե� ���� ����
	//�׷� �����ѿ� -@
	@Override
	public void groupUserKick(Model model, JoinGroupVo joinGroupVo) {
		// TODO Auto-generated method stub
		
	}

	//���Ե� ���� ���ΰ��� (�׷��� ����)
	//�׷� �����ѿ� -@
	@Override
	public void groupUserAllKick(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//���Խ�û �������� ���
	//������ ���������� 5�� �ο�
	//����������� ���� ���Խ�û��ȸ ���̺� �ο찹�� �̱�
	@Override
	public void groupRequestSelectAll(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//���Խ�û �������
	//�׷� �����ѿ� +@
	//������Ʈ���̺� �����ͻ���(���Խ�û ���� �޼ҵ� ���)
	@Override
	public void groupRequestHello(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//���Խ�û ���� ��ε��(���Խ�û ���� �޼ҵ� ���)
	//�׷� �����ѿ� +@
	//������Ʈ���̺� �����ͻ���(���Խ�û ���� �޼ҵ� ���)
	@Override
	public void groupRequestEverybodyHello(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//���Խ�û ����
	@Override
	public void groupRequestSorry(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//���Խ�û ��ΰ���(���Խ�û ���� �޼ҵ� ���)
	@Override
	public void groupRequestVeryverySorry(Model model, UpdateWaitVo updateWaitVo) {
		// TODO Auto-generated method stub
		
	}

	//�׷� ����
	@Override
	public void groupDeleteOne(Model model, GroupVo groupVo) {
		// TODO Auto-generated method stub
		
	}

	//���Եȱ׷� Ż��
	@Override
	public void groupOut(Model model, JoinGroupVo joinGroup) {
		// TODO Auto-generated method stub
		
	}

	//ȸ�� �ȷ��׵��
	//��� �ȷο����
	//�� �ȷ��׸�� ����
	@Override
	public void followInsertOne(HttpServletRequest req, MyFollowingVo myFollowing) {
		// TODO Auto-generated method stub
		
	}

	//ȸ�� �ȷ�������
	//��� �ȷο�����
	//�� �ȷ��׸�� ����
	@Override
	public void followDeleteOne(HttpServletRequest req, MyFollowingVo myFollowing) {
		// TODO Auto-generated method stub
		
	}



}
