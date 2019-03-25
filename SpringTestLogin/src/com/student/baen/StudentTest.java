package com.student.baen;

public class StudentTest {
    private int id;
    private String name;
    private String birthday;
    private int age;
    private int score;
    private int classid;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id �Z�b�g���� id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name �Z�b�g���� name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday �Z�b�g���� birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age �Z�b�g���� age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score �Z�b�g���� score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @return classid
	 */
	public int getClassid() {
		return classid;
	}
	/**
	 * @param classid �Z�b�g���� classid
	 */
	public void setClassid(int classid) {
		this.classid = classid;
	}
	/* (�� Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + classid;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}
	/* (�� Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentTest other = (StudentTest) obj;
		if (age != other.age)
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (classid != other.classid)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	/* (�� Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentTest [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", score="
				+ score + ", classid=" + classid + "]";
	}
	/**
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param classid
	 */
	public StudentTest(int id, String name, String birthday, int age, int score, int classid) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.score = score;
		this.classid = classid;
	}
	/**
	 *
	 */
	public StudentTest() {
		super();
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}




}
