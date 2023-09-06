package com.dakr.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.studentnotfoundexception.StudentNotFoundException;

@RestController
public class StudentController {

	
	@GetMapping("/student/{studentId}")
 public String getStudentName(@PathVariable Integer studentId)throws Exception {
	 if(studentId >= 100) {
	 return " Welcome to world of sukanya";
	 }
	 else {
		 throw new StudentNotFoundException("Student Id NotFound ");
	 }
 }
	
	
}
