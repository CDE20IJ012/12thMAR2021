package com.demo.cts;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.cts.domain.Book;
import com.demo.cts.service.BookService;

@SpringBootApplication
public class SpringboothibernateApplication implements CommandLineRunner{

  //  @Autowired
	//private BookRepository bookRepository;
	
	@Autowired
	 private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringboothibernateApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Book book=new Book();
		/*
		 * Scanner scanner=new Scanner(System.in); System.out.println("Enter the tile");
		 * String title=scanner.next(); System.out.println("Enter the author"); String
		 * author=scanner.next(); System.out.println("Enter the price"); int
		 * price=scanner.nextInt(); book.setTitle("AWS"); book.setAuthor("JAmes");
		 * book.setPrice(1000); bookRepository.save(book);
		 * System.out.println("Book added!!!!!!!!!!");
		 */
		/*
		 * System.out.println("Searching a specific book"); Optional<Book>
		 * bookFound=bookRepository.findById(12); if(bookFound.isPresent()) {
		 * System.out.println(bookFound.get()); } else {
		 * System.out.println("Book not found!!!!!!");
		 * 
		 * }
		 */
		/* System.out.println("All the books");
	    List<Book> bookList=bookRepository.findAll();
		for(Book book1 : bookList)
		{
			System.out.println(book1.getBookId()+" "+book1.getTitle()+" "+book1.getPrice());
		}*/
	   // System.out.println("Demo of delete!!!!!");
		/*
		 * Optional<Book> bookFoundForDelete=bookRepository.findById(2); Book
		 * book2=null; if(bookFoundForDelete.isPresent()) {
		 * book2=bookFoundForDelete.get(); // Get will return the object found
		 * bookRepository.delete(book2); } else {
		 * System.out.println("No book with the id entered"); }
		 */
	    Scanner scan=new Scanner(System.in);
	    System.out.println("Enter the id for the book to be updated");
	    int id=scan.nextInt();
	    
	    Book found=bookService.findBook(id);
	    if(found!=null)
	    {
	  
	    System.out.println("Enter the new price");
	    found.setPrice(scan.nextFloat());
	    bookService.updateBook(found);
	    System.out.println("Book update!!!!!");
	    }
	    else
	    {
	    	System.out.println("Book not found!!!!!!");
	    }
	    
	}
	
	

}
