package Server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;

public class ClassInfo extends JFrame {

	private JPanel contentPane;
	private JTable StudentInfoTable;
	static String[] studentInfos;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	static String[] studentIds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassInfo frame = new ClassInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClassInfo() {
		setTitle("Attendance Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Object[] columns = {"ID #","Date","In Time","Out Time","Total Time"};
		studentInfos = IntructorInfo.studentInfo.split("\n");
		Object[][] data = new Object[studentInfos.length][columns.length];
		try {
		for (int i=0;i<studentInfos.length;i++) {
			String[] student = studentInfos[i].split(", ");
			data[i] = student;
		}
		}
		catch ( Exception e) {JOptionPane.showMessageDialog(null, e);}
		
		studentIds = new String[studentInfos.length];
		for(int i =0;i<data.length;i++)
			studentIds[i]= (String) data[i][0];
		
		StudentInfoTable = new JTable(data,columns) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
			}
		};
		JScrollPane scrollPane = new JScrollPane();
		StudentInfoTable.setRowHeight(20);
		scrollPane.setBounds(10, 22, 414, 125);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(StudentInfoTable);
		
		lblNewLabel = new JLabel(IntructorInfo.enteredClass);
		lblNewLabel.setBounds(187, 0, 46, 14);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox(studentIds);
		comboBox.setBounds(206, 158, 30, 22);
		contentPane.add(comboBox);
		
	}
	
	
	
}
