package com.myspring.tt.myboot.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String reader;
	
	private String title;
	
	private String author;
	
	private String desc;

	
	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", reader=" + reader + ", title=" + title
				+ ", author=" + author + ", desc=" + desc + "]";
	}
   
}
