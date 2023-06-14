package com.kce.bean;

public class LibraryManager {
	private int BookId;
	private String BookName;
	private String Author;
	private String Genre;
	public LibraryManager(int bookId, String bookName, String author, String genre) {
		super();
		BookId = bookId;
		BookName = bookName;
		Author = author;
		Genre = genre;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	@Override
	public String toString() {
		return "LibraryManager [BookId=" + BookId + ", BookName=" + BookName + ", Author=" + Author + ", Genre=" + Genre
				+ "]";
	}


}
