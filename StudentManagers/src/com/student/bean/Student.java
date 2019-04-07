package com.student.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 与要使用的数据表一一对应，待 Student类 与 数据库中的数据表映射完成后，可以形成关联，
 * 从而可以通过 Student类 存取数据表中的信息
 * @author huamo
 *
 */
public class Student implements Serializable{

	/**
	 *  シリアルるID
	 */
	private static final long serialVersionUID = -5242708732119872239L;
	//变数定义ID
	private int id;
	//变数定义name
	private String name;
	//变数定义birthday
	private Date birthday;
	//变数定义age
	private int age;
	//变数定义score
	private double score;
	//变数定义classid
	private int classid;
	//变数定义address
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

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
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
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}







}
