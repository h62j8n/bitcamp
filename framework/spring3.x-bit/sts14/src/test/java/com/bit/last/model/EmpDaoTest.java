package com.bit.last.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.last.config.RootConfig;
import com.bit.last.model.entity.EmpVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional
@Rollback
public class EmpDaoTest {
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test() {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		assertNotNull(dao);
		assertNotNull(dao.selectAll());
		assertNotNull(dao.selectAll().size() > 0);
//		fail("Not yet implemented");
	}
	
	@Test
	public void insertOneTest() {
		EmpVo target = new EmpVo();
		target.setSabun(1006);
		target.setName("test6");
		target.setPay(6000);
		
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		dao.insertOne(target);
		assertEquals(target, dao.selectOne(target.getSabun()));
//		fail("Not yet implemented");
	}

}
