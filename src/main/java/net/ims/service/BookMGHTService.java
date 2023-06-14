package net.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ims.entity.BookMGHT;

import net.ims.repo.BookMGHTRepo;


@Service
public class BookMGHTService {
	@Autowired
	private BookMGHTRepo bRepo;

	public void saveBookList(BookMGHT b) {
		bRepo.save(b);
		

	}

	public List<BookMGHT> getAllBookMGHT()
	{
		return bRepo.findAll();
		}
	
	
	public  BookMGHT getBookMGHTById(int id) {
		return bRepo.findById(id).get();
	}
	
	
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	}

