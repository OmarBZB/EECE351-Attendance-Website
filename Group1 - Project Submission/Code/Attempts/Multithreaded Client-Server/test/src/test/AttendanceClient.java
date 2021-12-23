package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class AttendanceClient {
	
	public static void main(String argv[]) throws Exception{
		String userName;
		String Password;
		String Request;
		String RequestedClass;
		String S_ID; 
		String inTime; 
		String outTime;
		String inFromServerString="";
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

		Socket clientSocket = new Socket("Omars-MacBook-Pro.local", 1938); 

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
        
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        //Sending username and password to server
    	System.out.print("Please enter your User Name: ");
    	userName = inFromUser.readLine(); 
    	System.out.print("Please enter your User Password: ");
    	Password = inFromUser.readLine(); 
    	outToServer.writeBytes(userName + "\n" + Password);
    	

    	//Prompting the instructor to choose a class
    	String classes = inFromServer.readLine();
    	System.out.println(classes);
        System.out.print("Please enter a Class: ");
        RequestedClass = inFromUser.readLine();
        outToServer.writeBytes(RequestedClass);
        
        //Getting the info of the class chosen
        try
        {
          int linesPerRead = 2;
          for (int i = 0; i < linesPerRead; ++i)
          {
        	  inFromServerString+=inFromServer.readLine();
            // placing newlines back because readLine() removes them
        	  inFromServerString+='\n';
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        System.out.println(inFromServerString);
        
        boolean conversationActive=true;
        while(conversationActive) {
            System.out.println("1) Change a students records");
            System.out.println("2) Change table order");
            System.out.println("3) exit");
            System.out.print("Please choose an option: ");
            Request = inFromUser.readLine();
            if(Request.contains("1")) {
            	System.out.print("Please enter a Student ID: ");
                S_ID = inFromUser.readLine();
                System.out.print("Please enter the updated in time: ");
                inTime = inFromUser.readLine();
                System.out.print("Please enter the updated out time: ");
                outTime = inFromUser.readLine();
                
                outToServer.writeBytes('1' + S_ID + inTime + outTime);
                
                inFromServerString = "";
                try
                {
                  int linesPerRead = 4;
                  for (int i = 0; i < linesPerRead; ++i)
                  {
                	  inFromServerString+=inFromServer.readLine();
                    // placing newlines back because readLine() removes them
                	  inFromServerString+='\n';
                  }
                }
                catch (Exception e)
                {
                  e.printStackTrace();
                }
                System.out.println(inFromServerString);
            }
            else if(Request.contains("2")) {
                System.out.println("1) Student ID");
                System.out.println("2) In Time");
                System.out.println("3) Out Time");
                System.out.println("4) Total Time");
                System.out.println("Please choose variable to sort by: ");
                Request = inFromUser.readLine();
                if(Request.contains("1")) {
                	outToServer.writeBytes("2S_ID");
                }
                if(Request.contains("2")) {
                	outToServer.writeBytes("2in_time");
                }
                if(Request.contains("3")) {
                	outToServer.writeBytes("2out_time");
                }
                if(Request.contains("4")) {
                	outToServer.writeBytes("2total_time");
                }
                inFromServerString = "";
                try
                {
                  int linesPerRead = 4;
                  for (int i = 0; i < linesPerRead; ++i)
                  {
                	  inFromServerString+=inFromServer.readLine();
                    // placing newlines back because readLine() removes them
                	  inFromServerString+='\n';
                  }
                }
                catch (Exception e)
                {
                  e.printStackTrace();
                }
                System.out.println(inFromServerString);
            }
            else {
                outToServer.writeBytes("exit");
            	conversationActive=false;
            }
        }
        
	}
     

}
