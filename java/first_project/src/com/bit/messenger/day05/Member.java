package com.bit.messenger.day05;

import java.io.BufferedReader;
import java.io.PrintStream;

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

	private BufferedReader br; //����ڰ� ����� ������ ���� �Է½�Ʈ�� ����
	private PrintStream ps; //����ڰ� ����� ������ ���� ��½�Ʈ�� �� 
	
	public Member() {}
	public Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	public PrintStream getPs() {
		return ps;
	}
	public void setPs(PrintStream ps) {
		this.ps = ps;
	}
	
	public static final String LOGIN 	= "LI"; // �α���
	public static final String LOGOUT 	= "LO"; // �α׾ƿ�
	public static final String SIGNIN 	= "SI"; // ȸ������
	public static final String CHAT 	= "CH"; // ä��
	public static final String FRIEND 	= "FR"; // ģ�����
	public static final String SEARCH 	= "SR"; // ģ���˻�
	public static final String ID_DUP 	= "DU"; // ID�ߺ��˻�
	
	// �۾���� �ֱ�
	public static final String OK 	= "OK"; // �۾�����
	public static final String FAIL = "FA"; // �۾�����
	
	// �޽��� ���� 
	public static final String MSI00 = "ȸ�������� �Ϸ�Ǿ����ϴ�.";
	public static final String MSI01 = "ȸ�������� �����Ͽ����ϴ�.";
	public static final String MSI02 = "��й�ȣ�� ��Ȯ�� �Է����ּ���.";
	
	public static final String MID00 = "��� ������ ���̵��Դϴ�.";
	public static final String MID01 = "�̹� ���ԵǾ� �ִ� ȸ���Դϴ�.";
	
	public static final String MLI00 = "���������� �α��� �Ǿ����ϴ�.";
	public static final String MLI01 = "�α����� �����߽��ϴ�. ���̵� �Ǵ� ��й�ȣ�� �ٽ� Ȯ�����ּ���.";
	
	
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
