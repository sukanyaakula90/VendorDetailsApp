package com.dakr.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dakr.Entity.Student;
import com.dakr.studentnotfoundexception.StudentNotFoundException;

@RestControllerAdvice
public class StudentExcepionHandler {
	
@ExceptionHandler(value = StudentNotFoundException.class)

public ResponseEntity<Student> exceptionhandle(StudentNotFoundException snfe){
	Student sd = new Student();
	sd.setCode("400");
	sd.setMsg(snfe.getMessage());
	sd.setDate(LocalDateTime.now());
	return new ResponseEntity<>(sd,HttpStatus.BAD_REQUEST);
}
}
