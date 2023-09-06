package com.dakr.Entity;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Data
public class Student {
	
    private Integer stuid;
	private String code;
	private String msg;
	private  LocalDateTime date;
}
