package com.avneet.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Ratings")
public class WasherRating {


	@Id
	private Long id;
	private String Washername;
	private String comment;
	
	

	 @Transient
	    public static final String SEQUENCE_NAME = "users_sequence";
	
	//default
	public WasherRating() {
		super();
	}

	
	//constructor
	public WasherRating(Long id, String washername, String comment) {
		super();
		this.id = id;
		Washername = washername;
		this.comment = comment;
	}
	

	//getters&setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWashername() {
		return Washername;
	}
	public void setWashername(String washername) {
		Washername = washername;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "WasherRating [id=" + id + ", Washername=" + Washername + ", comment=" + comment + "]";
	}
	
	
	
}
