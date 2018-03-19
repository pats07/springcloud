package com.webservice.domain;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Date dateOfBirth;

	public User(Integer id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

}
