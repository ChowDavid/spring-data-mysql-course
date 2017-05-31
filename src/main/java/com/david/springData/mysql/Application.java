package com.david.springData.mysql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.david.springData.mysql.dao.BookRepository;
import com.david.springData.mysql.model.Book;
import com.david.springData.mysql.service.BookService;

public class Application {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		 try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class)){
			 BookService service=context.getBean(BookService.class);
			 BookRepository repo=context.getBean(BookRepository.class);
//			Book book=new Book("First Book", new Date(), 33, new BigDecimal("26.00"));
//			service.save(book);
//			book.setBookId(null);
//			book.setTitle("Java Book");
//			service.save(book);
//			
//			service.getAllBook().forEach(b->System.out.println(b));
			
			System.out.println("List our only 1,2,3");
			
			
//			repo.findAll(new ArrayList<Long>(){{
//				add(1L);
//				add(2L);
//				add(3L);
//			}}).forEach(b->System.out.println(b));
//			
//			repo.findByTitle("Java");
			
//			repo.findByTitleIgnoreCase("java");
			
//			repo.findByPageCountLessThanEqual(12);
//			repo.findByPageCountBetween(10,200);
//			repo.findTop5ByTitleLike("%Java%").forEach(b->System.out.println(b));
			repo.findByAuthor_FirstName("Allan").forEach(b->System.out.println(b));
		 }
		 
		 

	}

}
