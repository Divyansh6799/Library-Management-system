package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Issuebook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField ROLL_NUMBER;
	public static JTextField FIRST_NAME;
	private JTextField BOOK_NAME;
	private JTextField AUTHOR;
	private JTextField PUBLICATION;
	private JTextField EDITION;
	private JTextField COURSE_1;
	public static JTextField CONTACT;
	private JTextField BRANCH_1;
	private JTextField TR_NO;
    public  static  JTextField USERNAME;
    public static JComboBox<String> comboBox_book;
	public static JLabel datetime;
	JLabel returndate;
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issuebook frame = new Issuebook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  void rdatetime() {
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime n=LocalDateTime.now().plusDays(10);
		returndate.setText(dt.format(n));
	}
	public void idatetime() {
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime n=LocalDateTime.now();
		datetime.setText(dt.format(n));
	}
	
	public void combu() {
		comboBox_book = new JComboBox<String>();
		comboBox_book.setBackground(Color.WHITE);
		comboBox_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("SELECT  BOOK ID  FOR  ISSUE BOOKS..".equals(comboBox_book.getSelectedItem())) {
						JOptionPane.showInternalMessageDialog(null, "INVALID OPTION....");
						comboBox_book.setSelectedItem("");
                    	BOOK_NAME.setText("");
                    	AUTHOR.setText("");
                    	PUBLICATION.setText("");
                    	EDITION.setText("");
                    	COURSE_1.setText("");
                    	BRANCH_1.setText("");
                    	
				}else {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT BOOK_ID,BOOK_NAME,AUTHOR,PUBLICATION,EDITION,COURSE,BRANCH FROM BOOKS WHERE BOOK_ID=?";
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
                    	
                    	
                    	
                    	comboBox_book.setSelectedItem(s);
                    	BOOK_NAME.setText(s1);
                    	AUTHOR.setText(s2);
                    	PUBLICATION.setText(s3);
                    	EDITION.setText(s4);
                    	COURSE_1.setText(s5);
                    	BRANCH_1.setText(s6);
                    	
                    	
                    
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "ENTERIES ARE NOT MATCHED WITH DATABASE !"
                    				+ "PLEASE ENTER CORRECT DETAILS");	
                    	}
				}catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}

			}
		});
		comboBox_book.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_book.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT  BOOK ID  FOR  ISSUE BOOKS.."}));
				try {
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT BOOK_ID FROM BOOKS WHERE  TOTAL_BOOKS>0";
		    		PreparedStatement st = con.prepareStatement(sql);
		    		ResultSet rs  = st.executeQuery();
		            while(rs.next()) {
		            	comboBox_book.addItem(rs.getString("BOOK_ID"));
		            }
		        }catch(Exception e1) {
					e1.printStackTrace();
				}
		comboBox_book.setBounds(119, 95, 354, 28);
		contentPane.add(comboBox_book);
		
		datetime = new JLabel("");
		datetime.setForeground(Color.BLUE);
		datetime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		datetime.setBounds(197, 320, 162, 28);
		contentPane.add(datetime);
		
		returndate = new JLabel("");
		returndate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		returndate.setForeground(Color.BLUE);
		returndate.setBounds(609, 321, 129, 28);
		contentPane.add(returndate);
		
		lblNewLabel_2 = new JLabel("LAST DATE OF RETURN-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(365, 318, 246, 28);
		contentPane.add(lblNewLabel_2);
	}

	
	  public static void issue() {
		  try{
				Connection con=Connectionclass.getConnection();
	    		String sql = "select s.ROLL_NUMBER,s.FIRST_NAME,s.CONTACT FROM  STUDENT  s   JOIN login  l"
	            		+ " on s.ROLL_NUMBER=l.ROLL_NUMBER"
	            		+ " WHERE l.USERNAME=?";
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, USERNAME.getText());
	        
	            ResultSet rs  = st.executeQuery();
              if(rs.next()) {
              	String s=rs.getString(1);
              	String s1=rs.getString(2);
              	String s2=rs.getString(3);
              	
              	ROLL_NUMBER.setText(s);
              	FIRST_NAME.setText(s1);
              	CONTACT.setText(s2);
            }
		  }catch(NullPointerException ex)
			{
				
			ex.printStackTrace();
				
			} catch (SQLException e1) {
				// 
				e1.printStackTrace();
			}
		
		    }

	public Issuebook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISSUEBOOKS");
		lblNewLabel.setBounds(277, 0, 133, 43);
		lblNewLabel.setFont(new Font("Niagara Engraved", Font.ITALIC, 38));
		contentPane.add(lblNewLabel);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.setEditable(false);
		ROLL_NUMBER.setBounds(141, 52, 97, 20);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ROLL NUMBER-");
		lblNewLabel_1.setBounds(0, 52, 145, 18);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("NAME-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(287, 53, 135, 14);
		contentPane.add(lblNewLabel_3);
		
		FIRST_NAME = new JTextField();
		FIRST_NAME.setEditable(false);
		FIRST_NAME.setBounds(348, 52, 145, 20);
		contentPane.add(FIRST_NAME);
		FIRST_NAME.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("BOOK NAME-");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9.setBounds(34, 142, 129, 14);
		contentPane.add(lblNewLabel_9);
		
		BOOK_NAME = new JTextField();
		BOOK_NAME.setEditable(false);
		BOOK_NAME.setBounds(182, 141, 153, 20);
		contentPane.add(BOOK_NAME);
		BOOK_NAME.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("AUTHOR-");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_10.setBounds(392, 141, 102, 14);
		contentPane.add(lblNewLabel_10);
		
		AUTHOR = new JTextField();
		AUTHOR.setEditable(false);
		AUTHOR.setBounds(531, 138, 153, 20);
		contentPane.add(AUTHOR);
		AUTHOR.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("PUBLICATION-");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_11.setBounds(34, 198, 129, 14);
		contentPane.add(lblNewLabel_11);
		
		PUBLICATION = new JTextField();
		PUBLICATION.setEditable(false);
		PUBLICATION.setBounds(182, 197, 153, 20);
		contentPane.add(PUBLICATION);
		PUBLICATION.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("EDITION-");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_12.setBounds(392, 198, 102, 14);
		contentPane.add(lblNewLabel_12);
		
		EDITION = new JTextField();
		EDITION.setEditable(false);
		EDITION.setBounds(531, 197, 153, 20);
		contentPane.add(EDITION);
		EDITION.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("COURSE-");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_14.setBounds(34, 262, 110, 14);
		contentPane.add(lblNewLabel_14);
		
		COURSE_1 = new JTextField();
		COURSE_1.setEditable(false);
		COURSE_1.setBounds(182, 261, 153, 20);
		contentPane.add(COURSE_1);
		COURSE_1.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("DATE  OF  ISSUE--");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_15.setBounds(0, 320, 192, 28);
		contentPane.add(lblNewLabel_15);
		
		JButton btnNewButton_2 = new JButton("ISSUE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con=Connectionclass.getConnection();
				String r=ROLL_NUMBER.getText(); 
				String b=(String) comboBox_book.getSelectedItem();
				String sql="select ROLL_NUMBER,BOOK_ID,RETURN_STATUS FROM ISSUEBOOKS WHERE ROLL_NUMBER=?  AND BOOK_ID=? AND RETURN_STATUS='NO'";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, ROLL_NUMBER.getText());
	            st.setString(2, (String) comboBox_book.getSelectedItem());
	            ResultSet rs  = st.executeQuery();
	            if(rs.next()) {
	            String s=rs.getString(1);
	            String s1=rs.getString(2);
                String s2=rs.getString(3);
                if(r.equals(s) && b.equals(s1) && "NO".equals(s2)) {
                		JOptionPane.showMessageDialog(null, "YOU DON'T RETURNED THE PREVIOUS   "+BOOK_NAME.getText()+"   BOOK");
                		comboBox_book.setSelectedItem("");
                    	BOOK_NAME.setText("");
                    	AUTHOR.setText("");
                    	PUBLICATION.setText("");
                    	EDITION.setText("");
                    	COURSE_1.setText("");
                    	BRANCH_1.setText("");
                }}else {
                String sql1 = "INSERT INTO ISSUEBOOKS(ROLL_NUMBER,NAME, BOOK_ID, BOOK_NAME, AUTHOR,EDITION,DATE_OF_ISSUE,DATE_OF_RETURN,RETURN_STATUS,CONTACT) VALUES(?,?,?,?,?, ?, ?, ?,'NO',?)";
	            PreparedStatement st1 = con.prepareStatement(sql1);
	            st1.setString(1, ROLL_NUMBER.getText());
                st1.setString(2, FIRST_NAME.getText());
                st1.setString(3,(String) comboBox_book.getSelectedItem());
                st1.setString(4, BOOK_NAME.getText());
                st1.setString(5, AUTHOR.getText());
                st1.setString(6, EDITION.getText());
                st1.setString(7, datetime.getText());
                st1.setString(8, returndate.getText());
                st1.setString(9, CONTACT.getText());
                
                int i = st1.executeUpdate();
                if(i>0) {
                	String sql2 = "UPDATE BOOKS SET TOTAL_BOOKS=TOTAL_BOOKS-1 WHERE BOOK_ID=?";
    	            PreparedStatement st2 = con.prepareStatement(sql2);
    	            st2.setString(1,(String) comboBox_book.getSelectedItem());
    	            int j=st2.executeUpdate();
    	            if(j>0) {
                	JOptionPane.showMessageDialog(null, "THE  BOOK   "+BOOK_NAME.getText()+"   HAS  BEEN   ISSUED  SUCCESSFULLY...");
    	            }else {
    	            	JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG...TRY AGAIN....!");
    	            }setVisible(false);
                	User_Menu frame = new User_Menu();
					frame.setVisible(true);
					}else {
                		JOptionPane.showMessageDialog(null, "somewent wrong.....try again later....!");	
                	}
                }
             }
		catch(NullPointerException ex)
			{ex.printStackTrace();
			} catch (SQLException e1) {
			e1.printStackTrace();} 
		}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(277, 386, 146, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<<<<<");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				User_Menu frame = new User_Menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_3.setBounds(514, 386, 125, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_16 = new JLabel("CONTACT-");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_16.setBounds(514, 53, 97, 14);
		contentPane.add(lblNewLabel_16);
		
		CONTACT = new JTextField();
		CONTACT.setEditable(false);
		CONTACT.setBounds(597, 47, 145, 20);
		contentPane.add(CONTACT);
		CONTACT.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("BRANCH-");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_17.setBounds(392, 262, 93, 14);
		contentPane.add(lblNewLabel_17);
		
		BRANCH_1 = new JTextField();
		BRANCH_1.setBounds(531, 261, 153, 20);
		contentPane.add(BRANCH_1);
		BRANCH_1.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("TRANSACTION NO-");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_18.setBounds(0, 389, 192, 20);
		contentPane.add(lblNewLabel_18);
		
		TR_NO = new JTextField();
		TR_NO.setBounds(10, 420, 113, 20);
		contentPane.add(TR_NO);
		TR_NO.setColumns(10);
		Random ran = new Random();
		int n = ran.nextInt(100000000)+1;
		String val = String.valueOf(n);
		TR_NO.setText(val);
		
		USERNAME = new JTextField();
		USERNAME.setForeground(Color.CYAN);
		USERNAME.setBorder(null);
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		USERNAME.setEditable(false);
		USERNAME.setBackground(Color.CYAN);
		USERNAME.setBounds(34, 0, 204, 20);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		
		 issue();
		 combu();
		 rdatetime();
		 idatetime();
	}	
}
