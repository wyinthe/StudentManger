package com.student.baen;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.students.Student;
/**
 *  测试student类
 * @author huamo
 *
 */
   public class PrintStudent {


	/**
	 * 生成student类的对象，集合，用打印语句输出结果
	 * @param args
	 */
    public static void main(String[] args) {

    	//生成student类的对象
	      //对象类型       对象名称 = 构造方法（对对象进行初始化）
		StudentTest studentOne = new StudentTest();

		//因为我们使用是 空参的构造方法，所以创建好对象后，对象是没有具体内容的
		//要给对象添加具体内容的话，需要调用student类里的set方法
		//通过.set方法，给对象studentOne的属性添加内容
		studentOne.setId(1);
		studentOne.setName("zhang");
		studentOne.setBirthday("1990-06-02");
		studentOne.setAge(29);
		studentOne.setScore(90);
		studentOne.setClassid(2);

		// 创建student类的对象 studentTwo
//		对象类型 对象名称 构造方法（实参数方法）
		StudentTest studentTwo = new StudentTest();
		studentTwo.setId(2);
		studentTwo.setName("li");
		studentTwo.setBirthday("1992-05-12");
		studentTwo.setAge(27);
		studentTwo.setScore(95);
		studentTwo.setClassid(2);

		// public StudentTest(int id, String name, String birthday, int age, int score,
		// int classid)
		// 使用实参数构造方法 来创建对象，创建完成后，获得括号内的具体数值，不用在使用set方法来设置数值
		StudentTest studentThree = new StudentTest(3, "wang", "1993-06-20", 26, 89, 3);
		StudentTest studentFour = new StudentTest(4, "zhao", "1990-12-23", 29, 65, 3);
		StudentTest studentFive = new StudentTest(5, "guo", "1994-09-27", 25, 76, 3);

		/**

		// 使用打印语句来查看相关信息，用 对象名称.get的方法来活的对象的具体数值
		//1.打印完结果后 自动换行 再次打印信息会出现在下一行
		System.out.println(studentFour.getId());
		 //2.打印完结果后，不自动换行，再次打印的信息会出现在同一行
		System.out.println(studentFour.getName());
		System.out.println(studentFour.getBirthday());
		System.out.println(studentOne.getAge());
		System.out.println(studentOne.getScore());
		System.out.println(studentOne.getClassid());
         *
		 */


		// 集合，1.List集合
	//集合类型1 创建List<放入集合中的数据（对象）的类型>集合的名称，=初始化（new） ArrayList<>()对结合进行初始化
		//（需要导入java外部包，java。uti1下的包）快捷键 CL+SHIFT+O
		//快捷键补全arr。。 用ALTGR+/
		List<StudentTest> studentList = new ArrayList<>();
		//通过集合名称.add的方法，可以给集合添加内容
		studentList.add(studentOne);
		studentList.add(studentTwo);
		studentList.add(studentThree);
		studentList.add(studentFour);
		studentList.add(studentFive);

		//System.out.println(studentList);
		System.out.println("学生"+studentList);


	/**.get(index) 是从0开始的
	 * System.out.println(studentList.get(index));
	 */



		//集合的名称.size（）的方法 来获取集合里的对象个数；
		System.out.println(studentList.size());

		//2.map集合
		//集合类型<放入集合中的数据（对象）的类型>创建后集合的名称=对集合进行初始化
		Map<String,StudentTest> studentTestMap = new HashMap<>();

		//通过集合名称.put的方法，可以给集合添加内容
		studentTestMap.put("1", studentOne);
		studentTestMap.put("2", studentTwo);
		studentTestMap.put("3", studentThree);






}

   }