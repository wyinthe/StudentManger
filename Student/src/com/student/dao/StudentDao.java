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
	 * 这段是用于查询总信息
	 * 查询数据库所有信息
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






	/**回到dao层 在这边
	 * 根据ID查询学生信息
	 */
	public List<Student> queryById(int stuId) {
		String sql = "SELECT id,name,birthday,age,score,classid,address FROM studentone WHERE id ="+ stuId +" ";
		List<Student>studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;


	}
/**
 * 4在dao层链接
 * @param stuName
 * @return
 */
	public List<Student> queryByName(String stuName) {
		String sql = "SELECT id,name,birthday,age,score,classid,address FROM studentone WHERE name ='" + stuName + "'";
		List<Student> studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;

	}

	public boolean deleteStudentById(int stuId) {
		String sql = "DELETE FROM studentone WHERE id = ?";
		//增删改都是用到update
		boolean result =jdbcTemplate.update(sql, stuId) == 1;
		//return jdbcTemplate.update(sql, stuId) == 1;
		return result;
	}


	public boolean deleteStudentByName(String stuName) {
		String sql = "DELETE FROM studentone WHERE name = ?";
		boolean result =jdbcTemplate.update(sql, stuName) == 1;
		return result;

	}

	public boolean addStudent(Student student) {
		String sql = "INSERT INTO studentone(id,name,birthday,age,score,classId,address) values(0,?,?,?,?,?,?)";
		boolean result =jdbcTemplate.update(sql,
				                            student.getName(),
				                            student.getBirthday(),
				                            student.getAge(),
				                            student.getScore(),
				                            student.getClassId(),
				                            student.getAddress()
				                            ) == 1;
		return result;



	}


/**
 * 学生のテーブルを更新
 * @param student
 * @return
 */
	public boolean updateStudent(Student student) {
	String sql = "UPDATE studentone SET name=?,birthday=?,age=?,score=?,classid=?,address=? WHERE id=?";
	boolean result = jdbcTemplate.update(sql,
			                             student.getName(),
			                             student.getBirthday(),
			                             student.getAge(),
			                             student.getScore(),
			                             student.getClassId(),
			                             student.getAddress(),
			                             student.getId()
			                             ) ==1;
	return result;





	}

	public boolean addAddress(int stuId,String stuAddress) {
		String sql = "UPDATE studentone SET address=? WHERE id=?";
		boolean result = jdbcTemplate.update(sql,stuAddress,stuId)==1;
		return result;
	}







}
