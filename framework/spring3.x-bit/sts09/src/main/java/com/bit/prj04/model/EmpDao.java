package com.bit.prj04.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.prj04.model.entity.EmpVo;

public interface EmpDao {
	
	@Select("SELECT * FROM emp01 ORDER BY sabun DESC")
	List<EmpVo> selectAll() throws Exception;
	
	@Select("SELECT * FROM emp01 WHERE sabun = #{value}")
	EmpVo selectOne(int value) throws Exception;
	
	@Insert("INSERT INTO emp01 (name, nalja, pay, deptno) VALUES (#{name}, now(), #{pay}, 1)")
	void insertOne(EmpVo bean) throws Exception;
	
	@Update("UPDATE emp01 SET name = #{name}, pay = #{pay} WHERE sabun = #{sabun}")
	int updateOne(EmpVo bean) throws Exception;
	
	@Delete("DELETE FROM emp01 WHERE sabun = #{value}")
	int deleteOne(int value) throws Exception;
}
