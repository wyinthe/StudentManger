package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Student;

public class StudentMapper implements RowMapper<Student>{


	/**
	 * 继承RowMapper接口后，使用mapRow的方法将Student类与数据表中的列一一对应
	 */
	//修饰符  名字                                                             异常处理
	@Override
	public Student mapRow(ResultSet rs, int mun) throws SQLException {
		//生成Student的对象
		Student student = new Student();
		//用set的方法，吧数据表中的数据赋值给Student类，rs后的括号内，双引号中是数据表的列名称
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setBirthday(rs.getDate("birthday"));
		student.setAge(rs.getInt("age"));
		student.setScore(rs.getDouble("score"));


		//设置返回值
		return student;
	}

	private String getStrBirthday(String birthday) {
		//日期转换需要用到的SimpleDateFormat方法，首先生成它的对象
		SimpleDateFormat fommter = new SimpleDateFormat("yyyy-mm-dd");
		//创建一个Date型对象，用来接收数据库的birthday
		Date date = new Date();
		//创建一个String变量，接收字符串类型的birthday
		String strBirthday = "";


	//用try，catch的形式 处理异常
		try {
			//先自己打出date = fommter.parse(birthday);  接收数据表的birthday
			date = fommter.parse(birthday);
			//将储存了数据表中date类型的birthday，转换为"yyyy-mm-dd"格式后，赋值给strBirthday；
			strBirthday = new SimpleDateFormat("yyyy-mm-dd").format(date);

		} catch (ParseException e) {

			e.printStackTrace();
		}


		return strBirthday;
	}











}
