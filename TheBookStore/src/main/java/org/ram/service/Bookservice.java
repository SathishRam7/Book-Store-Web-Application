package org.ram.service;

import java.util.List;

import org.ram.entity.Book;
import org.ram.repositary.BookRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bookservice {
@Autowired
private BookRepositary brepo;
	public void save(Book b) {
		brepo.save(b);
	}
	public List<Book> getallbooks(){
		return brepo.findAll();
	}
	public Book getbookbyid(int id) {
		return brepo.findById(id).get();
	}
	public void deletebyid(int id) {
		brepo.deleteById(id);
	}
	
	
}
