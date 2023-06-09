package send_data_aiml;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField t1;
	private JTextField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 23));
		frame.setBounds(100, 100, 546, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(205, 29, 123, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(55, 127, 102, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(55, 199, 102, 28);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(190, 127, 163, 30);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JTextField();
		p1.setBounds(190, 199, 163, 27);
		frame.getContentPane().add(p1);
		p1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=t1.getText();
				String p=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root", "mrec");
					String q="select count(*) from Signup where username=? and password=?";
					
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1, u);
					ps.setString(2, p);
					ResultSet rs=ps.executeQuery();
					rs.next();
					int c=rs.getInt(1);
					if(c==0)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Inavlid");
						
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "login done");
					}
					
					
					
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(173, 291, 117, 35);
		frame.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

}
