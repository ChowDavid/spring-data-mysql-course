package com.david.springData.mysql.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.david.springData.mysql.model.Book;

@NoRepositoryBean
public interface BookRepository extends JpaRepository<Book, Long> {

	/*
	 * HQL: select generatedAlias0 from com.david.springData.h2.model.Book as
	 * generatedAlias0 where generatedAlias0.title=:param0
	 */

	/*
	 * SQL:92 select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as
	 * PAGE_COU2_0_, book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as
	 * PUBLISH_4_0_, book0_.TITLE as TITLE5_0_ from BOOK book0_ where
	 * book0_.TITLE=?
	 */
	public Book findByTitle(String title);

	/*
	 * SQL:92 - select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as
	 * PAGE_COU2_0_, book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as
	 * PUBLISH_4_0_, book0_.TITLE as TITLE5_0_ from BOOK book0_ where
	 * book0_.TITLE like ?
	 */
	public List<Book> findByTitleLike(String title);

	/*
	 * SQL:92 - select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as
	 * PAGE_COU2_0_, book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as
	 * PUBLISH_4_0_, book0_.TITLE as TITLE5_0_ from BOOK book0_ where
	 * book0_.TITLE like ?
	 */
	public List<Book> findByTitleContaining(String title);

	/*
	 * SQL:92 - select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as
	 * PAGE_COU2_0_, book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as
	 * PUBLISH_4_0_, book0_.TITLE as TITLE5_0_ from BOOK book0_ where
	 * book0_.TITLE like ?
	 */
	public List<Book> findByTitleStartingWith(String title);

	public List<Book> findByTitleEndingWith(String title);

	/*
	 * select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as PAGE_COU2_0_,
	 * book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as PUBLISH_4_0_,
	 * book0_.TITLE as TITLE5_0_ from BOOK book0_ where
	 * upper(book0_.TITLE)=upper(?)
	 */
	public List<Book> findByTitleIgnoreCase(String title);

	public List<Book> findByPageCountEquals(int pageCount);

	public List<Book> findByPageCountGreaterThan(int pageCount);

	public List<Book> findByPageCountLessThan(int pageCount);

	public List<Book> findByPageCountGreaterThanEqual(int pageCount);

	/*
	 * select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as PAGE_COU2_0_,
	 * book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as PUBLISH_4_0_,
	 * book0_.TITLE as TITLE5_0_ from BOOK book0_ where book0_.PAGE_COUNT<=?
	 */
	public List<Book> findByPageCountLessThanEqual(int pageCount);

	/*
	 * select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as PAGE_COU2_0_,
	 * book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as PUBLISH_4_0_,
	 * book0_.TITLE as TITLE5_0_ from BOOK book0_ where book0_.PAGE_COUNT
	 * between ? and ?
	 */
	public List<Book> findByPageCountBetween(int min, int max);

	public List<Book> findByTitleNot(String title);

	public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);

	public List<Book> findByTitleContainingOrPageCountGreaterThan(String title, int pageCount);

	public List<Book> findByPublishDateAfter(Date date);

	public List<Book> findByPublishDateBefore(Date date);

	public List<Book> findByPublishDateBetween(Date date1, Date date2);

	/*
	 * select book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as PAGE_COU2_0_,
	 * book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as PUBLISH_4_0_,
	 * book0_.TITLE as TITLE5_0_ from BOOK book0_ where book0_.TITLE like ?
	 * order by book0_.PRICE asc
	 */
	public List<Book> findByTitleLikeOrderByPriceAsc(String title);

	/*
	 * 
	 * limiting Query Results
	 *
	 */

	/*
	 * select top ? book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as
	 * PAGE_COU2_0_, book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as
	 * PUBLISH_4_0_, book0_.TITLE as TITLE5_0_ from BOOK book0_ where
	 * book0_.TITLE like ?
	 */
	public List<Book> findTop5ByTitleLike(String title);

	/*
	 * select top ? book0_.bookId as bookId1_0_, book0_.PAGE_COUNT as
	 * PAGE_COU2_0_, book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as
	 * PUBLISH_4_0_, book0_.TITLE as TITLE5_0_ from BOOK book0_ where
	 * book0_.TITLE like ?
	 */
	public List<Book> findFirstByTitleLike(String title);
	
	public List<Book> findByAuthor_FirstName(String fistName);

}
