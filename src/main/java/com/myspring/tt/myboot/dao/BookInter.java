package com.myspring.tt.myboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspring.tt.myboot.domain.model.Book;

public interface BookInter extends JpaRepository<Book, Long>{

	List<Book> findBooksByTitle(String title);
}
