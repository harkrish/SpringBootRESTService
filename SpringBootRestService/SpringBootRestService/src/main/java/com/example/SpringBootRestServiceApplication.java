package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.controller.Library;
import com.example.repository.LibraryRepository;

@SpringBootApplication
public class SpringBootRestServiceApplication {//implements CommandLineRunner
    
	@Autowired
	LibraryRepository repository; 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub 
//		
//		Library lib= repository.findById("fdsefr343").get();  //JPA Interaction with Database //findById returns Optional,by using get() use Library Entity object 
//		System.out.println(lib.getAuthor()); 
//		
//		lib.setAisle(44);
//		lib.setAuthor("Sai");
//		lib.setBook_name("Rest"); 
//		lib.setId("test");
//		lib.setIsbn("test44"); 
//		
//		repository.save(lib); 
//		List<Library> allRecords = repository.findAll(); 
//		for(Library item: allRecords) {
//			System.out.println(item.getBook_name());
//		}
//		//repository.delete(lib); //delete entity
//	}
	


}
