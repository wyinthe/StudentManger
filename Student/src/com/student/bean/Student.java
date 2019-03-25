package com.student.bean;

public class Student {

	// 对应数据库的ID列
	private int id;
	// 对应数据库的name列
	private String name;
	// 对应数据库的birthday列
	private String birthday;
	// 对应数据库的age列
	private int age;
	// 对应数据库的score列
	private double score;
	// 对应数据库的classId列
	private int classId;
	// 对应数据库的address列
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
