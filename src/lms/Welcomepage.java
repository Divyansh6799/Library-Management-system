package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Welcomepage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcomepage frame = new Welcomepage();
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
	public Welcomepage() {
	
		setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 12));
		setTitle("WELCOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 583, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("USER  LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login frame = new Login();
				frame.setVisible(true);
				Login.lblNewLabel_7.setText("USER LOGIN");
				Login.lblNewLabel_3.setVisible(false); 
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		btnNewButton.setBounds(178, 309, 242, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("-----OR-----");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(237, 338, 131, 31);
		contentPane.add(lblNewLabel_1);
		 
		JButton btnNewButton_1 = new JButton("ADMIN  LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login frame = new Login();
				frame.setVisible(true);
				Login.lblNewLabel_7.setText("ADMIN LOGIN");
				Login.lblNewLabel_31.setVisible(false);
				Login. btnNewButton_1.setVisible(false);
				Login.btnNewButton_2.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		btnNewButton_1.setBounds(178, 368, 242, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME ");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel_2.setBounds(193, 11, 213, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\libraryWEL.png"));
		lblNewLabel_4.setBounds(178, 40, 253, 258);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\welcome (2).jpg"));
		lblNewLabel_3.setBounds(0, 0, 567, 421);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
