package net.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.ims.entity.BookMGHT;

import net.ims.exceptionalhandler.RecordNotFoundException;
import net.ims.service.BookMGHTServiceImpldao;



@Controller
public class BookController {
	@Autowired
	private BookMGHTServiceImpldao service;
	
	@RequestMapping("/")
	
    public String HomePage()
	{
		
		return"home.html";
	}
	
	@GetMapping("/addBook")
	
	public String getBookMGHT()
	{
		
		return"BookMGHT.html";
	}
	
	@PostMapping("/saveBookMGHTList")
    public  String saveCat(@ModelAttribute BookMGHT b)
		 
    {
		service.addBook(b);	 
	 
		return"redirect:/getBookMGHTList";
	   }
	

     @GetMapping("/getBookMGHTList")
        public String getAllBookMGHTList(Model model) {
           List<BookMGHT> list = service.getAllBook();
             model.addAttribute("pol", list);
                return "BookMGHTDisplay";
}
	@RequestMapping("/editBookMGHTList/{id}")
	public String editPol(@PathVariable int id,BookMGHT b,Model model) {
	
	    BookMGHT c=service.saveOrUpdateBook(b);
	
		{model.addAttribute("pol",c);
		return "updateBookMGHTList.html";}
		
		
	}
	@RequestMapping("/deleteBookMGHTList/{id}")
	public String deleteBookList(@PathVariable int id,BookMGHT book) {
		service.deletebook(id);
		return "redirect:/getBookMGHTList";
	}
	
	@RequestMapping("/search")
	public String findBook()
	{
		
		return"bookSearch";
	}
	
	@GetMapping("/findBook")
	public String displayBookById(@RequestParam("id") int id, Model model) {
	    try {
	        BookMGHT b = service.getbookById(id);
	        model.addAttribute("pol", b);
	        
	    } catch (RecordNotFoundException e) {
	        model.addAttribute("error", "Book not found");
	    }
	    return "DisplaySearchBook";
	}

	
}
