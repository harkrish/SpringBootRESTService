package com.example.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Equivalent of @Controller+@ResponseBody
public class GreetingController { 
	
	@Autowired  //Automatically create object for class and does not allocate memory -> dependency injection
	Greeting greeting; //Inject other dependent bean into our bean
	AtomicLong counter = new AtomicLong();
	
	//http://localhost:8080/greeting?name=Hari
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name")String name) {
		
		greeting.setId(counter.incrementAndGet());
		greeting.setContent("Hello I'm "+name); 
		return greeting; //Jackson API to convert Java object into JSON				
	}

	 //GET localhost:8080/getBookByISBN/12007 
	/* 
	 * @GetMapping("/getBookByISBN/{isbn}")
	public Greeting getBook(@PathVariable String isbn) {
		
		return greeting; //Jackson API to convert Java object into JSON				
	} 
	 * 
	 */
}
