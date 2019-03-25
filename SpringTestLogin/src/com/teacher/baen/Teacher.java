package com.teacher.baen;

public class Teacher {
	private int id;
	private String name;
	private String birthday;
	private int age;
	private int score;
	private int classid;






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






	public int getScore() {
		return score;
	}






	public void setScore(int score) {
		this.score = score;
	}






	public int getClassid() {
		return classid;
	}






	public void setClassid(int classid) {
		this.classid = classid;
	}






	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", score=" + score
				+ ", classid=" + classid + "]";
	}






	public Teacher(int id, String name, String birthday, int age, int score, int classid) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.score = score;
		this.classid = classid;
	}






	public Teacher() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}





}
