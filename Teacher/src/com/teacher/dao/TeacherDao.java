package com.teacher.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.teacher.bean.Teacher;
import com.teacher.mapper.TeacherMapper;



public class TeacherDao {

	private JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}





	public List<Teacher> queryAll(){
		String sql = "SELECT id,name,birthday,age,score,address,classid FROM teacher";
		List<Teacher> teacherList = new ArrayList<>();
		teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;

	}
	public List<Teacher> queryById(int teaId) {
		String sql = "SELECT id,name,birthday,age,score,address,classid FROM teacher WHERE Id =" + teaId + "";
		List<Teacher> teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;

	}

	public List<Teacher> queryByName(String name) {
		String sql = "SELECT id,name,birthday,age,score,address,classid FROM teacher WHERE name ='" + name + "'";
		List<Teacher> teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;

	}







	/**
	 * 增加老师地址信息
	 */

	public boolean addAddress(int teaId,String teaAddress) {
		String sql = "UPDATE studentone SET address=? WHERE id=?";
		boolean result = jdbcTemplate.update(sql,teaAddress,teaId)==1;
		return result;
	}





	/**
	 * 增加老师信息
	 */
	public boolean addTeacher(Teacher teacher) {
		String sql = "INSERT INTO studentone(id,name,birthday,age,score,address,classId) values(0,?,?,?,?,?,?)";
		boolean result =jdbcTemplate.update(sql,
				teacher.getName(),
				teacher.getBirthday(),
				teacher.getAge(),
				teacher.getScore(),
				teacher.getAddress(),
				teacher.getClassid()
				                            ) == 1;
		return result;



	}



}
