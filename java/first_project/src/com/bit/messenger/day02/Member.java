package com.bit.messenger.day02;
/**
 * 
 * @id : �ߺ�üũ ���
 * @pw : ��ȣȭ ��� (����)
 * @phone: �޴��� ��ȣ ���� ���� ( �ڸ��� �� �߰� Ư������('-') ������ ����
 *
 */
public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	
	public static final String LOGIN 	= "LI"; // �α���
	public static final String LOGOUT 	= "LO"; // �α׾ƿ�
	public static final String SIGNIN 	= "SI"; // ȸ������
	public static final String CHAT 	= "CH"; // ä��
	public static final String FRIEND 	= "FR"; // ģ�����
	public static final String SEARCH 	= "SR"; // ģ���˻�
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
