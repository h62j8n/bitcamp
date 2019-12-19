package com.bit.day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class Ex01 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.1.29:1521:xe";
		Properties info = new Properties();
		info.setProperty("user", "scott");
		info.setProperty("password", "tiger");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String bar = "---------------------------------";
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		Scanner scan = new Scanner(System.in);
		String input = null;
		
		System.out.println(bar+"\nCRUD (dept table)\n"+bar);
		
		OracleDriver driver = new OracleDriver();
//		DriverManager.registerDriver(driver);	// ������ ���� (OracleDriver ��ü ���� �� �ڵ� �����)
		
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("1")) {
				System.out.print("deptNo\n>");
				String deptNo = scan.nextLine();
				System.out.print("dName\n>");
				String dName = scan.nextLine();
				System.out.print("loc\n>");
				String loc = scan.nextLine();
				
				String sql = "INSERT INTO DEPT VALUES ("+deptNo+", '"+dName+"', '"+loc+"')";
				System.out.println(sql);	// �ݵ�� �������� ����غ��� Ȯ���ϰ� cmd���� ������ ����غ��⵵ �ϸ� �׽�Ʈ�Ѵ�.
				
				try {	// ���ŷ����� �ݵ�� �Ź� �����ؾ߸� �Ѵ�.
					conn = DriverManager.getConnection(url, info);	// sql ����
					stmt = conn.createStatement();					// ���ο� ����(?) ��ɾ �Է��� �غ�?
					
					int result = stmt.executeUpdate(sql);
					if (result > 0) {
						System.out.println("�Է� �Ϸ�");
					} else {
						System.out.println("�Է� ����");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null) stmt.close();
						if (conn != null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			} else if (input.equals("2")) {
				String sql = "SELECT DEPTNO, RPAD(DNAME, 10, ' '), LOC FROM DEPT ORDER BY DEPTNO";
				
				try {
					conn = DriverManager.getConnection(url, info);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					
					System.out.println(bar+"\nDEPTNO\t|DNAME\t\t|LOC\n"+bar);
					while (rs.next()) {
						System.out.print(rs.getObject(1)+"\t|");
						System.out.print(rs.getObject(2)+"\t|");
						System.out.println(rs.getObject(3));
					}
					System.out.println(bar);
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) rs.close();
						if (stmt != null) stmt.close();
						if (conn != null) conn.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if (input.equals("4")) {
				System.out.print("������ deptNo\n>");
				String deptNo = scan.nextLine();
				
				String sql = "DELETE FROM DEPT WHERE DEPTNO = "+deptNo;
				try {
					conn = DriverManager.getConnection(url, info);
					stmt = conn.createStatement();
					
					int result = stmt.executeUpdate(sql);
					if (result > 0) {
						System.out.println("���� �Ϸ�");
					} else {
						System.out.println("���� ����");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null) stmt.close();
						if (conn != null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			} else if (input.equals("0")) break;
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
