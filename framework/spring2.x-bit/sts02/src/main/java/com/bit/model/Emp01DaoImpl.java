package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.bit.model.entity.Emp01Vo;

public class Emp01DaoImpl implements Emp01Dao {
	JdbcTemplate jdbcTemplate;
	PlatformTransactionManager transactionManager; 
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public List<Emp01Vo> selectAll() throws SQLException {
		String sql="select * from emp01";
		PreparedStatementCreator psc=null;
		psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt=null;
				pstmt=con.prepareStatement(sql);
				return pstmt;
			}
		};
		
		
		RowMapper<Emp01Vo> rowMapper=new RowMapper<Emp01Vo>() {

			@Override
			public Emp01Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Emp01Vo(
						rs.getInt(1),
						rs.getString(2),
						rs.getTimestamp(3),
						rs.getInt(4),
						rs.getInt(5)
						);
			}
			
		};
		return (List<Emp01Vo>) jdbcTemplate.query(psc, rowMapper);
	}

	@Override
	public Emp01Vo selectOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(final Emp01Vo bean) throws SQLException {
		final String sql="insert into emp01 (name,nalja,pay,deptno) values (?,now(),?,?)";
		TransactionDefinition definition=null;
		definition=new DefaultTransactionDefinition();
		TransactionStatus status = null;
		status=transactionManager.getTransaction(definition);
		try {
		PreparedStatementCreator psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt=null;
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getPay());
				pstmt.setInt(3, bean.getDeptno());
				return pstmt;
			}
		};
		jdbcTemplate.update(psc);
		psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt=null;
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getPay());
				pstmt.setInt(3, bean.getDeptno());
				return pstmt;
			}
		};
		jdbcTemplate.update(psc);
			transactionManager.commit(status);
		}catch (Exception e) {
			// rollback
			transactionManager.rollback(status);
		}
	}

	@Override
	public int updateOne(Emp01Vo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean loginCheck(int sabun, String name) {
		String sql="select count(*) from emp01 where sabun=? and name=?";
		int result=jdbcTemplate.queryForInt(sql,new Object[] {sabun,name});
		if(result>0)return true;
		return false;
	}

}





