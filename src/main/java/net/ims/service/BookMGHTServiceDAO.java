package net.ims.service;

import java.util.List;

import net.ims.entity.BookMGHT;
import net.ims.exceptionalhandler.RecordNotFoundException;

public interface BookMGHTServiceDAO {

	public List<BookMGHT> getAllBook();
	public  BookMGHT addBook(BookMGHT book);
	public BookMGHT saveOrUpdateBook(BookMGHT book);
	public boolean deletebook(Integer id);
	BookMGHT getbookById(Integer id ) throws RecordNotFoundException;
}
