package com.student.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Page;
import com.student.bean.Student;
import com.student.dao.PageDao;


/**
 * 处理分页功能的控制层
 * @author huamo
 *
 */
@Controller
public class PageController {
	private static PageDao getDao() {
		//??????
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PageDao dao = (PageDao) context.getBean("pageDao");
		return dao;
	}

	/**
	 * 分页显示初始化，即第一次进入jsp页面时，就已经是分页完成的状态
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/goTOStudentPage")
	public String getLimitStudent(Model model) {
		//链接Pagedao
		PageDao dao = getDao();
		//创建bean包下Page类的对象，需要调取里面的方法来计算分页所需要的数据；
		Page page = new Page();
		//首先设置当前页，因为是初始化，第一次进入分页页面，所以页码为1，手动设置就好
		page.setNowPageNo(1);
		//其次设置数据表总数据数，这个直接调取dao层的方法来查询数据库，从而得到实时状态下的数据库信息
		page.setStudentTableNum(dao.getStudentTableNum());
		//这时，有了2个数值，便可计算出其他的信息
        page.getTotalPages();


		//这是我们将获取到的当前页赋值给变量first，因为数据库中数据排序是从第0条开始，索爷用当前页面减1；
		int first = page.getNowPageNo() -1;
		//这是我们将获取到的当前页赋值给变量 pageSize;
		int pageSize = page.getPageSize();
		//至此分页查询中需要的2个关键参数便设置完成，

		//调取dao层的分页查询方法，并传入2个参数，将查询到的信息存储到创建的集合中
		List<Student> studentList = dao.getStudentLimitPage(first, pageSize);
		//返回值中 处理从数据表中查询到的分页数据外，还要返回当前页，以及总页数
		model.addAttribute("stuList", studentList);
		//返回总页数，使页数为最新
		model.addAttribute("totalPage",page.getTotalPages());
		//返回当前页码，让页码表示成最新数-
		model.addAttribute("pageNum",page.getNowPageNo());

		return "student";


	}

	/**
	 * 上一页功能
	 * @param jspPrevPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getStudentPrevPage")
	public String getPrevStudentPage(String jspPrevPage,Model model) {


		PageDao dao = getDao();
		Page page =new Page();
		page.setNowPageNo(Integer.valueOf(jspPrevPage.trim()));
		page.setStudentTableNum(dao.getStudentTableNum());
		page.getTotalPages();
		int first = (page.getPrefPage()-1) * page.getPageSize();
		int pageSize = page.getPageSize();
		List<Student> studentList = dao.getStudentLimitPage(first, pageSize);

		model.addAttribute("stuList",studentList);
		model.addAttribute("pageNum",page.getPrefPage());
		model.addAttribute("totalPage",page.getTotalPages());

		return "student";


	}




	     /**
		  * 下一页功能
		  * @param jspNextfPage
		  * @param model
		  * @return 需要自己在巩固
		  */
	@RequestMapping(value="/getStudentNextPage")
		public String getNextStudentPage(String jspNextfPage,Model model) {

		PageDao dao = getDao();
		Page page =new Page();
		page.setNowPageNo(Integer.valueOf(jspNextfPage.trim()));
		page.setStudentTableNum(dao.getStudentTableNum());
		page.getTotalPages();
		int first = (page.getNextPage()-1) * page.getPageSize();
		int pageSize = page.getPageSize();
		List<Student> studentList = dao.getStudentLimitPage(first, pageSize);

		model.addAttribute("stuList",studentList);
		model.addAttribute("pageNum",page.getNextPage());
		model.addAttribute("totalPage",page.getTotalPages());
		return "student";
	}


	/**
	 * 末页
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/getStudentLostPage")
	public String getLastStudentPage(Model model) {
		PageDao dao = getDao();
		Page page =new Page();
		page.setStudentTableNum(dao.getStudentTableNum());
		page.getTotalPages();
		int first = (page.getTotalPages()-1) * page.getPageSize();
		int pageSize = page.getPageSize();
		List<Student> studentList = dao.getStudentLimitPage(first, pageSize);

		model.addAttribute("stuList",studentList);
		model.addAttribute("pageNum",page.getTotalPages());
		model.addAttribute("totalPage",page.getTotalPages());

		return "student";

	}

	/**
	 * 跳转功能
	 * @param pogeNo
	 * @param model
	 * @return
	 */

	@RequestMapping(value ="/getStudentFindPage")
	public String getFindStudentPage(String pogeNo,Model model) {

		PageDao dao = getDao();
		Page page = new Page();
		page.setNowPageNo(Integer.valueOf(pogeNo.trim()));
		page.setStudentTableNum(dao.getStudentTableNum());
		page.getTotalPages();

		int first = (page.getNowPageNo() -1)*page.getPageSize();
		int pageSize = page.getPageSize();
		List<Student> studentList = dao.getStudentLimitPage(first, pageSize);

		model.addAttribute("stuList",studentList);
		model.addAttribute("pageNum",page.getNowPageNo());
		model.addAttribute("totalPage",page.getTotalPages());

		return "student";



	}





}
