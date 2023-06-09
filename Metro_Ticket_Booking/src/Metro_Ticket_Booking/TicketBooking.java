package Metro_Ticket_Booking;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketBooking {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketBooking window = new TicketBooking();
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
	public TicketBooking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ticket Booking");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(174, 11, 152, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 97, 84, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("From ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 146, 84, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("To");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(35, 206, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ticket");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(35, 255, 61, 24);
		frame.getContentPane().add(lblNewLabel_4);
		
		t1 = new JTextField();
		t1.setBounds(149, 97, 116, 24);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Kphb", "JNTU", "Oosmania", "SR Nagar", "Miyapur", "LB Nagar", "MGBS", "Erragadda", "Irrammanjil", "Ameerpet"}));
		c1.setBounds(149, 149, 116, 22);
		frame.getContentPane().add(c1);
		
		JComboBox c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"Select", "Kphb", "JNTU", "Oosmania", "SR Nagar", "Miyapur", "LB Nagar", "MGBS", "Erragadda", "Irrammanjil", "Ameerpet"}));
		c2.setBounds(149, 204, 116, 22);
		frame.getContentPane().add(c2);
		
		JComboBox c3 = new JComboBox();
		c3.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		c3.setBounds(149, 258, 116, 22);
		frame.getContentPane().add(c3);
		
		JButton b = new JButton("Book");
		b.addActionListener(new ActionListener() {
			private Component btnNewButton;

			public void actionPerformed(ActionEvent e) {
				String n=t1.getText();
				String f=(String) c1.getSelectedItem();
				String t=(String) c2.getSelectedItem();
				String no=(String) c3.getSelectedItem();
				int not=Integer.parseInt(no);
				int bill=not*80;
				if(f.equals(t))
				{
					JOptionPane.showMessageDialog(btnNewButton, "pls check your from and to stations!");
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton,"Name :"+n+ "\n From : " +f+ "\n To :" +t+ "\n Tickets : "+no+ "\n Bill:"+bill);
				}
				
			}
		});
		b.setFont(new Font("Tahoma", Font.BOLD, 17));
		b.setBounds(210, 323, 116, 36);
		frame.getContentPane().add(b);
	}

}
