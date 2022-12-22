package com.collections.di.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("category")
public class Category {
	private static final Logger logger = LoggerFactory.getLogger(Category.class);
	
	@Value("2")
	private long id; 
	
	@Value("Category-2")
	private String name;
	
	@Autowired
	@Qualifier("bookWhitman")
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();  
        Category category = ctx.getBean(Category.class);
        logger.info("====== BookAutowiriedByType Output Start =====");
		logger.info(category.getCategoryDetails());
		logger.info(" ===== BookAutowiriedByType Output End =====");
        
	}
	
	public String getCategoryDetails() {
		return book.getBookDetails();
	}
	
	
}
