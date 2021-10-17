package lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Updatebooks extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -328345170908281515L;
	private JPanel contentPane;
	private JTextField BOOK_NAME;
	private JTextField AUTHOR;
	private JTextField PUBLICATION;
	private JTextField TOTAL_BOOKS;
	private JTextField COURSE;
	private JTextField YEAR;
	private JTextField EDITION;
	private JTextField SEMESTER;
	private JTextField BRANCH;
	private JComboBox<String> comboBox_book;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatebooks frame = new Updatebooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void combo() {
		comboBox_book = new JComboBox<String>();
		comboBox_book.setBackground(Color.WHITE);
		comboBox_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("SELECT  BOOK ID  FOR  UPDATE BOOKS..".equals(comboBox_book.getSelectedItem())) {
						JOptionPane.showInternalMessageDialog(null, "INVALID OPTION....");
				}else {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT * FROM BOOKS WHERE BOOK_ID=?";
		    		PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, (String) comboBox_book.getSelectedItem());
    	            ResultSet rs  = st.executeQuery();
                    if(rs.next()) {
                    	String s=rs.getString(1);
                    	String s1=rs.getString(2);
                    	String s2=rs.getString(3);
                    	String s3=rs.getString(4);
                    	String s4=rs.getString(5);
                    	String s5=rs.getString(6);
                    	String s6=rs.getString(7);
                    	String s7=rs.getString(8);
                    	String s8=rs.getString(9);
                    	String s9=rs.getString(10);
                    
                    	
                    	
                    	comboBox_book.setSelectedItem(s);
                    	BOOK_NAME.setText(s1);
                    	AUTHOR.setText(s2);
                    	PUBLICATION.setText(s3);
                    	EDITION.setText(s4);
                    	TOTAL_BOOKS.setText(s5);
                    	COURSE.setText(s6);
                    	YEAR.setText(s7);
                    	SEMESTER.setText(s8);
                    	BRANCH.setText(s9);
                    	
                    
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "ENTERIES ARE NOT MATCHED WITH DATABASE !"
                    				+ "PLEASE ENTER CORRECT DETAILS");	
                    	}
				}catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}

			}
		});
		comboBox_book.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_book.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT  BOOK ID  FOR  UPDATE BOOKS.."}));
				try {
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT BOOK_ID FROM BOOKS";
		    		PreparedStatement st = con.prepareStatement(sql);
		    		ResultSet rs  = st.executeQuery();
		            while(rs.next()) {
		            	
		            	comboBox_book.addItem(rs.getString("BOOK_ID"));
		            	
		            }
		        }catch(Exception e1) {
					e1.printStackTrace();
				}
		comboBox_book.setBounds(130, 58, 354, 28);
		contentPane.add(comboBox_book);
	}

	/**
	 * Create the frame.
	 */
	public Updatebooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE  BOOK DETAILS INTO LIBRARY");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(133, 11, 460, 36);
		contentPane.add(lblNewLabel);
		
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
		TOTAL_BOOKS.setBounds(463, 123, 146, 20);
		contentPane.add(TOTAL_BOOKS);
		TOTAL_BOOKS.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("TOTAL BOOKS-");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(342, 125, 117, 14);
		contentPane.add(lblNewLabel_6);
		
		COURSE = new JTextField();
		COURSE.setBounds(463, 174, 146, 20);
		contentPane.add(COURSE);
		COURSE.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("COURSE-");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(342, 176, 103, 14);
		contentPane.add(lblNewLabel_7);
		
		YEAR = new JTextField();
		YEAR.setBounds(463, 227, 146, 20);
		contentPane.add(YEAR);
		YEAR.setColumns(10);
		
		EDITION = new JTextField();
		EDITION.setBounds(133, 331, 170, 20);
		contentPane.add(EDITION);
		EDITION.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("YEAR-");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_8.setBounds(342, 229, 74, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("SEMESTER-");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9.setBounds(342, 274, 103, 36);
		contentPane.add(lblNewLabel_9);
		
		SEMESTER = new JTextField();
		SEMESTER.setBounds(463, 283, 146, 20);
		contentPane.add(SEMESTER);
		SEMESTER.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "UPDATE BOOKS SET BOOK_NAME=?,AUTHOR=?,PUBLICATION=?,EDITION=?, TOTAL_BOOKS=?,COURSE=?, YEAR=?,SEMESTER=?,BRANCH=?"
		    				+ "WHERE BOOK_ID=?";
    	            PreparedStatement st = con.prepareStatement(sql);
    	           
                    st.setString(1, BOOK_NAME.getText());
                    st.setString(2, AUTHOR.getText());
                    st.setString(3, PUBLICATION.getText());
                    st.setString(4, EDITION.getText());
                    st.setString(5, TOTAL_BOOKS.getText());
                    st.setString(6, COURSE.getText());
                    st.setString(7, YEAR.getText());
                    st.setString(8, SEMESTER.getText());
                    st.setString(9, BRANCH.getText());
                    st.setString(10,  (String) comboBox_book.getSelectedItem());
					
                    int i = st.executeUpdate();
                    if(i>0) {
                    	setVisible(false);
                    	JOptionPane.showMessageDialog(null, " SUCCESSFULLY   UPDATE   "+ BOOK_NAME.getText()  +"   INTO  LIBRARY");	
                    	setVisible(false);
                    	User_Menu frame = new User_Menu ();
    					frame.setVisible(true);
                    }else {
                    		JOptionPane.showMessageDialog(null, "somewent wrong! TRY AGAIN.....");	
                    	}
				}catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBounds(103, 406, 165, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				User_Menu frame = new User_Menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(0, 17, 86, 28);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("BRANCH-");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_10.setBounds(342, 334, 97, 14);
		contentPane.add(lblNewLabel_10);
		
		BRANCH = new JTextField();
		BRANCH.setBounds(463, 331, 146, 20);
		contentPane.add(BRANCH);
		BRANCH.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("DELETE BOOK");
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "DELETE FROM BOOKS WHERE BOOK_ID=?";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, (String) comboBox_book.getSelectedItem());
                    int i = st.executeUpdate();
                    if(i>0) {
                    	setVisible(false);
                    	JOptionPane.showMessageDialog(null, " SUCCESSFULLY   DELETE    "+ BOOK_NAME.getText()  +"   FROM  LIBRARY");	
                    	setVisible(false);
                    	User_Menu frame = new User_Menu ();
    					frame.setVisible(true);
    			   }else {
                    		JOptionPane.showMessageDialog(null, "somewent wrong! TRY AGAIN.....");	
                    	}
				}catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			

			}
		});
		btnNewButton_3.setForeground(Color.MAGENTA);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_3.setBounds(319, 408, 165, 24);
		contentPane.add(btnNewButton_3);
		
		combo();
	}
}
