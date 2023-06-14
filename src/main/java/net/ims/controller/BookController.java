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
import org.springframework.web.servlet.ModelAndView;

import net.ims.entity.BookMGHT;

import net.ims.service.BookMGHTService;
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
	
	public String getBookMGHTList()
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
		model.addAttribute("pol",c);
		return "updateBookMGHTList.html";
	}
	@RequestMapping("/deleteBookMGHTList/{id}")
	public String deleteBookList(@PathVariable int id,BookMGHT book) {
		service.deletebook(id);
		return "redirect:/getBookMGHTList";
	}
	
}