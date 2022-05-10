package com.avneet.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DatabaseSequence {
	
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

    public static String getSequenceName()
    {
	return SEQUENCE_NAME;
	}
    
	
    @Id
	private String id;
    private long seq;
    
    
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public long getSeq() {
		return seq;
	}


	public void setSeq(long seq) {
		this.seq = seq;
	}

	
	

	public DatabaseSequence() {
		super();
	}


	public DatabaseSequence(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}


	@Override
	public String toString() {
		return "DatabaseSequence [id=" + id + ", seq=" + seq + "]";
	} 

}
