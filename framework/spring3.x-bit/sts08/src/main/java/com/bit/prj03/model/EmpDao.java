package com.bit.prj03.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.prj03.model.entity.EmpVo;

public interface EmpDao {
	// list
	List<EmpVo> selectAll() throws SQLException;
	
	// detail
	EmpVo selectOne(int key) throws SQLException;
	
	// insert
	void insertOne(EmpVo bean) throws SQLException;
	
	// edit
	int updateOne(EmpVo bean) throws SQLException;
	int updatePay(int pay) throws SQLException;	// 조회수
	int selectTotal() throws SQLException;		// 총 게시글 수
	
	// delete
	int deleteOne(int key) throws SQLException;
}
