package com.gofortrainings.newsportal.core.JavaPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class University {

	public List<Person> getPersonDetails() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("AnilReddy", 25, "Student", "Male"));
		personList.add(new Person("ramya", 23, "Student", "FeMale"));
		personList.add(new Person("ravi", 23, "Student", "Male"));
		personList.add(new Person("ramireddy", 19, "Student", "Male"));
		personList.add(new Person("pooran", 40, "Student", "Male"));
		personList.add(new Person("dhoni", 22, "Student", "Male"));
		personList.add(new Person("poornima", 34, "Student", "FeMale"));
		personList.add(new Person("sowmya", 25, "Student", "FeMale"));
		personList.add(new Person("priya", 20, "Student", "FeMale"));
		personList.add(new Person("krishnaveni", 29, "Student", "FeMale"));
		personList.add(new Person("Ram", 22, "Lecturer", "Male"));
		personList.add(new Person("kavya", 22, "Lecturer", "FeMale"));
		personList.add(new Person("brakrath", 21, "attender", "Male"));
		personList.add(new Person("raksha", 20, "Admissions officer", "FeMale"));
		personList.add(new Person("anju", 25, "Student", "FeMale"));
		personList.add(new Person("pavani", 55, "Lecturer", "FeMale"));
		personList.add(new Person("akhil", 32, "Professsor", "Male"));
		personList.add(new Person("konda", 56, "Technician", "Male"));
		personList.add(new Person("roopa", 62, "Student", "FeMale"));
		personList.add(new Person("mani", 10, "Web editor", "Male"));
		personList.add(new Person("ramya", 27, "Librarian", "Male"));
		personList.add(new Person("AnilReddy", 25, "Student", "Male"));

		return personList;
	}

	public Person getYoungStudent(List<Person> personList) {
		Iterator<Person> personIterator = personList.iterator();
		Person youngLecturer = null;
		while (personIterator.hasNext()) {
			Person person = (Person) personIterator.next();
			String type = "Lecturer";
			if (person.getType().equals(type)) {
				if (youngLecturer == null) {
					youngLecturer = person;
				} else if (youngLecturer.age > person.getAge()) {
					youngLecturer = person;
				}
			}
		}
		return youngLecturer;
	}
}
