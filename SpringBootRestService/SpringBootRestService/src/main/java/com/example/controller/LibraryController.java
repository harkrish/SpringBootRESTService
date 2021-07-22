package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.repository.LibraryRepository;
import com.example.service.LibraryService;

@RestController
public class LibraryController {  
	
	@Autowired 
	LibraryRepository repository;  
	
	@Autowired 
	LibraryService libraryService;
	
	@Autowired 
	AddBookResponse response;
	
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
    
	@PostMapping("/addBook")
	public ResponseEntity addBookImp(@RequestBody Library lib) { 
		
		String id = libraryService.buildId(lib.getIsbn(),lib.getAisle());
		
		if(!libraryService.checkBookAlreadyExist(id)) {
		logger.info("Book is not alredy exist");
		lib.setId(id);
	    repository.save(lib);	 
	    //customHeaders
	    HttpHeaders headers = new HttpHeaders(); 
	    headers.add("unique", id);
	    response.setMsg("Book is Successfully Added"); 
	    response.setId(id);  
	    
	    //return response;
	    return new ResponseEntity<AddBookResponse>(response,headers,HttpStatus.CREATED); //201
		} 
		else {
			//Book Already exist 
			logger.info("Book alredy exist");
			response.setMsg("Book Already exist"); 
			response.setId(id);
			return new ResponseEntity<AddBookResponse>(response,HttpStatus.ACCEPTED); //202
		}		
	}
	
	@GetMapping("/getBooks/{id}") 
	public Library getBookById(@PathVariable(value="id") String id) { 
		try {
		Library lib = repository.findById(id).get(); 
		return lib;
		} 
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
    
	@GetMapping("/getBooks/author") 
	public List<Library> getBookByAuthorName(@RequestParam(value="authorname") String authorname) {
		return repository.findByAuthor(authorname);
	}
	
	@PutMapping("updateBook/{id}") //200
	public ResponseEntity<Library> updateBookById(@PathVariable(value="id") String id,@RequestBody Library lib) {
		Library existingId = repository.findById(id).get(); 
		System.out.println(existingId.getIsbn());
		existingId.setAisle(lib.getAisle()); 
		existingId.setAuthor(lib.getAuthor());
		existingId.setBook_name(lib.getBook_name());  
		repository.save(existingId); 
		return new ResponseEntity<Library>(existingId,HttpStatus.OK); 		
	} 
	
	@DeleteMapping("/deleteBook") 
	public ResponseEntity<String> deleteBookById(@RequestBody Library lib) { 
		Library deleteBookId = repository.findById(lib.getId()).get();
		repository.delete(deleteBookId);
		return new ResponseEntity<>("Book is Deleted",HttpStatus.CREATED);
		
	}
	
	

}
