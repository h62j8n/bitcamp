package com.bit.rest.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.rest.model.entity.EmpVo;

public interface EmpDao {
	
	@Select("select * from emp01 order by sabun desc")
	List<EmpVo> selectAll();
	
	@Insert("insert into emp01 values(emp01_seq.nextval, #{name}, sysdate, #{pay})")
	void insertOne(EmpVo bean);
	
	@Select("select * from emp01 where sabun=${value}")
	EmpVo selectOne(int sabun);
	
	@Update("update emp01 set name = #{name}, pay = #{pay} where sabun = #{sabun}")
	int updateOne(EmpVo bean);
	
	@Delete("delete from emp01 where sabun=#{value}")
	int deleteOne(int key);
}
