package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Student;

/**
 * 通过使用RowMapper的方法，将数据库信息与Student实体类 形成关联
 *
 * @author huamo
 *
 */
public class StudentMapper implements RowMapper<Student> {

	/**
	 * 用mapRowd的方法，让student类里面的没一个变量和mysql里的每一列一一对应，实现数据之间的传输
	 */
	@Override
	public Student mapRow(ResultSet rs, int num) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		// 创建student类的对象
		Student student = new Student();
		// 用set的方法，给student类属性设置数值时，直接将数据库的信息对应传入；
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setBirthday(getStringBir(rs.getString("birthday")));
		student.setAge(rs.getInt("age"));
		student.setScore(rs.getDouble("score"));
		student.setClassId(rs.getInt("classid"));
		student.setAddress(rs.getString("address"));

		return student;
	}

	/**
	 * 将数据库的Date类birthday数据类型转换为String型
	 * 使用java的SimpleDateFormat常用类，来进行时间类型转换
	 * @param string
	 * @return
	 */
	private String getStringBir(String birthday) {
		// 生成一个SimpleDateFormat类的对象      构造方法    日期形式

		SimpleDateFormat fommter = new SimpleDateFormat("yyyy-mm-dd");
		// 生成Date类的对象
		Date date = new Date();
		// 定义一个String类型的时间变量
		String strRtnDate = "";
		// 用fommter调用parse方法，将birthday赋值给生成的date对象

		try {
			// 用fommter调用parse方法，将birthday赋值给生成的date对象,然后会报异常 使用try。catch生成 处理异常
			date = fommter.parse(birthday);
			strRtnDate = new SimpleDateFormat("yyyy-mm-dd").format(date);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return strRtnDate;
	}

}
