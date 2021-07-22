package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.controller.Library;

public class LibraryRepositoryImpl implements CustomLibraryRepository{
    
	
	@Autowired 
	LibraryRepository repository;
	
	@Override
	public List<Library> findByAuthor(String AuthorName) {
		 
		List<Library> books = repository.findAll(); 
		List<Library> booksWithAuthor = new ArrayList<Library>();
		
		for(int i=0;i<books.size();i++) {
			if(AuthorName.equalsIgnoreCase(books.get(i).getAuthor())) {
				booksWithAuthor.add(books.get(i));
			}
		}
		
		return booksWithAuthor;
	}

}
