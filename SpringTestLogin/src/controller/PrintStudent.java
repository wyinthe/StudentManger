package studenttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.student.bean.Student;

public class PrintStudent {

	public static void main(String[] args) {
		// class instance 构造函数
		StudentTest studentOne = new StudentTest();
		studentOne.setId(1);
		studentOne.setName("zhang");
		studentOne.setBirthday("1990-06-02");
		studentOne.setAge(29);
		studentOne.setScore(90);
		studentOne.setClassid(2);

		StudentTest studentTwo = new StudentTest();
		// 通过set方法，给对象studentOne的变量
		studentTwo.setId(2);
		studentTwo.setName("li");
		studentTwo.setBirthday("1992-05-12");
		studentTwo.setAge(27);
		studentTwo.setScore(95);
		studentTwo.setClassid(2);

		// public StudentTest(int id, String name, String birthday, int age, int score,
		// int classid)
		// 创建对象StudentTest时，利用实参构造器，直接给对象初始化。
		StudentTest studentThree = new StudentTest(3, "wang", "1993-06-20", 26, 89, 3);
		StudentTest studentFour = new StudentTest(4, "zhao", "1990-12-23", 29, 65, 3);
		StudentTest studentFive = new StudentTest(5, "guo", "1994-09-27", 25, 76, 3);

		// 通过get方法获取取变量的属性值
		// System.out.println(studentOne.getId());
		// System.out.println(studentOne.getName());
		// System.out.println(studentOne.getBirthday());
		// System.out.println(studentOne.getAge());
		// System.out.println(studentOne.getScore());
		// System.out.println(studentOne.getClassid());
		System.out.println();

		// 创建一个集合，用于储存刚才创建的student信息。
		// 集合 的类型 集合的名称
		List<StudentTest> studentList = new ArrayList<StudentTest>();

		studentList.add(studentOne);
		studentList.add(studentTwo);
		studentList.add(studentThree);
		studentList.add(studentFour);
		studentList.add(studentFive);

		// double sumStudentScore= GetsumStudentScore(studentList);
		// System.out.println(sumStudentScore);
		// double maxStudentScore= GetMaxStudentScore(studentList);
		// System.out.println(maxStudentScore);
		double minStudentScore = GetMinStudentScore(studentList);
		System.out.println(minStudentScore);
		double advStudentScore = GetAdvStudentScore(studentList);
		System.out.println(advStudentScore);

		Map<String, StudentTest> studentMap = new HashMap<>();
		studentMap.put("1", studentOne);
		studentMap.put("2", studentTwo);
		studentMap.put("3", studentThree);
		studentMap.put("4", studentFour);
		studentMap.put("5", studentFive);

		// System.out.println(studentMap);
		double sumStudentScoreMap = GetSumStudentScoreMap(studentMap);
		System.out.println(sumStudentScoreMap);
	}

	/**
	 * 求studentLits内的学生成绩综合
	 */
	private static double GetSumStudentScoreMap(Map<String, StudentTest> studentMap) {
		double sumStudentScoreMap = 0;
		for (StudentTest student : studentMap.values()) {
			sumStudentScoreMap += student.getScore();
			// sumStudentScoreMap=sumStudentScoreMap+student.getgetScore()

		}
		return sumStudentScoreMap;

	}

	/**
	 * 求studentLits内的学生成绩综合
	 *
	 * @param studentList
	 * @return
	 */
	private static double GetsumStudentScore(List<StudentTest> studentList) {
		double GetSumStudentScore = 0;
		for (StudentTest GetSum : studentList) {
			GetSumStudentScore += GetSum.getScore();
		}
		return GetSumStudentScore;
	}

	private static double GetAdvStudentScore(List<StudentTest> studentList) {
		double advStudentScore = GetsumStudentScore(studentList) / studentList.size();

		return advStudentScore;

	}

	private static double GetMaxStudentScore(List<StudentTest> studentList) {
		double maxStudentScore = 0;
		for (StudentTest Getmax : studentList) {
			if (maxStudentScore < Getmax.getScore()) {
				maxStudentScore = Getmax.getScore();
			}
		}
		return maxStudentScore;

	}

	private static double GetMinStudentScore(List<StudentTest> studentList) {
		double minStudentScore = 0;
		for (StudentTest Getmin : studentList) {
			if (Getmin.getId() == 1) {
				minStudentScore = Getmin.getScore();
			} else {
				if (minStudentScore > Getmin.getScore()) {
					minStudentScore = Getmin.getScore();
				}

			}

		}
		return minStudentScore;

	}

	// double minScore=0;
	// for(Student stu:stuList) {
	// if(stu.getId()==1) {
	// minScore=stu.getScore();
	// }else {
	// if(minScore>stu.getScore()) {
	// minScore=stu.getScore();
	// }
	// }
	// }
	// return minScore;

}
