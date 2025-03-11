package com.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity,Integer>{
 
	//Interface for generic CRUD operations on a repository
	//for a specific type.
	Optional<BookEntity> findByTitle(String title);

	List<BookEntity> findByPriceLessThan(double price);
	
	Optional<BookEntity> findByTitleIgnoreCase(String title);
	
	List<BookEntity> findAllByOrderBySubjectDesc();
	
	@Query("FROM BookEntity")
	List<BookEntity> methodOne();
	
	@Query("FROM BookEntity b where b.title like 'A%' and b.price>200.0")
	List<BookEntity> methodTwo();
	
	@Query(value="select * from book where price<300",nativeQuery=true)
	List<BookEntity> methodNativeQuery();

	//named parameters
	@Query("FROM BookEntity b WHERE b.title=:bookName")
	List<BookEntity> methodFour(@Param("bookName") String bookName);
	
	
	//positional notation
	@Query("FROM BookEntity b WHERE b.subject=?1")
	List<BookEntity> methodFive(String subject);
	
	//this should either match or not match the order of params
	@Query("FROM BookEntity b WHERE b.title=:bookName and b.price<:price")
	List<BookEntity> methodSix(@Param("price") double price ,@Param("bookName") String bookName);
	
	//this shiuld match the order of params
	@Query("FROM BookEntity b WHERE b.subject=?1 and b.price=?2")
	List<BookEntity> methodSeven(String subject,double price);
}