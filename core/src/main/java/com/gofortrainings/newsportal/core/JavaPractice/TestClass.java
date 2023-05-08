package com.gofortrainings.newsportal.core.JavaPractice;

import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		
		University university = new University();

		List<Person> personsList = university.getPersonDetails();
		
        /*
		List<person> studentList = university.getStudentDetails(personsList);

		List<person> librarianList = university.getLibrarianDetails(personsList);
		Iterator<person> youngAgeList = youngAge.iterator();
		while (youngAgeList.hasNext()) {
		person person = (person) youngAgeList.next();
		System.out.println(" Age :" + person.getAge());
		*/
		
		
		Person youngLecturer = university.getYoungStudent(personsList);
		System.out.println(youngLecturer);
	
	}
}
