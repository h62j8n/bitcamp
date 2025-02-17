package com.bit.project02.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.project02.model.entity.DeptVo;

public class DeptDaoImpl1 implements DeptDao {
	JdbcTemplate jdbcTemplate;
	private RowMapper<DeptVo> rowMapper;
	
	public DeptDaoImpl1() {
		rowMapper = new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
							rs.getInt(1), rs.getString(2), rs.getString(3)
						);
			}
			
		};
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<DeptVo> selectAll() {
		String sql = "SELECT * FROM dept01";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void insertOne(String dname, String loc) {
		String sql = "INSERT INTO dept01 (dname, loc) VALUES(?, ?)";
		jdbcTemplate.update(sql, dname, loc);
	}

	@Override
	public DeptVo selectOne(int key) {
		String sql = "SELECT * FROM dept01 WHERE deptno = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, key);
	}

	@Override
	public int updateOne(String dname, String loc, int deptno) {
		String sql = "UPDATE dept01 SET dname = ?, loc = ? WHERE deptno = ?";
		
		return jdbcTemplate.update(sql, dname, loc, deptno);
	}
}
