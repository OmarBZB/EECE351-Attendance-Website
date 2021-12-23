package com.samer.httpserver;

import java.io.IOException;


public class HttpServer {
	
	private static int port = 8080;
	private static String webroot = "";
	
	public static void main(String[] args) {
		
		System.out.println("Starting HTTP Server...");
		
		try {
			HttpServerThread httpServerThread = new HttpServerThread(port, webroot);
			httpServerThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
