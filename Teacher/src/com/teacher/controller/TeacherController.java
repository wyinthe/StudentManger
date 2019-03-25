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
		TeacherDao dao = (TeacherDao) context.getBean("TeaDao");

		return dao;
	}

	@RequestMapping(value="goTOTeacherPage")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("TeaDao");

		List<Teacher> teacherList = new ArrayList<>();
		teacherList= dao.queryAll();
		model.addAttribute("TeaList",teacherList);

		return "teacher";
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

	@RequestMapping(value="/getTeacherById")
	public String getTeacherById(String id,Model model) {
		//将从页面获取到的String id，转换成int型的数据，用于数据库查询
		int teaId =Integer.valueOf(id);
		TeacherDao getDao = getTeacherDao();
		List<Teacher> teacherList =getDao.queryById(teaId);
		model.addAttribute("teaList",teacherList);
		return "select";


	}


	@RequestMapping(value="/getStudentByName")
	public String getStudentByName(String name,Model model) {
		TeacherDao getDao = getTeacherDao();
		List<Teacher> teacherList =getDao.queryByName(name);
		model.addAttribute("teaList",teacherList);
		return "select";
	}




}
