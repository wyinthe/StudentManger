package com.teacher.baen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.students.Student;

public class PrintTeacher {

	public static void main(String[] args) {
		Teacher teacherOne = new Teacher();

		teacherOne.setId(1);
		teacherOne.setName("zhang");
		teacherOne.setBirthday("1990-06-02");
		teacherOne.setAge(29);
		teacherOne.setScore(70);
		teacherOne.setClassid(2);

		Teacher teacherTow = new Teacher();

		teacherTow.setId(2);
		teacherTow.setName("zhou");
		teacherTow.setBirthday("1990-07-05");
		teacherTow.setAge(30);
		teacherTow.setScore(78);
		teacherTow.setClassid(3);

		Teacher teacherThree=new Teacher(3,"wang","1992-05-01",28,88,1);
		Teacher teacherFour=new Teacher(4,"liu","1990-09-09",29,90,1);
		Teacher teacherFive=new Teacher(5,"liu","1990-09-09",29,104,2);

       //添加List集合       List名字
		List<Teacher> teacherList = new ArrayList<Teacher>();

		teacherList.add(teacherOne);
		teacherList.add(teacherTow);
		teacherList.add(teacherThree);
		teacherList.add(teacherFour);
		teacherList.add(teacherFive);

		Map<String, Teacher> teacherMap = new HashMap<>();
		teacherMap.put("1", teacherOne);
		teacherMap.put("2", teacherTow);
		teacherMap.put("3", teacherThree);
		teacherMap.put("4", teacherFour);
		teacherMap.put("5", teacherFive);









	}
	//map求合
	private static int getSumTeacherScoreMap(Map<String, Teacher> teacherMap) {
		int sumScore = 0;
		//                         map时候记住带上.values
		for (Teacher teacher : teacherMap.values()) {
			sumScore += teacher.getScore();
		}

		return sumScore;
	}

	//List求合
	public static int getSumTeacherScoreList(List<Teacher> teacherList) {
		int sumScore = 0;
		for (Teacher teacher : teacherList) {
			sumScore += teacher.getScore();
		}
		return sumScore;
	}


	public static int getAdvTeacherScoreList(List<Teacher>TeacherList) {
		int advScore = getSumTeacherScoreList(TeacherList)/TeacherList.size();
		return advScore;
	}





}
