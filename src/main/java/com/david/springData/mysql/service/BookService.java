package com.david.springData.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.springData.mysql.dao.BookRepository;
import com.david.springData.mysql.model.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public void save(Book book){
		repo.save(book);
	}
	
	public List<Book> getAllBook(){
		return repo.findAll();
	}
	
	
}
