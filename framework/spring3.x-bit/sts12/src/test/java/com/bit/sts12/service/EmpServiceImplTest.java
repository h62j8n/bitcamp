package com.bit.sts12.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class EmpServiceImplTest {

	@Autowired
	EmpService service;
	
	@Test
	public void test() {
		service.selectAll(null);
		service.selectOne(0, null);
		try {
			service.insertOne(null);
		} catch (Exception e) {
		}
		service.deleteOne(0);
		service.updateOne(null);
		assertNotNull(service);
//		assertTrue(true);
//		fail("Not yet implemented");
	}

}
