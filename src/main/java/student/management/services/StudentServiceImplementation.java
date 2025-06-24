package student.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.models.Student;
import student.management.repositories.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{

	@Autowired
	StudentRepository repo;
	
	@Override
	public String addStudent(Student st) {
		 repo.save(st);
		return "Student added!!";
	}
	
	@Override
	public String updateStudent(Student st) {
		repo.save(st);
		return "Student Updated!!";
	}


	@Override
	public Student searchStudent(int roll) {
		return repo.findById(roll).get();
	}

	@Override
	public String deleteStudent(int roll) {
	  repo.deleteById(roll);
	  return "Student Deleted";
	}

	@Override
	public List<Student> fetchAllStudents() {
		return repo.findAll();
	}

	@Override
	public String deleteAllStudents() {
	 repo.deleteAll();
	 return "Students Deleted!!";
	}
}
