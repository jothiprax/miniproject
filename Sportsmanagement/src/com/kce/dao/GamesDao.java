package com.kce.dao;

public class GamesDao {
	
	private int serial_no;

		private String gamename;


		public GamesDao() {

		}

		public GamesDao(int serial_no,String gamename) {

		super();

		this.serial_no= serial_no;

		this.gamename = gamename;


		}

		public int getserial_no() {

		return serial_no;

		}

		public void setserial_no(int serial_no) {

		this.serial_no = serial_no;

		}

		public String getgamename() {

		return gamename;

		}

		public void setgamename(String gamename) {

		this.gamename = gamename;

		}

		public int getSerial_no() {
			return serial_no;
		}

		public void setSerial_no(int serial_no) {
			this.serial_no= serial_no;
		}


		}
