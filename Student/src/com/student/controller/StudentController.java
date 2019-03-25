package com.student.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Student;
import com.student.dao.StudentDao;


@Controller
public class StudentController {

	/**1,总的dao链接层
	 * 	链接StudentDao层的共通方法
	 */

	private StudentDao getDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao getDao = (StudentDao) context.getBean("StuDao");


		return getDao;
	}



/**
 * 从主页直接跳转到学生信息查询功能页面
 * @return
 */
	@RequestMapping(value="/goToSelectPage")
	public String goToSelectPage(Model model) {
		//调取方法链接Dao层
		StudentDao dao= getDao();
		//获取Dao层的查询方法进行数据库访问后，吧访问的数据赋值给集合studentList
		List<Student>studentList = dao.queryAll();
		//返回集合
		model.addAttribute("stuList",studentList);
		//指定返回页面
		//此处的return，指返回到那个jsp页面
		return "select";

	}




	/**
	 * 处理页面的超链接请求，请求名称为goTOStudentPage
	 */
	@RequestMapping(value="goTOStudentPage")
	public String queryAll(Model model) {


		//使用ApplicationContext方法，连接dao层，获取查询数据库的相关方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//创建一个StudentDao类型的变量，将使用context方法获取到的applicationContext。xml配置文件里的dao层的路径；
				StudentDao dao = (StudentDao) context.getBean("StuDao");
				//创建集合，将从数据库查询到的信息存放到集合中
		List<Student> studentList = new ArrayList<>();

		//调取dao层里的queryAll方法，获取数据库总信息
		studentList = dao.queryAll();

		//使用model方法，将获取到的信息，返回前台jsp页面。
		//其中addAttribute括号内，第一个参数，是用来指定将结果返回到jso页面的那个位置，第二个参数，是用来指定将那些结果来返回
		model.addAttribute("stuList", studentList);

		//此处的return，是指返回到那个jsp页面

	return "student";
	}





	@RequestMapping(value="/getStudentById")
	public String getStudentById(String id,Model model) {
		//将从页面获取到的String id，转换成int型的数据，用于数据库查询
		int stuId =Integer.valueOf(id);
		StudentDao getDao = getDao();
		List<Student> studentList =getDao.queryById(stuId);
		model.addAttribute("stuList",studentList);
		return "select";


	}

	@RequestMapping(value="/getStudentByName")
	public String getStudentByName(String name,Model model) {
		StudentDao getDao = getDao();
		List<Student> studentList =getDao.queryByName(name);
		model.addAttribute("stuList",studentList);
		return "select";
	}

/**
 * 根据输入的学生ID来查询具体学生信息
 * @param id
 * @param model
 * @return
 */
	@RequestMapping(value="/selStudent")
	//关于如何获取网页上，文本输入框中输入的内容，根据servlet协议，是通过获取文本框（<input>标签）
	//的name属性名称后，能够u暗恋获取到该文本框的输入内容
	public String selectStudentById(String id,Model model) {

		// 从前台获取的参数都是String型，而数据库中Id是int型，所以要进行数据类型转换
		//用Integer的方法对字符串类型的id进行转换
		// 因为前台传入的参数内容，可能会有空格，所以要去除参数的前后空格用 .trim（）.
		int stuId =Integer.valueOf(id.trim());
		StudentDao dao =getDao();
		//这步完成以后回到studentdao层
		List<Student>studentList = dao.queryById(stuId);
		model.addAttribute("stuList",studentList);
		return "select";
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
		StudentDao dao = (StudentDao) context.getBean("StuDao");
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
				csvFileOutputStream.write(value.getId()+",");
				csvFileOutputStream.write(value.getName()+",");
				csvFileOutputStream.write(value.getBirthday()+",");
				csvFileOutputStream.write(value.getAge()+",");
				csvFileOutputStream.write(value.getScore()+",");
				csvFileOutputStream.write(value.getClassId()+",");
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
