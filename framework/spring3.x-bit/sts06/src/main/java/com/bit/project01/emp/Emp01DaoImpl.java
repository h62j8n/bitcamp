package com.bit.project01.emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Emp01DaoImpl extends JdbcDaoSupport implements Emp01Dao {
	private RowMapper<Emp01Vo> rowMapper = new RowMapper<Emp01Vo>() {

		@Override
		public Emp01Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Emp01Vo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
		}
	};

	@Override
	public List<Emp01Vo> selectAll() {
		String sql = "SELECT * FROM EMP01";
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	@Override
	public void insertOne(String name, int pay) {
		String sql = "INSERT INTO EMP01 (NAME, NALJA, PAY, DEPTNO) VALUES (?, NOW(), ?, 1)";
		getJdbcTemplate().update(sql, new Object[] {name, pay});
	}

	@Override
	public Emp01Vo selectOne(int key) {
		String sql = "SELECT * FROM EMP01 WHERE SABUN=?";
		return getJdbcTemplate().queryForObject(sql, rowMapper, key);
	}

	@Override
	public void updateOne(int sabun, String name, int pay) {
		String sql = "UPDATE EMP01 SET NAME = ?, PAY = ? WHERE SABUN = ?";
		getJdbcTemplate().update(sql, name, pay, sabun);
	}

	@Override
	public int deleteOne(int sabun) {
		String sql = "DELETE FROM EMP01 WHERE SABUN = ?";
		return getJdbcTemplate().update(sql, sabun);
	}
}
