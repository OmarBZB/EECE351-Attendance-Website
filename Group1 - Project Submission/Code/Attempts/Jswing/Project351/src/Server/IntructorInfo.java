package Server;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IntructorInfo extends JFrame {

	private JPanel contentPane;
	static String studentInfo;
	static String enteredClass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntructorInfo frame = new IntructorInfo();
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
	public IntructorInfo() {
		setTitle("Attendance Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbClass = new JLabel("Enter Class Name");
		lbClass.setBounds(161, 43, 97, 14);
		contentPane.add(lbClass);
		String [] arrClasses = Login.classes.split(",");
		JComboBox requestBox = new JComboBox(arrClasses);
		requestBox.setSelectedIndex(-1);
		requestBox.setToolTipText("Enter Request\r\n");
		requestBox.setMaximumRowCount(3);
		requestBox.setBounds(114, 80, 205, 22);
		contentPane.add(requestBox);
		
		JButton classButton = new JButton("Next");
		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					enteredClass = (String) requestBox.getSelectedItem();
					Login.dataout.writeUTF(enteredClass);
					Login.dataout.flush();
					studentInfo = Login.datain.readUTF();
					dispose();
					ClassInfo ci = new ClassInfo();
					ci.setVisible(true);
					
					}
					catch (Exception ex) {}
				}
				
			
		});
		classButton.setBounds(169, 195, 89, 23);
		contentPane.add(classButton);
		
		
	}
}
