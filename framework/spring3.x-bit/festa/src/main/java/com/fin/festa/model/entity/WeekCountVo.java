package com.fin.festa.model.entity;

public class WeekCountVo {		//�̹��� �ű�������Ȳ���Vo

	private int userCount;		//�̹��� �ű԰����� ��  
	private int groupCount;		//�̹��� �׷���� ��
	private int ventureCount;	//�̹��� ����ڽ�û ��
	private int campCount;		//�̹��� ķ������ ��
	private int reportCount;	//�̹��� �Ű��� ��
	
	@Override
	public String toString() {
		return "WeekCountVo [userCount=" + userCount + ", groupCount=" + groupCount + ", ventureCount=" + ventureCount
				+ ", campCount=" + campCount + ", reportCount=" + reportCount + "]";
	}
	
	public WeekCountVo() {
		// TODO Auto-generated constructor stub
	}

	public WeekCountVo(int userCount, int groupCount, int ventureCount, int campCount, int reportCount) {
		super();
		this.userCount = userCount;
		this.groupCount = groupCount;
		this.ventureCount = ventureCount;
		this.campCount = campCount;
		this.reportCount = reportCount;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public int getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	public int getVentureCount() {
		return ventureCount;
	}

	public void setVentureCount(int ventureCount) {
		this.ventureCount = ventureCount;
	}

	public int getCampCount() {
		return campCount;
	}

	public void setCampCount(int campCount) {
		this.campCount = campCount;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}
	
	
}
