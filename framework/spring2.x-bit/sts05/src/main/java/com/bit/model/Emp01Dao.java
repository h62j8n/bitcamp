package com.bit.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.model.entity.Emp01Vo;

public interface Emp01Dao {
	List<Emp01Vo> selectAll() throws SQLException;
	Emp01Vo selectOne(int key) throws SQLException;	// key : primary key
	void insertOne(Emp01Vo bean) throws SQLException;
	int updateOne(Emp01Vo bean) throws SQLException;
	int deleteOne(int key) throws SQLException;
}
