package com.student.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.bean.Student;
import com.student.dao.StudentDao;

@Controller

public class StudentController {
	/**
	 * @RequestParam注解的作用是：根据参数名从URL中取得参数值
	 * @param username
	 *            用户名，一定要对应着表单的name才行
	 * @param password
	 *            用户密码，也应该对应表单的数据项
	 * @param model
	 *            一个域对象，可用于存储数据值
	 * @return
	 */
	@RequestMapping("/login") // @RequestMapping 注解可以用指定的URL路径访问本控制层
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		if (username.equals("admin") && password.equals("admin")) {
			model.addAttribute("username", username);
			return "LoginOK";
		} else {
			model.addAttribute("username", username);
			return "LoginNG";
		}
	}

	/**
	 * 处理主页
	 *
	 * @return
	 */
	private static StudentDao getStudentDao() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		StudentDao dao = (StudentDao) context.getBean("Studao");
		return dao;
	}

	/**
	 * 处理主页的超链接请求，请求的名称为goToStudentPage
	 *
	 * @return
	 */
	@RequestMapping(value = "goToStudentPage")
	public String queryAll(Model model) {
		// 使用ApplicationContext方法，链接dao层，获取查询数据库的相关方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 创建一个StudentDao类型的变量，将使用context方法获取到的applicationContext.xml配置文件里的dao层的路径；
		StudentDao dao = (StudentDao) context.getBean("Studao");
		// 创建集合，将从数据库查询到的信息存放到集合中
		List<Student> studentList = new ArrayList<>();
		// 调取dao层里的queryAll方法，获取数据库总信息
		studentList = dao.queryAll();
		// 使用model方法，将获取到的信息，返回到前台jsp页面
		// 其中addAttribute括号内，第一个参数是用来指定将查询信息返回到jsp页面的具体位置，第二个参数，是用来指定查询结果来返回
		model.addAttribute("stuList", studentList);
		// 返回student.jsp页面
		return "student";
	}

	/**
	 * 处理主页的请求，然后带着从数据库查询到的数据，返回到新的select.ｊｓｐ页面。
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goToSelectPage")
	public String goToSelectPage(Model model) {
		// 调取链接dao层的方法
		StudentDao getDao = getStudentDao();
		// 创建集合，接收从dao层查询获取的数据库结果
		List<Student> studentList = getDao.queryAll();
		// 用model方法，把结果返回到jsp页面的指定位置
		model.addAttribute("stuList", studentList);
		// 返回到select.jsp页面
		return "select";
	}

	/**
	 * 处理主页的请求，然后带着从数据库查询到的数据，返回到新的delete.ｊｓｐ页面。
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goToDeletePage")
	public String goToDeletePage(Model model) {
		StudentDao getDao = getStudentDao();
		List<Student> studentList = getDao.queryAll();
		model.addAttribute("stuList", studentList);

		return "delete";
	}

	@RequestMapping(value = "goToAddPage")
	public String goToAddPage(Model model) {
		StudentDao getDao = getStudentDao();
		List<Student> studentList = getDao.queryAll();
		model.addAttribute("stuList", studentList);

		return "addstu";
	}

	/**
	 * 访问ID查询学生信息页面
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "getStudentById")
	public String getStudentById(String id, Model model) {
		// 将从页面获取到的String id，转换成int型的数据，用于数据库查询：
		int stuId = Integer.valueOf(id);
		StudentDao getDao = getStudentDao();
		List<Student> studentList = getDao.queryById(stuId);
		model.addAttribute("stuList", studentList);
		return "select";

	}

	/**
	 * 返回到新的update.jsp页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goToUpDatePage")
	public String goToUpDatePage(Model model) {
		StudentDao getDao = getStudentDao();
		List<Student> studentList = getDao.queryAll();
		model.addAttribute("stuList", studentList);

		return "update";
	}

	/**
	 * 根据jsp页面获取的参数，进行数据库删除操作
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteStudent")


@
	public String getDeleteStudent(String id, Model model) {
		// 从前台获取的参数都是String型，而数据库中Id是int型，所以要进行数据类型转换
		// 因为前台传入的参数内容，可能会有空格，所以要去除参数的前后空格。trim（）.
		int stuId = Integer.valueOf(id.trim());
		StudentDao getDao = getStudentDao();
		// 创建boolean型的变量，来接收从dao层删除操作的结果，如果有结果，result为true，反之为false；
		boolean result = getDao.deleteById(stuId);

		if (result) {
			System.out.println("削除成功");
		} else {
			System.out.println("削除失敗");
			// 此处可以直接用getDao方法来调取，dao层数据库方法
			model.addAttribute("stuList", getDao.queryAll());
		}
		return "delete";
	}

	/**
	 * 根据jsp页面获取的参数，进行数据库添加操作
	 *
	 * @param id
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/addStudent")
	public String addStudent(String name, String birthday, String age, String score, String classid, String address,
			Model model) {
		Student student = new Student();
		student.setName(name.trim());
		student.setBirthday(birthday.trim());
		student.setAge(Integer.valueOf(age.trim()));
		student.setScore(Integer.valueOf(score.trim()));
		student.setClassid(Integer.valueOf(classid.trim()));
		student.setAddress(address.trim());
		StudentDao getDao = getStudentDao();
		boolean result = getDao.addStudent(student);
		if (result) {
			System.out.println("追加成功した");
		} else {
			System.out.println("追加失敗した");
		}
		model.addAttribute("stuList", getDao.queryAll());
		return "addstu";

	}

	@RequestMapping(value = "getStudentByName")
	public String getStudentByNmae(String name, Model model) {
		StudentDao getDao = getStudentDao();
		List<Student> studentList = getDao.queryByName(name);
		model.addAttribute("stuList", studentList);
		return "select";
	}

	/**
	 *
	 */
	@RequestMapping(value = "upDateStudent")
	public String upDateStudent(String name, String birthday, String age, String score, String classid, String address,
			String id, Model model) {

		Student student = new Student();
		student.setName(name.trim());
		student.setBirthday(birthday.trim());
		student.setAge(Integer.valueOf(age.trim()));
		student.setScore(Integer.valueOf(score.trim()));
		student.setClassid(Integer.valueOf(classid.trim()));
		student.setAddress(address.trim());
		student.setId(Integer.valueOf(id.trim()));
		StudentDao getDao = getStudentDao();
		boolean result = getDao.upStudent(student);

		if (result) {
			System.out.println("更新完了");
		} else {
			System.out.println("更新できませんでした");
		}
		model.addAttribute("stuList", getDao.queryAll());
		return "update";

	}

	@RequestMapping(value = "/checkStudentName.do")
	protected void checkStudentName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 链接dao进行数据库查询
		StudentDao getDao = getStudentDao();
		// 创建name变量，用以下方法接收ajax请求中的参数
		String name = request.getParameter("studentName");
		// 传入参数到dao层的查询方法，并将判断结果赋值给answer
		boolean answer = getDao.checkStudentName(name);
		// 创建变量result，存入返回jsp页面的结果
		String result = null;
		// 对从dao层返回的结果判断，
		if (answer == true) {
			// 被使用，则将下面用字符串形式编写的html格式的语句返回
			result = "<font color = 'red'>この名前が入力できません</font>";
		} else {
			// 没被使用则传回下列结果
			result = "<font color = 'green'>この名前が入力できます</font>";
		}
		// 用response设置返回请求的编码
		response.setCharacterEncoding("UTF-8");
		// 用response设置返回请求的格式
		response.setContentType("text/html;charset=UTF-8");
		// 用response返回请求给ajax，
		response.getWriter().print(result);
	}

	/**
	 * ajax 查询姓名
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "selectStudentName.do")
	protected void selectStudentName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 链接dao进行数据库查询
		StudentDao getDao = getStudentDao();
		// 创建name变量，用以下方法接收ajax请求中的参数
		String name = request.getParameter("studentName");
		// 传入参数到dao层的查询方法，并将判断结果赋值给answer
		boolean answer = getDao.selectStudentName(name);
		// 创建变量result，存入返回jsp页面的结果
		String result = null;
		// 对从dao层返回的结果判断，
		if (answer == true) {
			// 被使用，则将下面用字符串形式编写的html格式的语句返回
			result = "<font color = 'red'>この名前が存在してません,直してください！</font>";
		} else {
			// 没被使用则传回下列结果
			result = "<font color = 'green'>この名前が入力できます</font>";
		}
		// 用response设置返回请求的编码
		response.setCharacterEncoding("UTF-8");
		// 用response设置返回请求的格式
		response.setContentType("text/html;charset=UTF-8");
		// 用response返回请求给ajax，
		response.getWriter().print(result);

	}

	/**
	 * ajax 删除 id
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "upDateStudentName.do")
	protected void upDateStudentName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 连接dao层调取数据库
		StudentDao getDao = getStudentDao();
		// 创建id变量，用以下方法接收ajax请求中的参数
		String name = request.getParameter("upname");
		// 传入参数到dao层的查询方法，并将判断结果赋值给answer
		boolean answer = getDao.upDateStudentName(name);
		// 创建变量result，存入返回jsp页面的结果
		String result = null;
		// 对从dao层返回的结果判断，
		if (answer == true) {
			// 如果answer符合true的要求，则将下面用字符串形式编写的html格式的语句返回
			result = "<font color = 'red'>このnameが存在していません,直してください！</font>";
		} else {
			// 如果不符合要求则执行以下语句返回
			result = "<font color = 'green'>このnameが更新できます </font>";
		}
		// 用response设置返回请求的编码
		response.setCharacterEncoding("UTF-8");
		// 用response设置返回请求的格式
		response.setContentType("text/html;charset=UTF-8");
		// 用response设置返回请求给ajax
		response.getWriter().print(result);
	}

	/**
	 * 学生一覧をWordファイル出力
	 *
	 * @return
	 */
	@RequestMapping(value = "getOutPutToCsv")
	public String getOutPutToWord(Model model) {
		// 使用ApplicationContext方法，链接dao层，获取查询数据库的相关方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 创建一个StudentDao类型的变量，将使用context方法获取到的applicationContext.xml配置文件里的dao层的路径；
		StudentDao dao = (StudentDao) context.getBean("Studao");
		// 创建集合，将从数据库查询到的信息存放到集合中
		List<Student> studentList = new ArrayList<>();
		// 调取dao层里的queryAll方法，获取数据库总信息
		studentList = dao.queryAll();
		// 使用model方法，将获取到的信息，返回到前台jsp页面
		// 其中addAttribute括号内，第一个参数是用来指定将查询信息返回到jsp页面的具体位置，第二个参数，是用来指定查询结果来返回
		model.addAttribute("stuList", studentList);
		// 返回student.jsp页面
		// TODO:OutputToWord
		File outputFilePath = new File("C:/Users/xumin/Desktop/csv/sample.csv");
		System.out.println(outputFilePath);
		try {
			outputFilePath = getWordFileByStudentList(studentList);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		model.addAttribute("outputFilePath", outputFilePath);
		return "student";
	}




	/**
	 * studentLisｔでWorｄファイルを作成
	 *
	 * @param studentList
	 * @throws FileNotFoundException
	 */
	private File getWordFileByStudentList(List<Student> studentList) throws FileNotFoundException {
		/*
		 * System.out.println("1111"); File csv = new
		 * File("C:/Users/xumin/Desktop/csv/sample.csv"); // CSVデータファイル
		 * System.out.println("2222"); System.out.println(csv); try {
		 *
		 * BufferedReader br = new BufferedReader(new FileReader(csv));
		 * System.out.println(br);
		 *
		 * // 最終行まで読み込む String line = ""; for (Student stu : studentList) { line +=
		 * stu.toString(); System.out.println(line); } while ((line = br.readLine()) !=
		 * null) {
		 *
		 * // 1行をデータの要素に分割 StringTokenizer st = new StringTokenizer(line, ",");
		 *
		 * while (st.hasMoreTokens()) { // 1行の各要素をタブ区切りで表示
		 * System.out.print(st.nextToken() + "\t"); } System.out.println(); }
		 * br.close();
		 *
		 * } catch (FileNotFoundException e) { // Fileオブジェクト生成時の例外捕捉
		 * e.printStackTrace(); } catch (IOException e) { //
		 * BufferedReaderオブジェクトのクローズ時の例外捕捉 e.printStackTrace(); } return csv; }
		 */
		File csvFile = null;
		String fileName = "student";
		BufferedWriter csvFileOutputStream = null;
		try {
			File file = new File("C:/Users/xumin/Desktop/csv");
			if (!file.exists()) {
				file.mkdir();
			}
			// 定义文件名格式并创建
			csvFile = File.createTempFile(fileName, ".csv", new File("C:/Users/xumin/Desktop/csv"));
			System.out.println("csvFile：" + csvFile);
			// UTF-8使正确读取分隔符","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GBK"),
					1024);
			System.out.println("csvFileOutputStream：" + csvFileOutputStream);
			// foreach（拡張for文）での書き方
			// 学生の1個ずつ取り出す
			for (Student value : studentList) {
				// 学生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
				csvFileOutputStream.write(value.getId()+",");
				csvFileOutputStream.write(value.getName()+",");
				csvFileOutputStream.write(value.getBirthday()+",");
				csvFileOutputStream.write(value.getAge()+",");
				csvFileOutputStream.write(value.getScore()+",");
				csvFileOutputStream.write(value.getClassid()+",");
				csvFileOutputStream.write(value.getAddress()+",");
				csvFileOutputStream.write("\r\n");
			}
			// 写入文件头部
			// for (Iterator propertyIterator = ((Map) studentList).entrySet().iterator();
			// propertyIterator.hasNext();) {
			// java.util.Map.Entry propertyEntry = (java.util.Map.Entry)
			// propertyIterator.next();
			// csvFileOutputStream.write((String) propertyEntry.getValue() != null
			// ? new String(((String) propertyEntry.getValue()).getBytes("GBK"), "GBK")
			// : "");
			// if (propertyIterator.hasNext()) {
			// csvFileOutputStream.write(",");
			// }
			// System.out.println(new String(((String)
			// propertyEntry.getValue()).getBytes("GBK"), "GBK"));
			// }
			// csvFileOutputStream.write("\r\n");
			// 写入文件内容
			// for (Iterator<Student> iterator = studentList.iterator();
			// iterator.hasNext();) {
			// Object row = (Object) iterator.next();
			// for (Iterator propertyIterator = ((Map) studentList).entrySet().iterator();
			// propertyIterator.hasNext();) {
			// java.util.Map.Entry propertyEntry = (java.util.Map.Entry)
			// propertyIterator.next();
			// csvFileOutputStream.write((String) BeanUtils.getProperty(row,
			// ((String) propertyEntry.getKey()) != null ? (String) propertyEntry.getKey() :
			// ""));
			// if (propertyIterator.hasNext()) {
			// csvFileOutputStream.write(",");
			// }
			// }
			// if (iterator.hasNext()) {
			// csvFileOutputStream.write("\r\n");
			// }
			// }
			csvFileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}
}
