package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

/**
 * 关联数据库，编写数据库操作方法
 *
 * @author huamo
 *
 */

public class StudentDao {
	// 外部功能导入 生成JdbcTemplate变量，用于数据库操作
	private JdbcTemplate jdbcTemplate;

	/**
	 * 右键ソース导入get，set方法 后删除get
	 *
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询所有信息
	 *
	 * @return
	 */

	public List<Student> queryStudent() {
		// 编写数据库查询语句。注意不要用*来代替所有列
		String sql = "SElECT id,name,birthday,age,score FROM studenttwo";
		// 创建集合，然后List 用于接收数据表中查询到的信息
		List<Student> studentList = new ArrayList<>();
		// 用 jdbcTemplate 的 .query 的方法来操作数据库，括号内的两个参数为，数据库查询语句，第二个将查到的数据进行转换
		studentList = jdbcTemplate.query(sql, new StudentMapper());
		// 设置返回值
		return studentList;
	}

	public void insert(Student entity) {
		String sql = "INSERT INTO studenttwo(name,birthday,age,score)values(?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { entity.getName(), entity.getBirthday(), entity.getAge(), entity.getScore() },
				new int[] { Types.VARCHAR, Types.DATE, Types.INTEGER, Types.INTEGER });
	}

	public List<Student> search() {

		String sql = "SELECT id,name,birthday,age,score FROM studenttwo order by id";

		List<Student> studentList = jdbcTemplate.query(sql, new StudentMapper());

		return studentList;
	}

	public void delete() {

		String sql = "DELETE FROM studenttwo";
		jdbcTemplate.execute(sql);

	}

	//
	public void update (Student entity) {
		String sql = "UPDATE studenttwo set name = ?,birthday = ?, age = ?, score = ? WHERE id =?";
		jdbcTemplate.update(sql,
				new Object[] {entity.getName(), entity.getBirthday(), entity.getAge(), entity.getScore(), entity.getId()},
				new int[] {Types.VARCHAR, Types.DATE, Types.INTEGER, Types.INTEGER,Types.INTEGER});

				}





}