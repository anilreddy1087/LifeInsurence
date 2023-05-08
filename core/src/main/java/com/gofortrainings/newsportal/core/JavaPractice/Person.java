package com.gofortrainings.newsportal.core.JavaPractice;

public class Person {

	String name;
	int age;
	String type;
	String gender;

	public Person() {
	}

	public Person(String name, int age, String type, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.type = type;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", type=" + type + ", gender=" + gender + "]";
	}

}
