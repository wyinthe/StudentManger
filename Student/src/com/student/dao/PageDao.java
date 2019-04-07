package com.student.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

/**
 * 用于分页功能的dao层数据库查询类
 * @author huamo
 *
 */
public class PageDao {


		private JdbcTemplate jdbcTemplate;



		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		public int getStudentTableNum() {
			//先编写条数据库查询语句，查询数据表的所有信息
			String sql = "SELECT id,name,birthday,age,score,classid,address FROM studentone";
			//创建集合，用集合存储数据库表中查询到的数据
			List<Student> studentList = jdbcTemplate.query(sql, new StudentMapper());
			//创建个变量，用集合的 .size（）方法，可以算出集合中元素的个数，从而知道数据表中总数据数
			int studentNum =studentList.size();
			return studentNum;
		}


		/**
		 * 根据获取到的查询条件，分页查询数据库信息
		 * @param first
		 * @param pageSize
		 * @return
		 */
		public List<Student> getStudentLimitPage(int first,int pageSize){
			//
			String sql ="SELECT id,name,birthday,age,score,classid,address FROM studentone LIMIT "+first+","+pageSize+"";
			List<Student> studentList = jdbcTemplate.query(sql, new StudentMapper());
			return studentList;




		}




	}


