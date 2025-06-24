package student.management.services;

import java.util.List;

import student.management.models.Student;

public interface StudentService {

	String addStudent(Student st);
	String updateStudent(Student st);
	Student searchStudent(int roll);
	String deleteStudent(int roll);
	
    List<Student> fetchAllStudents();
    
    String deleteAllStudents();
}
