package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.bit.model.entity.Dept01Vo;

public class Dept01Dao2Impl extends JdbcDaoSupport implements Dept01Dao {

	@Override
	public List<Dept01Vo> selectAll() throws SQLException {
		String sql="select * from dept01 order by deptno desc";
		return this.getJdbcTemplate().query(sql, new RowMapper<Dept01Vo>() {

			@Override
			public Dept01Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("rowNum:"+rowNum);
				return new Dept01Vo(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
						);
			}
			
		});
	}

	@Override
	public void insertOne(Dept01Vo bean) throws SQLException {
		String sql="insert into dept01 (dname,loc) values (?,?)";
		this.getJdbcTemplate().update(
				sql,new Object[] {bean.getDname(),bean.getLoc()});
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		String sql="delete from dept01 where deptno=?";
		
		return this.getJdbcTemplate().update(
				sql,new Object[] {deptno});
	}

}










