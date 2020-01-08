package com.bit.mvc02.emp.model;

import java.sql.SQLException;
import java.util.ArrayList;

// 프론트 작업을 배제하고 백엔드에서 개발된 내용을 확인하는 방법
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
