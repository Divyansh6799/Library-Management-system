package lms;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Profile extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField ROLL_NUMBER;
	private static JTextField FIRST_NAME;
	private static JTextField LAST_NAME;
	private static JTextField GENDER;
	private static JTextField COURSE;
	private static JTextField BRANCH;
	private static JTextField YEAR;
	private static JTextField SEMESTER;
	private static JTextField CONTACT;
	private static JTextField MAIL_ID;
	public static JTextField USERNAME;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Profile().setVisible(true);
	    }
	    
	 public static void student() {
			try {
					Connection con=Connectionclass.getConnection();
		            String sql = "select s.*FROM  STUDENT  s   JOIN login  l"
		            		+ " on s.ROLL_NUMBER=l.ROLL_NUMBER"
		            		+ " WHERE l.USERNAME=?";
		            		
		            PreparedStatement st = con.prepareStatement(sql);
		            st.setString(1, USERNAME.getText());
		          
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
		            }
				 catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
		    }

	/**
	 * Create the frame.
	 */
	public Profile() {
		setBounds(500, 140, 709, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MY PROFILE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 31));
		lblNewLabel.setBounds(242, 13, 219, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ROLL NUMBER-");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(30, 80, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.setBounds(30, 105, 287, 31);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME-");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(30, 147, 117, 14);
		contentPane.add(lblNewLabel_2);
		
		FIRST_NAME = new JTextField();
		FIRST_NAME.setBounds(30, 172, 287, 31);
		contentPane.add(FIRST_NAME);
		FIRST_NAME.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("LAST NAME-");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(30, 214, 117, 30);
		contentPane.add(lblNewLabel_3);
		
		LAST_NAME = new JTextField();
		LAST_NAME.setBounds(30, 255, 287, 30);
		contentPane.add(LAST_NAME);
		LAST_NAME.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER-");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(30, 296, 91, 14);
		contentPane.add(lblNewLabel_4);
		
		GENDER = new JTextField();
		GENDER.setBounds(30, 321, 287, 31);
		contentPane.add(GENDER);
		GENDER.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("COURSE-");
		lblNewLabel_5.setForeground(Color.CYAN);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(30, 363, 91, 22);
		contentPane.add(lblNewLabel_5);
		
		COURSE = new JTextField();
		COURSE.setBounds(30, 395, 287, 30);
		contentPane.add(COURSE);
		COURSE.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("BRANCH-");
		lblNewLabel_6.setForeground(Color.CYAN);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(418, 75, 97, 14);
		contentPane.add(lblNewLabel_6);
		
		BRANCH = new JTextField();
		BRANCH.setBounds(418, 100, 281, 31);
		contentPane.add(BRANCH);
		BRANCH.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("YEAR-");
		lblNewLabel_7.setForeground(Color.CYAN);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(418, 147, 76, 14);
		contentPane.add(lblNewLabel_7);
		
		YEAR = new JTextField();
		YEAR.setBounds(418, 172, 281, 30);
		contentPane.add(YEAR);
		YEAR.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("SEMESTER-");
		lblNewLabel_8.setForeground(Color.CYAN);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_8.setBounds(418, 213, 97, 22);
		contentPane.add(lblNewLabel_8);
		
		SEMESTER = new JTextField();
		SEMESTER.setBounds(418, 248, 281, 31);
		contentPane.add(SEMESTER);
		SEMESTER.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("CONTACT-");
		lblNewLabel_9.setForeground(Color.CYAN);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9.setBounds(418, 296, 97, 14);
		contentPane.add(lblNewLabel_9);
		
		CONTACT = new JTextField();
		CONTACT.setBounds(418, 321, 281, 31);
		contentPane.add(CONTACT);
		CONTACT.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("MAIL ID-");
		lblNewLabel_10.setForeground(Color.CYAN);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_10.setBounds(418, 363, 92, 22);
		contentPane.add(lblNewLabel_10);
		
		MAIL_ID = new JTextField();
		MAIL_ID.setBounds(418, 388, 281, 31);
		contentPane.add(MAIL_ID);
		MAIL_ID.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UPDATE MY PROFILE");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                    		JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG....!");	
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
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(230, 449, 281, 31);
		contentPane.add(btnNewButton_1);
		
		USERNAME = new JTextField();
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		USERNAME.setEditable(false);
		USERNAME.setBackground(Color.LIGHT_GRAY);
		USERNAME.setBounds(10, 11, 137, 22);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\icons8-close-35.png"));
		btnNewButton_2.setBounds(642, 1, 67, 43);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\welcome.jpg"));
		lblNewLabel_11.setBounds(0, 1, 709, 504);
		contentPane.add(lblNewLabel_11);
		
		student();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
