package Server;

import java.awt.EventQueue;

import javax.swing.*;

import javax.swing.JFrame;
import java.sql.*;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class Login {

	private JFrame frmAttendanceClient;
	Connection conn = null;
	private JTextField tfUser;
	private JPasswordField tfPass;
	String userName;
	String Password;
	static String classes;
	Socket clientSocket;
	static DataInputStream datain;
	static DataOutputStream dataout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAttendanceClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		//this.conn = sqliteConnection.dbConnector();//
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
		clientSocket = new Socket("Omars-MacBook-Pro.local", 1940);
		datain = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
		dataout = new DataOutputStream(clientSocket.getOutputStream()); }
		catch (Exception e) {}
		frmAttendanceClient = new JFrame();
		frmAttendanceClient.getContentPane().setBackground(Color.GRAY);
		frmAttendanceClient.setTitle("Attendance Client");
		frmAttendanceClient.setBounds(100, 100, 450, 300);
		frmAttendanceClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAttendanceClient.getContentPane().setLayout(null);
		
		JLabel labelUser = new JLabel("Enter Username");
		labelUser.setBounds(10, 94, 137, 13);
		frmAttendanceClient.getContentPane().add(labelUser);
		
		JLabel labelPass = new JLabel("Enter password");
		labelPass.setBounds(10, 148, 111, 13);
		frmAttendanceClient.getContentPane().add(labelPass);
		
		tfUser = new JTextField();
		tfUser.setBounds(28, 118, 96, 19);
		frmAttendanceClient.getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		tfPass = new JPasswordField();
		tfPass.setEchoChar('*');
		tfPass.setBounds(28, 168, 96, 19);
		frmAttendanceClient.getContentPane().add(tfPass);
		JButton LoginButton = new JButton("Log in");
		LoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					dataout.writeUTF(tfUser.getText() + "\n" + tfPass.getText());
					dataout.flush();
					classes = datain.readUTF();
					if (classes.equals("server error"))
						JOptionPane.showMessageDialog(null, "Username and/or password are incorrect");
					else {
						frmAttendanceClient.dispose();
						IntructorInfo ii = new IntructorInfo();
						ii.setVisible(true);
					}
						
				}
				
				catch (Exception ae) {
					JOptionPane.showMessageDialog(null, ae);
				}
				
			}
		});
		LoginButton.setBounds(149, 143, 85, 21);
		frmAttendanceClient.getContentPane().add(LoginButton);
		
		
	}
}
