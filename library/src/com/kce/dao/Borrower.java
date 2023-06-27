package com.kce.dao;
import java.util.*;
import java.sql.Connection;

import java.sql.DriverManager;
import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Scanner;

//import com.mysql.jdbc.PreparedStatement;

class Borrower {

		private int id;

		private String name;

		private List<Book> borrowedBooks;

		private Connection connection;

		public Borrower(int id, String name, Connection connection) {

		this.id = id;

		this.name = name;

		this.borrowedBooks = new ArrayList<>();

		this.connection = connection;

		}

		public int getId() {

		return id;

		}

		public String getName() {

		return name;

		}

		public List<Book> getBorrowedBooks() {

		return borrowedBooks;

		}

		public void borrowBook(Book book) throws LibraryException {

		if (book.getDueDate() != null) {

		throw new LibraryException("Book is already borrowed by another borrower.");

		}

		try {

		String query = "UPDATE books SET due_date = CURRENT_TIMESTAMP WHERE id = ?";

		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query)) {

		statement.setInt(1, book.getId());

		statement.executeUpdate();

		}

		borrowedBooks.add(book);

		book.setDueDate(new Date());

		System.out.println("Book borrowed successfully!");

		} catch (SQLException e) {

		throw new LibraryException("Error borrowing book: " + e.getMessage());

		}

		}

		public void returnBook(Book book) throws LibraryException {

		if (!borrowedBooks.contains(book)) {

		throw new LibraryException("Book is not borrowed by this borrower.");

		}

		try {

		String query = "UPDATE books SET due_date = NULL WHERE id = ?";

		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query)) {

		statement.setInt(1, book.getId());

		statement.executeUpdate();

		}

		borrowedBooks.remove(book);

		book.setDueDate(null);

		System.out.println("Book returned successfully!");

		} catch (SQLException e) {

		throw new LibraryException("Error returning book: " + e.getMessage());

		}

		}

		}

		class ReferenceBook extends Book {

		private String topic;

		public ReferenceBook(int id, String title, String author, String topic) {

		super(id, title, author);

		this.topic = topic;

		}

		public String getTopic() {

		return topic;

		}
}
