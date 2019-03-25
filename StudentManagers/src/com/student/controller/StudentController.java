package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Student;
import com.student.dao.StudentDao;

/**
 * springMVC框架中，控制层所在位置，用于处理网页发起的服务请求
 * 需要使用标签的方式    @Controller 来关联配置文件，指定控制层的位置
 * @author huamo
 *
 */
//在springMVC-servlet.xml创建完成后 创建StudentController的包 然后输入@Controller

@Controller

public class StudentController {

	// 在完成 @RequestMapping(value ="/queryStudent ")
	// public String queryStudent() {

	// 后 在src创建applicationContext.xml


	/**
	 * 查询数据库信息的方法
	 * @return
	 */
	//对请求进行一一关联定位
	@RequestMapping(value = "/queryStudent")
	public String queryStudent(Model model) {
		//再输入ApplicationContext
		//用ApplicationContext方法，获取配置文件applicationContext.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//链接dao层的StudentDao类文件 .getBean ("")；括号内的影壕，是配置文件中bean标签的id属性名
		StudentDao getDao = (StudentDao) context.getBean("StuDao");
		//创建集合，用于储存从dao层获取到的数据库查询结果
		List<Student> studentList = new ArrayList<>();
		//用变量getDao调取StudentDao类 中的方法查询数据库，并将结果赋值给集合
		studentList = getDao.queryStudent();
		//用 model 的 addAttribute 方法，吧结果返回到指定的jsp页面中
		//括号内的两个参，第一个为数据返回到jsp页面的那个位置，通过el表达式来指定，第二个为要返回的数据。
		model.addAttribute("stuList", studentList);
		//此处的返回值，定义的是将处理结果返回到WEB-INF下的那个jsp文件
		return "student";

	}
}
