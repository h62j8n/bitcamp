package com.bit.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.bit.model.entity.Emp01Vo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class Emp01Dao2Impl implements Emp01Dao {
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	@Override
	public List<Emp01Vo> selectAll() throws SQLException {
		List<Emp01Vo> list = null;
		list = sqlMapClientTemplate.queryForList("selectAll");
		
		return list;
	}

	@Override
	public Emp01Vo selectOne(int key) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(Emp01Vo bean) throws SQLException {
	}

	@Override
	public int updateOne(Emp01Vo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int key) throws SQLException {
		return 0;
	}

}
