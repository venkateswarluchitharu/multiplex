package com.multiplex.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Multiplex {
	
	private Long multiplex_id;
	 @Size(min=4,max=10)
	 private String multiplex_name;
	 @Email
	 private String multiplex_address;
	 @NotNull
	 private String multiplex_rating;

}
