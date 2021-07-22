package com.example.controller;

import org.springframework.stereotype.Component;

@Component
public class Greeting { 
	
	//Bean class/ Resource representation class/ Entity
	private long id; 
	private String content;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
	

}
