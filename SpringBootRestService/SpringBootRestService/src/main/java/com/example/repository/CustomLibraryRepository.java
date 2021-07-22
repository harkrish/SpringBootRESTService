package com.example.repository;

import java.util.List;

import com.example.controller.Library;

public interface CustomLibraryRepository {
	public List<Library> findByAuthor(String AuthorName);
}
