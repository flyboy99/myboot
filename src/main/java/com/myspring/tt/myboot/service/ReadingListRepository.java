package com.myspring.tt.myboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspring.tt.myboot.domain.model.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}
