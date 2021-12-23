package com.samer.httpserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;


public class HttpServerThread extends Thread {

	private int port;
	private String webroot;
	private ServerSocket serverSocket;
	
	public HttpServerThread(int port, String webroot) throws IOException {
		this.port = port;
		this.webroot = webroot;
		this.serverSocket = new ServerSocket(this.port);
	}
	
	@Override
	public void run() {
		int connNum = 0;
		try {
			while(serverSocket.isBound() && !serverSocket.isClosed()) { 
				connNum++;
				System.out.println("Awaiting Connenction " + connNum +"...");
				
				Socket socket = serverSocket.accept();
				System.out.println("Connection " + connNum + " Established");
				
				HttpServerWorker httpServerWorker = new HttpServerWorker(socket);
				httpServerWorker.start();
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {}
			}
		}
	}
}
