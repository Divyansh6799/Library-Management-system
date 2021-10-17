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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 423);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MY PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(362, 13, 130, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ROLL NUMBER-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(30, 59, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.setBounds(161, 58, 117, 20);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(30, 112, 117, 14);
		contentPane.add(lblNewLabel_2);
		
		FIRST_NAME = new JTextField();
		FIRST_NAME.setBounds(161, 111, 117, 20);
		contentPane.add(FIRST_NAME);
		FIRST_NAME.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("LAST NAME-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(30, 160, 117, 14);
		contentPane.add(lblNewLabel_3);
		
		LAST_NAME = new JTextField();
		LAST_NAME.setBounds(161, 159, 117, 20);
		contentPane.add(LAST_NAME);
		LAST_NAME.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER-");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(30, 213, 91, 14);
		contentPane.add(lblNewLabel_4);
		
		GENDER = new JTextField();
		GENDER.setBounds(161, 212, 117, 20);
		contentPane.add(GENDER);
		GENDER.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("COURSE-");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(30, 260, 91, 14);
		contentPane.add(lblNewLabel_5);
		
		COURSE = new JTextField();
		COURSE.setBounds(161, 259, 117, 20);
		contentPane.add(COURSE);
		COURSE.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("BRANCH-");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(351, 61, 97, 14);
		contentPane.add(lblNewLabel_6);
		
		BRANCH = new JTextField();
		BRANCH.setBounds(458, 58, 116, 20);
		contentPane.add(BRANCH);
		BRANCH.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("YEAR-");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(351, 112, 76, 14);
		contentPane.add(lblNewLabel_7);
		
		YEAR = new JTextField();
		YEAR.setBounds(458, 111, 116, 20);
		contentPane.add(YEAR);
		YEAR.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("SEMESTER-");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_8.setBounds(351, 162, 97, 14);
		contentPane.add(lblNewLabel_8);
		
		SEMESTER = new JTextField();
		SEMESTER.setBounds(458, 159, 116, 20);
		contentPane.add(SEMESTER);
		SEMESTER.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("CONTACT-");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9.setBounds(351, 215, 97, 14);
		contentPane.add(lblNewLabel_9);
		
		CONTACT = new JTextField();
		CONTACT.setBounds(458, 212, 116, 20);
		contentPane.add(CONTACT);
		CONTACT.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("MAIL ID-");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_10.setBounds(335, 262, 92, 14);
		contentPane.add(lblNewLabel_10);
		
		MAIL_ID = new JTextField();
		MAIL_ID.setBounds(437, 259, 226, 20);
		contentPane.add(MAIL_ID);
		MAIL_ID.setColumns(10);
		
		JButton btnNewButton = new JButton("<<<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new User_Menu().setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(574, 335, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE MY PROFILE");
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
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(211, 335, 281, 23);
		contentPane.add(btnNewButton_1);
		
		USERNAME = new JTextField();
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		USERNAME.setEditable(false);
		USERNAME.setBackground(Color.ORANGE);
		USERNAME.setBounds(30, 13, 171, 20);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		
		student();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
