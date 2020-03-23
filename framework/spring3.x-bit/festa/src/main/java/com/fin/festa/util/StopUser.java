package com.fin.festa.util;

import java.util.ArrayList;
import java.util.List;

import com.fin.festa.model.entity.ProfileVo;

//�Ϸ縶�� �����Ⱓ ó��
public class StopUser {

	//�������� �Ⱓ 1�Ͼ� ����
	public Object[] StopUserCount(List<ProfileVo> list) {
		
		Object[] obj= null;
		List<ProfileVo> stoplv_zero = new ArrayList<>();	//�����Ⱓ�� 0���λ���� ��¸���Ʈ
		List<ProfileVo> stoplv_over = new ArrayList<>();	//�����Ⱓ�� �����ִ»���� ��¸���Ʈ
		int stoplv=0;
		
		for(int i=0; i<list.size(); i++) {
			
			stoplv=list.get(i).getMyAdmin().getStoplv();
			stoplv--;
			
			//�����Ⱓ�� 0���� �������Ʈ�� ���� ����
			if(stoplv == 0) {
				list.get(i).getMyAdmin().setStoplv(stoplv);
				stoplv_zero.add(list.get(i));
			//�����Ⱓ�� �����ִ� �������Ʈ�� ���� ����
			}else {
				list.get(i).getMyAdmin().setStoplv(stoplv);
				stoplv_over.add(list.get(i));
			}
			
		}
		
		obj=new Object[] {stoplv_zero, stoplv_over};
		
		return obj;
	}
	
}
