package com.fin.festa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.FeedDaoImpl;
import com.fin.festa.model.IndexDaoImpl;
import com.fin.festa.model.entity.FeedVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.util.DateCalculate;
import com.fin.festa.util.UploadPhoto;

@Service
public class FeedServiceImpl implements FeedService{

	//���,����,������ �ּ�2���̻� ���� �޼ҵ�� �� Ʈ����� �����Ұ�!!
	
	@Autowired
	FeedDaoImpl feedDao;
	
	@Autowired 
	IndexDaoImpl indexDao;
	
	//�α��ǵ� ���(�׷��ǵ�,�����ǵ� ���ļ�)
	@Override
	public void hotFeedSelectAll(HttpServletRequest req) {

		DateCalculate cal=new DateCalculate();
		FeedVo feed = new FeedVo();
		List<FeedVo> groupFeedList = feedDao.hotGroupFeedSelectAll();
		List<FeedVo> myFeedList = feedDao.hotMyFeedSelectAll();
		
		//�׷��ǵ��ۻ���
		feed.setFeedList(groupFeedList);
		req.setAttribute("groupFeedCmmt", feedDao.hotGroupCommentSelectAll(feed));
		//�����ǵ��ۻ���
		feed.setFeedList(myFeedList);
		req.setAttribute("myFeedCmmt", feedDao.hotMyCommentSelectAll(feed));
		//�ǵ� ��¥�� ����
		req.setAttribute("feedList", cal.VoDateReturn(groupFeedList, myFeedList));
		
		//���������ٴϴ� �α�ķ����,�׷���
		if(req.getSession().getAttribute("login")!=null) {
			req.setAttribute("grouplist", indexDao.addrGroupSelectAll((ProfileVo)req.getSession().getAttribute("login")));
		}else {
			req.setAttribute("grouplist", indexDao.totalGroupSelectAll());
		}
		req.setAttribute("camplist", indexDao.veryHotCampSelectAll());
		
	}

	//�α�׷��ǵ� ��۴�����
	@Override
	public List<GroupCommentVo> groupFeedCmmtMore(Model model, GroupPostVo groupPostVo) {
		
		return feedDao.groupFeedCmmtMore(groupPostVo);
	}

	//�αⰳ���ǵ� ��۴�����
	@Override
	public List<MyCommentVo> myFeedCmmtMore(Model model, MyPostVo myPostVo) {
		
		return feedDao.myFeedCmmtMore(myPostVo);
	}

	//�α��ǵ� ��۵��(�׷��ǵ�,�����ǵ� �����ؼ� ���)
	@Override
	public void hotFeedCmmtInsertOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {

		//�����ǵ� ��۵��
		if(groupCommentVo.getGpnum()==0) {
			feedDao.myFeedCmmtInsertOne(myCommentVo);
		//�׷��ǵ� ��۵��
		}else {
			feedDao.groupFeedCmmtInsertOne(groupCommentVo);
		}
	}

	//�α��ǵ� ��ۻ���(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void hotFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo, MyCommentVo myCommentVo) {

		//�׷��ǵ�,�����ǵ� ����
		if(groupCommentVo.getGcnum()==0) {
			feedDao.myFeedCmmtDeleteOne(myCommentVo);
		}else {
			feedDao.groupFeedCmmtDeleteOne(groupCommentVo);
		}
	}

	//�α��ǵ� ���ƿ���(�׷��ǵ�,�����ǵ� �����ؼ� ���ƿ���)
	//�α��ǵ� ���ƿ䰹�� +1
	//�� ���ƿ��� ����
	@Transactional
	@Override
	public void hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {

		//�����ǵ��϶�
		if(myGoodVo.getGpnum()==0) {
			feedDao.myFeedLikeInsertOne(myGoodVo);
			
			MyPostVo post=new MyPostVo();
			post.setMpnum(myGoodVo.getMpnum());
			
			feedDao.myFeedLikeOnePlus(post);
		//�׷��ǵ��϶�
		}else {
			feedDao.groupFeedLikeInsertOne(myGoodVo);
			
			GroupPostVo grouppost=new GroupPostVo();
			grouppost.setGpnum(myGoodVo.getGpnum());
			
			feedDao.groupFeedLikeOnePlus(grouppost);
		}
		req.getSession().setAttribute("goodlist", feedDao.myGoodRenewal(myGoodVo));
	}

	//�α��ǵ� ���ƿ�����(�׷��ǵ�,�����ǵ� �����ؼ� ���ƿ�����)
	//�α��ǵ� ���ƿ䰹�� -1
	//�� ���ƿ��� ����
	@Transactional
	@Override
	public void hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {

		//�����ǵ��϶�
		if(myGoodVo.getGpnum()==0) {
			feedDao.myFeedLikeDeleteOne(myGoodVo);
			
			MyPostVo post=new MyPostVo();
			post.setMpnum(myGoodVo.getMpnum());
			
			feedDao.myFeedLikeOneMinus(post);
		//�׷��ǵ��϶�
		}else {
			feedDao.groupFeedLikeDeleteOne(myGoodVo);
			
			GroupPostVo grouppost=new GroupPostVo();
			grouppost.setGpnum(myGoodVo.getGpnum());
			
			feedDao.groupFeedLikeOneMinus(grouppost);
		}
		req.getSession().setAttribute("goodlist", feedDao.myGoodRenewal(myGoodVo));
	}

	//�α��ǵ� �Ű���(�׷��ǵ�,�����ǵ� �����ؼ� �Ű���)
	//�ش� �Ű�������� �Ű����Ƚ�� +1
	@Transactional
	@Override
	public void hotFeedReport(HttpServletRequest req, ReportListVo reportListVo, MultipartFile[] files) {

		UploadPhoto up = new UploadPhoto();
		String rlphoto = up.upload(files, req, reportListVo);
		reportListVo.setRlphoto(rlphoto);
		
		//��Ÿ��ư�����ٰ� �ٸ���üũ�ϰ� �Ѿ�°�� �ٸ���üũ������ ��ü
		String rlreport = reportListVo.getRlreport();
		String[] report = rlreport.split(",");
		if(report.length>1) {
			if(report[0].equals("��Ÿ")) {
				rlreport = report[1];
			}else {
				rlreport = report[0];
			}
		}else {
			rlreport=rlreport.substring(0, rlreport.length()-1);
		}
		reportListVo.setRlreport(rlreport);
		
		//�����ǵ����� �׷��ǵ����� üũ
		if(reportListVo.getGpnum()==0) {
			feedDao.myFeedReportInsertOne(reportListVo);
		}else {
			feedDao.groupFeedReportInsertOne(reportListVo);
		}
		
		feedDao.feedReportCountUpdate(reportListVo);
	}

	//�α��ǵ� ����(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void hotFeedUpdateOne(HttpServletRequest req, GroupPostVo groupPostVo, MyPostVo myPostVo, MultipartFile[] files) {
		
		UploadPhoto up = new UploadPhoto();
		//�����ǵ����� �׷��ǵ����� üũ
		if(groupPostVo.getGpnum()==0) {
			String mpphoto = up.upload(files, req, myPostVo);
			//������ �ִ������� �����Ҷ�
			if(myPostVo.getMpphoto()!=null) {
				//�Ѿ�� ÷�λ����� �����Ҷ�(������ ���� ���������)
				if(!mpphoto.equals("")) {
					mpphoto=myPostVo.getMpphoto()+","+mpphoto;
					myPostVo.setMpphoto(mpphoto);
				}
			//������ �ִ������� ������
			}else {
				myPostVo.setMpphoto(mpphoto);
			}
			feedDao.myFeedUpdateOne(myPostVo);
		}else {
			String gpphoto = up.upload(files, req, groupPostVo);
			//������ �ִ������� �����Ҷ�
			if(groupPostVo.getGpphoto()!=null) {
				//�Ѿ�� ÷�λ����� �����Ҷ�(������ ���� ���������)
				if(!gpphoto.equals("")) {
					gpphoto=groupPostVo.getGpphoto()+","+gpphoto;
					groupPostVo.setGpphoto(gpphoto);
				}
			//������ �ִ������� ������
			}else {
				groupPostVo.setGpphoto(gpphoto);
			}
			feedDao.groupFeedUpdateOne(groupPostVo);
		}
	}

	//�α��ǵ� �����˾� �������
	@Override
	public void hotFeedUpdateOnePop(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {

		//�����ǵ�,�׷��ǵ� ����
		if(groupPostVo.getGpnum()==0) {
			model.addAttribute("feedEdit", feedDao.myFeedSelectOne(myPostVo));
			System.out.println(feedDao.myFeedSelectOne(myPostVo));
		}else {
			model.addAttribute("feedEdit", feedDao.groupFeedSelectOne(groupPostVo));
			System.out.println(feedDao.groupFeedSelectOne(groupPostVo));
		}
	}

	//�α��ǵ� ����(�׷��ǵ�,�����ǵ� �����ؼ� ����)
	@Override
	public void hotFeedDeleteOne(Model model, GroupPostVo groupPostVo, MyPostVo myPostVo) {

		//�׷��ǵ�,�����ǵ� ����
		if(groupPostVo.getGpnum()==0) {
			feedDao.myFeedDeleteOne(myPostVo);
		}else {
			feedDao.GroupFeedDeleteOne(groupPostVo);
		}
	}


}
