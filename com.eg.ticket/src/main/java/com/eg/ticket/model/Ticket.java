package com.eg.ticket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {
    @Id
    private String id;
    private String name;
    private String date;
    private String assigned_to;
    private String subject;
    private String description;
    private String state;
    
    public Ticket(String id, String name, String date, String assigned_to, String subject, String description,
			String state) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.assigned_to = assigned_to;
		this.subject = subject;
		this.description = description;
		this.state = state;
	}



	public Ticket() {
    }


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



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getAssigned_to() {
		return assigned_to;
	}



	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}
    

}