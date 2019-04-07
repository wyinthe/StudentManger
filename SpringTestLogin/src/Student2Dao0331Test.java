/**
 *
 */
package com.student.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.entity.Student2Entity;

/**
 * @author luyao
 *
 */
class Student2Dao0331Test {

	/**
	 * 学生情報Dao.
	 */
	private static Student2Dao student2Dao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		student2Dao = (Student2Dao) context.getBean("student2Dao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * {@link com.student.dao.Student2Dao#search()} のためのテスト・メソッド。
	 */
	@Test
	void testSearch() {

		student2Dao.delete();

		List<Student2Entity> student2EntityList = student2Dao.search();

		int countExpected = 0;

		assertEquals(countExpected, student2EntityList.size());
	}

}
