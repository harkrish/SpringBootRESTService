package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.controller.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, String>,CustomLibraryRepository { //Return type of primary key


}
