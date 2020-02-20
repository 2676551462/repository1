package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.bean.Book;
import com.offcn.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "getBook", method = RequestMethod.GET)
	public ModelAndView getBooklist() {
		List<Book> list = bookService.getBookList();
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value = "getBookById/{isbn}", method = RequestMethod.GET)
	public ModelAndView getBookById(@PathVariable("isbn") Integer isbn) {
		Book book = bookService.getBookById(isbn);
//		System.out.println(isbn);
//		System.out.println(book);
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("book", book);
		return mv;
	}
	
	
	@RequestMapping(value = "/addBook",method = RequestMethod.POST)
	public String addBook(Book book ) {
		bookService.addBook(book);
		return "redirect:/book/getBook";
	}
	
	@RequestMapping(value = "/updateBook",method = RequestMethod.POST)
	public String updateBook(Book book ) {
		bookService.updateBook(book);
		return "redirect:/book/getBook";
	}
	
	@RequestMapping(value = "/delete/{isbn}",method = RequestMethod.DELETE)
	public String deleteBookById(@PathVariable("isbn") Integer isbn ) {
		bookService.deleteBookById(isbn);
		return "redirect:/book/getBook";
	}
	
}
