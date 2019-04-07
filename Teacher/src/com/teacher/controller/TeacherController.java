package com.teacher.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.teacher.bean.Teacher;
import com.teacher.dao.TeacherDao;

@Controller
public class TeacherController {

	private TeacherDao getTeacherDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao getTeacherDao = (TeacherDao) context.getBean("TeaDao");

		return getTeacherDao;
	}




	@RequestMapping(value="goToSelectpage")
	public String goToSelectpage(Model model) {
		//调取链接dao层的方法
		TeacherDao getDao = getTeacherDao();
		List<Teacher> teacherList =getDao.queryAll();
		model.addAttribute("teaList", teacherList);

		//此处的return，指返回到那个jsp页面



		return "select";
	}





	@RequestMapping(value = "goToTeacherPage")
	public String queryAll(Model model) {

		// 使用ApplicationContext方法，连接dao层，获取查询数据库的相关方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 创建一个StudentDao类型的变量，将使用context方法获取到的applicationContext。xml配置文件里的dao层的路径；
		TeacherDao dao = (TeacherDao) context.getBean("TeaDao");
		// 创建集合，将从数据库查询到的信息存放到集合中
		List<Teacher> teacherList = new ArrayList<>();

		// 调取dao层里的queryAll方法，获取数据库总信息
		teacherList = dao.queryAll();

		// 使用model方法，将获取到的信息，返回前台jsp页面。
		// 其中addAttribute括号内，第一个参数，是用来指定将结果返回到jso页面的那个位置，第二个参数，是用来指定将那些结果来返回
		model.addAttribute("teaList", teacherList);

		// 此处的return，是指返回到那个jsp页面

		return "teacher";
	}


	@RequestMapping(value = "/getTeacherById")
	public String getTeacherById(String id, Model model) {
		// 将从页面获取到的String id，转换成int型的数据，用于数据库查询
		int teaId = Integer.valueOf(id);
		TeacherDao getDao = getTeacherDao();
		List<Teacher> teacherList = getDao.queryById(teaId);
		model.addAttribute("teaList", teacherList);
		return "select";

	}



	@RequestMapping(value = "/getTeacherByName")
	public String getTeacherByName(String name, Model model) {
		TeacherDao getDao = getTeacherDao();
		List<Teacher> teacherList = getDao.queryByName(name);
		model.addAttribute("teaList", teacherList);
		return "select";
	}


	/**
	 * 增加老师信息
	 */

	@RequestMapping(value = "/addTeacher")
	public String addStudent(String name,String birthday,String age,String score,String classId,String address,Model model) {

		Teacher teacher = new Teacher();

		teacher.setName(name.trim());
		teacher.setBirthday(birthday.trim());
		teacher.setAge(Integer.valueOf(age.trim()));
		teacher.setScore(Integer.valueOf(score.trim()));
		teacher.setAddress(address.trim());
		teacher.setClassid(Integer.valueOf(classId.trim()));

		TeacherDao dao = getTeacherDao();
		//创建boolean型变量，将数据库的增加结果返回给result
		//然后去dao层
		boolean result = dao.addTeacher(teacher);
		if(result) {
			System.out.println("");
		}else {
			System.out.println("");
		}
		model.addAttribute("teaList", dao.queryAll());
		return "addTeacher";




	}



	@RequestMapping(value="goToAddPage")
	public String goToAddPage(Model model) {
		TeacherDao getDao = getTeacherDao();
		List<Teacher> teacherList = getDao.queryAll();
		model.addAttribute("teaList",teacherList);
		return "addTeacher";




		//model.addAttribute("stuList", studentList);
		//return "addStudent";
	}










}
