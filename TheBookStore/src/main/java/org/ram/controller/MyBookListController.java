package org.ram.controller;

import org.ram.service.mybookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {
   
	@Autowired
	private mybookservice mybs;
	
	@RequestMapping("/deletemylist/{id}")
	public String deletemylist(@PathVariable("id")int id) {
		mybs.deletebyid(id);
		return "redirect:/mybooks";
	}
}
