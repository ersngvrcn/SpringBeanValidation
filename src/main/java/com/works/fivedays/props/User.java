package com.works.fivedays.props;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class User {
	
	@NotNull(message="Name not null")
	@NotEmpty(message="Name not empty")
	private String name;
	
	@Range(min=3, max=18, message = "age between 3 and 18")
	private int age;
	
	@Email(message="Mail format fail")
	@NotEmpty(message = "Mail not empty")
	private String mail;
	private String desc;
	
}
