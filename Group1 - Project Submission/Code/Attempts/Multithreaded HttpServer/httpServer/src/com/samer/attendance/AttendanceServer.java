package com.samer.attendance;

import java.io.BufferedInputStream;
import java.nio.ByteBuffer;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.sql.*; 
public class AttendanceServer {
    
	private int port = 1938;
    
	private ServerSocket serverSocket;
    
	static final String dbURL1 = "jdbc:mysql://localhost:3306/351_InstrcutorRecords";
    static final String dbURL2 = "jdbc:mysql://localhost:3306/351_ClassAttendanceInfo";
  
    //Constructor: Loads java driver for the MySQL DB Server
    public AttendanceServer() throws ClassNotFoundException {Class.forName("com.mysql.cj.jdbc.Driver");}
    
    
    public void acceptConnections() {
    	try {
    		serverSocket = new ServerSocket(port);
	    }
	    catch (IOException e) {
		    System.err.println("ServerSocket instantiation failure");
		    e.printStackTrace();
		    System.exit(0);
	    }

    	//Assigning a socket for each client
    	while (true) {
    		try {
    		    //wait for a TCP handshake initialization (arrival of a "SYN" packet)
    			Socket newConnection = serverSocket.accept();
    			//System.out.println("accepted connection");
    			ServerThread st = new ServerThread(newConnection);
    			new Thread(st).start();
	    	}
    		catch (IOException ioe) {
    			System.err.println("server accept failed");
    		}
    	}
    }
    
    public static void main(String args[]) {
    	AttendanceServer server = null;
    	try {
    		server = new AttendanceServer();
    	}
    	catch (ClassNotFoundException e) {
    		System.out.println("unable to load JDBC driver");
    		e.printStackTrace();
    		System.exit(1);
    	}
    	//The server starts listening
    	server.acceptConnections();
    }

    
    //Internal class
    class ServerThread implements Runnable { 	//Every instance of a ServerThread will handle one client (TCP connection)

    private Socket socket;
    private DataInputStream datain;
    private DataOutputStream dataout;

    public ServerThread(Socket socket) {this.socket = socket;}

    public void run() {
    	try {
    		//Input and output streams, obtained from the member socket object 
    		datain = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    		dataout = new DataOutputStream(new BufferedOutputStream (socket.getOutputStream()));
    		
    	} catch (IOException e) {return;}

    	boolean conversationActive = true;
      
    	String UserName = null;
    	String Password = null;
    	String current = null;
    	String current2 = null;
    	String current3 = null;
    	String request = null;


    	try {
		    //Reading username and password from the client
    		current = datain.readUTF();
	        int i1 = current.indexOf("\n");
	        UserName = current.substring(0, i1);
	        Password = current.substring(i1+1);
	        String Classes = getClasses(UserName, Password);
	
	        //Writing the classes found to the client (351)
	        dataout.writeUTF(Classes);
	        dataout.flush();
    	    
	        //Reading class chosen by the client
    		current2 = datain.readUTF();
    		String table = OpenClass(current2);
    		
    		//Writing class information to the client
    		dataout.writeUTF(table);
   	        dataout.flush();
   	        
   	        //Getting the request of what the client wants to do
   	        request = datain.readUTF();
   	        while(conversationActive) {
   	        	current3 = datain.readUTF();
	    	    if(request.contains("3")){
   	   	        	conversationActive=false;
   	   	        	break;
   	   	        }
   	   	        	//Reading a student ID, new In_Time, and new Out_Time from the client
   	    	        
   	    	        //System.out.println(current3);
   	    	        String S_ID, inTime, outTime;
   	    	        S_ID = current3.substring(1,10);
   	 
   	    	        //System.out.println(S_ID);
   	    	        inTime = current3.substring(10,18);

   	    	        //System.out.println(inTime);
   	    	        outTime = current3.substring(18);
  
   	    	        //System.out.println(outTime);
   	    	        
   	    	        // Updating DB with new In_Time, Out_Time, and Total_Time
   	    	        String table2 = changeTime(S_ID, inTime, outTime, current2);
 
   	    	        // Writing Updated class information to the client
   	    	        dataout.writeUTF(table2);
   	    	        dataout.flush();
   	   	       
   	        }
   	        System.out.println("closing socket");
	       	datain.close();
	       	dataout.close();
	       	socket.close();  
   	        
    	} catch (IOException e) {}
    }

	//This function is for communicating with the database server
	//using API provided by the JDBC driver loaded at the top
    private String getClasses(String username, String password) {
        String result = "None available";
        Connection conn = null;
        try {
        	conn = DriverManager.getConnection(dbURL1,"root","Sah82@MySQL");
        	Statement stmt = conn.createStatement();
        
        	String query0 = "SELECT ID FROM InstructorCredentials WHERE username="
        				+ "'" + username + "'" + " and password=" + "'" + password + "'";
        	ResultSet rs0 = stmt.executeQuery(query0);
        	rs0.next();
        	String id = rs0.getString(1);
        
	        String query = "SELECT classnumber " + "FROM Class " + "WHERE ID= " + "'" + id + "'";
	        //System.out.println("query = " + query);
	        ResultSet rs = stmt.executeQuery(query);
	        StringBuffer sb = new StringBuffer();
	        rs.next();
	        sb.append(rs.getString(1));
	        while (rs.next()) {
	        	sb.append(", ");
	        	sb.append(rs.getString(1));
	        }
	        result = sb.toString();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            result = "server error";
        }
        finally {
        	if (conn != null) {
    		    try {
    			    conn.close();
    		    } catch (SQLException e) {}
        	}
      	}
        return result;
    }
  

    private String OpenClass(String classNum) {
        String result = "None available";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL2,"root","Sah82@MySQL");
            Statement stmt = conn.createStatement();
            String query = "SELECT * " + "FROM StudentsAttendance " + " ORDER BY S_ID";
            //System.out.println("query = " + query);
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int nbCols = rsmd.getColumnCount();
            StringBuffer sb = new StringBuffer();
            while (rs.next()) {
        	    sb.append(rs.getString(1));
        	    for(int i=2;i<=nbCols;i++) {
                    sb.append(", ");
                    sb.append(rs.getString(i));
        	    }
                sb.append("\n");
            }
            result = sb.toString();
        	} catch (SQLException e) {
        		System.out.println(e.getMessage());
        		result = "server error";
        	}
        finally {
            if (conn != null) {
                try {
          		    conn.close();
          		} catch (SQLException e) {}
          	}
        }
        return result;
    }
  
 
    
    private String changeTime(String S_ID, String inTime, String outTime, String classnumber) {
    	Connection conn = null;
        String result;
        String totalTime = computeTotalTime(inTime, outTime);
        Time totalTime2=Time.valueOf(totalTime);

    	try {
    		conn = DriverManager.getConnection(dbURL2,"root","Sah82@MySQL");
    		Statement stmt = conn.createStatement();
    		String query =  "Update ignore StudentsAttendance" +
    						" Set In_Time=" + "'" + inTime + "'" +", out_Time=" + "'" + outTime + "'" + ", Total_Time=" + "'" + totalTime2 + "'" +
    						" WHERE S_ID=" + "'" + S_ID + "' ";
            //System.out.println("query = " + query);
            stmt.executeUpdate(query);
            
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
            result = "server error";
          }
    	finally {
    		if (conn != null) {
    			try {
    				conn.close();
    			} catch (SQLException e) {}
            }
    	}
    	result=OpenClass(classnumber);
    	//System.out.print(result);
    	return result;
    }
    
    
    
    private String changeInTime(String S_ID, String inTime, String classnumber) {
    	Connection conn = null;
    	String outTime = "";
    	try {
    		conn = DriverManager.getConnection(dbURL2,"root","Sah82@MySQL");
    		Statement stmt = conn.createStatement();
    		String query =  "SELECT outTime FROM StudentsAttendance WHERE S_ID = "+"'"+S_ID+"'";
            stmt.executeQuery(query);
            ResultSet RSoutTime = stmt.executeQuery(query);
            outTime = RSoutTime.getString(1);
    	} 
    	catch (SQLException e) {
    		System.out.println(e); }
    	finally {
            if (conn != null) {
                try {
          		    conn.close();
          		} catch (SQLException e) {}
          	}
        }
    	return changeTime(S_ID, inTime, outTime, classnumber);
    }
    
    
    private String changeOutTime(String S_ID, String outTime, String classnumber) {
    	Connection conn = null;
    	String inTime = "";
    	try {
    		conn = DriverManager.getConnection(dbURL2,"root","Sah82@MySQL");
    		Statement stmt = conn.createStatement();
    		String query =  "SELECT inTime FROM StudentsAttendance WHERE S_ID = "+"'"+S_ID+"'";
            stmt.executeQuery(query);
            ResultSet RSinTime = stmt.executeQuery(query);
            outTime = RSinTime.getString(1);
    	} 
    	catch (SQLException e) {
    		System.out.println(e); }
    	finally {
            if (conn != null) {
                try {
          		    conn.close();
          		} catch (SQLException e) {}
          	}
        }
    	return changeTime(S_ID, inTime, outTime, classnumber);  
    }
    
    private String computeTotalTime(String inTime, String outTime) {
    	String ShourIn = inTime.substring(0, 2);
   	 	String ShourOut = outTime.substring(0, 2);
	   	String SminIn = inTime.substring(3, 5);
	   	String SminOut = outTime.substring(3, 5);
	   	String SsecIn = inTime.substring(6, 8);
	   	String SsecOut = outTime.substring(6, 8);
	   	int hourIn =Integer.valueOf(ShourIn);
	   	int hourOut =Integer.valueOf(ShourOut);
	   	int minIn = Integer.valueOf(SminIn);
	   	int minOut = Integer.valueOf(SminOut);
	   	int secIn = Integer.valueOf(SsecIn);
	   	int secOut = Integer.valueOf(SsecOut);
	   	int InTimeSeconds = (hourIn * 3600) + (minIn * 60) + secIn;
	    int OutTimeSeconds = (hourOut * 3600) + (minOut * 60) + secOut;
	    int TimeSeconds = OutTimeSeconds - InTimeSeconds;
	  	int TotalTimeHours = (TimeSeconds/3600);
	  	int TotalTimeMins = ((TimeSeconds%3600)/60)/1;
	  	int TotalTimeSecs = ((TimeSeconds%3600)%60);
	   	String TotalTime = TotalTimeHours+":"+TotalTimeMins+":"+TotalTimeSecs;
	   	return TotalTime;
    	}
  }
}
