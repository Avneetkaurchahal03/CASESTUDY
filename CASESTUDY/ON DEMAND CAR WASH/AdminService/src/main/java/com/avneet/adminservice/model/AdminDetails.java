package com.avneet.adminservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Document(collection="Admin")
public class AdminDetails {
	
	@Id
	@NotNull
	private Integer id;
	@NotNull
	@Size(min=25 ,message="should not have numeric in it")
	private String name;
	
	
	//default Constructor
	public AdminDetails() {
		super();
	}
	
	// parameterised Constructor
	public AdminDetails(@NotNull Integer id, @NotNull @Size(min = 25) String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	
	//GettersAndSetters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AdminDetails [id=" + id + ", name=" + name + "]";
	}
	


	
	
	

	
	
}
