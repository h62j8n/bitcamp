package com.fin.festa.model.entity;

public class HashTagVo {		//해시태그(전체) 

	private int htnum;			//해시태그 번호 (pk)
	private String httitle1;	//해시태그 내용
	private String httitle2;	//	″
	private String httitle3;	//	″
	private int gpnum;			//게시글 해시태그
	private int canum;			//캠핑장 해시태그
	private int grnum;			//그룹 해시태그
	private int mpnum;			//피드 해시태그
	private CampVo camp;
	private CampReviewVo campReview;
	private GroupCommentVo groupComment;
	private GroupNoticeCommentVo groupNoticeComment;
	private GroupNoticeVo groupNotice;
	private GroupPostVo groupPost;
	private GroupVo group;
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
		return "HashTagVo [htnum=" + htnum + ", httitle1=" + httitle1 + ", httitle2=" + httitle2 + ", httitle3="
				+ httitle3 + ", gpnum=" + gpnum + ", canum=" + canum + ", grnum=" + grnum + ", mpnum=" + mpnum
				+ ", camp=" + camp + ", campReview=" + campReview + ", groupComment=" + groupComment
				+ ", groupNoticeComment=" + groupNoticeComment + ", groupNotice=" + groupNotice + ", groupPost="
				+ groupPost + ", group=" + group + ", joinGroup=" + joinGroup + ", myAdmin=" + myAdmin + ", myBookMark="
				+ myBookMark + ", myComment=" + myComment + ", myFollower=" + myFollower + ", myFollowing=" + myFollowing
				+ ", myGood=" + myGood + ", myPost=" + myPost + ", myVenture=" + myVenture + ", pageSearch="
				+ pageSearch + ", profile=" + profile + ", reportList=" + reportList + ", updateWait=" + updateWait
				+ "]";
	}
	
	public HashTagVo() {
		// TODO Auto-generated constructor stub
	}

	public HashTagVo(int htnum, String httitle1, String httitle2, String httitle3, int gpnum, int canum, int grnum,
			int mpnum, CampVo camp, CampReviewVo campReview, GroupCommentVo groupComment,
			GroupNoticeCommentVo groupNoticeComment, GroupNoticeVo groupNotice, GroupPostVo groupPost, GroupVo group,
			JoinGroupVo joinGroup, MyAdminVo myAdmin, MyBookMarkVo myBookMark, MyCommentVo myComment,
			MyFollowerVo myFollower, MyFollowingVo myFollowing, MyGoodVo myGood, MyPostVo myPost, MyVentureVo myVenture,
			PageSearchVo pageSearch, ProfileVo profile, ReportListVo reportList, UpdateWaitVo updateWait) {
		super();
		this.htnum = htnum;
		this.httitle1 = httitle1;
		this.httitle2 = httitle2;
		this.httitle3 = httitle3;
		this.gpnum = gpnum;
		this.canum = canum;
		this.grnum = grnum;
		this.mpnum = mpnum;
		this.camp = camp;
		this.campReview = campReview;
		this.groupComment = groupComment;
		this.groupNoticeComment = groupNoticeComment;
		this.groupNotice = groupNotice;
		this.groupPost = groupPost;
		this.group = group;
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

	public int getHtnum() {
		return htnum;
	}

	public void setHtnum(int htnum) {
		this.htnum = htnum;
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

	public int getGpnum() {
		return gpnum;
	}

	public void setGpnum(int gpnum) {
		this.gpnum = gpnum;
	}

	public int getCanum() {
		return canum;
	}

	public void setCanum(int canum) {
		this.canum = canum;
	}

	public int getGrnum() {
		return grnum;
	}

	public void setGrnum(int grnum) {
		this.grnum = grnum;
	}

	public int getMpnum() {
		return mpnum;
	}

	public void setMpnum(int mpnum) {
		this.mpnum = mpnum;
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

	public GroupVo getGroup() {
		return group;
	}

	public void setGroup(GroupVo group) {
		this.group = group;
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

	public void setMyFollwer(MyFollowerVo myFollower) {
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
