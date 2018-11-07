/**
 * @author Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.spring.jdbc.domain;

import org.springframework.stereotype.Component;

@Component
public class Book {
	private long   id;
	private long   category_id;
	private String isbn;
	private String title;
	private float  price;

	/**
	 * Default Book
	 */
	public Book() {
		this.id = 0l;
		this.category_id = 0l;
		this.isbn = "";
		this.title = "";
		this.price = (float)0.00;
	}

	/**
	 * @param id
	 * @param isbn
	 * @param title
	 * @param price
	 */
	public Book(long id, long category_id, String isbn, String title, float price) {
		this.id = id;
		this.category_id = category_id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	public long getCategory_id() {
		return category_id;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book - Id: " + this.id + ", Category ID: " + this.category_id + ", ISBN: " + this.isbn + ", Title: " + this.title + ", Price: " + this.price;
	}

}
