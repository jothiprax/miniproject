
	package com.kce.bean;

import java.util.Date;

public class BookDetails {
	private int bookid;
			private String bookname;
		private String author;

		private double rate;

		public BookDetails(int bookid, String bookname, String author, double rate) {
			super();
			this.bookid = bookid;
			this.bookname = bookname;
			this.author = author;
			this.rate = rate;
		}
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		public String toString() {
			return "BookDetails [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", rate=" + rate
					+ "]";
		}
}

	

	