package com.fin.festa.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fin.festa.model.entity.PageSearchVo;

//��¥���� ���
public class DateCalculate {

	//����
	private Date today;			//�ð� �����Ϳ� ���̴��ʵ尪
	
	//����ð� �̴µ�����
	private String time1;		//���� ��¥
	
	//������ �ű��̿���������� �̴µ�����
	private String time2;		//������ ��¥
	private String monday;		//�����ֱ��� ������ ��¥
	private String tuesday;		//�����ֱ��� ȭ���� ��¥
	private String wednesday;	//�����ֱ��� ������ ��¥
	private String thursday;	//�����ֱ��� ����� ��¥
	private String friday;		//�����ֱ��� �ݿ��� ��¥
	private String saturday;	//�����ֱ��� ����� ��¥
	private String sunday;		//�����ֱ��� �Ͽ��� ��¥
	
	//�̹��� �ű�������Ȳ������� �̴µ�����
	private String startday;	//�̹��ֱ��� ������ ��¥
	private String endday;		//�̹��ֱ��� �Ͽ��� ��¥
	
	
	
	public DateCalculate() {
		
	}
	
	//��¥ ������
	public String dateFormat(Timestamp date) {
		time1=this.getTime();
		int today1=Integer.parseInt(time1);
		
		SimpleDateFormat fomat=null;
		fomat=new SimpleDateFormat("yyyyMMdd");
		time1=fomat.format(date);
		int thisDay=Integer.parseInt(time1);
		
		if(today1==thisDay) {
			fomat=new SimpleDateFormat("a hh�� mm�� ss��");
			time1=fomat.format(date);
		}else {
			fomat=new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm��");
			time1=fomat.format(date);
		}
		return time1;
	}
	
	//����ð� ����
	public String getTime(){
		
		today=new Date();
		time1=new SimpleDateFormat("yyyyMMdd").format(today);
		
		return time1;
	}
	
	//�����ð� ����
	public String yesterday() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		today=calendar.getTime();
		time2=new SimpleDateFormat("yyyy-MM-dd").format(today);
		
		return time2;
	}
	
	//�������� ���̴¸޼ҵ�
	public String returnTime(Calendar calendar) {
		
		today=calendar.getTime();
		time2=new SimpleDateFormat("yyyy-MM-dd").format(today);
		return time2;
	}
	
	//������ �ű��̿����������
	public DateCalculate lastWeekNewUser() {
		
		Calendar calendar = Calendar.getInstance();
		int yoil=calendar.get(Calendar.DAY_OF_WEEK);
		
		if(yoil==1) {				//���ñ��� -7�� �Ͽ����϶�
			//������
			calendar.add(Calendar.DAY_OF_MONTH, -13);
			monday=returnTime(calendar);
			//ȭ����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tuesday=returnTime(calendar);
			//������
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			wednesday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			thursday=returnTime(calendar);
			//�ݿ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			friday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			saturday=returnTime(calendar);
			//�Ͽ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			sunday=returnTime(calendar);
		}else if(yoil==2) {			//���ñ��� -7�� �������϶�
			//������
			calendar.add(Calendar.DAY_OF_MONTH, -7);
			monday=returnTime(calendar);
			//ȭ����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tuesday=returnTime(calendar);
			//������
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			wednesday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			thursday=returnTime(calendar);
			//�ݿ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			friday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			saturday=returnTime(calendar);
			//�Ͽ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			sunday=returnTime(calendar);
		}else if(yoil==3) {			//���ñ��� -7�� ȭ�����϶�
			//������
			calendar.add(Calendar.DAY_OF_MONTH, -8);
			monday=returnTime(calendar);
			//ȭ����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tuesday=returnTime(calendar);
			//������
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			wednesday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			thursday=returnTime(calendar);
			//�ݿ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			friday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			saturday=returnTime(calendar);
			//�Ͽ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			sunday=returnTime(calendar);
		}else if(yoil==4) {			//���ñ��� -7�� �������϶�
			//������
			calendar.add(Calendar.DAY_OF_MONTH, -9);
			monday=returnTime(calendar);
			//ȭ����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tuesday=returnTime(calendar);
			//������
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			wednesday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			thursday=returnTime(calendar);
			//�ݿ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			friday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			saturday=returnTime(calendar);
			//�Ͽ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			sunday=returnTime(calendar);
		}else if(yoil==5) {			//���ñ��� -7�� ������϶�
			//������
			calendar.add(Calendar.DAY_OF_MONTH, -10);
			monday=returnTime(calendar);
			//ȭ����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tuesday=returnTime(calendar);
			//������
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			wednesday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			thursday=returnTime(calendar);
			//�ݿ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			friday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			saturday=returnTime(calendar);
			//�Ͽ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			sunday=returnTime(calendar);
		}else if(yoil==6) {			//���ñ��� -7�� �ݿ����϶�
			//������
			calendar.add(Calendar.DAY_OF_MONTH, -11);
			monday=returnTime(calendar);
			//ȭ����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tuesday=returnTime(calendar);
			//������
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			wednesday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			thursday=returnTime(calendar);
			//�ݿ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			friday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			saturday=returnTime(calendar);
			//�Ͽ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			sunday=returnTime(calendar);
		}else if(yoil==7) {			//���ñ��� -7�� ������϶�
			//������
			calendar.add(Calendar.DAY_OF_MONTH, -12);
			monday=returnTime(calendar);
			//ȭ����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tuesday=returnTime(calendar);
			//������
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			wednesday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			thursday=returnTime(calendar);
			//�ݿ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			friday=returnTime(calendar);
			//�����
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			saturday=returnTime(calendar);
			//�Ͽ���
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			sunday=returnTime(calendar);
		}
		return this;
		
	}
	
	//�̹��� �ű�������Ȳ���� ���
	public DateCalculate weekNewUser() {
		
		Calendar calendar = Calendar.getInstance();
		int yoil=calendar.get(Calendar.DAY_OF_WEEK);
		
		
		//�������� ���� �ش��� 00��00�б������� �����ǹǷ� �״����� 00��00������ ó��
		if(yoil==1) {				//������ �Ͽ����϶�
			//�̹��� ������
			calendar.add(Calendar.DAY_OF_MONTH, -6);
			startday=returnTime(calendar);
			//�̹��� ��������
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			endday=returnTime(calendar);
		}else if(yoil==2) {			//������ �������϶�
			//�̹��� ������
			calendar.add(Calendar.DAY_OF_MONTH, 0);
			startday=returnTime(calendar);
			//�̹��� ��������
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			endday=returnTime(calendar);
		}else if(yoil==3) {			//������ ȭ�����϶�
			//�̹��� ������
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			startday=returnTime(calendar);
			//�̹��� ��������
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			endday=returnTime(calendar);
		}else if(yoil==4) {			//������ �������϶�
			//�̹��� ������
			calendar.add(Calendar.DAY_OF_MONTH, -2);
			startday=returnTime(calendar);
			//�̹��� ��������
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			endday=returnTime(calendar);
		}else if(yoil==5) {			//������ ������϶�
			//�̹��� ������
			calendar.add(Calendar.DAY_OF_MONTH, -3);
			startday=returnTime(calendar);
			//�̹��� ��������
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			endday=returnTime(calendar);
		}else if(yoil==6) {			//������ �ݿ����϶�
			//�̹��� ������
			calendar.add(Calendar.DAY_OF_MONTH, -4);
			startday=returnTime(calendar);
			//�̹��� ��������
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			endday=returnTime(calendar);
		}else if(yoil==7) {			//������ ������϶�
			//�̹��� ������
			calendar.add(Calendar.DAY_OF_MONTH, -5);
			startday=returnTime(calendar);
			//�̹��� ��������
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			endday=returnTime(calendar);
		}
		
		return this;
	}
	
	@Override
	public String toString() {
		return "DateCalculate [monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday="
				+ thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday + ", startday="
				+ startday + ", endday=" + endday + "]";
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getStartday() {
		return startday;
	}

	public void setStartday(String startday) {
		this.startday = startday;
	}

	public String getEndday() {
		return endday;
	}

	public void setEndday(String endday) {
		this.endday = endday;
	}
	
	
}
