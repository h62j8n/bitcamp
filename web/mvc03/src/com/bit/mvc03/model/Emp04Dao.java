package com.bit.mvc03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
link>>> http://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html
 
<Resource
		auth="Container"
		type="javax.sql.DataSource"
		name="jdbc/oracle"
		driverClassName="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe"
		username="scott"
		password="tiger"
		maxWait="6000"
		minIdle="10"
		maxIdle="50"
		maxActive="20"
	/>
*/

public class Emp04Dao {
	javax.sql.DataSource dataSource;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Emp04Dao() {
		try {
			InitialContext init = new InitialContext();
//			
//			javax.naming.Context context=null;
//			context=(Context) init.lookup("java:/comp/env");
//			
//			dataSource=(DataSource) context.lookup("jdbc/oracle");
			///////////////////////////////////////////
			dataSource=(DataSource)init.lookup("java:/comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Emp04Dto> selectAll() throws SQLException{
		List<Emp04Dto> list=new ArrayList();
		String sql="select * from emp04 order by sabun";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Emp04Dto bean=new Emp04Dto();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getString("nalja"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	public Emp04Dto selectOne(int sabun) throws SQLException{
		Emp04Dto bean =new Emp04Dto();
		String sql="select * from emp04 where sabun=?";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getString("nalja"));
				bean.setPay(rs.getInt("pay"));
				bean.setEtc(rs.getString("etc"));
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return bean;
	}
//	sabun number primary key,
//	name varchar2(15),
//	nalja varchar2(50),
//	pay number,
//	etc varchar2(15)
	public void insertOne(String name,int pay,String etc) throws SQLException{
		java.util.Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YY/MM/DD");
		String sysdate=sdf.format(date);
		String sql="insert into emp04 values (emp04_seq.nextval,?,?,?,?)";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, sysdate);
			pstmt.setInt(3, pay);
			pstmt.setString(4, etc);
			pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	public int updateOne(int sabun,String name,int pay,String etc) throws SQLException{
		int result=0;
		String sql="update emp04 set name=?,pay=?,etc=? where sabun=?";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.setString(3, etc);
			pstmt.setInt(4, sabun);
			result=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return result;
	}
<<<<<<< HEAD
	
	public int deleteOne(int sabun) throws SQLException{
		int result=0;
		String sql="delete from emp04 where sabun=?";
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			result=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return result;
	}
=======
>>>>>>> 0b9268d46ce442e29a716da2162ffb8bd68f1646
}














