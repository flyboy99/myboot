package com.myspring.tt.myboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.tt.myboot.domain.model.Book;
import com.myspring.tt.myboot.service.ReadingListRepository;

@Controller
@RequestMapping("/readinglist")
public class ReadingListController {
	
	private ReadingListRepository listRepository;
	
	@Autowired
	public ReadingListController(ReadingListRepository
			listRepository)
	{		
		this.listRepository = listRepository;
	}
	
	@RequestMapping(value="/{reader}", method=RequestMethod.GET)
	public String readerBooks(@PathVariable("reader") String reader,
			Model model){
		List<Book> readingList = listRepository.findByReader(reader);
		if(null!=readingList){
			model.addAttribute("books",readingList);
		}
		
		return "readingList";
	}
	
	@RequestMapping(value="/{reader}", method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader,
			Book book){
		book.setReader(reader);
		listRepository.save(book);
		return "redirect:/{reader}";
	}
}
