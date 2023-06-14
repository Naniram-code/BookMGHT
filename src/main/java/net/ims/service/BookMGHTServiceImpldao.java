package net.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ims.entity.BookMGHT;
import net.ims.exceptionalhandler.RecordNotFoundException;
import net.ims.repo.BookMGHTRepo;
@Service
public class BookMGHTServiceImpldao implements BookMGHTServiceDAO {
	@Autowired
	private BookMGHTRepo bRepo;
	 
	
	public List<BookMGHT> getAllBook() {
		List<BookMGHT>booklist=bRepo.findAll();
		
		return booklist;
	}

	
	public BookMGHT addBook(BookMGHT book) {

		
		   BookMGHT b= bRepo.save(book);
	             if (b!=null) 
	             { b=bRepo.save(b);
		            return b;}
	                return null;

	}
	public BookMGHT saveOrUpdateBook(BookMGHT book) {
	
		 Optional<BookMGHT> bookOptional = bRepo.findById(book.getId());
		   BookMGHT b= bookOptional.get();
	             if (b!=null) 
		    	  b=bRepo.save(b);
		    
	           return b;

	}
	


	public boolean deletebook(Integer id) {
		
		 Optional<BookMGHT> bookOptional = bRepo.findById(id);
		    BookMGHT book=bookOptional.get();
		    boolean flag =false;
		    if (book!=null) {
		    	bRepo.deleteById(id);
		       flag=true;
		    } else {
		    	
		        
		    }return flag;
	}
    public BookMGHT getbookById(Integer id) throws RecordNotFoundException {
	  
	     Optional<BookMGHT> bookOptional = bRepo.findById(id);
	    
	    if (bookOptional.isPresent()) 
	        return bookOptional.get();
	     else 
	        throw new RecordNotFoundException("Book Not Found");


}}
