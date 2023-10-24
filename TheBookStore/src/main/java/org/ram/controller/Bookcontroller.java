package org.ram.controller;

import java.util.List;

import org.ram.entity.Book;
import org.ram.entity.MyBookList;
import org.ram.service.Bookservice;
import org.ram.service.mybookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Bookcontroller {
	@Autowired
	private Bookservice bookservice;
	
	@Autowired 
	private mybookservice mybookservice;
	
    @GetMapping("/")
	public String home() {
		return "home";
	}
    
    @GetMapping("/bookregister")
    public String bookregister() {
    return "bookregister";	
    }
    @GetMapping("/availablebooks")
    public ModelAndView getallbook() {
    	List<Book>list=bookservice.getallbooks();
    	return new ModelAndView("booklist","book",list);
    }
    @PostMapping("/save")
    public String addbook(@ModelAttribute Book book) {
    bookservice.save(book);	
    return "redirect:/availablebooks";
    }
    
    @GetMapping("/mybooks")
    public String getmybooks(Model model) {
    	
    	List<MyBookList>mybooks=mybookservice.getallbooks();
    	model.addAttribute("book", mybooks);
    	return "mybooks";
    }
    
    @RequestMapping("/mylist/{id}")
    public String getmylist(@PathVariable("id") int id){
    	Book b=bookservice.getbookbyid(id);
    	MyBookList ab=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
    	mybookservice.savemybooks(ab);
    	return "redirect:/mybooks";
    }
    @RequestMapping("/bookedit/{id}")
    public String bookedit(@PathVariable("id")int id,Model model) {
          Book b=bookservice.getbookbyid(id);
          model.addAttribute("book", b);
    	return "bookedit";
    }
    @RequestMapping("/deletebook/{id}")
    public String deletebook(@PathVariable("id") int id) {
    	bookservice.deletebyid(id);
    	return "redirect:/availablebooks";
    }
    
}
