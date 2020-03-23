package com.bit.sts12.model.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmpDao {
	@Select("SELECT * FROM EMP01 ORDER BY SABUN DESC")
	List<EmpVo> selectAll();
	
	@Select("SELECT * FROM EMP01 WHERE SABUN = #{value}")
	EmpVo selectOne(int key);
	
	@Insert("INSERT INTO EMP01 VALUES (EMP01_SEQ.NEXTVAL, #{name}, SYSDATE, #{pay})")
	void insertOne(EmpVo bean);
	
	@Update("UPDATE EMP01 SET NAME = #{name}, PAY = #{pay} WHERE SABUN = #{sabun}")
	int updateOne(EmpVo bean);
	
	@Delete("DELETE FROM EMP01 WHERE SABUN = #{value}")
	int deleteOne(int key);
}
