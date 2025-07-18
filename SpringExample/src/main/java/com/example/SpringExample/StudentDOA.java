package com.example.SpringExample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDOA {
@Autowired
private final StudRepo studRepo;
public StudentDOA(StudRepo studRepo) {
	this.studRepo = studRepo;
}
// Fetch student by ID
public  StudentEntity getStudentById(Long id) {
	return studRepo.findById(id).orElse(null);
}
// Fetch all students
public List<StudentEntity> getAllStudents() {
	return studRepo.findAll();
}
// Add new student
public void addStudent(StudentEntity student) {
	studRepo.save(student);
}
// Update student
public void updateStudent(StudentEntity student) {
	studRepo.save(student);
}
// Delete student by ID
public void deleteStudent(Long id) {
	studRepo.deleteById(id);
}


}
