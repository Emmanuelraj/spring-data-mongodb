package com.example.springdatamongodb.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document
public class UserDTO 
{
	
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Field("_id")
	private String id;
	
	
	private String name;
	
	
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	
	private Date dob;
	
	
	private String description;
	
	
	private Address address;
	
	
	private Date createdDate;
	
	
	//private Path imagePath;
	
	
	


	public UserDTO(String id, String name, Date dob, String description, Address address, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.description = description;
		this.address = address;
		this.createdDate = createdDate;
		//this.imagePath = imagePath;
	}

/**
	public Path getImagePath() {
		return imagePath;
	}


	public void setImagePath(Path imagePath) {
		this.imagePath = imagePath;
	}
*/

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", dob=" + dob + ", description=" + description + ", address="
				+ address + ", createdDate=" + createdDate + "]";
	}

	
	
	
	
	
	
	

}
