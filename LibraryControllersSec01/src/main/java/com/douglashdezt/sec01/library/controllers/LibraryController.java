package com.douglashdezt.sec01.library.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douglashdezt.sec01.library.models.dtos.SaveBookDTO;
import com.douglashdezt.sec01.library.models.entities.Book;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	private static List<Book> library = new ArrayList<>();
    
    static {
        library.add(new Book("0261102303", "Lord of the Rings"));
        library.add(new Book("0007441428", "Game of Thrones"));
        library.add(new Book("0747581088", "Harry Potter and the Half-Blood Prince"));
        library.add(new Book("1401248195", "Watchmen"));
        library.add(new Book("030788743X", "Ready player one 2"));
        library.add(new Book("843760494X", "Cien Años de Soledad 2"));
        library.add(new Book("0553804367", "A Briefer History of Time"));
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getBookList(Model model) {
    	model.addAttribute("books", library);
    	return "book-list";
    }
    
    @GetMapping("/")
    public String getMainpage(Model model) {
    	String time = Calendar.getInstance().getTime().toString();
    	model.addAttribute("time", time);
    	
    	return "main";
    }
    
    @PostMapping("/save")
    public String saveBook(@ModelAttribute SaveBookDTO bookInfo) {
    	System.out.println(bookInfo);
    	
    	Book newBook = new Book(bookInfo.getIsbn(), bookInfo.getTitle());
    	library.add(newBook);
    	
    	return "redirect:/library/";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
