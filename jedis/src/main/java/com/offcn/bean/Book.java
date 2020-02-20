package com.offcn.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Book implements Serializable {
	private Integer isbn;
	private String bookName;
	private double price;
	
	public Book(String bookName, double price) {
		super();
		this.bookName = bookName;
		this.price = price;
	}
	public Book(Integer isbn, String bookName, double price) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBook_name(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookName=" + bookName + ", price=" + price + "]";
	}
	
}
