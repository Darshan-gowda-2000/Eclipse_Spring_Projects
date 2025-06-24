package student.management.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import student.management.models.Student;

@Controller
public class NavigationController {

	@GetMapping("/openAddStudent")
	public String openAddStudentPage()
	{
		return "addStudent";
	}
	
	@GetMapping("/openUpdateStudent")
	public String openUpdateStudentPage()
	{
		return "updateStudent";
	}
	
	@GetMapping("/openSearchStudent")
	public String openSearchStudentPage()
	{
		return "searchStudent";
	} 
	
	@GetMapping("/openDeleteStudent")
	public String openDeleteStudentPage()
	{
		return "deleteStudent";
	} 
	
}
