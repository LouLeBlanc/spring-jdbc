/*
 * @author Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.spring.jdbc.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Louis LeBlanc
 * Category component
 *
 */
@Component
public class Category {
	private long			id;
	private String			name;
	private Set<Book>		booksSet;
	private List<Book>		booksList;
	private Map<String, Book>	booksMap;

	/**
	 * Default Constructor
	 */
	public Category() {
		this.id = (long)0;
		this.name = "";
		this.booksSet = new HashSet<Book>();
		this.booksList = new ArrayList<Book>();
		this.booksMap = new HashMap<String, Book>();
	}

	/**
	 * @param id
	 * @param name
	 * @param booksSet
	 * @param booksList
	 * @param booksMap
	 */
	public Category(long id, String name, Set<Book> booksSet, List<Book> booksList, Map<String, Book> booksMap) {
		this.id = id;
		this.name = name;
		this.booksSet = booksSet;
		this.booksList = booksList;
		this.booksMap = booksMap;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the booksSet
	 */
	public Set<Book> getBooksSet() {
		return booksSet;
	}

	/**
	 * @param booksSet the booksSet to set
	 */
	public void setBooksSet(Set<Book> booksSet) {
		this.booksSet = booksSet;
	}

	/**
	 * @return the booksList
	 */
	public List<Book> getBooksList() {
		return booksList;
	}

	/**
	 * @param booksList the booksList to set
	 */
	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

	/**
	 * @return the booksMap
	 */
	public Map<String, Book> getBooksMap() {
		return booksMap;
	}

	/**
	 * @param booksMap the booksMap to set
	 */
	public void setBooksMap(Map<String, Book> booksMap) {
		this.booksMap = booksMap;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder collectionString = new StringBuilder();

		if (!this.booksSet.isEmpty()) {

			collectionString.append("===================== Books Set Output Start =====================\n");
			collectionString.append("Category -- Id: " + this.id + ", Name: " + this.name + ", Books Set: [");
			this.booksSet.forEach((book) -> {
				collectionString.append(book.toString());
				collectionString.append(", ");
			});
			collectionString.delete(collectionString.length() - 3, collectionString.length());
			collectionString.append("]\n");
			collectionString.append("===================== Books Set Output End =====================");

		} else if (!this.booksList.isEmpty()) {

			collectionString.append("===================== Books List Output Start =====================\n");
			collectionString.append("Category -- Id: " + this.id + ", Name: " + this.name + ", Books List: [");
			this.booksList.forEach((book) -> {
				collectionString.append(book.toString());
				collectionString.append(", ");
			});
			collectionString.delete(collectionString.length() - 3, collectionString.length());
			collectionString.append("]\n");
			collectionString.append("===================== Books List Output End =====================");

		} else if (!this.booksMap.isEmpty()) {

			collectionString.append("===================== Books Map Output Start =====================\n");
			collectionString.append("Category -- Id: " + this.id + ", Name: " + this.name + ", Books Map: <");
			this.booksMap.forEach((s, book) -> {
				collectionString.append("Key" + s + "=");
				collectionString.append(book.toString());
				collectionString.append(", ");
			});
			collectionString.delete(collectionString.length() - 3, collectionString.length());
			collectionString.append(">\n");
			collectionString.append("===================== Books Map Output End =====================");

		} else {
			collectionString.append("Category -- Id: " + this.id + ", Name: " + this.name);
		}

		return collectionString.toString();
	}

}
