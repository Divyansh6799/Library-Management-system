package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
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
import java.awt.event.ActionEvent;

public class Returnbook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField ROLL_NUMBER;
	public static JComboBox<String> comboBox_book;
	private static JTextField NAME;
	private JTextField BOOK_NAME;
	private JTextField AUTHOR;
	private JTextField EDITION;
	private JTextField DATE_OF_ISSUE;
	private JTextField TR_NO;
	public  static JTextField USERNAME;
	private JTextField LASTRETURN;
	private JTextField returndate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Returnbook frame = new Returnbook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void rdatetime() {
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("YYYY-MM-dd  HH:MM:SS");
		LocalDateTime n=LocalDateTime.now();
		returndate.setText(dt.format(n));
	}
	public static void user() {
		try {
			Connection con=Connectionclass.getConnection();
			 String sql = "select s.ROLL_NUMBER, s.FIRST_NAME FROM  STUDENT  s   JOIN login  l"
	            		+ " on s.ROLL_NUMBER=l.ROLL_NUMBER"
	            		+ " WHERE l.USERNAME=?";
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, USERNAME.getText());
           ResultSet rs = st.executeQuery();
           if(rs.next()) {
        	   String s=rs.getString(1);
           	   String s1=rs.getString(2);
           	   ROLL_NUMBER.setText(s);
           	   NAME.setText(s1);
           }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void combu() {
		comboBox_book = new JComboBox<String>();
		comboBox_book.setBackground(Color.WHITE);
		comboBox_book.addActionListener(new ActionListener() {
			/**
			 *
			 */
			public void actionPerformed(ActionEvent e) {
				if("SELECT  BOOK ID  FOR  RETURN BOOKS..".equals(comboBox_book.getSelectedItem())) {
						JOptionPane.showInternalMessageDialog(null, "INVALID OPTION....");
						comboBox_book.setSelectedItem("");
                    	BOOK_NAME.setText("");
                    	AUTHOR.setText("");
                    	EDITION.setText("");
                    	DATE_OF_ISSUE.setText("");
                    	
                    	
				}else {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT BOOK_ID,ROLL_NUMBER,BOOK_NAME,AUTHOR,EDITION,DATE_OF_ISSUE,DATE_OF_RETURN FROM ISSUEBOOKS WHERE BOOK_ID=? AND ROLL_NUMBER=? AND RETURN_STATUS='NO'";
		    		PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, (String) comboBox_book.getSelectedItem());
    	            st.setString(2, ROLL_NUMBER.getText());
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
                    	ROLL_NUMBER.setText(s1);
                    	BOOK_NAME.setText(s2);
                    	AUTHOR.setText(s3);
                    	EDITION.setText(s4);
                    	DATE_OF_ISSUE.setText(s5);
                    	LASTRETURN.setText(s6);
                    	                   
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
		comboBox_book.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT  BOOK ID  FOR  RETURN BOOKS.."}));
				try {
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT BOOK_ID FROM ISSUEBOOKS where  RETURN_STATUS='NO'";
					PreparedStatement st = con.prepareStatement(sql);
//					st.setString(1, ROLL_NUMBER.getText());
		    		ResultSet rs  = st.executeQuery();
		            while(rs.next()) {
		            	comboBox_book.addItem(rs.getString("BOOK_ID"));
		            }
		        }catch(Exception e1) {
					e1.printStackTrace();
				}
		comboBox_book.setBounds(119, 95, 354, 28);
		contentPane.add(comboBox_book);
		
		returndate = new JTextField();
		returndate.setForeground(Color.CYAN);
		returndate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		returndate.setEditable(false);
		returndate.setBounds(394, 24, 235, 23);
		contentPane.add(returndate);
		returndate.setColumns(10);
		
		
	}
	
		public Returnbook() {
		setResizable(false);
		setTitle("RETURN BOOK");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RETURNBOOK");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(252, 11, 155, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ROLL NUMBER-");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(43, 63, 121, 14);
		contentPane.add(lblNewLabel_1);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.setBounds(174, 61, 121, 20);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("STUDENT NAME-");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(67, 162, 129, 14);
		contentPane.add(lblNewLabel_3);
		
		NAME = new JTextField();
		NAME.setEditable(false);
		NAME.setBounds(217, 160, 214, 20);
		contentPane.add(NAME);
		NAME.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("BOOK NAME-");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(67, 205, 109, 14);
		contentPane.add(lblNewLabel_4);
		
		BOOK_NAME = new JTextField();
		BOOK_NAME.setEditable(false);
		BOOK_NAME.setBounds(217, 203, 214, 20);
		contentPane.add(BOOK_NAME);
		BOOK_NAME.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("AUTHOR-");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(67, 253, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		AUTHOR = new JTextField();
		AUTHOR.setEditable(false);
		AUTHOR.setBounds(217, 251, 214, 20);
		contentPane.add(AUTHOR);
		AUTHOR.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("EDITION-");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_6.setBounds(67, 299, 94, 14);
		contentPane.add(lblNewLabel_6);
		
		EDITION = new JTextField();
		EDITION.setEditable(false);
		EDITION.setBounds(217, 297, 214, 20);
		contentPane.add(EDITION);
		EDITION.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DATE OF ISSUE-");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_7.setBounds(67, 340, 129, 14);
		contentPane.add(lblNewLabel_7);
		
		DATE_OF_ISSUE = new JTextField();
		DATE_OF_ISSUE.setEditable(false);
		DATE_OF_ISSUE.setBounds(217, 338, 214, 20);
		contentPane.add(DATE_OF_ISSUE);
		DATE_OF_ISSUE.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("LAST DATE OF RETURN-");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_8.setBounds(43, 374, 184, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("RETURN BOOK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
					String sql= "UPDATE ISSUEBOOKS SET DATE_OF_RETURN=?,RETURN_STATUS='YES'"
							+ "WHERE ROLL_NUMBER=? AND BOOK_ID=? AND DATE_OF_ISSUE=? AND RETURN_STATUS='NO'";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, returndate.getText());
					st.setString(2, ROLL_NUMBER.getText());
                    st.setString(3, (String) comboBox_book.getSelectedItem());
                    st.setString(4 , DATE_OF_ISSUE.getText());
                    int i = st.executeUpdate();
                    if(i>0) {
                    	String sql1="update books set total_books=total_books+1 where book_id=?";
                    	PreparedStatement st1 = con.prepareStatement(sql1);
        	            st1.setString(1, (String) comboBox_book.getSelectedItem());
        	            int j=st1.executeUpdate();
        	            if(j>0)
        	            {
                    	JOptionPane.showMessageDialog(null, "SUCCESSFULLY RETURNED"+(String) comboBox_book.getSelectedItem()+"BOOK");	
        	            }else {
        	            JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!...");	
        	            }
                    	setVisible(false);
                    	User_Menu frame = new User_Menu();
    					frame.setVisible(true);
                      }
                    	else {
                    		JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!...");	
                    	}
				} catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBounds(400, 395, 191, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<<<<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				User_Menu frame = new User_Menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBounds(427, 429, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_9 = new JLabel("TRANSACTION NO-");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(457, 268, 172, 20);
		contentPane.add(lblNewLabel_9);
		
		TR_NO = new JTextField();
		TR_NO.setBounds(457, 310, 121, 20);
		contentPane.add(TR_NO);
		TR_NO.setColumns(10);
		
		LASTRETURN = new JTextField();
		LASTRETURN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		LASTRETURN.setEditable(false);
		LASTRETURN.setBounds(217, 372, 214, 20);
		contentPane.add(LASTRETURN);
		LASTRETURN.setColumns(10);
		
		USERNAME = new JTextField();
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		USERNAME.setForeground(Color.RED);
		USERNAME.setBackground(Color.PINK);
		USERNAME.setEditable(false);
		USERNAME.setBorder(null);
		USERNAME.setBounds(0, 0, 103, 25);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		 user();
		 combu();
		 rdatetime();
	}
}
