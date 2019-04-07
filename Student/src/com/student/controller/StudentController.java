package com.student.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Student;
import com.student.dao.StudentDao;

@Controller
public class StudentController {

	/**
	 * 1,总的dao链接层 链接StudentDao层的共通方法
	 */

	private StudentDao getDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao getDao = (StudentDao) context.getBean("StuDao");

		return getDao;
	}

	/**
	 * 从主页直接跳转到学生信息查询功能页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/goToSelectPage")
	public String goToSelectPage(Model model) {
		// 调取方法链接Dao层
		StudentDao dao = getDao();
		// 获取Dao层的查询方法进行数据库访问后，吧访问的数据赋值给集合studentList
		List<Student> studentList = dao.queryAll();
		// 返回集合
		model.addAttribute("stuList", studentList);
		// 指定返回页面
		// 此处的return，指返回到那个jsp页面
		return "select";

	}

	/**
	 * 处理页面的超链接请求，请求名称为goTOStudentPage
	 */
	//@RequestMapping(value = "goTOStudentPage")
	public String queryAll(Model model) {

		// 使用ApplicationContext方法，连接dao层，获取查询数据库的相关方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 创建一个StudentDao类型的变量，将使用context方法获取到的applicationContext。xml配置文件里的dao层的路径；
		StudentDao dao = (StudentDao) context.getBean("StuDao");
		// 创建集合，将从数据库查询到的信息存放到集合中
		List<Student> studentList = new ArrayList<>();

		// 调取dao层里的queryAll方法，获取数据库总信息
		studentList = dao.queryAll();

		// 使用model方法，将获取到的信息，返回前台jsp页面。
		// 其中addAttribute括号内，第一个参数，是用来指定将结果返回到jso页面的那个位置，第二个参数，是用来指定将那些结果来返回
		model.addAttribute("stuList", studentList);

		// 此处的return，是指返回到那个jsp页面

		return "student";
	}

	@RequestMapping(value = "/getStudentById")
	public String getStudentById(String id, Model model) {
		// 将从页面获取到的String id，转换成int型的数据，用于数据库查询
		int stuId = Integer.valueOf(id);
		StudentDao getDao = getDao();
		List<Student> studentList = getDao.queryById(stuId);
		model.addAttribute("stuList", studentList);
		return "select";

	}

	@RequestMapping(value = "/getStudentByName")
	public String getStudentByName(String name, Model model) {
		StudentDao getDao = getDao();
		List<Student> studentList = getDao.queryByName(name);
		model.addAttribute("stuList", studentList);
		return "select";
	}

	/**
	 * 根据输入的学生ID来查询具体学生信息
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selStudent")
	// 关于如何获取网页上，文本输入框中输入的内容，根据servlet协议，是通过获取文本框（<input>标签）
	// 的name属性名称后，能够获取到该文本框的输入内容
	public String selectStudentById(String id, Model model) {

		// 从前台获取的参数都是String型，而数据库中Id是int型，所以要进行数据类型转换
		// 用Integer的方法对字符串类型的id进行转换
		// 因为前台传入的参数内容，可能会有空格，所以要去除参数的前后空格用 .trim（）.
		int stuId = Integer.valueOf(id.trim());
		StudentDao dao = getDao();
		// 这步完成以后回到studentdao层
		List<Student> studentList = dao.queryById(stuId);
		model.addAttribute("stuList", studentList);
		return "select";
	}

	/**
	 * 2 在select.js学生名字检查 完成后再这里进行
	 *
	 * @param name+++
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/goToSelectByName")
	public String selectStudentByName(String name, Model model) {
		String stuName = name.trim();
		StudentDao dao = getDao();
		/**
		 * 3返回DAO层 5回到controller
		 */
		List<Student> studentList = dao.queryByName(stuName);
		model.addAttribute("stuList", studentList);
		return "select";

	}


	/**
	 * 下载信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/goToDownLoadFile")
	public static void dowmLoadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 通知浏览器这是一个下载文件的请求，上面代码要导包
		response.setContentType("application/x-mmasdownload");
		// 指定要下载的文件名称
		String fileName = "downFile.docx";
		// 通知浏览器，不在由浏览器来自行处理（或打开）要下载的文件，而由用户端来处理（主要应对IE浏览器）
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		// 编写文件输出流
		OutputStream out = response.getOutputStream();
		// 配置要下载的文件路径
		String wordFilePath = "C:\\Users\\huamo\\Desktop\\新建.docx";
		// 首先用Java读取要下载的文件
		InputStream in = new FileInputStream(wordFilePath);
		// servlet IO 传输步骤
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		// 关闭IN接口
		in.close();

	}

	/**
	 * 在主页先制作 学生の情報を削除 超链接，然后再controller层建立连接dao层调取方法 跳转到delete.jsp功能页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/goToDeletePage")
	public String goToDeletePage(Model model) {
		// 调取方法链接Dao层
		StudentDao dao = getDao();
		// 获取Dao层的查询方法进行数据库访问后，吧访问的数据赋值给集合studentList
		List<Student> studentList = dao.queryAll();
		// 返回集合
		model.addAttribute("stuList", studentList);
		// 指定返回页面
		// 此处的return，指返回到那个jsp页面
		return "delete";

	}

	/**
	 * 根据学生ID来删除数据表信息
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/DeleteStudent")
	public String deleteStudentById(String id, Model model) {
		// 用Integer的方法对字符串类型的id进行转换，括号内的是toString里的去除变量前后空格的方法
		int stuId = Integer.valueOf(id.trim());
		// 连接StudentDao层
		StudentDao dao = getDao();
		// 让删除有一个更好的反馈
		// 新建一个boolean型变量，调取dao层的删除方法，将操作后的结果返回给result
		boolean result = dao.deleteStudentById(stuId);
		// 对返回结果进行判断
		// 如果删除操作成功，给出提示
		if (result) {
			System.out.println("削除完了");

		} else {
			System.out.println("削除できません");
		}
		// 删除操作完成后，再次查询下数据库信息，并将结果返回到页面
		model.addAttribute("stuList", dao.queryAll());
		// 指定返回页面
		return "delete";


	}

	 /**
	  * 根据名字来删除
	  * @param name
	  * @param model
	  * @return
	  */


		@RequestMapping(value = "/goToDeleteByName")
		public String deleteStudentByName(String name, Model model) {
			// 用Integer的方法对字符串类型的id进行转换，.trim 括号内的是toString里的去除变量前后空格的方法
			String stuName = name.trim();
			// 连接StudentDao层
			StudentDao dao = getDao();
			// 让删除有一个更好的反馈
			// 新建一个boolean型变量，调取dao层的删除方法，将操作后的结果返回给result
			boolean result = dao.deleteStudentByName(stuName);

			// 对返回结果进行判断
			// 如果删除操作成功，给出提示
			if (result) {
				System.out.println("削除完了");

			} else {
				System.out.println("削除できません");
			}
			// 删除操作完成后，再次查询下数据库信息，并将结果返回到页面
			model.addAttribute("stuList", dao.queryAll());
			// 指定返回页面
			return "delete";


		}

		@RequestMapping(value = "/addStudent")
		public String addStudent(String name,String birthday,String age,String score,String classId,String address,Model model) {
			//創建student的對象
			Student student = new Student();
			//用set方法吧从jsp页面接收到的数据，去除前后空格，并转换为相应格式后，赋值给student对象
			student.setName(name.trim());
			student.setBirthday(birthday.trim());
			student.setAge(Integer.valueOf(age.trim()));
			student.setScore(Integer.valueOf(score.trim()));
			student.setClassId(Integer.valueOf(classId.trim()));
			student.setAddress(address.trim());
			//連接StudentDao层
			StudentDao dao = getDao();
			//创建boolean型变量，将数据库的增加结果返回给result
			//然后去dao层
			boolean result = dao.addStudent(student);
			if(result) {
				System.out.println("");
			}else {
				System.out.println("");
			}
			model.addAttribute("stuList", dao.queryAll());
			return "addStudent";




		}







		   /**
		    * 追加学生信息
            * 跳转到addstudent功能页面
            *
            * @param model
            * @return
            */
		@RequestMapping(value="gotoAddPage")
		public String goToAddPage(Model model) {
			StudentDao dao = getDao();
			List<Student> studentList = dao.queryAll();
			model.addAttribute("stuList", studentList);
			return "addStudent";
		}




             /**
              * 跳转到update功能页面
              * @param model
              * @return
              */
		@RequestMapping(value = "/goToUpDatePage")
		public String goToUpDatePage(Model model) {
			StudentDao dao = getDao();
			model.addAttribute("stuList", dao.queryAll());
			return "update";
		}


		@RequestMapping(value="/updateStuednt")
		public String UpdateStudent(String id,String name,String birthday,String age,String score,String classId,String address,Model model) {
			Student student = new Student();
			student.setId(Integer.valueOf(id.trim()));
			student.setName(name.trim());
			student.setBirthday(birthday.trim());
			student.setAge(Integer.valueOf(age.trim()));
			student.setScore(Double.valueOf(score.trim()));
			student.setClassId(Integer.valueOf(classId.trim()));
			student.setAddress(address.trim());
			StudentDao dao = getDao();
			boolean result = dao.updateStudent(student);
			if(result) {
				System.out.println("更新完了");
			}else {
				System.out.println("更新できません");
			}
			model.addAttribute("stuList",dao.queryAll());
			return "update";

		}


		@RequestMapping(value="/addStduentAddress")
		public String addStudentAddress(String addr11,String id,Model model) {
			int stuId = Integer.valueOf(id.trim());
			String stuAddress = addr11.trim();
			StudentDao dao = getDao();
			boolean result = dao.addAddress(stuId, stuAddress);
			if(result) {
				System.out.println("追加完了");
			}else {
				System.out.println("追加できません");
			}
			model.addAttribute("stuList",dao.queryAll());
			return "update";
		}













	/**
	 * scv
	 * 学生一覧をWordファイル出力
	 *
	 * @return
	 */
	@RequestMapping(value = "getOutPutToCsv")
	public String getOutPutToWord(Model model) {

		// 使用ApplicationContext方法，链接dao层，获取查询数据库的相关方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 创建一个StudentDao类型的变量，将使用context方法获取到的applicationContext.xml配置文件里的dao层的路径；
		StudentDao dao = getDao();
		// 创建集合，将从数据库查询到的信息存放到集合中
		List<Student> studentList = new ArrayList<>();
		// 调取dao层里的queryAll方法，获取数据库总信息
		studentList = dao.queryAll();
		// 使用model方法，将获取到的信息，返回到前台jsp页面
		// 其中addAttribute括号内，第一个参数是用来指定将查询信息返回到jsp页面的具体位置，第二个参数，是用来指定查询结果来返回
		model.addAttribute("stuList", studentList);
		// 返回student.jsp页面
		// TODO:OutputToWord
		File outputFilePath = new File("C:/Users/huamo/Desktop/csv/sample.csv");
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
			File file = new File("C:/Users/huamo/Desktop/csv");
			if (!file.exists()) {
				file.mkdir();
			}
			// 定义文件名格式并创建
			csvFile = File.createTempFile(fileName, ".csv", new File("C:/Users/huamo/Desktop/csv"));
			System.out.println("csvFile：" + csvFile);
			// UTF-8使正确读取分隔符","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GBK"),
					1024);
			System.out.println("csvFileOutputStream：" + csvFileOutputStream);
			// foreach（拡張for文）での書き方
			// 学生の1個ずつ取り出す
			for (Student value : studentList) {
				// 学生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
				csvFileOutputStream.write(value.getId() + ",");
				csvFileOutputStream.write(value.getName() + ",");
				csvFileOutputStream.write(value.getBirthday() + ",");
				csvFileOutputStream.write(value.getAge() + ",");
				csvFileOutputStream.write(value.getScore() + ",");
				csvFileOutputStream.write(value.getClassId() + ",");
				csvFileOutputStream.write(value.getAddress() + ",");
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
