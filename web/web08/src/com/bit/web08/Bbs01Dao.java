package com.bit.web08;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Bbs01Dao {
	public ArrayList<Bbs01Dto> list() {
		ArrayList<Bbs01Dto> list = new ArrayList<Bbs01Dto>();
		
		Bbs01Dto bean = new Bbs01Dto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		while (rs.next()) {
			Bbs01Dto bean = new Bbs01Dto();
			bean.setNum(rs.getInt("num"));
			bean.setSub(rs.getString("sub"));
			bean.setNalja(rs.getDate("nalja"));
			bean.setCnt(rs.getDate("cnt"));
			list.add(bean);
		}
		
		return list;
	}
}