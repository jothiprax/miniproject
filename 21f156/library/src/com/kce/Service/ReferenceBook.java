package com.kce.Service;
import java.util.*;
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

		class Novel extends Book {

		private String genre;

		public Novel(int id, String title, String author, String genre) {

		super(id, title, author);

		this.genre = genre;

		}

		public String getGenre() {

		return genre;

		}

		}
