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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Updatestudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField ROLL_NUMBER;
	private JTextField FIRST_NAME;
	private JTextField LAST_NAME;
	private JTextField GENDER;
	private JTextField COURSE;
	private JTextField BRANCH;
	private JTextField YEAR;
	private JTextField SEMESTER;
	private JTextField CONTACT;
	private JTextField MAIL_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatestudent frame = new Updatestudent();
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
	public Updatestudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE   STUDENT   DETAILS");
		lblNewLabel.setBounds(195, 11, 291, 21);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ROLL NUMBER-");
		lblNewLabel_1.setBounds(41, 65, 166, 14);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_1);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.setBounds(195, 63, 118, 20);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBounds(358, 52, 178, 38);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\divya\\OneDrive\\Pictures\\search.png"));
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT * FROM STUDENT WHERE ROLL_NUMBER=?";
		    		
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, ROLL_NUMBER.getText());
    	        
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
                    	
                    	
                    	ROLL_NUMBER.setText(s);
                    	FIRST_NAME.setText(s1);
                    	LAST_NAME.setText(s2);
                    	GENDER.setText(s3);
                    	COURSE.setText(s4);
                    	BRANCH.setText(s5);
                    	YEAR.setText(s6);
                    	SEMESTER.setText(s7);
                    	CONTACT.setText(s8);
                    	MAIL_ID.setText(s9);
                    	
                    
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "ENTERIES ARE NOT MATCHED WITH DATABASE !"
                    				+ "PLEASE ENTER CORRECT DETAILS");	
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
		btnNewButton.setFont(new Font("Toledo Heavy", Font.ITALIC, 18));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME-");
		lblNewLabel_2.setBounds(10, 121, 111, 14);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_2);
		
		FIRST_NAME = new JTextField();
		FIRST_NAME.setBounds(131, 119, 151, 20);
		contentPane.add(FIRST_NAME);
		FIRST_NAME.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("LAST NAME-");
		lblNewLabel_3.setBounds(10, 174, 111, 14);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_3);
		
		LAST_NAME = new JTextField();
		LAST_NAME.setBounds(131, 172, 151, 20);
		contentPane.add(LAST_NAME);
		LAST_NAME.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER-");
		lblNewLabel_4.setBounds(10, 225, 80, 14);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_4);
		
		GENDER = new JTextField();
		GENDER.setBounds(131, 223, 151, 20);
		contentPane.add(GENDER);
		GENDER.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("COURSE-");
		lblNewLabel_5.setBounds(10, 279, 80, 14);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_5);
		
		COURSE = new JTextField();
		COURSE.setBounds(131, 277, 151, 20);
		contentPane.add(COURSE);
		COURSE.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("BRANCH-");
		lblNewLabel_6.setBounds(10, 340, 94, 14);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_6);
		
		BRANCH = new JTextField();
		BRANCH.setBounds(131, 338, 151, 20);
		contentPane.add(BRANCH);
		BRANCH.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("YEAR-");
		lblNewLabel_7.setBounds(342, 122, 103, 14);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_7);
		
		YEAR = new JTextField();
		YEAR.setBounds(455, 119, 151, 20);
		contentPane.add(YEAR);
		YEAR.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("SEMESTER-");
		lblNewLabel_8.setBounds(342, 175, 103, 14);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_8);
		
		SEMESTER = new JTextField();
		SEMESTER.setBounds(455, 172, 151, 20);
		contentPane.add(SEMESTER);
		SEMESTER.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("CONTACT-");
		lblNewLabel_9.setBounds(342, 226, 89, 14);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_9);
		
		CONTACT = new JTextField();
		CONTACT.setBounds(455, 223, 151, 20);
		contentPane.add(CONTACT);
		CONTACT.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("MAIL-ID..");
		lblNewLabel_10.setBounds(326, 280, 80, 14);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_10);
		
		MAIL_ID = new JTextField();
		MAIL_ID.setBounds(436, 277, 221, 20);
		contentPane.add(MAIL_ID);
		MAIL_ID.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBounds(261, 393, 145, 38);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "UPDATE STUDENT SET FIRST_NAME=?,LAST_NAME=?,GENDER=?, COURSE=?, BRANCH=?, YEAR=?,SEMESTER=?, CONTACT=?,MAIL_ID=?"
		    				+ "WHERE ROLL_NUMBER=?";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            
                    st.setString(1, FIRST_NAME.getText());
                    st.setString(2, LAST_NAME.getText());
                    st.setString(3, GENDER.getText());
                    st.setString(4, COURSE.getText());
                    st.setString(5, BRANCH.getText());
                    st.setString(6, YEAR.getText());
                    st.setString(7, SEMESTER.getText());
                    st.setString(8, CONTACT.getText());
                    st.setString(9, MAIL_ID.getText());
					
                    st.setString(10, ROLL_NUMBER.getText());
                    int i = st.executeUpdate();
                    if(i>0) {
                    	setVisible(false);
                    	JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED!...");	
                    	setVisible(false);
                    	User_Menu frame = new User_Menu();
    					frame.setVisible(true);
    					
    				
                   	 	
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "somewent wrong");	
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
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<<<<");
		btnNewButton_2.setBounds(436, 393, 116, 38);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				User_Menu frame = new User_Menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNewButton_2);
	}
}
