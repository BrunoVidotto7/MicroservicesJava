package com.vidotto.bookservice.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidotto.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
