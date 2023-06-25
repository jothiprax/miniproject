package libmanage;

import java.sql.Date;

public class Book {
	private int id;

	private String title;

	private String author;

	private Date dueDate;

	public Book(int id, String title, String author) {

	this.id = id;

	this.title = title;

	this.author = author;

	this.dueDate = null;

	}

	public int getId() {

	return id;

	}

	public String getTitle() {

	return title;

	}

	public String getAuthor() {

	return author;

	}

	public Date getDueDate() {

	return dueDate;

	}

	public void setDueDate(java.util.Date date) {

	this.dueDate = (Date) date;

	}

	}

