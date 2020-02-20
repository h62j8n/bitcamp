package com.bit.day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class Ex02 {
	public static void main(String[] args) {
		// �л������������α׷� (ver 0.5.0)
		// �й�, �̸�, ����, ����, ����
		
		String url = "jdbc:oracle:thin:@192.168.1.29:1521:xe";
		Properties info = new Properties();
		info.setProperty("user", "scott");
		info.setProperty("password", "tiger");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		OracleDriver driver = new OracleDriver();
		
		String bar = "--------------------------------------";
		String menu = "1:�Է� 2:���� 3:���� 4:���� 0:����\n>";
		Scanner scan = new Scanner(System.in);
		String input = null;
		
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("1")) {
				String num, name, kor, eng, math;
				System.out.print("�й�\n>");
				num = scan.nextLine();
				System.out.print("�л� �̸�\n>");
				name = scan.nextLine();
				System.out.print("��������\n>");
				kor = scan.nextLine();
				System.out.print("��������\n>");
				eng = scan.nextLine();
				System.out.print("��������\n>");
				math = scan.nextLine();
				
				String sql = "INSERT INTO STUDENT VALUES("+num+", '"+name+"', "+kor+", "+eng+", "+math+")";
//				System.out.println(sql);
				try {
					conn = DriverManager.getConnection(url, info);
					stmt = conn.createStatement();
					
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
				String sql = "SELECT NUM, NAME, KOR, ENG, MATH FROM STUDENT ORDER BY NUM";
				
				try {
					conn = DriverManager.getConnection(url, info);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					
					System.out.println(bar+"\n�й�\t|�̸�\t|����\t|����\t|����\n"+bar);
					while (rs.next()) {
						System.out.print(rs.getObject(1)+"\t|");
						System.out.print(rs.getObject(2)+"\t|");
						System.out.print(rs.getObject(3)+"\t|");
						System.out.print(rs.getObject(4)+"\t|");
						System.out.println(rs.getObject(5));
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
				
			} else if (input.equals("3")) {
				String num, name, kor, eng, math;
				System.out.print("������ �й�\n>");
				num = scan.nextLine();
				
				System.out.print("�л� �̸�\n>");
				name = scan.nextLine();
				System.out.print("��������\n>");
				kor = scan.nextLine();
				System.out.print("��������\n>");
				eng = scan.nextLine();
				System.out.print("��������\n>");
				math = scan.nextLine();
				
				String sql = "UPDATE STUDENT SET NUM="+num+", NAME='"+name+"', " +
						"KOR="+kor+", ENG="+eng+", MATH="+math+" WHERE NUM="+num;
//				System.out.println(sql);
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
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			} else if (input.equals("4")) {
				System.out.print("������ �й�\n>");
				String num = scan.nextLine();
				
				String sql = "DELETE FROM STUDENT WHERE NUM ="+num;
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
