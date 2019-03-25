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
		String sql = "SELECT id,name,birthday,age,score,address FROM teacher";
		List<Teacher> teacherList = new ArrayList<>();
		teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;

	}
	public List<Teacher> queryById(int teaId) {
		String sql = "SELECT id,name,birthday,age,score,address FROM studentone WHERE Id =" + teaId + "";
		List<Teacher> teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;

	}

	public List<Teacher> queryByName(String name) {
		String sql = "SELECT id,name,birthday,age,score,address FROM studentone WHERE name ='" + name + "'";
		List<Teacher> teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;

	}



}
