package com.udemy.springpractice4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.springpractice4.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
