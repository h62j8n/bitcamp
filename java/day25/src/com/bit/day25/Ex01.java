package com.bit.day25;

import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;

public class Ex01 {
	public static void main(String[] args) {
		oracle.jdbc.driver.OracleDriver driver = null;					// ����Ŭ ����̹� (�ܺ� ���̺귯��)
		driver = new OracleDriver();									// ����̹� ��ü ����
		
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		
//		String url = "jdbc:oracle:thin:@ip:port:sid/";			// ������ url (jdbc:oracle:thin: ���� ������)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";		// 1521: ����Ŭ ��ġ �� ������ ��������Ʈ, xe: ��ġ�� ����Ŭ db�̸�
		Properties info = new Properties();						// ��������
		info.put("user", "scott");
		info.put("password", "tiger");
		
		try {
			conn = java.sql.DriverManager.getConnection(url, info);		// �ڹٿ��� �����ϴ� sql ������
			System.out.println("���� ����");
			
//			String sql = "delete from dept where deptno=90";
//			String sql = "update dept set dname = '������', loc = '����' where deptno = 90";
			String sql = "insert into dept (deptno, dname, loc) values ('90', '�ӽ�', '����')";
			
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);				// ���� ���� �� 1, �������� ������ ��� 0
			if (result > 0) {
				System.out.println("�۾����� ("+result+")");
			} else {
				System.out.println("�۾����� ("+result+")");
			}
			
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
			
		} finally {
			try {
				if (stmt != null) stmt.close();					// ���������� ���� �ʼ�
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
