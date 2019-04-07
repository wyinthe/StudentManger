package com.student.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.bean.Student;
import com.student.util.DateUtil;

class StudentDaoTest {

	private static StudentDao studentDao;

	private String format = "yyyy/mm/dd";



	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		studentDao = (StudentDao) context.getBean("StuDao");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}



	//测试数据内容
	@Test
	public void testInsert() throws Exception {
       //首先删除数据库内容
		studentDao.delete();

		//添加数据内容
		Student entity = new Student();
		entity.setName("wang 5");
		entity.setBirthday(DateUtil.stringToDate("1998/01/01", "1998/01/01"));
		entity.setAge(21);
		entity.setScore(89);


		studentDao.insert(entity);

		List<Student> studentList = studentDao.search();

		assertEquals(1,studentList.size());

		// entityExpected 期待值，添加期望的数据内容
		Student entityExpected = new Student();
		entityExpected.setName("wang 5");
		entityExpected.setBirthday(DateUtil.stringToDate("1998/01/01", "1998/01/01"));
		entityExpected.setAge(21);
		entityExpected.setScore(89);

		assertTrue(equals(entityExpected, studentList.get(0)));

	}


    @Test
	public void testUpdate() throws Exception {
    	// 数据库claer.
    	studentDao.delete();

		// 添加预想数据插入，
		Student entity = new Student();
		entity.setName("wang 5");
		entity.setBirthday(DateUtil.stringToDate("1998/01/01", "1998/01/01"));
		entity.setAge(21);
		entity.setScore(89);
        // 插入
		studentDao.insert(entity);
		// 检索
		List<Student> studentList = studentDao.search();

	    // 检索的数据更新
		Student entityExpected = studentList.get(0);
    	entityExpected.setName("wang 5");
		entityExpected.setBirthday(DateUtil.stringToDate("1998/01/01", "1998/01/01"));
		entityExpected.setAge(21);
		entityExpected.setScore(89);

		// 更新
		studentDao.update(entityExpected);
		// 检索
		studentList = studentDao.search();
		// 作比较
		assertEquals(1, studentList.size());


		assertTrue(equals(entityExpected, studentList.get(0)));


	}

	/**
	 * 进行判断，学生情報一致判断.
	 *
	 * @param entity1学生情报.
	 * @param entity2学生情报.
	 * @return 一致クラス.
	 */
	private boolean equals(Student entity1, Student entity2) {

		//学生情报内容是否一致
		if (entity1.getName().equals(entity2.getName())
				&& entity1.getBirthday().equals(entity2.getBirthday())
				&& entity1.getAge() == entity2.getAge()
				&& entity1.getScore() == entity2.getScore()) {
			return true;
		} else {
			return false;
		}

	}

	@Test
	public void test() throws Exception{
		studentDao.delete();

		Student entity = new student();


	}


}
