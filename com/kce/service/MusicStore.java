package com.kce.service;

public class MusicStore {
      private int productid;
      private String genre;
      private String artist;
      private String language;
      private double price;
      private int quantity;
      private String releasedate;
      public MusicStore() {
    	  
      }
	public MusicStore(String artist) {
		super();
		this.artist = artist;
	}
	public MusicStore(int productid, String genre, String artist, String language, double price, int quantity,
			String releasedate) {
		super();
		this.productid = productid;
		this.genre = genre;
		this.artist = artist;
		this.language = language;
		this.price = price;
		this.quantity = quantity;
		this.releasedate = releasedate;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	@Override
	public String toString() {
		return "MusicStore [productid=" + productid + ", genre=" + genre + ", artist=" + artist + ", language="
				+ language + ", price=" + price + ", quantity=" + quantity + ", releasedate=" + releasedate + "]";
	}
	
      
      
}
