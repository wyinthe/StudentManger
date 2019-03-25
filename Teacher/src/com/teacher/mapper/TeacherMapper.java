package com.teacher.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.teacher.bean.Teacher;

public class TeacherMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int num) throws SQLException {

		Teacher teacher = new Teacher();
		// 用set的方法，给student类属性设置数值时，直接将数据库的信息对应传入；
		teacher.setId(rs.getInt("id"));
		teacher.setName(rs.getString("name"));
		teacher.setBirthday(getStringBir(rs.getString("birthday")));
		teacher.setAge(rs.getInt("age"));
		teacher.setScore(rs.getDouble("score"));
		teacher.setAddress(rs.getString("address"));

		return teacher;
	}

	private String getStringBir(String birthday) {
		// TODO 自動生成されたメソッド・スタブ
		SimpleDateFormat fommter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		String StrRtnDate = "";

		try {
			date = fommter.parse(birthday);
			StrRtnDate = new SimpleDateFormat("yyyy-mm-dd").format(date);

		}catch (ParseException e) {

			e.printStackTrace();
		}


		return StrRtnDate;
	}

}
