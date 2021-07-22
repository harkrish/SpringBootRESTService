package com.example.controller;

import org.springframework.stereotype.Component;

@Component
public class AddBookResponse { 
	
	private String id;
	private String msg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	} 
	
	
	

}
