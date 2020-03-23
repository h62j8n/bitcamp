package com.fin.festa.model.entity;

import java.sql.Date;
import java.util.List;

public class GroupVo {					//�׷�
	
	private List<GroupVo> groupList;	//�׷� �迭�Ķ���Ϳ� ���̴°�
	private int grnum;					//�׷� ��ȣ (pk)
	private String grname;				//�׷� �̸�
	private String grintro;				//�׷� �Ұ�
	private String grphoto;				//�׷� ����
	private String graddr;				//�׷� �ּ�
	private String httitle1;			//�׷��ؽ��±�1
	private String httitle2;			//�׷��ؽ��±�2
	private String httitle3;			//�׷��ؽ��±�3
	private Date grdate;				//�׷� ������
	private int pronum;					//�׷� ��ǥ�� ��ȣ
	private int grtotal;				//�׷� �ο���
	private int grventure;				//�׷� ����� ����
	private int grrn;					//������ ��ȣ
	private int jointot;				//���Խ��� ��Ͻ� �ο���,�����߹�� �ο���
	private CampVo camp;
	private CampReviewVo campReview;
	private GroupCommentVo groupComment;
	private GroupNoticeCommentVo groupNoticeComment;
	private GroupNoticeVo groupNotice;
	private GroupPostVo groupPost;
	private JoinGroupVo joinGroup;
	private MyAdminVo myAdmin;
	private MyBookMarkVo myBookMark;
	private MyCommentVo myComment;
	private MyFollowerVo myFollower;
	private MyFollowingVo myFollowing;
	private MyGoodVo myGood;
	private MyPostVo myPost;
	private MyVentureVo myVenture;
	private PageSearchVo pageSearch;
	private ProfileVo profile;
	private ReportListVo reportList;
	private UpdateWaitVo updateWait;
	
	@Override
	public String toString() {
		return "GroupVo [groupList=" + groupList + ", grnum=" + grnum + ", grname=" + grname + ", grintro=" + grintro
				+ ", grphoto=" + grphoto + ", graddr=" + graddr + ", httitle1=" + httitle1 + ", httitle2=" + httitle2
				+ ", httitle3=" + httitle3 + ", grdate=" + grdate + ", pronum=" + pronum + ", grtotal=" + grtotal
				+ ", grventure=" + grventure + ", grrn=" + grrn + ", jointot=" + jointot + ", camp=" + camp
				+ ", campReview=" + campReview + ", groupComment=" + groupComment + ", groupNoticeComment="
				+ groupNoticeComment + ", groupNotice=" + groupNotice + ", groupPost=" + groupPost + ", joinGroup="
				+ joinGroup + ", myAdmin=" + myAdmin + ", myBookMark=" + myBookMark + ", myComment=" + myComment
				+ ", myFollower=" + myFollower + ", myFollowing=" + myFollowing + ", myGood=" + myGood + ", myPost="
				+ myPost + ", myVenture=" + myVenture + ", pageSearch=" + pageSearch + ", profile=" + profile
				+ ", reportList=" + reportList + ", updateWait=" + updateWait + "]";
	}
	
	public GroupVo() {
		// TODO Auto-generated constructor stub
	}

	public GroupVo(List<GroupVo> groupList, int grnum, String grname, String grintro, String grphoto, String graddr,
			String httitle1, String httitle2, String httitle3, Date grdate, int pronum, int grtotal, int grventure,
			int grrn, int jointot, CampVo camp, CampReviewVo campReview, GroupCommentVo groupComment,
			GroupNoticeCommentVo groupNoticeComment, GroupNoticeVo groupNotice, GroupPostVo groupPost,
			JoinGroupVo joinGroup, MyAdminVo myAdmin, MyBookMarkVo myBookMark, MyCommentVo myComment,
			MyFollowerVo myFollower, MyFollowingVo myFollowing, MyGoodVo myGood, MyPostVo myPost, MyVentureVo myVenture,
			PageSearchVo pageSearch, ProfileVo profile, ReportListVo reportList, UpdateWaitVo updateWait) {
		super();
		this.groupList = groupList;
		this.grnum = grnum;
		this.grname = grname;
		this.grintro = grintro;
		this.grphoto = grphoto;
		this.graddr = graddr;
		this.httitle1 = httitle1;
		this.httitle2 = httitle2;
		this.httitle3 = httitle3;
		this.grdate = grdate;
		this.pronum = pronum;
		this.grtotal = grtotal;
		this.grventure = grventure;
		this.grrn = grrn;
		this.jointot = jointot;
		this.camp = camp;
		this.campReview = campReview;
		this.groupComment = groupComment;
		this.groupNoticeComment = groupNoticeComment;
		this.groupNotice = groupNotice;
		this.groupPost = groupPost;
		this.joinGroup = joinGroup;
		this.myAdmin = myAdmin;
		this.myBookMark = myBookMark;
		this.myComment = myComment;
		this.myFollower = myFollower;
		this.myFollowing = myFollowing;
		this.myGood = myGood;
		this.myPost = myPost;
		this.myVenture = myVenture;
		this.pageSearch = pageSearch;
		this.profile = profile;
		this.reportList = reportList;
		this.updateWait = updateWait;
	}

	public List<GroupVo> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupVo> groupList) {
		this.groupList = groupList;
	}

	public int getGrnum() {
		return grnum;
	}

	public void setGrnum(int grnum) {
		this.grnum = grnum;
	}

	public String getGrname() {
		return grname;
	}

	public void setGrname(String grname) {
		this.grname = grname;
	}

	public String getGrintro() {
		return grintro;
	}

	public void setGrintro(String grintro) {
		this.grintro = grintro;
	}

	public String getGrphoto() {
		return grphoto;
	}

	public void setGrphoto(String grphoto) {
		this.grphoto = grphoto;
	}

	public String getGraddr() {
		return graddr;
	}

	public void setGraddr(String graddr) {
		this.graddr = graddr;
	}

	public String getHttitle1() {
		return httitle1;
	}

	public void setHttitle1(String httitle1) {
		this.httitle1 = httitle1;
	}

	public String getHttitle2() {
		return httitle2;
	}

	public void setHttitle2(String httitle2) {
		this.httitle2 = httitle2;
	}

	public String getHttitle3() {
		return httitle3;
	}

	public void setHttitle3(String httitle3) {
		this.httitle3 = httitle3;
	}

	public Date getGrdate() {
		return grdate;
	}

	public void setGrdate(Date grdate) {
		this.grdate = grdate;
	}

	public int getPronum() {
		return pronum;
	}

	public void setPronum(int pronum) {
		this.pronum = pronum;
	}

	public int getGrtotal() {
		return grtotal;
	}

	public void setGrtotal(int grtotal) {
		this.grtotal = grtotal;
	}

	public int getGrventure() {
		return grventure;
	}

	public void setGrventure(int grventure) {
		this.grventure = grventure;
	}

	public int getGrrn() {
		return grrn;
	}

	public void setGrrn(int grrn) {
		this.grrn = grrn;
	}

	public int getJointot() {
		return jointot;
	}

	public void setJointot(int jointot) {
		this.jointot = jointot;
	}

	public CampVo getCamp() {
		return camp;
	}

	public void setCamp(CampVo camp) {
		this.camp = camp;
	}

	public CampReviewVo getCampReview() {
		return campReview;
	}

	public void setCampReview(CampReviewVo campReview) {
		this.campReview = campReview;
	}

	public GroupCommentVo getGroupComment() {
		return groupComment;
	}

	public void setGroupComment(GroupCommentVo groupComment) {
		this.groupComment = groupComment;
	}

	public GroupNoticeCommentVo getGroupNoticeComment() {
		return groupNoticeComment;
	}

	public void setGroupNoticeComment(GroupNoticeCommentVo groupNoticeComment) {
		this.groupNoticeComment = groupNoticeComment;
	}

	public GroupNoticeVo getGroupNotice() {
		return groupNotice;
	}

	public void setGroupNotice(GroupNoticeVo groupNotice) {
		this.groupNotice = groupNotice;
	}

	public GroupPostVo getGroupPost() {
		return groupPost;
	}

	public void setGroupPost(GroupPostVo groupPost) {
		this.groupPost = groupPost;
	}

	public JoinGroupVo getJoinGroup() {
		return joinGroup;
	}

	public void setJoinGroup(JoinGroupVo joinGroup) {
		this.joinGroup = joinGroup;
	}

	public MyAdminVo getMyAdmin() {
		return myAdmin;
	}

	public void setMyAdmin(MyAdminVo myAdmin) {
		this.myAdmin = myAdmin;
	}

	public MyBookMarkVo getMyBookMark() {
		return myBookMark;
	}

	public void setMyBookMark(MyBookMarkVo myBookMark) {
		this.myBookMark = myBookMark;
	}

	public MyCommentVo getMyComment() {
		return myComment;
	}

	public void setMyComment(MyCommentVo myComment) {
		this.myComment = myComment;
	}

	public MyFollowerVo getMyFollower() {
		return myFollower;
	}

	public void setMyFollower(MyFollowerVo myFollower) {
		this.myFollower = myFollower;
	}

	public MyFollowingVo getMyFollowing() {
		return myFollowing;
	}

	public void setMyFollowing(MyFollowingVo myFollowing) {
		this.myFollowing = myFollowing;
	}

	public MyGoodVo getMyGood() {
		return myGood;
	}

	public void setMyGood(MyGoodVo myGood) {
		this.myGood = myGood;
	}

	public MyPostVo getMyPost() {
		return myPost;
	}

	public void setMyPost(MyPostVo myPost) {
		this.myPost = myPost;
	}

	public MyVentureVo getMyVenture() {
		return myVenture;
	}

	public void setMyVenture(MyVentureVo myVenture) {
		this.myVenture = myVenture;
	}

	public PageSearchVo getPageSearch() {
		return pageSearch;
	}

	public void setPageSearch(PageSearchVo pageSearch) {
		this.pageSearch = pageSearch;
	}

	public ProfileVo getProfile() {
		return profile;
	}

	public void setProfile(ProfileVo profile) {
		this.profile = profile;
	}

	public ReportListVo getReportList() {
		return reportList;
	}

	public void setReportList(ReportListVo reportList) {
		this.reportList = reportList;
	}

	public UpdateWaitVo getUpdateWait() {
		return updateWait;
	}

	public void setUpdateWait(UpdateWaitVo updateWait) {
		this.updateWait = updateWait;
	}
	
	
}
