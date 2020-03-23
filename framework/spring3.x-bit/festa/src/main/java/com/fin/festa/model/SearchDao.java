package com.fin.festa.model;

import java.util.List;

import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;

public interface SearchDao {
	
	List<CampVo> searchCampSelectAll(PageSearchVo search);
	
	List<GroupVo> searchGroupSelectAll(PageSearchVo search);
	
	List<MyPostVo> searchMyFeedSelectAll(PageSearchVo search);
	
	List<GroupPostVo> searchGroupFeedSelectAll(PageSearchVo search);
	
	MyPostVo myFeedDetail(MyPostVo post);
	
	List<MyCommentVo> myFeedCmmtSelectAll(MyPostVo post);
	
	GroupPostVo groupFeedDetail(GroupPostVo grouppost);
	
	List<GroupCommentVo> groupFeedCmmtSelectAll(GroupPostVo grouppost);
	
	int myFeedUpdateOne(MyPostVo post);
	
	int groupFeedUpdateOne(GroupPostVo grouppost);
	
	int myFeedDeleteOne(MyPostVo post);
	
	int groupFeedDeleteOne(GroupPostVo grouppost);
	
	void myFeedCmmtInsertOne(MyCommentVo cmmt);
	
	void groupFeedCmmtInsertOne(GroupCommentVo groupcmmt);
	
	int myFeedCmmtDeleteOne(MyCommentVo cmmt);
	
	int groupFeedCmmtDeleteOne(GroupCommentVo groupcmmt);
	
	void myFeedLikeInsertOne(MyGoodVo good);
	
	void groupFeedLikeInsertOne(MyGoodVo good);
	
	int myFeedLikeDeleteOne(MyGoodVo good);
	
	int groupFeedLikeDeleteOne(MyGoodVo good);
	
	int myFeedLikePlusOne(MyGoodVo good);
	
	int groupFeedLikePlusOne(MyGoodVo good);
	
	int myFeedLikeMinusOne(MyGoodVo good);
	
	int groupFeedLikeMinusOne(MyGoodVo good);
	
	List<MyGoodVo> myGoodRenewal(MyGoodVo good);
	
	void myFeedReportInsertOne(ReportListVo report);
	
	void groupFeedReportInsertOne(ReportListVo report);
	
	int feedUserReportCountUpdate(ReportListVo report);
}