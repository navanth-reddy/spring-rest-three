package com;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.BookEntity;
import com.repository.BookRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MainApp {

	BookRepository repo;

	public MainApp(BookRepository repo) {
		this.repo = repo;
	}

	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
	}

	@PostConstruct
	public void doSomething() {

//		List<BookEntity> list = (List<BookEntity>) repo.findAll();
//		list.forEach((b) -> System.out.println(b));

//		Optional<BookEntity> optBook = repo.findById(11);
//		if (optBook.isPresent())
//			System.out.println(optBook.get());
//		else
//			System.out.println("no such book found");
		/*
		 * String title="Angular in action";
		 * 
		 * Optional<BookEntity> entity=repo.findByTitle(title);
		 * 
		 * 
		 * if(entity.isPresent()) System.out.println(entity.get()); else
		 * System.out.println("no such book found");
		 * 
		 * double price=901.0;
		 * 
		 * List<BookEntity> list=repo.findByPriceLessThan(price);
		 * list.forEach((b)->System.out.println(b));
		 */

		/*List<BookEntity> list = repo.methodOne();

		list.forEach(System.out::println);*/

		/*List<BookEntity> list1 = repo.methodTwo();

		list1.forEach(System.out::println);*/
		
		/*List<BookEntity> list2 = repo.methodNativeQuery();

		list2.forEach(System.out::println);*/
		
		
		List<BookEntity> list2 = repo.methodFour("Spring");
		list2.forEach(System.out::println);
		
		/*List<BookEntity> list3 = repo.methodSix(600,"Spring");
		list3.forEach(System.out::println);*/
		
		List<BookEntity> list3 = repo.methodSeven("Spring",600);
		list3.forEach(System.out::println);
	}

}