package com.demo.cts.service;

import java.util.List;

import com.demo.cts.domain.Book;

public interface BookService {

	public void deleteBook(int id);
	public void addBook(Book book);
	public Book findBook(int id);
	public List<Book> displayAllBooks();
	public void updateBook(Book book);
}
