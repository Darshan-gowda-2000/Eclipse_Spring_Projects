package student.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;
import student.management.models.Student;
import student.management.services.StudentService;

// When we want to return html pages display the data we have to use @Controller
// If we want to return String we have to use @RestController
@Controller                                     
public class StudentController {
 
	
/*	@GetMapping("/got/{data}")                       // example for @PathVariable
	public String gotIt(@PathVariable String data)
	{
		return "Got it"+data;
	}
	
	@GetMapping("/achiveIt")
	public String getIt(@RequestParam String d1, @RequestParam String d2)      // Example for @RequestParam
	{
		return "Persue it!!"+d1 +","+d2;
	}
	
	@PostMapping("/acceptStudent")
	public String acceptStudent(
			@RequestParam int roll,
			@RequestParam  String name,
			@RequestParam  String branch,
			@RequestParam  int yop,
			@RequestParam double cgpa
			)
	{
		Student st=new Student(roll,name,branch,yop,cgpa);
		System.out.println(st);
		return "Student data recived";
	} */
	
	
	// Creating in
	@Autowired        
	StudentService service;
	
	
	@PostMapping("/addStudent")
	public String acceptNewStudent(@ModelAttribute Student st,Model model)
	{
		service.addStudent(st);
		model.addAttribute("msg","Student Added Successfully!!");
		return "index";
	}
	
	@PostMapping("/updateStudent")
	public String updateNewStudent(@ModelAttribute Student st)
	{
		service.updateStudent(st);
		return "index";
	}
	
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam int roll,Model model)
	{
		Student st=service.searchStudent(roll);
		model.addAttribute("student",st);
    	return "displayStudent";
	}  
		
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll)
	{
    	 service.deleteStudent(roll);
    	 return "index";
	}   
	
	@GetMapping("/fetchAllStudents")
	public  String fetchAllStudents(Model model) {
	List<Student> stList=service.fetchAllStudents();
	model.addAttribute("studentList",stList);
	return "displayAllStudents";
	}
	
	@GetMapping("/deleteAllStudents")
	public String deleteAllStudents() {
	 service.deleteAllStudents();
	 return "index";
	}
	
}