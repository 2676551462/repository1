package com.offcn.service;

import java.util.List;

import com.offcn.utils.SerializableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.offcn.bean.Book;
import com.offcn.dao.BookMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class BookService {
	
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private JedisPool jedisPool;

	@Transactional
	public List<Book> getBookList() {
		List<Book> list = null;
		Jedis jedis = jedisPool.getResource();

		long start = System.currentTimeMillis();
		byte[] bytes = jedis.get(SerializableUtils.serializable("list"));
		if (bytes==null){
			 list = bookMapper.getBookList();
			jedis.set(SerializableUtils.serializable("list"),SerializableUtils.serializable(list));
			long end = System.currentTimeMillis();
			System.out.println("走数据库时间："+(end-start));
		}else{
			list = (List<Book>) SerializableUtils.unSerializable(bytes);
			long end = System.currentTimeMillis();
			System.out.println("走缓存时间："+(end-start));
		}
		jedis.close();
		return list;
	}
	
	
	  @Transactional 
	  public void addBook(Book book) { 
		  bookMapper.addBook(book);
	  
	  }
	  
	  @Transactional 
	  public void deleteBookById(Integer isbn) {
		  bookMapper.deleteBookById(isbn); 
	  }

	  @Transactional 
	  public void updateBook(Book book) {
		  bookMapper.updateBook(book);
		
	}

	  @Transactional 
	  public Book getBookById(Integer isbn) {
		  return bookMapper.getBookById(isbn);
	  }
	 

}
