package com.bit.mvc02.emp.model;

import java.sql.SQLException;
import java.util.ArrayList;

// ����Ʈ �۾��� �����ϰ� �鿣�忡�� ���ߵ� ������ Ȯ���ϴ� ���
public class DaoTest {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Emp02Dao dao = null;
		try {
			dao = new Emp02Dao(driver, url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("dao : " + (dao != null));
		System.out.println("dao connection : " + (dao.conn != null));
		
		ArrayList<Emp02Dto> list;
		try {
			list = dao.selectAll();
			for (Emp02Dto bean : list) {
				System.out.println(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
