package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

/**
 * Dao层 这里是用来写 链接数据库，使用Jdbctemplet方法，从数据库存取信息
 *
 * @author huamo
 *
 */
public class StudentDao {

	// 创建Jdbctemplate类型的变量
	private JdbcTemplate jdbcTemplate;

	/**
	 *
	 * @param jdbcTemplate
	 */

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询数据库所以信息
	 */

	public List<Student> queryAll() {
		// 编写数据库查询语句,并在a5中执行，确认格式正确
		String sql = "SELECT id,name,birthday,age,score,classid,address FROM studentone";
		// 创建List集合，用于储存从数据库中取出的信息；
		List<Student> studentList = new ArrayList<>();
		// 使用jdbcTemplate，带着sql查询语句，查询数据库后，使用new StudentMapper（）来转换数据后，
		// 存入到studentList集合中
		studentList = jdbcTemplate.query(sql, new StudentMapper());
		// 返回studentList
		return studentList;
	}


	public List<Student> queryByName(String name) {
		String sql = "SELECT id,name,birthday,age,score,classid,address FROM studentone WHERE name ='" + name + "'";
		List<Student> studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;

	}

	/**回到dao层 在这边
	 * 根据ID查询学生信息
	 */
	public List<Student> queryById(int stuId) {
		String sql = "SELECT id,name,birthday,age,score,classid,address FROM studentone WHERE id ="+ stuId +" ";
		List<Student>studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;


	}

}
