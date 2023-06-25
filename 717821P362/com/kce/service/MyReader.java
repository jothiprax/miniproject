package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyReader {
	/*
	 * this is a reader class that is similar to Scanner class in
	 * java.util.Scanner yet on Scanner a issue is faced with newLine
	 */
	private static InputStreamReader in = null; // inputstreamreader object necessary for buffered reader
	private static BufferedReader buff = null; // bufferedreader is created
	public MyReader() throws IOException {
		in = new InputStreamReader(System.in);
		buff = new BufferedReader(in);
	}
	public int nextInt() throws IOException {
		return Integer.parseInt(buff.readLine()); // read input as line and convert it into integer
	}
	public String nextLine() throws IOException{
		return buff.readLine();
	}
}
