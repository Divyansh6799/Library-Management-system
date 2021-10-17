package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTextArea;

public class Aboutus extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField txtMarfexpresssoftwarecom;
	public static JButton btnNewButton;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aboutus frame = new Aboutus();
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
	public Aboutus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 752, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GLOBAL EVOLUTION LIBRARY");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(142, 25, 457, 31);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("PLEASE VISIT OUR WEBSITE FOR FURTHOR INFORMATION......");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(10, 407, 428, 31);
		contentPane.add(lblNewLabel_1);
		
		txtMarfexpresssoftwarecom = new JTextField();
		txtMarfexpresssoftwarecom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtMarfexpresssoftwarecom.setBackground(Color.PINK);
		txtMarfexpresssoftwarecom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		txtMarfexpresssoftwarecom.setText("DT-SOFTWARECOMPANY.COM");
		txtMarfexpresssoftwarecom.setEditable(false);
		txtMarfexpresssoftwarecom.setBounds(10, 449, 387, 31);
		contentPane.add(txtMarfexpresssoftwarecom);
		txtMarfexpresssoftwarecom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("developed by----");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_2.setBounds(435, 378, 159, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mr. DIVYANSH TRIVEDI\r\n(coding expert)\r\n");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(435, 404, 278, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mr. ADARSH BAJPAI\r\n(database administrator)");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(435, 453, 278, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("back");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\back.png"));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				if(User_Menu.getFrames().equals(this)) {
			
					User_Menu m = new User_Menu();
				m.setVisible(true);
			}else if(User_Menu.getFrames().equals(this)) {
				User_Menu m1 = new User_Menu();
				m1.setVisible(true);
			}
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(10, 26, 96, 30);
		contentPane.add(lblNewLabel_5);
		
		JTextArea txtrGlobalEvolutionLibrarygel = new JTextArea();
		txtrGlobalEvolutionLibrarygel.setFont(new Font("Jokerman", Font.BOLD | Font.ITALIC, 14));
		txtrGlobalEvolutionLibrarygel.setForeground(Color.RED);
		txtrGlobalEvolutionLibrarygel.setText("GLOBAL  EVOLUTION  LIBRARY(GEL) IS A   AUTOMATED  LIBRARY SOFTWARE .\r\nTHIS IS APPLICABLE FOR ALL COLLEGES, UNIVERSITIES AND HIGHER EDUCATION CAMPUS.\r\nIT CONTAINS MORE FACILITIES LIKE ONLINE BOOKS,MESSAGES AND CONTACT TO ADMIN.\r\nIT IS USED TO SIMPLIFY THE TASK OF A LIBRARY WHICHS OPERATE IN COLLEGES.\r\nIT IS VERY FAST AND COMFORTABLE SOFTWARE TO PROCESS IN EVERY PLATEFORM.\r\nIT IS ALSO MANAGE BIG DATABASE FOR CONTAINING LARGE AMOUNT OF BOOKS AND \r\nSTUDENTS.THANK YOU FOR USING THIS .");
		txtrGlobalEvolutionLibrarygel.setEditable(false);
		txtrGlobalEvolutionLibrarygel.setLineWrap(true);
		txtrGlobalEvolutionLibrarygel.setWrapStyleWord(true);
		txtrGlobalEvolutionLibrarygel.setBackground(new Color(0,0,0,200));
		txtrGlobalEvolutionLibrarygel.setBounds(60, 108, 629, 243);
		contentPane.add(txtrGlobalEvolutionLibrarygel);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\welcome.jpg"));
		lblNewLabel_6.setBounds(0, 0, 736, 496);
		contentPane.add(lblNewLabel_6);
		
		
		
		
		
	}
}
