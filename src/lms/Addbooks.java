package lms;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Addbooks extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField BOOK_ID;
	private JTextField BOOK_NAME;
	private JTextField AUTHOR;
	private JTextField PUBLICATION;
	private JTextField TOTAL_BOOKS;
	private JTextField COURSE;
	private JTextField YEAR;
	private JTextField EDITION;
	private JTextField SEMESTER;
	private JTextField BRANCH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbooks frame = new Addbooks();
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
	public Addbooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD BOOK INTO LIBRARY");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(179, 11, 389, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK ID-");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(27, 77, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		BOOK_ID = new JTextField();
		BOOK_ID.setBounds(133, 76, 170, 20);
		contentPane.add(BOOK_ID);
		BOOK_ID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("BOOK NAME-");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(27, 144, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		BOOK_NAME = new JTextField();
		BOOK_NAME.setBounds(133, 142, 170, 20);
		contentPane.add(BOOK_NAME);
		BOOK_NAME.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("AUTHOR-");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(27, 213, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		AUTHOR = new JTextField();
		AUTHOR.setBounds(133, 211, 170, 20);
		contentPane.add(AUTHOR);
		AUTHOR.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PUBLICATION-");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(27, 274, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		PUBLICATION = new JTextField();
		PUBLICATION.setBounds(133, 271, 170, 20);
		contentPane.add(PUBLICATION);
		PUBLICATION.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("EDITION-");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(27, 333, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		TOTAL_BOOKS = new JTextField();
		TOTAL_BOOKS.setBounds(463, 76, 146, 20);
		contentPane.add(TOTAL_BOOKS);
		TOTAL_BOOKS.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("TOTAL BOOKS-");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(342, 78, 117, 14);
		contentPane.add(lblNewLabel_6);
		
		COURSE = new JTextField();
		COURSE.setBounds(463, 142, 146, 20);
		contentPane.add(COURSE);
		COURSE.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("COURSE-");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(342, 144, 103, 14);
		contentPane.add(lblNewLabel_7);
		
		YEAR = new JTextField();
		YEAR.setBounds(463, 268, 146, 20);
		contentPane.add(YEAR);
		YEAR.setColumns(10);
		
		EDITION = new JTextField();
		EDITION.setBounds(133, 331, 170, 20);
		contentPane.add(EDITION);
		EDITION.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("YEAR-");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_8.setBounds(346, 273, 74, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("SEMESTER-");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9.setBounds(342, 333, 103, 14);
		contentPane.add(lblNewLabel_9);
		
		SEMESTER = new JTextField();
		SEMESTER.setBounds(463, 327, 146, 20);
		contentPane.add(SEMESTER);
		SEMESTER.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "INSERT INTO BOOKS(BOOK_ID,BOOK_NAME,AUTHOR,PUBLICATION,EDITION, TOTAL_BOOKS,COURSE, YEAR,SEMESTER,BRANCH) VALUES(?,?,?,?,?, ?, ?, ?, ?,?)";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, BOOK_ID.getText());
                    st.setString(2, BOOK_NAME.getText());
                    st.setString(3, AUTHOR.getText());
                    st.setString(4, PUBLICATION.getText());
                    st.setString(5, EDITION.getText());
                    st.setString(6, TOTAL_BOOKS.getText());
                    st.setString(7, COURSE.getText());
                    st.setString(8, YEAR.getText());
                    st.setString(9, SEMESTER.getText());
                    st.setString(10,BRANCH.getText());
                   
					
                    int i = st.executeUpdate();
                    if(i>0) {
                    	setVisible(false);
                    	JOptionPane.showMessageDialog(null, " SUCCESSFULLY   "+ BOOK_NAME.getText()  +"   ADDED INTO LIBRARY");	
                    	setVisible(false);
                    	User_Menu frame = new User_Menu ();
    					frame.setVisible(true);
    					
    					
                   	 	
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "somewent wrong! TRY AGAIN.....");	
                    	}
                    
 	            	
    	            
				}
                    
                
				 catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBounds(236, 379, 139, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<<<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				User_Menu frame = new User_Menu();
				frame.setVisible(true);
			}
		});
		

		JButton btnNewButton_5 = new JButton("update or delete the existing  books");
		btnNewButton_5.setBounds(133, 426, 355, 36);
		btnNewButton_5.setBorderPainted(true);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Updatebooks().setVisible(true);
			}
		});
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setBackground(Color.CYAN);
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setForeground(new Color(255, 0, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(431, 379, 110, 28);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("BRANCH-");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_10.setBounds(342, 214, 86, 14);
		contentPane.add(lblNewLabel_10);
		
		BRANCH = new JTextField();
		BRANCH.setBounds(463, 211, 146, 20);
		contentPane.add(BRANCH);
		BRANCH.setColumns(10);
	}
}
