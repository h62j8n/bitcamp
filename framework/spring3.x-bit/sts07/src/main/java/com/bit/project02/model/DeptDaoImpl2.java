package com.bit.project02.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.project02.model.entity.DeptVo;
//import com.ibatis.sqlmap.client.SqlMapClient;

// use ibatis : mybatis 사용을 위해 관련된 부분 모두 주석
// 예외처리는 throws 하는 것이 좋은 방식
// 트랜잭션 처리할 경우 예외처리할 필요가 없어짐
public class DeptDaoImpl2 /*implements DeptDao*/ {
//	
//	@Autowired
//	SqlMapClient sqlMapClient;
//	
//	@Override
//	public List<DeptVo> selectAll() {
//		try {
//			return sqlMapClient.queryForList("dept.selectAll");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public void insertOne(String dname, String loc) {
//		try {
//			sqlMapClient.insert("dept.insertOne", new DeptVo(0, dname, loc));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public DeptVo selectOne(int key) {
//		try {
//			return (DeptVo) sqlMapClient.queryForObject("dept.selectOne", key);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public int updateOne(String dname, String loc, int deptno) {
//		try {
//			return sqlMapClient.update("dept.updateOne", new DeptVo(deptno, dname, loc));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	
}
