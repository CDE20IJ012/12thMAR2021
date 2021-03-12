package com.demo.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cts.dao.BookRepository;
import com.demo.cts.domain.Book;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

	@Override
	public void deleteBook(int id) {
	   return;
		
	
	}

	

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book findBook(int id) {
		Book found=null;
		Optional<Book> bookFound=bookRepository.findById(id);
		if(bookFound.isPresent())
		{
			found=bookFound.get();
		}
		return found;
	}

	@Override
	public List<Book> displayAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updateBook(Book book) {
		
		  bookRepository.save(book); 
	  }
	
}
