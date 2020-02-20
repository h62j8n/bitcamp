package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.model.entity.Emp01Vo;

public class Emp01Dao1Impl implements Emp01Dao {
	JdbcTemplate jdbcTemplate;

	public Emp01Dao1Impl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Emp01Vo> selectAll() throws SQLException {
		String sql = "SELECT * FROM EMP01";
		
		return jdbcTemplate.query(sql, new RowMapper<Emp01Vo>() {
			@Override
			public Emp01Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Emp01Vo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
			}
		});
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
