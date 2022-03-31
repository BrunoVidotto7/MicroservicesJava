package com.vidotto.bookservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidotto.bookservice.model.Book;
import com.vidotto.bookservice.proxy.CambioProxy;
import com.vidotto.bookservice.response.Cambio;
import com.vidotto.bookservice.respository.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
@EnableFeignClients
public class BookController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CambioProxy cambioProxy;
	
	@Operation(summary = "Find a specific book by your ID")
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {	
		Optional<Book> oBook = bookRepository.findById(id);
		if(oBook.isEmpty()) {
			throw new RuntimeException("Book not found");
		}
		Book book = oBook.get();
		
		Cambio cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
		var port = environment.getProperty("local.server.port");
		book.setEnvironment(
				"Book port: "+ port + 
				" Cambio Port: " + cambio.getEnvironment());
		book.setPrice(cambio.getConvertedValue());
		return book;
	}
}
