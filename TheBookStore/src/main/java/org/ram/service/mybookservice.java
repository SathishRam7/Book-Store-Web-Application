package org.ram.service;

import java.util.List;

import org.ram.entity.MyBookList;
import org.ram.repositary.MyBookRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mybookservice {
@Autowired
	private MyBookRepositary mybookrepo;
	
	public void savemybooks(MyBookList book) {
		mybookrepo.save(book);
	}
	public List<MyBookList>getallbooks(){
		return mybookrepo.findAll();
	}
	
	public void deletebyid(int id) {
		mybookrepo.deleteById(id);
	}
	
	
}
