package com.samer.httpserver;

import com.samer.attendance.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpServerWorker extends Thread{
	
	private Socket socket;
	
	public HttpServerWorker(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			
			int _byte = inputStream.read();
		
			String html = "<html><head><title> HTTP SERVER </title></head>"
						  + "<body><h1>this is a test"+"</h1></body></html>";
		
		
			final String CLRF = "\n\r";
		
			String response = "HTTP/1.1 200 OK" + CLRF +
							  "Content-Length: " + html.getBytes().length + CLRF +
							   CLRF +
							   html +
							   CLRF + CLRF;

		
			outputStream.write(response.getBytes());
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch(IOException e) {}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch(IOException e) {}
			}
		}
		
	}
	//serverSocket.close();

}

