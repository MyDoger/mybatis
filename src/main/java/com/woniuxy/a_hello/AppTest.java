package com.woniuxy.a_hello;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class AppTest {
	@Test
	public void testSave() throws Exception {
		
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession(true); 
		// ======================================================================
		
		User user = new User();
		user.setName("aaaaaa");
		user.setBirthday(new Date());
		user.setMoney(999d);
		
		s.insert("com.woniuxy.a_hello.UserMapper.save",user);
		
		// ======================================================================
		// s.commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================================
		
		User user = new User();
		user.setId(1);
		user.setName("qqqqqqq");
		user.setBirthday(new Date());
		user.setMoney(666d);
		
		s.update("com.woniuxy.a_hello.UserMapper.update", user);
		
		// ======================================================================
		s.commit();
		s.close();
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================================
		
		s.delete("com.woniuxy.a_hello.UserMapper.delete", 1);
		
		// ======================================================================
		s.commit();
		s.close();
		
	}
	
	@Test
	public void testFindAll() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================================
		
		List<User> list = s.selectList("com.woniuxy.a_hello.UserMapper.findAll");
		
		for (User user : list) {
			System.out.println(user);
		}
		
		// ======================================================================
		s.commit();
		s.close();
		
	}
	
	
	@Test
	public void testFindOne() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================================
		
		User user = s.selectOne("com.woniuxy.a_hello.UserMapper.findOne",2);
		System.out.println(user);
		
//		List<User> list = s.selectList("com.woniuxy.a_hello.UserMapper.findOne",2);
//		System.out.println(list);
		
		// ======================================================================
		s.commit();
		s.close();
		
	}
}
