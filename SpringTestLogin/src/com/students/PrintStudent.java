package com.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author louyifan
 *
 */
public class PrintStudent {

	public static void main(String[] args) {
		/**
		 * Studentのオブジェクトを生成する
		 */
		Student studentOne = new Student();
		studentOne.setId(1);
		studentOne.setName("zhang");
		studentOne.setBirthday("1990-05-29");
		studentOne.setAge(29);
		studentOne.setScore(92);
		studentOne.setClassid(1);
		// System.out.println(studentOne.getScore());

		Student studentTwo = new Student(2, "wang", "1992-05-06", 27, 86, 1);
		Student studentThree = new Student(3, "zhao", "1988-05-06", 31, 72, 1);
		Student studentFour = new Student(4, "guo", "1989-05-06", 30, 57, 1);
		Student studentFive = new Student(5, "sun", "1993-05-06", 26, 66, 1);
		// System.out.println(studentOne);
		// System.out.println(studentTwo);
		// System.out.println(studentThree);
		// System.out.println(studentFour);
		// System.out.println(studentFive);

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(studentOne);
		studentList.add(studentTwo);
		studentList.add(studentThree);
		studentList.add(studentFour);
		studentList.add(studentFive);
		//System.out.println(studentList);

		 //int sumStudentScoreList =
				 //;
//		 System.out.println("学生の総成績:"+getSumStudentScoreList(studentList));

//		 int advStudentScoreList = getAdvStudentScoreList(studentList);
//		 System.out.println("学生の平均成績:"+advStudentScoreList);
//		 int maxStudentScoreList = getMaxStudentScoreList(studentList);
//		 System.out.println("学生の成績の最高点:"+maxStudentScoreList);
//		 int minStudentScoreList = getMinStudentScoreList(studentList);
//		 System.out.println("学生の成績の最低点:"+minStudentScoreList);
		 String passStudentScoreList = getPassStudentScoreList(studentList);
		 System.out.println("合格の学生"+passStudentScoreList);

		Map<String, Student> studentMap = new HashMap<>();
		studentMap.put("1", studentOne);
		studentMap.put("2", studentTwo);
		studentMap.put("3", studentThree);
		studentMap.put("4", studentFour);
		studentMap.put("5", studentFive);



		//System.out.println(studentMap);
		int sumStudentScoreMap = getSumStudentScoreMap(studentMap);
		// System.out.println("学生の総成績:"+sumStudentScoreMap);

	}

	/**
	 *
	 * @param 学生の総成績を取得する getSumStudentScoreList
	 * @return
	 */
	public static int getSumStudentScoreList(List<Student> studentList) {
		int sumScore = 0;
		for (Student student : studentList) {
			sumScore += student.getScore();
		}
		return sumScore;
	}
	/**
	 *
	 * @param 学生の総成績を取得する getSumStudentScoreMap
	 * @return
	 */
	public static int getSumStudentScoreMap(Map<String, Student> studentMap) {
		int sumScore = 0;
		for (Student student : studentMap.values()) {
			sumScore += student.getScore();
		}
		return sumScore;

	}
	/**
	 *
	 * @param 学生の平均成績を取得する getAdvStudentScoreList
	 * @return
	 */
	public static int getAdvStudentScoreList(List<Student> studentList) {
		int advScore = getSumStudentScoreList(studentList)/studentList.size();
		return advScore;

	}
	/**
	 *
	 * @param 学生の成績の最高点を取得する getMaxStudentScoreList
	 * @return
	 */
	public static int getMaxStudentScoreList(List<Student> studentList) {
		int maxScore = 0;
		for (Student student : studentList) {
			if (student.getScore() > maxScore) {
				maxScore = student.getScore();
			}
		}
		return maxScore;
	}
	/**
	 *
	 * @param 学生の成績の最低点を取得する getMinStudentScoreList
	 * @return
	 */
	public static int getMinStudentScoreList(List<Student> studentList) {
		int minScore = 100;
		for (Student student : studentList) {
			if (student.getScore() < minScore) {
				minScore = student.getScore();
			}
		}
		return minScore;
	}
	/**
	 *
	 * @param 合格の成績をプリントする getPassStudentScoreList
	 * @return
	 */
	public static String getPassStudentScoreList(List<Student> studentList) {
		int passScore = 60;
		for (Student student : studentList) {
			if (student.getScore() >= passScore) {
				System.out.println(student.getName()+":"+student.getScore());
			}
		}
		return "おめでとう";
	}





}
