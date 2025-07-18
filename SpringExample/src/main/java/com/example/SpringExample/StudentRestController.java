package com.example.SpringExample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/api/students")
public class StudentRestController {
@Autowired
private final StudentDOA stud;
public StudentRestController(StudentDOA stud) {
	this.stud = stud;
}
@GetMapping
public List<StudentEntity> listStudents() {
	return stud.getAllStudents();
	}

@GetMapping("/getbyid/{studentId}")
public StudentEntity getStudentById(@PathVariable("studentId") Long id) {
	StudentEntity student = stud.getStudentById(id);
	if (student != null) {
		return student;
	}
	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not Found");
}

@GetMapping("/getall")
public List<StudentEntity> getAllStudents() {
	List<StudentEntity> students = stud.getAllStudents();
	if (students != null && !students.isEmpty()) {
		return students;
	}
	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Students Found");
}
@PostMapping("/add")
public StudentEntity addStudent(@RequestBody StudentEntity student) {
		stud.addStudent(student);
		  System.out.println("Received student: " + student);
	return student;
}
@PutMapping("/update/{studentId}")
public StudentEntity updateEmp(@PathVariable("studentId") Long id,@RequestBody StudentEntity std) {
	StudentEntity existstud=stud.getStudentById(id);
	   if(existstud!=null) {
		   existstud.setFirstName(std.getFirstName());
		   existstud.setLastName(std.getLastName());
		   existstud.setGender(std.getGender());
		   existstud.setDob(std.getDob());
		   existstud.setEmail(std.getEmail());
		   existstud.setPhone(std.getPhone());
		   existstud.setAddress(std.getAddress());
		   existstud.setCity(std.getCity());
		   existstud.setState(std.getState());
		  
		   existstud.setPincode(std.getPincode());
		   existstud.setEnrollmentDate(std.getEnrollmentDate());
		   existstud.setCourse(std.getCourse());
		  
		   
		   stud.updateStudent(existstud);
		   return existstud;
	   }
return null;
}
@DeleteMapping("/delete/{studentId}")
public String deleteStudent(@PathVariable("studentId") Long id) {
	StudentEntity student = stud.getStudentById(id);
	if (student != null) {
		stud.deleteStudent(id);
	} else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not Found");
	}
	   return id+" Student Deleted Sucessfully";
}
}
