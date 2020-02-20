package com.offcn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.offcn.bean.Book;

public interface BookMapper {
	public List<Book> getBookList();

	public void deleteBookById(Integer isbn);

	public void addBook(Book book);

	public void updateBook(Book book);

	public Book getBookById(Integer isbn);
}
