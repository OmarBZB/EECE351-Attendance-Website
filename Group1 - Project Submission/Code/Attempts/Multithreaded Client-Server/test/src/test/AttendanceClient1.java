package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
public class AttendanceClient1 {
	
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
		DataInputStream datain = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        DataOutputStream dataout = new DataOutputStream(clientSocket.getOutputStream()); 
        
        //Sending username and password to server
    	System.out.print("Please enter your User Name: ");
    	userName = inFromUser.readLine(); 
    	System.out.print("Please enter your User Password: ");
    	Password = inFromUser.readLine(); 
    	dataout.writeUTF(userName + "\n" + Password);
    	dataout.flush();
    	

    	//Prompting the instructor to choose a class
    	String classes = datain.readUTF();
    	System.out.println(classes);
        System.out.print("Please enter a Class: ");
        RequestedClass = inFromUser.readLine();
        dataout.writeUTF(RequestedClass);
        dataout.flush();
        
        //Getting the info of the class chosen
        String infoClass = datain.readUTF();
        System.out.println(infoClass);
        
        boolean conversationActive=true;
        while(conversationActive) {
            System.out.println("1) Change a students records");
            System.out.println("2) Change table order");
            System.out.println("3) exit");
            System.out.print("Please choose an option: ");
            Request = inFromUser.readLine();
            dataout.writeUTF(Request);
            dataout.flush();
            if(Request.contains("1")) {
            	System.out.print("Please enter a Student ID: ");
                S_ID = inFromUser.readLine();
                System.out.print("Please enter the updated in time: ");
                inTime = inFromUser.readLine();
                System.out.print("Please enter the updated out time: ");
                outTime = inFromUser.readLine();
                
                //Writing the id + intime + outtime to server
                dataout.writeUTF('1' + S_ID + inTime + outTime);
                
                //getting the updated table from server
                String updatedTable = datain.readUTF();
                System.out.println(updatedTable);
            }
            //FUNCTION OF CHANGING ORDER NOT IMPLEMENTED YET.!!!!!!!!!!!!!!//
            /**else if(Request.contains("2")) {
                System.out.println("Please choose variable to sort by: ");
                System.out.println("1) Student ID");
                System.out.println("2) In Time");
                System.out.println("3) Out Time");
                System.out.println("4) Total Time");
                Request = inFromUser.readLine();
                dataout.writeUTF('2' + Request);
                inFromServerString = "";
                System.out.println(inFromServerString);
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
            }**/
            else {
            	conversationActive=false;
            	System.out.println("Client terminated");
            }
        }
        
	}
     

}
